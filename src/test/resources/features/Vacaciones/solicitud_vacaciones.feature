# language: es
# author: JuanJoven

Característica: Solicitud de vacaciones
  Como colaborador de ManageHR
  Quiero registrar y aprobar una petición de vacaciones
  Para que el sistema guarde la solicitud y el jefe pueda aprobarla

  @solicitud_vacaciones
  Escenario: Registrar y aprobar una nueva solicitud de vacaciones
    # --- Colaborador (Sharon) crea la solicitud ---
    Dado que el usuario se encuentra en la página de inicio de sesión de Managehr
    Cuando ingrese las credenciales correctas (correo y clave)
      | email            | clave  |
      | sharon@gmail.com | 123456 |
    Y navega al módulo de Vacaciones
    Y diligencia el formulario de vacaciones
    Entonces debería visualizar un mensaje de confirmación de solicitud registrada
    Y cierra la sesión actual

    # --- Jefe de personal ingresa al sistema ---
    Y inicia sesión como jefe de personal
      | email         | clave  |
      | jefe@jefe.com | 123456 |

    Y navega al módulo de vacaciones como jefe
    Y aprueba la solicitud de vacaciones con motivo "Solicitud de vacaciones hik"
    Entonces el estado de la solicitud debería ser "Aprobada"
