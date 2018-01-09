package com.sourcesense.topstories.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sourcesense.topstories.bean.HNStory;
import com.sourcesense.topstories.bean.NYResult;
import com.sourcesense.topstories.bean.NYStory;
import com.sourcesense.topstories.bean.Story;

/**
 * REST service that attaches news from New York Times (technology section) and news.ycombinator.com
 * @author G. Scollo
 */
@RestController
public class StoriesController {
	
	private static final String NY_TOP_STORIES_API = "https://api.nytimes.com/svc/topstories/v2/technology.json?api-key=96f8d418ea904f1e88eb1b1c5fe7439f";
	private static final String HACKERS_NEWS_API_ALL = "https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty";
	private static final String HACKERS_NEWS_API_TEMPLATE_STORY = "https://hacker-news.firebaseio.com/v0/item/%s.json?print=pretty";
	
	/**
	 * NEWS_LIMIT = check the property topstories.limit<br>
	 * default = 30
	 */
	@Value("${topstories.limit:30}")
	private int newsLimit;

	private static final Logger log = LoggerFactory.getLogger(StoriesController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Top stories of technology from New York Times API, ordered by time
	 * @return List
	 */
	@RequestMapping(value="/news/nytimes", method=RequestMethod.GET)
    public List<NYStory> nytTopstories() {
		NYResult nyResult = getNYResult();
		
		return nyResult.getResults().stream()
				.sorted((s1, s2) -> s2.getCreated_date().compareTo(s1.getCreated_date()))
				.collect(Collectors.toList());
	}
	
	/**
	 * Top stories from news.ycombinator.com API, ordered by time.
	 * <p> This stories are limited to the first  {@link StoriesController#newsLimit}}
	 * @return
	 */
	@RequestMapping(value="/news/hacker-news", method=RequestMethod.GET)
    public List<HNStory> hnTopstories() {
		List<Integer> hnResults = getHNResults();
    	log.info(String.format("hacker-news results: %s; limit: %s", hnResults.size(), newsLimit));
    	List<HNStory> result = hnResults.stream()
    			.map(x -> getHNStory(x))
    			.limit(hnResults.size() > newsLimit? newsLimit : hnResults.size())
    			.sorted((s1, s2) -> Long.valueOf(s2.getTime()).compareTo(s1.getTime()))
    			.collect(Collectors.toList());
		
		return result;
	}

	/**
	 * Top stories of technology from New York Times and news.ycombinator.com API, ordered by time
	 * <p> This stories are limited to the first  {@link StoriesController#newsLimit}} for each API
	 * @return List
	 */
    @RequestMapping(value="/news", method=RequestMethod.GET)
    public List<Story> topstories() {
    	NYResult nyResult = getNYResult();
    	log.info(nyResult.toString());
    	log.info("New York Times Top Stories about technology: " + nyResult.getResults().size());
    	
    	List<Story> result = nyResult.getResults().stream()
    		.map(nytStory -> new Story(nytStory))
    		//.limit(nyResult.getResults().size() > newsLimit? newsLimit : nyResult.getResults().size())
    		.collect(Collectors.toList());
    	
    	List<Integer> hnResults = getHNResults();
    	log.info(String.format("hacker-news results: %s; limit: %s", hnResults.size(), newsLimit));
    	result.addAll(hnResults.stream()
    			.map(x -> new Story(getHNStory(x)))
    			.limit(hnResults.size() > newsLimit? newsLimit : hnResults.size())
    			.collect(Collectors.toList()));
    	
    	log.info("result before ordering... " + result.size());
    	return result.stream()
    			.sorted((s1, s2) -> s2.getTime().compareTo(s1.getTime()))
    			.collect(Collectors.toList());
    }
    
    private NYResult getNYResult() {
    	return restTemplate.getForObject(NY_TOP_STORIES_API, NYResult.class);
    }
    
	@SuppressWarnings("unchecked")
	private List<Integer> getHNResults() {
    	return restTemplate.getForObject(HACKERS_NEWS_API_ALL, List.class);
    }
	
	private HNStory getHNStory(Integer id) {
		String url = String.format(HACKERS_NEWS_API_TEMPLATE_STORY, id);
		return restTemplate.getForObject(url, HNStory.class);
	}
}