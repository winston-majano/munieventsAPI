
## Munievents API

**Descripción**:  
Munievents es una aplicación de tipo API-REST creada con las siguientes tecnologías:

- **Spring Boot**
- **JPA**
- **MySQL**
- **Lombok**
- **Java**

---

## Tecnologías Utilizadas

- **Spring Boot**: Framework para crear aplicaciones Java basadas en Spring.
- **JPA (Java Persistence API)**: Especificación para la gestión de datos en aplicaciones Java.
- **MySQL**: Sistema de gestión de bases de datos relacional.
- **Lombok**: Biblioteca que ayuda a reducir el código boilerplate en Java.
- **Java**: Lenguaje de programación utilizado para desarrollar la aplicación.

---

## Configuración del Proyecto

### Requisitos Previos

- **Java JDK**: Asegúrate de tener instalado Java JDK 17 o superior.
- **Maven**: Necesitarás Maven para gestionar las dependencias del proyecto.

### Instalación

1. Clona el repositorio:  ```
git clone https://github.com/winston-majano/munieventsAPI.git ```
2. Navega al directorio del proyecto:   ``` cd munievents ```
3. Compila el proyecto usando Maven: ``` ./mvnw clean install ```
4. Ejecuta la aplicación: ``` ./mvnw spring-boot:run```





## Endpoints

### Categorías

- **GET** `/api/v1/category`: Obtiene todas las categorías.
- **GET** `/api/v1/category/{idCategory}`: Obtiene una categoría por ID.
- **POST** `/api/v1/category`: Crea una nueva categoría.
- **PUT** `/api/v1/category/{id}`: Actualiza una categoría existente.
- **DELETE** `/api/v1/category/{id}`: Elimina una categoría por ID.

### Eventos

- **GET** `/api/v1/events`: Obtiene todos los eventos.
- **GET** `/api/v1/events/{idEvent}`: Obtiene un evento por ID.
- **POST** `/api/v1/events`: Crea un nuevo evento.
- **PUT** `/api/v1/events/{id}`: Actualiza un evento existente.
- **DELETE** `/api/v1/events/{id}`: Elimina un evento por ID.

### Noticias

- **GET** `/api/v1/news`: Obtiene todas las noticias.
- **GET** `/api/v1/news/{idNews}`: Obtiene una noticia por ID.
- **POST** `/api/v1/news`: Crea una nueva noticia.
- **PUT** `/api/v1/news/{id}`: Actualiza una noticia existente.
- **DELETE** `/api/v1/news/{id}`: Elimina una noticia por ID.

### Usuarios

- **GET** `/api/v1/users`: Obtiene todos los usuarios activos.
- **GET** `/api/v1/users/{id}`: Obtiene un usuario por ID.
- **POST** `/api/v1/users`: Crea un nuevo usuario.
- **PUT** `/api/v1/users/{id}`: Actualiza un usuario existente.
- **DELETE** `/api/v1/users/{id}`: Desactiva un usuario por ID.

---

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, por favor sigue estos pasos:

1. Haz un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -m 'Añadir nueva característica'`).
4. Haz push a la rama (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.

6. Clona el repositorio:
   ```bash
   git clone https://github.com/winston-majano/munieventsAPI.git


2.


cd munievents
