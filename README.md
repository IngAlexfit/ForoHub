<h1 align="center">🎯 ONE - Challenge LiterAlura</h1>

<div align="center">

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=black)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Proyecto Terminado](https://img.shields.io/badge/Estado-Proyecto%20Terminado-brightgreen)

</div>

## 📚 Descripción del Proyecto
> Este proyecto es una aplicación de foro desarrollada como parte del desafío LiterAlura. Permite a los usuarios crear, actualizar, listar y eliminar tópicos, así como gestionar categorías y usuarios.

## 🚀 Inicio Rápido

### 📋 Prerrequisitos
- Java 11 o superior
- PostgreSQL
- Maven

### ⚙️ Instalación

1. **Clonar el repositorio:**
```bash
git clone https://github.com/IngAlexfit/ForoHub.git
```

2. **Configurar base de datos:**
  - Editar `src/main/resources/application.properties`
  - Ajustar credenciales de PostgreSQL

3. **Construir y ejecutar el proyecto**

## ✨ Funcionalidades
- 📝 Crear, actualizar, listar y eliminar tópicos
- 🏷️ Gestión de categorías
- 🔐 Autenticación y autorización de usuarios
- 🎫 Generación de tokens JWT

## 💡 Ejemplo de Uso

**Crear un nuevo tópico:**
```json
POST /topicos
{
  "title": "Nuevo Tópico",
  "message": "Contenido del tópico",
  "categoryId": 1
}
```

**Listar todos los tópicos:**
```bash
GET /topicos
```

## 🛠️ Tecnologías
- Java
- Spring Boot
- JPA/Hibernate
- PostgreSQL

## 📖 API Endpoints

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/topicos` | Listar todos los tópicos |
| GET | `/topicos/{id}` | Obtener un tópico por ID |
| POST | `/topicos` | Crear un nuevo tópico |
| PUT | `/topicos/{id}` | Actualizar un tópico |
| DELETE | `/topicos/{id}` | Eliminar un tópico |

## 👤 Autor
**Dev. Alex Puello**

---
<div align="center">
⌨️ con ❤️ por Alex Puello
</div>
