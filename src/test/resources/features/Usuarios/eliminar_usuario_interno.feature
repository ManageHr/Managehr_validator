# language: es
# author: PiterRuiz

Característica: Eliminar usuario interno
  Como usuario administrador
  Quiero poder buscar y eliminar usuarios internos
  Para mantener actualizado el directorio de usuarios

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión de Managehr
    Cuando ingrese las credenciales correctas (correo y clave)
      | email          | clave  |
      | admin@sena.com | 123456 |
    Entonces se debe verificar que el usuario haya sido autenticado correctamente y redirigido al directorio de la página Managehr

  @eliminar_usuario_interno
  Escenario: Eliminar un usuario interno del sistema
    Cuando se encuentra en la vista con el titulo de "Directorio Usuarios" interno
    Y se busca por filtro con el numero de documento "12345678990"
    Entonces se valide que el usuario esta en la tabla interna
    Y se da click en el boton de detalles
    Entonces se debe visualizar que el rol es "Empleado"
    Y se cierra el modal de detalles
    Entonces se da click en el boton eliminar
    Y se confirma la eliminacion en el modal de confirmacion
    Entonces se valide que el usuario ya no esta en la tabla