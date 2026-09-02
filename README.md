# EasyMed - Based Microservices Medicine Order System

EasyMed is a microservices-based application designed for managing medicine orders. Built with Spring Boot, Spring Cloud, and React, it demonstrates end-to-end service discovery, inter-service communication via Feign Clients, dynamic persistence with MySQL, and a simple frontend interface.

The entire project is fully containerized with Docker Compose deployment.

---

## Architecture Overview

```
[ React UI Client ] (Port 3000)
       │
       │ HTTP (REST API calls)
       ▼
[ Consumer Service ] (Port 8090)
       │
       │ Service Discovery & Load Balancing (Feign Client)
       ├───► [ Eureka Server ] (Port 8080)
       │
       │ HTTP Routing via Registered Service Name
       ▼
[ Producer Service ] (Port 8085)
       │
       │ Spring Data JPA / Hibernate
       ▼
[ MySQL Database ] (Port 3306)

```

---

## Key Features

* **Service Discovery:** Uses **Netflix Eureka Server** for microservice registration and discovery.
* **Inter-Service Communication:** Employs **Spring Cloud OpenFeign** inside the Consumer service to communicate dynamically with the Producer without hardcoded URLs.
* **Data Persistence:** Uses **Spring Data JPA** with MySQL database backend for CRUD operations.
* **Single-Page React UI:** Clean, simple React interface utilizing state hooks and Axios for easy interactions.
* **One-Command Deployment:** Docker Compose orchestration allows spinning up the database, registry, microservices, and frontend in one step.

---

## Tech Stack

* **Frontend:** React.js, Axios, HTML5/CSS3
* **Backend:** Java 21, Spring Boot, Spring Cloud (Eureka, OpenFeign), Spring Data JPA
* **Database:** MySQL 8.0
* **DevOps & Containerization:** Docker, Docker Compose

---

## Getting Started

### Prerequisites

Ensure you have the following installed on your machine:

* [Docker Desktop](https://www.docker.com/products/docker-desktop/)
* [Java JDK 17+](https://www.oracle.com/java/technologies/downloads/)
* [Maven](https://maven.apache.org/)

---

## Running with Docker Compose (Recommended)

1. **Clone the repository:**
```bash
git clone https://github.com/pgit80/easyMed.git
cd easyMed

``

2. **Build the JAR files for all Java services:**
```bash
mvn clean package -DskipTests

```

3. **Start the application with Docker Compose:**
```bash
docker-compose up --build -d

```
4. **Access the Application Services:**
* **React UI App:** `http://localhost:3000`
* **Eureka Dashboard:** `http://localhost:8080/eureka`
* **Consumer Endpoints:** `http://localhost:8090/consumer/...`
* **Producer Endpoints:** `http://localhost:8085/...`


5. **Stop the Application:**
```bash
docker-compose down

```
---

## API Endpoints Summary

### Consumer Endpoints (Exposed to UI)

| Method | Endpoint | Description |
| --- | --- | --- |
| **POST** | `/consumer/save` | Create and save a new medicine order |
| **GET** | `/consumer/getAll` | Fetch all medicine orders |
| **GET** | `/consumer/getAllByName/{name}` | Fetch orders by medicine name |
| **GET** | `/consumer/getAllByContact/{contact}` | Fetch orders by customer contact number |

## Project Structure

```
.
├── easymed-eureka/         # Eureka Discovery Server
├── easyMedProducer/        # Producer Microservice (JPA + MySQL)
├── easyMedConsumer/        # Consumer Microservice (Feign Client)
├── easymed-ui/             # React Frontend App
├── docker-compose.yml      # Docker Multi-container Configuration
├── .gitignore              # Ignored dependencies & build files
└── README.md               # Project documentation

```
