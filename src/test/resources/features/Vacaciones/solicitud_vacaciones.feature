# language: es
# author: JuanJoven

Característica: Solicitud de vacaciones
  Como colaborador de ManageHR
  Quiero registrar una petición de vacaciones
  Para que el sistema guarde la solicitud

  @solicitud_vacaciones
  Escenario: Registrar una nueva solicitud de vacaciones
    Dado que el usuario se encuentra en la página de inicio de sesión de Managehr
    Cuando ingrese las credenciales correctas (correo y clave)
      | email            | clave  |
      | sharon@gmail.com | 123456 |
    Y navega al módulo de Vacaciones
    Y diligencia el formulario de vacaciones
    Entonces debería visualizar un mensaje de confirmación de solicitud registrada
