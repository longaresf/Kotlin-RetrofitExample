# Android Native API Network Layer & HTTP Client

Este repositorio contiene un módulo especializado en desarrollo móvil nativo para **Android** utilizando **Kotlin**. El proyecto se centra en el diseño e implementación de una capa de red robusta para el consumo eficiente de servicios web externos mediante **Retrofit 2**, gestionando la deserialización automática de datos JSON y optimizando la concurrencia en hilos secundarios.

## 🚀 Características y Capacidades Técnicas

* **Consumo de APIs RESTful:** Configuración avanzada de un cliente HTTP con Retrofit para interactuar con los endpoints de la API de `[...]`.
* **Manejo Asíncrono de Peticiones:** Implementación de flujos de trabajo asíncronos usando Corrutinas de Kotlin (Coroutines) con `suspend functions`.
* **Parseo Automático de Datos:** Integración de conversores de datos como clases de datos nativas de Kotlin (`data class`).
* **Arquitectura de Capas:** Aislamiento completo del cliente de red del resto de la interfaz gráfica, asegurando el principio de responsabilidad única.

## 🛠️ Stack Tecnológico

* **Lenguaje Principal:** Kotlin
* **Plataforma:** Android SDK Nativo
* **Cliente HTTP:** Retrofit 2
* **Conversión de Datos:** Kotlinx Serialization.
* **Gestión de Hilos:** Kotlin Coroutines.

## ⚙️ Arquitectura de Red y Solución de Problemas

El desarrollo de este cliente de red se diseñó resolviendo los desafíos estructurales de la conectividad móvil:

1. **Patrón Creacional (Singleton):** Se implementó una instancia única del cliente de Retrofit para evitar la recreación redundante de sockets de red y optimizar el consumo de memoria en el dispositivo.
2. **Seguridad en la UI (UI Thread Safety):** Toda la lógica de petición y parseo de red se fuerza a ejecutarse fuera del hilo principal del sistema (*Main Thread*), garantizando que la interfaz del usuario permanezca fluida y libre de congelamientos o bloqueos (*ANR - Android Not Responding*).
3. **Manejo de Errores Robustos:** Implementación de bloques de control para capturar fallos comunes de conectividad (dispositivo sin internet, tiempos de espera agotados o códigos de estado HTTP como `404` y `500`).

## 📌 Interfaces y Modelos de Código (Ejemplo)

El núcleo de la comunicación se define mediante la abstracción de interfaces claras:

```kotlin
interface ApiService {
    @GET("endpoint_del_proyecto")
    suspend fun fetchData(): Response<List<YourDataModel>>
}
````
🔧 Configuración e Instalación Local

Para inspeccionar el flujo de red o compilar el proyecto en Android Studio, sigue estos pasos:

    Clonar el repositorio:

  Bash
  git clone [https://github.com/longaresf/android-api-network-layer.git](https://github.com/longaresf/android-api-network-layer.git)

2. Abrir en Android Studio:

    Selecciona File > Open y elige el directorio clonado.

3. Sincronizar Gradle:

    Permite que el sistema descargue las dependencias de Retrofit especificadas en el archivo build.gradle (Module: app).

4. Ejecución:

    Corre la aplicación en un dispositivo físico con depuración USB activa o en un emulador con acceso a internet.

✒️ Autor

    Francisco Longares - Desarrollador Mobile Android - longaresf

