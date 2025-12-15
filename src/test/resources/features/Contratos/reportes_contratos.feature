# language: es
# author: Yon

Característica: Generar reporte de contratos
  Como usuario autenticado en ManageHR
  Quiero generar reporte de contratos
  Para poder visualizar y poder descargar el reporte

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión de Managehr
    Cuando ingrese las credenciales correctas (correo y clave)
      | email       | clave  |
      | admin@sena.com | 123456 |
    Entonces debo ser redirigido a la página principal del sistema

    @reporte_contratos
    Escenario: Generar y descargar reporte de contratos en diferentes formatos
      Dado
      Cuando doy clic en "Contratos"
      Entonces debo visualizar que me encuentro en "Gestión de Contratos"

      Cuando doy clic en "Reporte por Usuario"
      Entonces se debe visualizar el modal con el reporte

      Cuando doy clic en el botón "Descargar Excel"
      Entonces se debe descargar el archivo Excel en la carpeta de descargas

      Cuando doy clic en "Descargar PDF"
      Entonces se debe descargar un archivo PDF

      Cuando doy clic en el botón "Cerrar"
      Entonces el modal debe cerrarse
