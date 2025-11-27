# language: es
# author: Sharon

Característica: Gestión de solicitudes de Horas Extra como administrador
  Como administrador de ManageHR
  Quiero cambiar el estado y eliminar solicitudes de horas extra
  Para gestionar correctamente las solicitudes de los empleados

  @horas_extra_admin
  Escenario: Cambiar el estado de una solicitud de horas extra y luego eliminarla
    Dado que el usuario se encuentra en la página de inicio de sesión de Managehr
    Cuando ingrese las credenciales correctas (correo y clave)
      | email          | clave  |
      | admin@sena.com | 123456 |
    Y navega al módulo de Horas extra
    Y cambia el estado de la primera solicitud a "Aprobado"
    Entonces debe visualizar que el estado de la primera solicitud es "Aprobado"
    Cuando elimina la primera solicitud de horas extra
    Entonces la cantidad de solicitudes debe disminuir en 1
