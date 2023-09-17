# PopularRepoFinder
PopularRepoFinder is a Java Spring Boot application that allows you to discover popular repositories on GitHub. It leverages the GitHub API to fetch and present repositories based on various criteria.

## Features
The application provides the following features:

* List of the most popular repositories, sorted by the number of stars.
(Option to view the top N repositories (e.g., top 10, top 50, top 100).
* Filter repositories by programming language.
* Fetch repositories created from a specified date onwards.

## Getting Started
To get started with PopularRepoFinder, follow these steps:

**1. Clone the Repository:**
```
   git clone https://github.com/meysamzamani/PopularRepoFinder.git
```
**2. Configuration:**

    Modify the `application.yml` file to configure the default date and other application properties.

**3. Build and Run:**
   
    Build and run the application using Maven:
```
   mvn spring-boot:run
```
* The application will start on port 8080 by default.

**4. Access the API:**

    You can access the API to discover popular repositories by making GET requests to the `/api/v1.0/repo` endpoint with the following query parameters:

* limit: Number of repositories to retrieve (e.g., 10, 50, 100).
* language: Filter repositories by programming language (optional).
* sinceDate: Filter repositories created from a specific date onwards (optional).

Example Request:
```
GET http://localhost:8080/api/v1.0/repo?limit=10&language=java&sinceDate=2021-01-01
```
Example Response:
```
[
    {
        "id": 123,
        "name": "example-repo",
        "html_url": "https://github.com/example/example-repo",
        "description": "An example repository",
        "stargazers_count": 100,
        "language": "Java",
        "created_at": "2021-01-15T12:00:00Z"
    },
    // ... (more repositories)
]
```

**5. Error Handling:**

The application handles various error scenarios gracefully, and error responses follow standard HTTP status codes and JSON format.

**6. Swagger Documentation:**

You can access the Swagger documentation for the API by visiting http://localhost:8080/swagger-ui.html when the application is running. This documentation provides an interactive interface to explore and test the API endpoints.

## Technologies Used
* Java and Spring Boot for the backend application.
* Spring Cloud Feign for making requests to the GitHub API.
* Springdoc for generating Swagger documentation.
* Maven for project build and dependency management.

## Author
**Meysam Zamani**