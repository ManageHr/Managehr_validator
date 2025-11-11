# language: es
# author: Sharon

Característica: Registro de Horas Extra
  Como usuario autenticado en ManageHR
  Quiero registrar una solicitud de horas extra
  Para dejar evidencia de mis horas adicionales trabajadas

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión de Managehr
    Cuando ingrese las credenciales correctas (correo y clave)
      | email            | clave  |
      | sharon@gmail.com | 123456 |

  @horas_extra
  Escenario: Registrar horas extra exitosamente
    Cuando registra una solicitud de horas extra
      | descripcion | fecha      | tipo | cantidad |
      | Prueba2 QA  | 20/11/2025 | 2    | 3        |
    Entonces debe visualizar la confirmación de envío de la solicitud
    Y debe aparecer una alerta de exito y cerrarse

    Cuando registra una solicitud de horas extra sin descripcion
      | descripcion | fecha      | tipo | cantidad |
      |             | 20/11/2025 | 2    | 3        |
    Entonces debe visualizar el mensaje de error en el formulario de horas extra
    Y se debe cerrar la alerta



