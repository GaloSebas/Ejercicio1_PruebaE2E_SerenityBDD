# Ejercicio de Automaizacion E2E
## Autor: Galo Sanchez

### Descripcion del Ejercicio

- Prueba funcional automatizada (Prueba E2E) de un flujo de compra en la pagina _https://www.saucedemo.com/_ que incluye:

    1. Autenticarse con el usuario: standard_user y password: secret_sauce
    2. Agregar dos productos al carrito
    3. Visualizar el carrito
    4. Completar el formulario de compra
    5. Finalizar la compra hasta la confirmación: “THANK YOU FOR YOUR ORDER”

### Prerequisitos

- Asegurate de tener instalado lo siguiente:

    1. Sistema operativo Windows 11
    2. IDE IntelliJ IDEA (Community Edition) v2023.3.1
    3. Gradle versión 7.6.1 (debe estar en la variable de entorno)
    4. Apache maven 3.9.8 (debe estar en la variable de entorno)
    4. JDK versión 17  (debe estar en la variable de entorno)

### Pasos de Ejecucion

- Abre el terminal desde el directorio del proyecto y ejecuta:

    1. ./gradlew clean test

### Descripcion de las Tecnologias Utilizadas

- Para el ejercicio de automatizacion propuesto se ha utilizado el framework de SerenityBDD en leguage de programacion java.
- El patron de diseño del ejercicio esta basado en Screenplay.
- Adicionalmente se ha hecho uso de los siguientes frameworks: gherkin, cucumber, Junit y librerias como lombok, SonarLink, cucumber for java

### Notas adicionales

- El reporte sera generado en: e2e_automation_serenitybdd\build\reports\tests\test\index.html 
- Se han omitido las tildes en el presente documento para evitar caracteres no deseados en caso de abrir el documento en un dispositivo con un lenguaje diferente al espanol.