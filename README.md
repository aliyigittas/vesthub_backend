# Vesthub Backend Service
This is the backend service for Vesthub. It also includes the required database schema.

## Tech Stack
- Java Spring Boot
- MySQL

## Getting Started
1. Clone the repository

```bash
git clone https://github.com/aliyigittas/vesthub_backend
cd vesthub_backend
```

2. Import the database schema to MySQL

```bash
cat database/*.sql | mysql -u root -p
```

3. Run the application 

```bash
mvn spring-boot:run
```
