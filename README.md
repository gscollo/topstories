# topstories
Implementazione di un servizio REST che aggrega le top stories di news.ycombinator. com e le top stories della sezione di tecnolgia del New York Times.

# REQUISITI
- Java reqired version: 1.8
- Apache Maven reqired version: 3.3.3
- internet connection

# COMPILAZIONE ED ESECUZIONE
Utilizzando la shell o prompt, muoviti dentro la directory del progetto ed esegui il comando:
mvn clean install

Il progetto è compilato ed è stato creato il jar nella directory "target".
Adesso lancia l'applicazione utilizzando il comando:
java -jar target\topstories-0.0.1.jar


# REST URLs
1)	http://localhost:8080/news
	Tramite questa URL si accede al servizio REST  che restituisce le news aggregate ordinate temporalmente dalla più alla meno recente indipendentemente dalla sorgente.
	Per garantire un'esecuzione non troppo lenta, è stato inserito un limite a 30 news da ciascuna sorgente-
	
2) http://localhost:8080/news/hacker-news
	Stories from news.ycombinator.com.
	Restituisce le news dalla sorgente news.ycombinator.com ordinate alla stessa maniera. Anche qui è presente il limite a 30 news.
	
3) http://localhost:8080/news/nytimes
	Restituisce le news dalla sorgente New York Times (sezione technology) ordinate alla stessa maniera.
	