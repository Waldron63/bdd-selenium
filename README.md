# bdd-selenium

## Introducción

**bdd-selenium** es un proyecto de automatización de pruebas web que combina las metodologías **BDD** (*Behavior-Driven Development*) con **Selenium WebDriver**. El objetivo es demostrar cómo escribir pruebas de aceptación legibles por humanos utilizando el lenguaje Gherkin a través de Cucumber, y ejecutarlas de forma automatizada contra un navegador Chrome en modo *headless*.

### ¿Cómo se generó este repositorio?

El repositorio se construyó de forma incremental:

1. **Pruebas unitarias base**: Se configuró la estructura Maven del proyecto y se implementó el primer escenario BDD (`google_search.feature`) con sus pasos en `SearchSteps.java`, estableciendo la inicialización del `ChromeDriver` en modo *headless*, la navegación a Google, la búsqueda de un término y la verificación del resultado.
2. **Parte Hovers**: Se añadió el escenario `hovers.feature` orientado a interacciones de tipo *hover*, aplicando el patrón **Page Object Model** mediante `HoversPage.java` y sus pasos en `HoversSteps.java`, que navegan al sitio de pruebas [the-internet.herokuapp.com/hovers](https://the-internet.herokuapp.com/hovers), simulan el paso del ratón por encima del primer usuario y validan que aparezca el nombre de usuario correspondiente.

---

## Prerrequisitos

Asegúrate de contar con los siguientes elementos antes de ejecutar el proyecto:

| Herramienta | Versión requerida | Comando de verificación |
|---|---|---|
| Java (JDK) | 17 | `java -version` |
| Maven | 3.8+ | `mvn -version` |
| Google Chrome | Última estable | `google-chrome --version` |
| ChromeDriver | Compatible con Chrome instalado | `chromedriver --version` |

> **Nota sobre GitHub Codespaces**: El repositorio incluye un archivo `.devcontainer/devcontainer.json` que aprovisiona automáticamente Java 17, Maven (vía SDKMAN), Node.js LTS y Chrome con ChromeDriver al abrir el proyecto en un Codespace. No necesitas instalar ninguna dependencia manualmente.

---

## Instalación

### Desde GitHub Codespaces (recomendado)

1. Abre el repositorio en GitHub.
2. Haz clic en el botón **Code** → **Codespaces** → **Create codespace on main**.
3. Espera a que el contenedor termine de construirse (Java, Maven y Chrome se instalan automáticamente).
4. Una vez abierto el terminal integrado, instala las dependencias del proyecto:
   ```bash
   mvn install -DskipTests
   ```
5. El entorno está listo para ejecutar las pruebas.

### Localmente

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Waldron63/bdd-selenium.git
   cd bdd-selenium
   ```
2. Asegúrate de tener instalado Java 17 y Maven.
3. Instala Google Chrome y descarga la versión de [ChromeDriver](https://chromedriver.chromium.org/downloads) que corresponda a tu versión de Chrome. Coloca el binario en `/usr/local/bin/chromedriver` (Linux/Mac) o ajusta la ruta en `SearchSteps.java` y `HoversSteps.java`.
4. Descarga las dependencias del proyecto:
   ```bash
   mvn install -DskipTests
   ```

---

## Entorno

### Estructura del proyecto

```
bdd-selenium/
├── .devcontainer/
│   └── devcontainer.json
├── .gitignore
├── pom.xml
└── src/
    ├── main/com/eci/bddSelenium/          ← App.java (placeholder)
    └── test/
        └── java/
            └── com/
                └── eci/
                    └── bddSelenium/
                        ├── features/
                        │   ├── google_search.feature
                        │   └── hovers.feature
                        ├── pages/
                        │   └── HoversPage.java
                        ├── runners/
                        │   └── TestRunner.java
                        └── steps/
                            ├── HoversSteps.java
                            └── SearchSteps.java
```

### Flujo de las pruebas con Selenium

Los tests siguen este ciclo de vida dentro de los archivos:

1. **Feature** (`.feature`): Define el escenario en lenguaje Gherkin con pasos `Given / When / Then`.
2. **Steps** (`steps/`): Cada anotación (`@Given`, `@When`, `@Then`) instancia el `ChromeDriver` en modo *headless*, navega a la URL objetivo y realiza acciones sobre la página.
3. **Pages** (`pages/`): Las clases Page Object encapsulan los localizadores (`@FindBy`) y las interacciones (`Actions`) para mantener los pasos limpios y reutilizables.
4. **Runner** (`runners/TestRunner.java`): Orquesta la ejecución de todos los escenarios mediante `@CucumberOptions`, apuntando a la carpeta `features/` y al paquete `steps/`.
5. **Reportes**: Al finalizar, Cucumber genera informes en `target/` en formato JUnit XML, JSON y HTML.

### BDD

#### `features/` — google_search

| Escenario | Descripción |
|---|---|
| **Search for a term** | Abre la página de búsqueda de Google, ingresa el término "GitHub" en el campo de búsqueda y verifica que el término aparezca en el código fuente de la página de resultados. |

#### `features/` — hovers

| Escenario | Descripción |
|---|---|
| **Hover over first user and display profile** | Navega a la página de pruebas de *hovers* en [the-internet.herokuapp.com](https://the-internet.herokuapp.com/hovers), simula el movimiento del ratón sobre la primera figura de usuario y verifica que el texto "name: user1" sea visible en la leyenda que aparece. |

---

## Ejecución

<!-- Apartado reservado para agregar comandos de ejecución -->

---

## Construido con

| Herramienta | Versión | Rol |
|---|---|---|
| [Java](https://www.oracle.com/java/) | 17 | Lenguaje principal del proyecto |
| [Maven](https://maven.apache.org/) | 3.8+ | Gestión de dependencias y ciclo de construcción |
| [Selenium WebDriver](https://www.selenium.dev/) | 4.21.0 | Automatización del navegador web |
| [Cucumber](https://cucumber.io/) | 7.0.0 | Framework BDD: escritura y ejecución de escenarios Gherkin |
| [JUnit](https://junit.org/junit4/) | 4.13.2 | Framework de pruebas unitarias e integración con Cucumber |
| [Google Chrome (headless)](https://www.google.com/chrome/) | Última | Navegador utilizado en la ejecución de pruebas |
| [ChromeDriver](https://chromedriver.chromium.org/) | Compatible con Chrome | Puente entre Selenium y el navegador Chrome |
| [GitHub Codespaces / Dev Containers](https://containers.dev/) | — | Entorno de desarrollo reproducible en la nube |

---

## Autor

**Waldron63** — [@Waldron63](https://github.com/Waldron63)
