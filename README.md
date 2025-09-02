# Prueba Técnica - Fullstack (Complete Package)

Contenido:
- backend/ : Spring Boot project (Java 17) with JWT validation filter, PostgreSQL docker-compose, Swagger, logging, global exception handling, tests, Dockerfile, GitHub Actions CI.
- frontend/: Angular 15 scaffold (runnable) with service, components, auth interceptor, proxy config and GitHub Actions CI.

## Cómo ejecutar (rápido)
1. Backend:
   - Desde carpeta backend: `docker compose up -d` (levanta Postgres)
   - Configurar `application.yml` si cambias credenciales.
   - `mvn -f backend/pom.xml spring-boot:run`
   - Swagger UI: `http://localhost:8080/swagger-ui.html`

2. Frontend:
   - Instala Angular CLI: `npm i -g @angular/cli`
   - Desde carpeta frontend: `npm install`
   - `npm start` (usa proxy.conf.json para enrutar /api a backend)

## Auth (demo)
- Login: POST /auth/login { "username":"admin", "password":"password" } → devuelve token en data.token
- Frontend incluye formulario de login que guarda token en localStorage y lo añade a requests.

## CI
- Backend: .github/workflows/ci.yml ejecuta mvn test
- Frontend: .github/workflows/ci.yml ejecuta npm test

## Notas
- Cambia `app.jwt.secret` en application.yml y usa variables de entorno en producción.
- En producción: gestiona usuarios con base de datos y contraseñas hasheadas.
