# language: es
# author: PiterRuiz

Característica: Autenticación en la página de Managehr
  Como usuario de Managehr
  Quiero autenticarme en el portal de Managehr
  Para poder acceder al contenido y funcionalidades disponibles con los permisos de administrador.

  @autenticacion
  Escenario: Verificar la autenticación exitosa en la página de Managehr
    Dado que el usuario se encuentra en la página de inicio de sesión de Managehr
    Cuando ingrese las credenciales correctas (correo y clave)
      | email          | clave    |
      | admin@sena.com | 12345678 |
    Entonces se debe verificar que el usuario haya sido autenticado correctamente y redirigido al directorio de la página Managehr
