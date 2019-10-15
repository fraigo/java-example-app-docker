# docker-java-example

A basic Java app you can run locally, using Docker, or deploying to Heroku


## Running with Docker

After installing [Docker](https://www.docker.com/products/docker-desktop) you can run your application without installing Java or any other tool.

### Build the Java-Maven image

```sh
docker build -t mavenjdk8 ./
```

### Build and package your maven application

```sh
docker run -v $(pwd):/home/src -v maven_repository:/root/.m2/repository mavenjdk8 mvn package
```

### Using `docker-composer`

Run `docker-compose up -d` to start the services. This services include:

- A Java container with Maven (maven) running on port 5000 (http://localhost:5000/)
- A PostgreSQL container with a single database (no external port)
- A PhpPgAdmin web interface to manage your postgresql database (http://localhost:5002/)

### Compiling your application

You can edit the source code and then run the Maven process to build a new application package and restart the container:

```sh 
docker-compose exec maven mvn package  && docker-compose restart maven
```

You can run a set of services to run your application:

docker-compose exec  maven mvn package  && docker-compose stop maven && docker-compose up -d

## Running Locally

You need Java JDK and Maven installed. Run the following commands to get the source code, compile and package your application

```sh
$ git clone https://github.com/heroku/java-example-app.git
$ cd java-example-app
$ mvn install
```

### Run the Java application

Then you can run the java application using

```sh
$ java -jar target/java-example-app-1.0.jar
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

### Database connection 
To use a database, ensure you have a local `.env` file with a Database connection string like this:

```ini
JDBC_DATABASE_URL=jdbc:postgresql://localhost:5432/java_database_name
```

However, you need a PostgreSQL database server running with a database created.
An example page at http://localhost:5000/db is set to test your database connection.


## Deploying to Heroku

For more information about using Java on Heroku, see these Heroku Dev Center articles:

- [Java on Heroku](https://devcenter.heroku.com/categories/java)
- [Getting Started with Java on Heroku](https://devcenter.heroku.com/articles/getting-started-with-java)
- [![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

## Deploying to Heroku from command line

Install Heroku client and run the following commands:

```sh
$ heroku create
$ git push heroku master
$ heroku open
```
