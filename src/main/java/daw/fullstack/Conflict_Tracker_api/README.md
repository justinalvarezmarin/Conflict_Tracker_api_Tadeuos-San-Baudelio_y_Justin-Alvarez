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

# ⚙️ Notas del Backend (Spring Boot + Railway)

Aquí explico los líos que tuvimos con el servidor de Java y cómo los arreglamos para que no petara al subirlo a la nube. Como no somos expertos, nos costó entender por qué en nuestro PC iba bien y en internet no.

### 1. El lío de las Variables de Entorno (DB)
**El problema:** En mi ordenador usamos el MySQL local con usuario `root` y sin contraseña. Pero en **Railway**, la base de datos tiene otros datos (URL, usuario y pass raros).
**La solución:** En el archivo `application.properties`, no pusimos los datos a mano. Usamos "huecos" (variables) que Railway rellena solo:
* `spring.datasource.url=${MYSQL_URL}`
* `spring.datasource.username=${MYSQLUSER}`
  Si no pones esto así, el servidor intenta buscar el MySQL de tu casa dentro de Railway... y claro, no encuentra nada y da error de conexión.

### 2. El error de las CORS (El "Portero de Discoteca")
**El problema:** Este fue el error más pesado. El Frontend (Vercel) intentaba pedir datos y el navegador sacaba un error rojo gigante de **CORS**.
**La solución:** Por seguridad, Java viene bloqueado para que nadie externo le pida cosas. Tuvimos que crear una clase `WebConfig` para decirle: *"Oye, deja pasar a la web de Vercel, que es mi amiga"*.
Sin esto, aunque el servidor funcione, el navegador te corta el grifo.

### 3. El puerto dinámico (`server.port`)
**El problema:** En mi PC usamos siempre el puerto `8080`, pero en Railway el servidor se enciende en un puerto distinto cada vez.
**La solución:** Usamos la variable `server.port=${PORT:8080}`. Esto le dice a Java: *"Usa el puerto que te asigne Railway, y si no hay ninguno (como en mi casa), usa el 8080"*. Si no haces esto, Railway nunca llega a detectar que tu app ha arrancado.

### 4. El último gran fallo: Localhost vs Railway
**El problema:** Aunque el Backend estaba perfecto, el Frontend seguía intentando llamar a `localhost:8080`.
**Lo que aprendimos:** Que hay que avisarle al Frontend de que la URL ha cambiado. Mientras en la consola sigas viendo `localhost`, es que la conexión está rota porque el Front está buscando los datos en el sitio equivocado.


## Autores
* Justin Alvarez
* Tadeuos San Baudelio