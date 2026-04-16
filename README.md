<p align="center">
  <img src="assets/banner.png" alt="Banner" width="560"/>
</p>

# Email Service
Este repositorio es un **utilitario para aplicaciones Spring Boot de uso general**.  
Su propósito es ofrecer una base flexible para enviar correos electrónicos mediante estrategias personalizadas.

## Cómo usarlo
1. **Implementa tus propias estrategias**
    - Define las clases en `domain/strategies` según la lógica de envío que necesites.
    - Cada estrategia puede manejar un tipo de correo distinto (ejemplo: bienvenida, notificaciones, alertas).

2. **Renderiza el contenido HTML del correo**
    - Personaliza el cuerpo del mensaje en la estrategia.