# URL Shortener

A simple command-line URL shortener written in Java using SOLID principles.
The project uses Maven and targets Java 8.

### How to use

Run `mvn clean package`
Then run `java -jar target/URLShortener-1.0-SNAPSHOT.jar`

There are the following commands:

```
command -> usage <args>: what it does

help -> help : returns all commands and how to use them

shorten -> shorten <url> : shortens a URL and gives the shortened code

get -> get <code> : gets the original url from the code

list -> list : lists all the url to shortened url code pairs
```
