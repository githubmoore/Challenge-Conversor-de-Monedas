# 💸 Conversor de Monedas

## 📜 ¿Qué es esto?

Este proyecto es un **Conversor de Monedas** sencillo y práctico desarrollado en Java. Utiliza una API de tasas de cambio para obtener las tasas de conversión más recientes entre diferentes divisas, permitiendo realizar cálculos precisos de conversión entre monedas con solo unos pocos clics.

## 🚀 ¿Cómo funciona?

1. **Obtén las tasas de cambio**: El programa se conecta a una API de tasas de cambio para obtener los valores actualizados.
2. **Selecciona las monedas**: Puedes elegir entre varias monedas, como el Peso Chileno (CLP), Dólar Estadounidense (USD), Peso Argentino (ARS), y más.
3. **Introduce el monto**: Escribe la cantidad que deseas convertir en la divisa de origen.
4. **Convierte**: El programa realiza la conversión al instante y muestra el valor equivalente en la divisa de destino.

## 🌍 Monedas soportadas

- **CLP**: Peso Chileno
- **USD**: Dólar Estadounidense
- **ARS**: Peso Argentino
- **BOB**: Boliviano
- **BRL**: Real Brasileño
- **COP**: Peso Colombiano

## 🔑 ¿Cómo funciona internamente?

El conversor utiliza una serie de clases y herramientas en Java para realizar las siguientes acciones:

1. **Conexión HTTP**: Usamos la clase `HttpClient` para hacer solicitudes a la API de tasas de cambio.
2. **Parámetros de solicitud**: Personalizamos la solicitud HTTP con `HttpRequest` para obtener datos de las divisas específicas.
3. **Manejo de respuestas**: Utilizamos `HttpResponse` para recibir y procesar la respuesta JSON.
4. **Análisis JSON**: Con la biblioteca Gson, parseamos los datos JSON obtenidos de la API para extraer las tasas de conversión.
5. **Conversión**: Aplicamos las tasas de cambio obtenidas para realizar la conversión entre monedas seleccionadas.

## 🛠️ Tecnologías utilizadas

Este proyecto está desarrollado utilizando:

- **Java JDK 11**: Para el desarrollo del código.
- **Gson**: Biblioteca para manipular y parsear JSON.
- **HttpClient**: Para realizar las solicitudes HTTP a la API.
- **IntelliJ IDEA**: IDE opcional para facilitar el desarrollo.
- **Postman**: Para probar las solicitudes y respuestas de la API.

## 💡 ¿Cómo puedo usar este conversor?

Sigue estos pasos para usar el conversor de monedas en tu máquina local:

1. Clona este repositorio:
    ```bash
    git clone https://github.com/GitHubMoore/Challenge-Conversor-de-Monedas.git
    ```
2. Asegúrate de tener instalado **Java JDK 11** o superior.
3. Agrega la biblioteca **Gson** a tu proyecto.
4. Configura tu clave de API obtenida de [ExchangeRate-API](https://www.exchangerate-api.com/).
5. Ejecuta el programa y selecciona las monedas para realizar la conversión.

## ⚠️ Problemas conocidos

- **Compatibilidad**: Este programa es compatible con versiones modernas de Java (JDK 11 en adelante).
- **Conexión a la API**: La conversión depende de una conexión estable a Internet para obtener las tasas de cambio en tiempo real.

## 🤝 ¿Cómo contribuir?

¡Nos encantaría contar con tu contribución! Puedes ayudar de las siguientes maneras:

- Reportando problemas o errores en el programa.
- Sugerir nuevas características o mejoras en el conversor.
- Traducir este README a otros idiomas.
  
Simplemente abre un "issue" o haz un "pull request" en el repositorio.

## 📄 Licencia

Este proyecto está bajo la licencia **MIT**, lo que significa que puedes usar, modificar y distribuir libremente el código, siempre y cuando mantengas los derechos de autor y la licencia original.

## ✍️ Autor

Proyecto creado por **GitHubMoore**. ¡Gracias por utilizar este conversor de monedas! 😊
