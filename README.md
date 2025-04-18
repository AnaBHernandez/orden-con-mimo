# 🏰 Orden con MIMO - Backend

API REST para la aplicación de organización personal que implementa el método MIMO (Mírate, Imagina, Muévete, Ordena) con temática de Reino Fantástico.

## 🎨 Método MIMO

El método MIMO divide las tareas en cuatro categorías representadas por colores:

| Categoría | Color | Código | Descripción |
|-----------|-------|--------|-------------|
| **Mírate** | Púrpura | `#614385` | Tareas de autocuidado y desarrollo personal |
| **Imagina** | Dorado | `#F1C40F` | Tareas creativas y de planificación |
| **Muévete** | Naranja | `#E67E22` | Tareas que requieren acción inmediata |
| **Ordena** | Verde | `#27AE60` | Tareas de organización y estructura |

## 🛠️ Tecnologías

- Java 21
- Spring Boot 3.2.x
- Spring Data JPA
- Spring Security 
- H2 Database (desarrollo)
- Maven

## 🚀 Instalación y Ejecución

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/AnaBHernandez/orden-con-mimo-backend.git
   cd orden-con-mimo-backend
2. Compilar con Maven:
mvn clean install

4. Ejecutar la aplicación:
mvn spring-boot:run

5. La API estará disponible en:
http://localhost:8080/api
```
📊 Estructura del Proyecto
src/
├── main/
│   └── java/
│       └── com/
│           └── ordenconmimo/
│               ├── config/           # Configuraciones (CORS, seguridad)
│               ├── espacio/          # Módulo de gestión de espacios
│               │   ├── controladores/
│               │   ├── modelos/
│               │   ├── repositorios/
│               │   └── servicios/
│               ├── usuario/          # Módulo de gestión de tareas y usuarios
│               │   ├── controladores/
│               │   ├── modelos/
│               │   ├── repositorios/
│               │   └── servicios/

```
```
🌐 API REST
🗂️ Tareas
GET /api/tareas: Listar todas las tareas
GET /api/tareas/{id}: Obtener una tarea por ID
GET /api/tareas/categoria/{categoria}: Filtrar tareas por categoría MIMO
POST /api/tareas: Crear una nueva tarea
PUT /api/tareas/{id}: Actualizar una tarea existente
DELETE /api/tareas/{id}: Eliminar una tarea
```

```
🏠 Espacios
GET /api/espacios: Listar todos los espacios
GET /api/espacios/{id}: Obtener un espacio por ID
POST /api/espacios: Crear un nuevo espacio
PUT /api/espacios/{id}: Actualizar un espacio existente
DELETE /api/espacios/{id}: Eliminar un espacio
GET /api/espacios/{id}/tareas: Listar tareas de un espacio
```
🧪 Ejecutar Tests
mvn test

```
📚 Documentación
Para más detalles sobre el proyecto, consulta:
Wiki de arquitectura
Guía de desarrollo
Documentación de API (disponible al ejecutar la aplicación)
```
📝 Licencia
Este proyecto está licenciado bajo la Licencia MIT - ver el archivo LICENSE para más detalles.

## 💡 Notas sobre las Mejoras

1. **Estructura visual mejorada**:
   - Uso de emojis para mejorar la legibilidad
   - Formato de tabla para las categorías MIMO
   - Estructura jerárquica clara con encabezados

2. **Información técnica ampliada**:
   - Lista completa de tecnologías actualizadas (Java 21)
   - Estructura del proyecto más detallada
   - Comandos de instalación más claros

3. **Documentación de API**:
   - Listado completo de endpoints organizados por entidad
   - Formato claro para los métodos HTTP y rutas

4. **Características adicionales**:
   - Sección dedicada al método MIMO con los colores
   - Referencias a documentación adicional
   - Instrucciones para ejecutar tests

