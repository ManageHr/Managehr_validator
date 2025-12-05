# language: es
# author: Yon

Característica: Eliminación de contrato de usuario
  Como usuario autenticado en ManageHR
  Quiero registrar una solicitud de horas extra
  Para dejar evidencia de mis horas adicionales trabajadas

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión de Managehr
    Cuando ingrese las credenciales correctas (correo y clave)
      | email       | clave  |
      | admin@sena.com | 123456 |
    Entonces debo ser redirigido a la página principal del sistema

  @eliminar_contratos
  Escenario: Eliminación exitosa de un contrato
    Dado que estoy en la sección de Gestión de Contratos
    Cuando busco al usuario con número de documento "12345678990"
    Y verifico que el contrato con documento "12345678990" existe en la tabla
    Y selecciono la opción "Eliminar" para el contrato encontrado
    Entonces se debe mostrar una alerta de confirmación titulada "Confirmar eliminación"

    Cuando confirmo la eliminación en la alerta haciendo clic en "Sí, eliminar"
    Entonces debe mostrarse una alerta de éxito con el mensaje "El contrato ha sido eliminado correctamente"
    Y cierro la alerta de éxito

    Cuando busco nuevamente al usuario con documento "12345678990" en el filtro
    Entonces la tabla de resultados debe estar vacía
    Y no debe existir ningún registro con el documento "12345678990"