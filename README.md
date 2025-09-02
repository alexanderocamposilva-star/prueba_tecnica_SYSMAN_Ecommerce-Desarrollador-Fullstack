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

<img width="1601" height="729" alt="image" src="https://github.com/user-attachments/assets/be1cf4a2-1c87-4d50-be42-a10ba68280fa" />

Se debe validar si se crearon las imagenes en docker y si estan arriba:

<img width="1598" height="501" alt="image" src="https://github.com/user-attachments/assets/341aaf53-9d44-429e-b2bd-83fe0ed4dbdf" />

<img width="1598" height="501" alt="image" src="https://github.com/user-attachments/assets/ce1d4e6c-41c6-4c62-ac55-de3d220ae0ed" />

Validar que se halla creado la base de datos “materialdb”, las tablas (departamento, ciudad, material) y se hallan insertado los datos de prueba:

<img width="1632" height="842" alt="image" src="https://github.com/user-attachments/assets/99afbb9f-adf4-490d-acff-c60d47021138" />

<img width="943" height="716" alt="image" src="https://github.com/user-attachments/assets/cd4e2dab-2a80-40d4-b75d-9e87512298b6" />

<img width="943" height="716" alt="image" src="https://github.com/user-attachments/assets/4e5dfa6e-b62a-4dd1-9546-d57d8f42bcf5" />

<img width="1595" height="645" alt="image" src="https://github.com/user-attachments/assets/39d3f8f0-18be-4f33-8d4b-f4c44c5ce19f" />

Validar que se puede usar la API por swagger:

<img width="1844" height="887" alt="image" src="https://github.com/user-attachments/assets/bbdcc6c3-cdaf-417c-b837-9d931872b5b3" />

Se debe deusar primero el endpoint “/auth/login” con el siguiente JSON:

{
  "username": "admin",
  "password": "password"
}

<img width="1844" height="802" alt="image" src="https://github.com/user-attachments/assets/ae5a30c6-25d2-4d1b-9aa4-beef45b1808a" />

Respuesta:

<img width="1714" height="972" alt="image" src="https://github.com/user-attachments/assets/62b064d7-31ee-4af0-a32c-19f745eaea27" />

{
  "status": 200,
  "message": "Login exitoso",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc1NjgzOTYwMywiZXhwIjoxNzU2ODQzMjAzfQ.xqd72DhktrlvEJBF9KvYiNnd0uZfTyI-w48w7bxB1eQ"
  }
}

Este le generara un token que es el que debe de ingresar en el modal emergente al dar clic en el botón “Autorize”.

<img width="1851" height="809" alt="image" src="https://github.com/user-attachments/assets/b5089141-3970-4249-8d4e-03cb90ecae84" />

Una vez logeado y con el token se puede proceder a probar la inserción de un material y consultar los preexistentes.

<img width="1711" height="837" alt="image" src="https://github.com/user-attachments/assets/0cc95130-4aad-4960-b81f-694c64cee071" />

<img width="1708" height="1016" alt="image" src="https://github.com/user-attachments/assets/5c9a2136-1bf6-4ffb-b9de-383a8dcb6426" />

Luego proceder a ejecutar en la interfaz usando el formulario html y Angular.

<img width="1569" height="993" alt="image" src="https://github.com/user-attachments/assets/ce928f44-36a9-4ad6-8dea-01b64791a37e" />


