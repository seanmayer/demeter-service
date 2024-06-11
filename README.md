# Demeter Service

Demeter Service is a Spring Boot application written in Kotlin and Java, built with Maven.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 17
- Maven
- IntelliJ IDEA 2024.1 or any preferred IDE

### Installing

1. Clone the repository
```bash
git clone https://github.com/seanmayer/demeter-service.git
```
2. Navigate into the cloned repository
```bash
cd demeter-service
```
3. Install the dependencies
```bash
mvn install
```
4. Run the application
```bash
mvn spring-boot:run
```

## Running the tests

To run the tests, use the following command:

```bash
mvn test
```

## Built With

- [Kotlin](https://kotlinlang.org/)
- [Java](https://www.java.com/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)

## API Documentation

The API documentation is available at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

## application.properties

OpenAI API key is required to run the application.
 
`spring.ai.openai.api-key=${SPRING_AI_OPENAI_API_KEY}`

## Example Requests

### Create a new message

```bash
curl -X POST "http://localhost:8080/api/messages" -H "Content-Type: application/json" -d '{"id": "123", "content": "This is a new message"}'
```
## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.
