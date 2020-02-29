# Rest Api using GraphQL and SpringBoot and plus

For the development environment, the following tools are used:

* Go Programming Language (version 1.11) (https://golang.org)
* Java (1.8 or newer)
* Maven (http://maven.apache.org/)
* Docker (https://www.docker.com)



## How to execute the project via maven

Check that both programs are running using the terminal

    java -version
    go version
    mvn -version

Now run 

    mvn spring-boot:run (using maven)
    
or

    java -jar target/rest-api-0.0.1-SNAPSHOT.war

## How to execute the project with Docker

1. Install [Docker] (https://docs.docker.com/engine/installation/linux/docker-ce/debian/) following the guidelines on the project website.

Check that both programs are running using the terminal

	docker version

If you * are not allowed to run the `docker` program *
try adding your user to the `docker` group (you need to log out and login again after executing the command below):
	
	sudo addgroup $USER docker

And then run the image with `docker-compose`:

	docker-compose up
	
## Accessing the Ui to run queries

    http://localhost:8080/graphiql
    
Or via Postman to run the rest apis on the path

    http://localhost:8080/api/rest/person

## Runing exercises using GO

	go run exercises/2_1.go 
	go run exercises/2_4.go
	go run exercises/2_5.go
	
	
## Runing exercises using Java

	javac exercises/java_solutions/Solution24.java
	javap -v  exercises/java_solutions/Solution24
	java  exercises/java_solutions/Solution24
	
	javac exercises/java_solutions/Solution25.java
    javap -v  exercises/java_solutions/Solution25
    java  exercises/java_solutions/Solution25
  