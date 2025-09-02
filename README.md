# 🛒 SYSMAN Ecommerce - Prueba Técnica Fullstack

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)](https://spring.io/projects/spring-boot)
[![Angular](https://img.shields.io/badge/Angular-16+-red)](https://angular.io)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)](https://www.postgresql.org)
[![Docker](https://img.shields.io/badge/Docker-✓-blue)](https://www.docker.com)

## 📋 Descripción del Proyecto

Sistema de gestión de materiales desarrollado como prueba técnica fullstack con Spring Boot, Angular y Docker.

## 🚀 Características

### Backend (Spring Boot)
- **Java 17** con Spring Boot 3.2.0
- **Spring Data JPA** con PostgreSQL
- **Spring Security** con JWT
- **Dockerizado** con multi-stage build
- API RESTful completa

### Frontend (Angular)
- **Angular 16+** con TypeScript
- **Bootstrap** para UI responsive
- **NgRx** para state management (opcional)
- **Dockerizado** con Nginx

### Base de Datos
- **PostgreSQL 15**
- Datos iniciales automáticos
- Volumen Docker persistente

## 📦 Estructura del Proyecto
prueba_tecnica_SYSMAN_Ecommerce-Desarrollador-Fullstack/
├── backend/
│ ├── src/
│ ├── Dockerfile
│ └── pom.xml
├── frontend/
│ ├── src/
│ ├── Dockerfile
│ ├── nginx.conf
│ └── package.json
├── docker-compose.yml
└── README.md


## 🛠️ Instalación y Ejecución

### Prerrequisitos
- Docker 20.10+
- Docker Compose 2.0+
- Git

### 1. Clonar el repositorio
    bash
    git clone https://github.com/alexanderocamposilva-star/prueba_tecnica_SYSMAN_Ecommerce-Desarrollador-Fullstack.git
    cd prueba_tecnica_SYSMAN_Ecommerce-Desarrollador-Fullstack

### 2. Ejecutar con Docker Compose
    docker compose up --build

### 3. Acceder a las aplicaciones
    Frontend: http://localhost:4200
    Backend API: http://localhost:8080
    Base de datos: localhost:5432

### 🔧 Variables de Entorno
    Backend
    SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/materialsdb
    SPRING_DATASOURCE_USERNAME=postgres
    SPRING_DATASOURCE_PASSWORD=postgres
    
### Base de Datos
    POSTGRES_DB=materialsdb
    POSTGRES_USER=postgres
    POSTGRES_PASSWORD=postgres   

### 📊 API Endpoints
    Materiales

      GET /api/materials - Listar todos los materiales

      GET /api/materials/{id} - Obtener material por ID

      POST /api/materials - Crear nuevo material

      PUT /api/materials/{id} - Actualizar material

      DELETE /api/materials/{id} - Eliminar material

    Ciudades y Departamentos

      GET /api/cities - Listar ciudades


## 🚀 Explicacion Flash

Levantar el backend con su base de datos y el frontend por medio de un solo archivo de Docker

<img width="1599" height="447" alt="image" src="https://github.com/user-attachments/assets/c56d0cf3-46fd-4cf0-8ddf-89c090883e72" />



Se debe validar si se crearon las imagenes en docker y si estan arriba:




Validar que se halla creado la base de datos “materialdb”, las tablas (departamento, ciudad, material) y se hallan insertado los datos de prueba:






Validar que se puede usar la API por swagger:


Se debe deusar primero el endpoint “/auth/login” con el siguiente JSON:

{
  "username": "admin",
  "password": "password"
}




Respuesta:


{
  "status": 200,
  "message": "Login exitoso",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc1NjgzOTYwMywiZXhwIjoxNzU2ODQzMjAzfQ.xqd72DhktrlvEJBF9KvYiNnd0uZfTyI-w48w7bxB1eQ"
  }
}

Este le generara un token que es el que debe de ingresar en el modal emergente al dar clic en el botón “Autorize”.


Una vez logeado y con el token se puede proceder a probar la inserción de un material y consultar los preexistentes.



Luego proceder a ejecutar en la interfaz usando el formulario html y Angular.



