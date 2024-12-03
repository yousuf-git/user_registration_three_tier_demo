# User Registration and Login System

## Overview
This project demonstrates a three-tier architecture implementation using Spring Boot for the backend, HTML/CSS for the frontend, and a database for persistence. The system provides basic user registration and authentication features.

## Features
- User Registration
- User Login
- Form Validation
- Session Management

## Technology Stack
- Frontend: HTML, CSS
- Backend: Spring Boot
- Database: PostgreSQL
- Architecture: Three-Tier (Presentation, Business, Data)

## Project Structure
```
registration/
├── src/
│   ├── main/
│   │   ├── java/                       # Backend code
│   │   ├── resources/                  # Application properties
│   │        ├────────── static/        # Frontend files
├── pom.xml                             # Dependencies
└── readme.md
```

## Setup Instructions
1. Clone the repository
2. Configure database settings in `application.properties`
3. I've used PostgreSQL for this project. You can use any database of your choice.
3. Run `mvn spring-boot:run`
4. Access the application at `http://localhost:8080`
