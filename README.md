![logoMHR.png](src/test/resources/files/logoMHR.png)
# ManageHR - Sistema de Gestión de Recursos Humanos



## OBJETIVO PRINCIPAL

Desarrollar un sistema integral de gestión de recursos humanos que permita la automatización y validación de procesos de reclutamiento, administración de contratos y gestión de usuarios, mediante la implementación de pruebas automatizadas con Gherkin, Cucumber y Serenity BDD, garantizando la calidad y confiabilidad del software.

## OBJETIVOS ESPECÍFICOS

### Validación de Módulos Críticos:
- Módulo de Usuarios: Gestión de usuarios por parte del administrador
- Módulo de Contratos: Administración y validación de contratos laborales
- Postulación a Vacantes: Proceso completo de postulación para usuarios externos
- Gestión de Perfiles: Actualización y validación de datos personales

### Implementación de Calidad:
- Establecer framework de pruebas automatizadas con Serenity BDD
- Implementar lenguaje Gherkin para definición de criterios de aceptación
- Integrar pruebas en el pipeline de desarrollo continuo
- Generar reportes ejecutivos de calidad del software

## ALCANCE DEL PROYECTO

### Módulos Incluidos:

| Módulo | Funcionalidades | Responsable |
|--------|-----------------|-------------|
| Administración de Usuarios | CRUD usuarios, roles, permisos | Administrador |
| Gestión de Contratos | Creación, modificación, estado | Administrador |
| Postulación Vacantes | Búsqueda, aplicación, seguimiento | Usuario Externo |
| Perfil de Usuario | Actualización datos, historial | Todos los usuarios |

### Tecnologías Cubiertas:

- Pruebas: Serenity BDD + Cucumber + Gherkin
- JDK: Versión 15
- SDK: Versión 22
- Gestión de Dependencias: Gradle

## PROPÓSITO

Garantizar la calidad y confiabilidad del sistema ManageHR mediante la implementación de un framework robusto de pruebas automatizadas que valide los flujos críticos de negocio, reduciendo errores en producción y mejorando la experiencia del usuario final.

## ENLACES DEL PROYECTO

- Aplicación Web: https://evensoft21.com/managehr/Angular
- Contacto: managehr@evensoft21.com

## CONFIGURACIÓN TÉCNICA

### Requisitos del Sistema:
JDK Version: 15
Gradle Version: 7.0+
SDK Version: 22
Chrome Driver: Incluido en /driver

## Errores de commit 
#### Descarta todos los cambios en los archivos generados
- git checkout -- .gradle/
- git checkout -- build/
