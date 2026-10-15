# Spring Boot AOP Examples

A beginner-friendly project demonstrating **Aspect-Oriented Programming (AOP)** in Spring Boot using practical examples of different advice types.

## About the Project

Aspect-Oriented Programming (AOP) helps separate cross-cutting concerns such as logging, exception handling, execution monitoring, and request interception from the main business logic.

This project demonstrates how to use Spring AOP annotations with a `StudentService` class.

## Technologies Used

- Java
- Spring Boot
- Spring AOP
- AspectJ Annotations
- Maven
- REST API
- Postman
- IntelliJ IDEA

## Project Structure

```text
AopDemoExample/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/qspider/AopDemoExample/
│       │       ├── aspect/
│       │       │   └── LoggingAspect.java
│       │       ├── controller/
│       │       │   └── StudentController.java
│       │       ├── dto/
│       │       │   └── Student.java
│       │       ├── service/
│       │       │   └── StudentService.java
│       │       └── AopDemoExampleApplication.java
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md
```

## AOP Advice Covered

### 1. `@Before`

Executes before the target method.

**Use case:** Log a message before creating a student.

```java
@Before("execution(* com.qspider.AopDemoExample.service.StudentService.createStudent(..))")
public void logBeforeMethod() {
    System.out.println("Before method execution");
}
```

### 2. `@After`

Executes after the target method finishes, whether it succeeds or throws an exception.

**Use case:** Log method completion.

### 3. `@AfterReturning`

Executes only when the target method completes successfully.

**Use case:** Log the returned student object.

### 4. `@AfterThrowing`

Executes when the target method throws an exception.

**Use case:** Log the exception message for debugging.

### 5. `@Around`

Wraps the target method execution and provides control over when the method runs.

**Use case:** Log before and after execution, modify method arguments, inspect or modify the returned value, or control whether the target method executes.

```java
@Around("execution(* com.qspider.AopDemoExample.service.StudentService.dummyMethod(..))")
public Object logAroundMethod(ProceedingJoinPoint joinPoint)
        throws Throwable {

    System.out.println("Before method execution");

    Object result = joinPoint.proceed();

    System.out.println("After method execution");

    return result;
}
```

## REST API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/students` | Create or process a student |
| GET | `/api/students` | Execute the dummy method |

### Sample POST Request

**URL:** `http://localhost:8080/api/students`

**Request Body:**

```json
{
  "name": "Rahul",
  "age": 22
}
```

The response depends on the current implementation of `StudentService` and `LoggingAspect`.

## How to Run the Project

### Prerequisites

- JDK compatible with the project's Maven configuration
- IntelliJ IDEA or another Java IDE
- Maven
- Postman (optional, for API testing)

### Steps

1. Clone or download the repository.
2. Open the project in IntelliJ IDEA.
3. Allow Maven to download the dependencies.
4. Run `AopDemoExampleApplication.java`.
5. Test the endpoints using Postman.

### Run using Maven

```bash
mvn clean compile
mvn spring-boot:run
```

## Learning Outcomes

- Understand the fundamentals of Spring AOP.
- Create aspects using `@Aspect` and `@Component`.
- Write pointcut expressions using `execution()`.
- Understand the differences between the five main advice types.
- Use `ProceedingJoinPoint` to control method execution.
- Inspect and modify method arguments and return values.
- Apply AOP to logging and exception monitoring.

## Future Improvements

- Add execution-time measurement.
- Implement centralized exception handling.
- Add unit tests for service methods and aspects.
- Add request logging and validation examples.

## Author

**Rahul Singh**

Aspiring Java Full Stack Developer

## License

This project is available for educational and learning purposes.
