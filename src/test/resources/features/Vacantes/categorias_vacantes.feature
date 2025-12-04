# language: es

Característica: Gestión de categorías de vacantes
  Como administrador de Managehr
  Quiero crear, consultar, editar y eliminar categorías de vacantes
  Para mantener organizado el catálogo de vacantes

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión de Managehr
    Cuando ingrese las credenciales correctas (correo y clave)
      | email          | clave  |
      | admin@sena.com | 123456 |
    Y navega al módulo de categorías de vacantes

  @categorias_vacantes
  Escenario: CRUD completo de categoría de vacante
    Cuando crea una nueva categoría de vacante
      | nombre          | descripcion              |
      | QA Automatizado | Pruebas automatizadas QA |
    Y consulta la categoría de vacante por nombre "QA Automatizado"
    Y edita la categoría de vacante
      | nombreActual    | nuevoNombre       | nuevaDescripcion               |
      | QA Automatizado | QA Automatizado 2 | Categoría editada para pruebas |
    Y busca la categoría de vacante por nombre "QA Automatizado 2"
    Y elimina la categoría de vacante con nombre "QA Automatizado 2"

