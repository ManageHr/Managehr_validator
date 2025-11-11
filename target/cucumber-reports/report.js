$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/horas_extra.feature");
formatter.feature({
  "name": "Registro de Horas Extra",
  "description": "  Como usuario autenticado en ManageHR\n  Quiero registrar una solicitud de horas extra\n  Para dejar evidencia de mis horas adicionales trabajadas",
  "keyword": "Característica"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Antecedentes"
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
        "sharon@gmail.com",
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
formatter.scenario({
  "name": "Registrar horas extra exitosamente",
  "description": "",
  "keyword": "Escenario",
  "tags": [
    {
      "name": "@horas_extra"
    }
  ]
});
formatter.step({
  "name": "registra una solicitud de horas extra",
  "rows": [
    {
      "cells": [
        "descripcion",
        "fecha",
        "tipo",
        "cantidad"
      ]
    },
    {
      "cells": [
        "Prueba2 QA",
        "20/11/2025",
        "2",
        "3"
      ]
    }
  ],
  "keyword": "Cuando "
});
formatter.match({
  "location": "HorasExtraStepDefinitions.registraUnaSolicitudDeHorasExtra(HorasExtraUsuario\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "debe visualizar la confirmación de envío de la solicitud",
  "keyword": "Entonces "
});
formatter.match({
  "location": "HorasExtraStepDefinitions.debeVisualizarLaConfirmaciónDeEnvíoDeLaSolicitud()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "debe aparecer una alerta de exito y cerrarse",
  "keyword": "Y "
});
formatter.match({
  "location": "HorasExtraStepDefinitions.debeAparecerUnaAlertaDeExitoYCerrarse()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "registra una solicitud de horas extra sin descripcion",
  "rows": [
    {
      "cells": [
        "descripcion",
        "fecha",
        "tipo",
        "cantidad"
      ]
    },
    {
      "cells": [
        "",
        "20/11/2025",
        "2",
        "3"
      ]
    }
  ],
  "keyword": "Cuando "
});
formatter.match({
  "location": "HorasExtraStepDefinitions.registraUnaSolicitudDeHorasExtraSinDescripcion(HorasExtraUsuario\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "debe visualizar el mensaje de error en el formulario de horas extra",
  "keyword": "Entonces "
});
formatter.match({
  "location": "HorasExtraStepDefinitions.debeVisualizarElMensajeDeErrorEnElFormularioDeHorasExtra()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "se debe cerrar la alerta",
  "keyword": "Y "
});
formatter.match({
  "location": "HorasExtraStepDefinitions.seDebeCerrarLaAlerta()"
});
formatter.result({
  "status": "passed"
});
});