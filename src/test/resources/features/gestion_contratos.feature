# language: es

Característica: Gestión de contratos
  Como administrador de Managehr
  Quiero registrar contratos desde el módulo de Gestión de Contratos
  Para mantener actualizada la información contractual del personal

  @contratos
  Escenario: Registrar un nuevo contrato
    Dado que el usuario se encuentra en la página de inicio de sesión de Managehr
    Cuando ingrese las credenciales correctas (correo y clave)
      | email          | clave  |
      | admin@sena.com | 123456 |
    Y registra un nuevo contrato en el módulo de contratos
      | documento | tipoContrato            | estado | fechaIngreso | fechaFinal   | area     | cargo    | archivo          |
      | 103293999 | Contrato a término fijo | Activo | 01/05/2024   | 01/05/2025   | Finanzas | Empleado | contratoDemo.pdf |
    Entonces el contrato con documento "103293999" debe quedar registrado en la tabla de contratos
