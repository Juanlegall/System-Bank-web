# System Bank Web

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![GitHub stars](https://img.shields.io/github/stars/Juanlegall/System-Bank-web?style=social)
![GitHub forks](https://img.shields.io/github/forks/Juanlegall/System-Bank-web?style=social)

Este repositorio contiene el código fuente de un **Sistema de Home Banking** desarrollado como proyecto académico utilizando **Java**, **JSP**, **Servlets**, y **JDBC**. Permite la gestión completa de clientes, cuentas y movimientos bancarios, con funcionalidades diferenciadas por rol.

---

## Tabla de Contenidos

* [Características Principales](#características-principales)
* [Tecnologías Utilizadas](#tecnologías-utilizadas)
* [Requisitos del Sistema](#requisitos-del-sistema)
* [Configuración](#configuración)
    * [Clonado del Repositorio](#clonado-del-repositorio)
   
---

## Características Principales

* **Inicio de sesión seguro con control de acceso basado en roles (RBAC):**
    * Autenticación de usuarios y control de permisos según el tipo de cuenta (cliente o administrador).
* **Gestión de Clientes y Administradores:**
    * Alta, baja, modificación y listado (ABML).
* **Gestión de Cuentas Bancarias:**
    * Alta de cuentas, eliminación y actualizaciones.
    * Vinculación de cuentas con clientes.
* **Gestión de Transferencias:**
    * Realización de transferencias entre cuentas con validaciones.
    * Visualización de movimientos por cuenta.
* **Gestión de Préstamos (opcional):**
    * Alta y seguimiento de préstamos personales.
* **Entornos diferenciados por rol:**
    * Menú exclusivo para administradores.
    * Funcionalidades personalizadas para clientes.
* **Validaciones dinámicas en frontend y backend:**
    * Validación de datos, campos obligatorios, restricciones por tipo de usuario, etc.
* **Paginación de movimientos:**
    * Visualización paginada de movimientos por cuenta (10 por página).

---

## Tecnologías Utilizadas

* **Lenguaje de Programación:** Java (JDK 17)
* **Backend:**
    * Servlets
    * JDBC
    * Modelo en capas
* **Frontend:**
    * JSP
    * HTML
    * CSS
    * Bootstrap
* **Base de Datos:** MySQL
* **Servidor Web:** Apache Tomcat 10
* **IDE:** Eclipse
* **Control de versiones:** Git / GitHub

---

## Requisitos del Sistema

* Java JDK 17 o superior  
* Apache Tomcat 10  
* MySQL Server  
* Eclipse IDE (o compatible)  
* Navegador Web moderno

---

## Configuración

### Clonado del Repositorio

```bash
git clone https://github.com/Juanlegall/System-Bank-web.git
```
### Configuración de la Base de Datos

1. **Crear la base de datos:**
   - Abrí **MySQL Workbench** u otro cliente de base de datos.
   - Ejecutá el script `database.sql` ubicado en la carpeta `/scripts` del repositorio.
   - Este script creará la base de datos y todas las tablas necesarias para el sistema.

2. **Configurar los datos de conexión:**
   - Ubicá el archivo `Conexion.java` dentro del paquete `src/utils/` o similar.
   - Verificá y editá las siguientes variables según tu entorno local:

     ```java
     private static final String URL = "jdbc:mysql://localhost:3306/nombre_base_de_datos";
     private static final String USER = "root";
     private static final String PASSWORD = "tu_contraseña";
     ```

     > 🔁 Reemplazá `nombre_base_de_datos` con el nombre real usado en tu script, y `tu_contraseña` con tu clave de acceso a MySQL.

3. **Agregar el conector JDBC de MySQL:**
   - Asegurate de que el archivo `mysql-connector-j-8.0.x.jar` esté agregado al classpath del proyecto.
   - En Eclipse:  
     `Click derecho sobre el proyecto` → **Build Path** → **Add External Archives** → seleccionar el `.jar`.

> ✅ ¡Una vez hecho esto, el sistema ya estará listo para ejecutarse en tu entorno local!
