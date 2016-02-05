# Seagull

![seagull](https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Larus_pacificus_Bruny_Island.jpg/164px-Larus_pacificus_Bruny_Island.jpg)
It's for the birds.

## About

Seagull consists of two applications that make seed available from the `/birdfood` endpoint:
- **seagull-application** fetches seed over HTTP. 
- **mock-seagull-application** provides mock seed data. 

## Dependencies
- [Java SDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Gradle 2.+](http://gradle.org/gradle-download/)

## Running tests

1. Run `./gradlew clean test`.

## Running applications

1. Run `./gradlew applications/seagull-application:bootRun` for **seagull-application**.
1. Run `./gradlew applications/mock-seagull-application:bootRun` for **mock-seagull-application**.

Seed can be retrieved at `http://localhost:8080/birdfood` once an application is running. 
