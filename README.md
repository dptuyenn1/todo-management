## Prerequisites

Before running the project, make sure you have the following installed:

- **JDK 21**
- **Apache Maven 3.9+** (or use the included Maven Wrapper)

> **Note:** This project is built and tested with **JDK 21**. Using a different Java version may cause unexpected issues.

---

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/dptuyenn1/todo-management.git
cd todo-management/app
```

### Run the Application

Using the Maven Wrapper:

```bash
./mvnw spring-boot:run
```

or using Maven:

```bash
mvn spring-boot:run
```

By default, the application runs at:

```
http://localhost:8080
```

---

## API Documentation

Once the application is running, you can access the Swagger UI at:

```
http://localhost:8080/swagger-ui/index.html
```

---

## H2 Database Console

The project uses an embedded H2 database.

Access the H2 Console at:

```
http://localhost:8080/h2-console
```

Use the following connection settings:

| Property | Value |
|----------|-------|
| JDBC URL | `jdbc:h2:file:./data/todo-db` |
| Username | `sa` |
| Password | *(leave blank)* |

> **Note:** Make sure the JDBC URL is exactly:
>
> `jdbc:h2:file:./data/todo-db`
