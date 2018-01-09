# topstories
Implementazione di un servizio REST che aggrega le top stories di **news.ycombinator.com** e le top stories della sezione di tecnolgia del **New York Times**.

# REQUISITI
- JDK required version: 1.8
- Apache Maven required version: 3.3.3
- internet connection

# COMPILAZIONE ED ESECUZIONE
Utilizzando la shell o prompt, muoviti dentro la directory del progetto ed esegui il comando:
 >mvn clean install

Il progetto è compilato ed è stato creato il jar eseguibile nella directory "target".
Adesso lancia l'applicazione utilizzando il comando:
 >java -jar target\topstories-0.0.1.jar


# REST URLs
1)	http://localhost:8080/news
	Tramite questa URL si accede al servizio REST che restituisce le news aggregate ordinate temporalmente dalla più alla meno recente indipendentemente dalla sorgente.
	Per garantire un'esecuzione non troppo lenta, è stato inserito un limite a 30 news dalla sorgente **news.ycombinator.com**. Tale limite può essere modificato dalla property *topstories.limit* in *src/main/resources/application.properties*.
	
2) http://localhost:8080/news/hacker-news
	Restituisce le news dalla sorgente news.ycombinator.com ordinate alla stessa maniera. Anche qui è presente il limite a 30 news. Tale limite può essere modificato dalla property *topstories.limit* in *src/main/resources/application.properties*.
	
3) http://localhost:8080/news/nytimes
	Restituisce le news dalla sorgente New York Times (sezione technology) ordinate alla stessa maniera.
	
