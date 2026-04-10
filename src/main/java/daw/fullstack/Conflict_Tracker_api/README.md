# Conflict Tracker API

Proyecto desarrollado para el modulo de Fullstack (NF1). Esta aplicacion permite la gestion de conflictos globales mediante una interfaz web desarrollada con Thymeleaf y una API RESTful.

## Instrucciones para la ejecucion

### Requisitos previos
* Java 21 o superior
* Maven 3.x

### Pasos para ejecutar la aplicacion
1. Clonar o descargar el repositorio.
2. Abrir una terminal en la raiz del proyecto.
3. Ejecutar el comando:
   ./mvnw spring-boot:run
4. Acceder a la aplicacion en: http://localhost:8080

## Endpoints de la aplicacion

### Interfaz Web
* Listado de conflictos: http://localhost:8080/web/conflicts
* Formulario de alta: http://localhost:8080/web/conflicts/new

### API REST
Ejemplos de uso mediante comandos curl:

1. Obtener todos los conflictos (GET):
   curl -X GET http://localhost:8080/api/v1/conflicts

2. Crear un nuevo conflicto (POST):
   curl -X POST http://localhost:8080/api/v1/conflicts \
   -H "Content-Type: application/json" \
   -d '{
   "name": "Conflicto de Prueba",
   "description": "Descripcion generada para pruebas",
   "startDate": "2026-02-15",
   "status": "ACTIVE"
   }'

## Base de Datos
La aplicacion utiliza una base de datos H2 en memoria para el entorno de desarrollo.
* Consola H2: http://localhost:8080/h2-console
* JDBC URL: jdbc:h2:mem:testdb
* Usuario: SA
* Contrasena: (vacia)

## Autores
* Justin Alvarez
* Tadeuos San Baudelio