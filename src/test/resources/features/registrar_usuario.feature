# language: es
# author: PiterRuiz

Característica: Registrar nuevo usuario en Managehr
  Como usuario administrador
  Quiero poder registrar nuevos usuarios en el sistema
  Para gestionar el acceso de personal a la plataforma

  @registrar_usuario
  Escenario: Registrar un nuevo usuario administrativo
    Dado que el usuario se encuentra en la página de inicio de sesión de Managehr
    Cuando ingrese las credenciales correctas (correo y clave)
      | email          | clave  |
      | admin@sena.com | 123456 |
    Entonces se debe verificar que el usuario haya sido autenticado correctamente y redirigido al directorio de la página Managehr

    Cuando hace clic en "Agregar usuario"
    Y se abre el formulario modal de creación de usuario
#    Y llena todos los campos requeridos con datos válidos
#      | campo           | valor               |
#      | primerNombre    | Juan                |
#      | segundoNombre   | Carlos              |
#      | primerApellido  | Perez               |
#      | segundoApellido | Gomez               |
#      | tipoDocumento   | 1                   |
#      | numeroDocumento | 12345678990         |
#      | fechaNacimiento | 1990-05-20          |
#      | email           | juan.perez@test.com |
#      | direccion       | Calle 123 #45-67    |
#      | telefono        | 3001234567          |
#      | nacionalidad    | 1                   |
#      | eps             | EPS003              |
#      | fondoPension    | 2503                |
#      | genero          | 1                   |
#      | estadoCivil     | 1                   |
#      | rol             | 5                   |
#      | clave           | Password123         |
#      | repetirClave    | Password123         |

    Y llena todos los campos requeridos con datos válidos
      | primerNombre | segundoNombre | primerApellido | segundoApellido | tipoDocumento | numeroDocumento | fechaNacimiento | email               | direccion        | telefono   | nacionalidad | eps    | fondoPension | genero | estadoCivil | rol | password    | repetirPassword |
      | Juan         | Carlos        | Perez          | Gomez           | 1             | 12345678990     | 1990-05-20      | juan.perez@test.com | Calle 123 #45-67 | 3001234567 | 1            | EPS003 | 2503         | 1      | 1           | 5   | Password123 | Password123     |
    Entonces el botón "Guardar" debe estar habilitado
    Y al hacer clic en "Guardar"
    Entonces debe aparecer una alerta que diga "Usuario creado con éxito"
    Y el usuario debe aparecer en la tabla de usuarios