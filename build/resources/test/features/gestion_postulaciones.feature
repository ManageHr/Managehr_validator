# language: es
# author: YonRuiz

Característica: Gestión de postulaciones de usuarios
  Como usuario administrador
  Quiero poder validar y filtrar los estados de las postulaciones
  Para que los usuarios puedan ver el estado de su postulación en su perfil

  @gestion_postulaciones @regresion
  Escenario: Gestión completa del estado de postulaciones
    Dado que el usuario se encuentra en la página de inicio de sesión de Managehr
    Cuando ingrese las credenciales correctas (correo y clave)
      | email          | clave  |
      | admin@sena.com | 123456 |
    Entonces se debe verificar que el usuario haya sido autenticado correctamente y redirigido al directorio de la página Managehr


    Cuando navega a la sección "Vacantes" y selecciona "Postulaciones"
    Entonces debe ser direccionado a la vista de "Gestión de Postulaciones"
    Y debe visualizar la tabla con los registros de postulaciones

    Cuando hace click en "Ver Detalles" de una postulación
    Entonces debe aparecer un modal con la información completa de la postulación
    Y al hacer click en el botón "X" del modal
    Entonces debe cerrarse la información del modal

    Cuando hace click en el botón "Editar Estado" de una postulación
    Entonces debe aparecer un modal con un select para cambiar el estado
    Y completa el estado a cambiar:
      | campo  | valor     |
      | estado | Pendiente |
    Y hace click en el botón Guardar
    Entonces debe actualizarse el estado en la tabla de postulaciones

    Cuando hace click en el botón "Siguiente" de paginación
    Entonces debe cargar la segunda página de registros

    Cuando ingresa datos en el campo de filtrado "Sharon"
    Entonces debe filtrar y mostrar solo las postulaciones que coincidan