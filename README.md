Grupo Bastión

ALKEWALLET-Entrega Módulo 2

|       Integrante        |    Rol        |
| :---------------------- | :------------ |
| 👤 **Felipe Martínez**  | Desarrollador |
| 👤 **Manuel Damke**     | Desarrollador |
| 👤 **Eugenio Zúñiga**   | Desarrollador |

# 💳 AlkeWallet

![Java](https://img.shields.io/badge/Java-17%2F21-orange?logo=openjdk)
![Maven](https://img.shields.io/badge/Maven-Build-red?logo=apachemaven)
![JUnit](https://img.shields.io/badge/Tests-JUnit5-brightgreen?logo=junit5)
![Status](https://img.shields.io/badge/Estado-En%20Desarrollo-yellow)

Aplicación de billetera digital desarrollada en **Java**, que permite crear cuentas, administrar saldo (depósitos y retiros) y realizar **conversión de moneda**, manteniendo precisión financiera mediante el uso de `BigDecimal`.  
Incluye **menú interactivo por consola** y **pruebas unitarias con JUnit**.

---

## 📌 Funcionalidades

- Crear cuenta indicando titular y moneda base
- Ver saldo disponible
- Ingresar dinero
- Retirar dinero con validación de fondos
- Convertir saldo entre monedas (USD, CLP, EUR…)
- Manejo económico preciso usando `BigDecimal`
- Arquitectura orientada a objetos
- Menú interactivo con `Scanner`

---

## 🛠 Tecnologías utilizadas

| Herramienta | Uso |
|------------ |------|
| Java  21    | Desarrollo de la aplicación |
| Maven       | Gestión de dependencias y build |
| JUnit 5     | Pruebas unitarias |
| JavaDoc     | Documentación del código

---

## 📂 Estructura del proyecto

```text
alkewallet/
├── src/
│ ├── main/java/cl/alkewallet/
│ │ ├── App.java # Menú principal en consola
│ │ ├── Cuenta.java # Clase modelo
│ │ ├── Convertidor.java # Interface conversión
│ │ ├── ConvertidorImplementacion.java
│ │ ├── TipoMoneda.java # Enum de monedas
│ │ └── ...
│ └── test/java/cl/alkewallet/
│ ├── CuentaTest.java # Test creación de cuenta
│ └── ConvertidorTest.java # Test conversión de moneda
| 
├── target/  #Documentación
└── pom.xml
```

---

## 🚀 Instalación y Ejecución

### Prerrequisitos

*   Tener instalado el **Java Development Kit (JDK)** (versión 21).

### Pasos

1.  **Clonar el repositorio** (o descargar los archivos):
    ```bash
    git clone <url-del-repositorio>
    ```

2.  **Navegar al directorio del proyecto**:
    ```bash
    cd AlkeWallet
    ```

3.  **Compilar el proyecto**:
    ```bash
    javac App.java
    ```

4.  **Ejecutar la aplicación**:
    ```bash
    java App
    ```

5.  **Menú de la aplicación**:
    ```bash
    ![imagen](https://github.com/escaheche/AlkeWallet/imagenes/menu.png)
    ```

## 💵 Tasas de Conversión (Referenciales)

El sistema utiliza las siguientes tasas de conversión fijas para la demostración:

*   1 USD = 770 CLP
*   1 EUR = 900 CLP

*   *Desarrollado para el bootcamp DESARROLLO DE APLICACIONES MÓVILES ANDROID TRAINEE V2.0*
