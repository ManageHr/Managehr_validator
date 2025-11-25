# language: es
# author: JuanJoven
@managehr @registro
Característica: Registro de usuario en ManageHR
  Como visitante de la pagina web
  Quiero registrarme en ManageHR
  Para acceder con mis credenciales y usar el sistema como usuario externo

  Escenario: Verificar el registro exitoso en la página de ManageHR
    Dado que el usuario se encuentra en el formulario de registro de ManageHR
    Cuando ingresa los datos válidos en el formulario
      | numeroDocumento | nombreCompleto    | correo                 | confirmarCorreo        | contrasenia   | confirmarContrasenia |
      | 1234567890      | Prueba desde auto | pruerbauto@example.com | pruerbauto@example.com | ClaveFuerte#1 | ClaveFuerte#1        |
    Entonces se debe verificar que el usuario haya sido registrado correctamente y redirigido a su perfil