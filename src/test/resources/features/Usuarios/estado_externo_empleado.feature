# language: es
# author: PiterRuiz

Característica: Camiar estado a usuario externo
  Como usuario administrador
  Quiero poder cambiar de externo a empleado a un usuario
  Para que el usuario pueda tener todos los permisos de empleado

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión de Managehr
    Cuando ingrese las credenciales correctas (correo y clave)
      | email          | clave  |
      | admin@sena.com | 123456 |
    Entonces se debe verificar que el usuario haya sido autenticado correctamente y redirigido al directorio de la página Managehr

  @cambiar_usuario
  Escenario: Registrar un nuevo usuario administrativo
    Cuando se encuentra en la vista con el titulo de "Directorio Usuarios Externos"
    Y se encuentra busca por filtro con el numero de documento "12345678990"
    Entonces se valide que el usuario esta en la tabla externo
    Entonces se da click en el boton de editar
    Y se debe mostrar un modal con el estado y se debe cambiar
      | campo | valor |
      | rol   | 3     |
    Entonces sale un modal de actualizado y se debe cerrar el modal