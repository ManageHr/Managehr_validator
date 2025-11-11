$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/gestion_postulaciones.feature");
formatter.feature({
  "name": "Gestión de postulaciones de usuarios",
  "description": "  Como usuario administrador\n  Quiero poder validar y filtrar los estados de las postulaciones\n  Para que los usuarios puedan ver el estado de su postulación en su perfil",
  "keyword": "Característica"
});
formatter.scenario({
  "name": "Gestión completa del estado de postulaciones",
  "description": "",
  "keyword": "Escenario",
  "tags": [
    {
      "name": "@gestion_postulaciones"
    },
    {
      "name": "@regresion"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que el usuario se encuentra en la página de inicio de sesión de Managehr",
  "keyword": "Dado "
});
formatter.match({
  "location": "AutenticacionStepDefinitions.queElUsuarioSeEncuentraEnLaPáginaDeInicioDeSesiónDeManagehr()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "ingrese las credenciales correctas (correo y clave)",
  "rows": [
    {
      "cells": [
        "email",
        "clave"
      ]
    },
    {
      "cells": [
        "admin@sena.com",
        "123456"
      ]
    }
  ],
  "keyword": "Cuando "
});
formatter.match({
  "location": "AutenticacionStepDefinitions.ingreseLasCredencialesCorrectasCorreoYClave(CredencialesInicioSesion\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "se debe verificar que el usuario haya sido autenticado correctamente y redirigido al directorio de la página Managehr",
  "keyword": "Entonces "
});
formatter.match({
  "location": "AutenticacionStepDefinitions.seDebeVerificarQueElUsuarioHayaSidoAutenticadoCorrectamenteYRedirigidoAlDirectorioDeLaPáginaManagehr()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "navega a la sección \"Vacantes\" y selecciona \"Postulaciones\"",
  "keyword": "Cuando "
});
formatter.match({
  "location": "GestionPostulacionesStepDefinitions.navegaALaSecciónYSelecciona(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "debe ser direccionado a la vista de \"Gestión de Postulaciones\"",
  "keyword": "Entonces "
});
formatter.match({
  "location": "GestionPostulacionesStepDefinitions.debeSerDireccionadoALaVistaDe(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "debe visualizar la tabla con los registros de postulaciones",
  "keyword": "Y "
});
formatter.match({
  "location": "GestionPostulacionesStepDefinitions.debeVisualizarLaTablaConLosRegistrosDePostulaciones()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "hace click en \"Ver Detalles\" de una postulación",
  "keyword": "Cuando "
});
formatter.match({
  "location": "GestionPostulacionesStepDefinitions.haceClickEnDeUnaPostulación(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "debe aparecer un modal con la información completa de la postulación",
  "keyword": "Entonces "
});
formatter.match({
  "location": "GestionPostulacionesStepDefinitions.debeAparecerUnModalConLaInformaciónCompletaDeLaPostulación()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "al hacer click en el botón \"X\" del modal",
  "keyword": "Y "
});
formatter.match({
  "location": "GestionPostulacionesStepDefinitions.alHacerClickEnElBotónDelModal(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "debe cerrarse la información del modal",
  "keyword": "Entonces "
});
formatter.match({
  "location": "GestionPostulacionesStepDefinitions.debeCerrarseLaInformaciónDelModal()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "hace click en el botón \"Editar Estado\" de una postulación",
  "keyword": "Cuando "
});
formatter.match({
  "location": "GestionPostulacionesStepDefinitions.haceClickEnElBotónDeUnaPostulación(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "debe aparecer un modal con un select para cambiar el estado",
  "keyword": "Entonces "
});
formatter.match({
  "location": "GestionPostulacionesStepDefinitions.debeAparecerUnModalConUnSelectParaCambiarElEstado()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "completa el estado a cambiar:",
  "rows": [
    {
      "cells": [
        "campo",
        "valor"
      ]
    },
    {
      "cells": [
        "estado",
        "Pendiente"
      ]
    }
  ],
  "keyword": "Y "
});
formatter.match({
  "location": "GestionPostulacionesStepDefinitions.completaElEstadoACambiar(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "hace click en el botón Guardar",
  "keyword": "Y "
});
formatter.match({
  "location": "GestionPostulacionesStepDefinitions.haceClickEnElBotónGuardar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "debe actualizarse el estado en la tabla de postulaciones",
  "keyword": "Entonces "
});
formatter.match({
  "location": "GestionPostulacionesStepDefinitions.debeActualizarseElEstadoEnLaTablaDePostulaciones()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "hace click en el botón \"Siguiente\" de paginación",
  "keyword": "Cuando "
});
formatter.match({
  "location": "GestionPostulacionesStepDefinitions.haceClickEnElBotónDePaginación(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "debe cargar la segunda página de registros",
  "keyword": "Entonces "
});
formatter.match({
  "location": "GestionPostulacionesStepDefinitions.debeCargarLaSegundaPáginaDeRegistros()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "ingresa datos en el campo de filtrado \"Sharon\"",
  "keyword": "Cuando "
});
formatter.match({
  "location": "GestionPostulacionesStepDefinitions.ingresaDatosEnElCampoDeFiltrado(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "debe filtrar y mostrar solo las postulaciones que coincidan",
  "keyword": "Entonces "
});
formatter.match({
  "location": "GestionPostulacionesStepDefinitions.debeFiltrarYMostrarSoloLasPostulacionesQueCoincidan()"
});
formatter.result({
  "status": "passed"
});
});