# language: es
# author: Sharon

Característica: Registro de Horas Extra
  Como usuario autenticado en ManageHR
  Quiero registrar una solicitud de horas extra
  Para dejar evidencia de mis horas adicionales trabajadas

  Antecedentes:
    Dado que el usuario ingresa con sus credenciales a ManageHR
      | correo           | clave  |
      | sharon@gmail.com | 123456 |

  @horas_extra
  Escenario: Registrar horas extra exitosamente
    Cuando registra una solicitud de horas extra
      | descripcion | fecha     | tipo     | cantidad |
      | Prueba2 QA  | 20/11/2025 | Nocturna | 3        |
    Entonces debe visualizar la confirmación de envío de la solicitud







