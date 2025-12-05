Grupo Bastión

ALKEWALLET-Entrega Módulo 2

Integrantes

Felipe Martínez

Manuel Damke

Eugenio Zúñiga


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
|------------|------|
| Java 17/21 | Desarrollo de la aplicación |
| Maven | Gestión de dependencias y build |
| JUnit 5 | Pruebas unitarias |
| BigDecimal | Manejo de dinero sin errores de precisión |

---

## 📂 Estructura del proyecto


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
└── pom.xml


---

## ▶ Cómo ejecutar el proyecto

### 1. Compilar

```bash
mvn clean compile

2. Ejecutar aplicación
mvn exec:java -Dexec.mainClass="cl.alkewallet.App"

🧪 Ejecutar pruebas
mvn test
