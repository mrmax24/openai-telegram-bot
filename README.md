# Telegram bot 🤖 + OpenAi 💬 (SpringBoot/Angular)
## Project description:
```
A Telegram chat bot integrated with ChatGPT, provided with an administrator panel designed to monitor
user activity, statistics, and facilitate communication with users. The interaction between the bot
and the admin panel is powered by Spring Boot, while the frontend part is implemented using Angular.
```

[Link to project presentation](https://www.youtube.com/watch?v=6HM09NYBk8w)

## Project structure

#### <u>API</u>
The Admin panel part has a Three-Tier Architecture:
- **Presentation layer** (Controller) - accepts requests from clients and sends results back to them.
- **Application logic** layer (Service) - provide logic to operate on the data sent to and from the Repository and the client.
- **Data access layer** (Repository) - represents a bridge between the database and the application.

Telegram bot part:
- **Telegram bot logic** - contains logic enabling data exchange between the bot and the interface, 
with integrated functionality for interacting with ChatGPT.

#### <u>FRONTEND</u>
- **Components** - contains the HTML and CSS defining a specific page or UI element, along with TypeScript code 
that handles the logic, user interactions, and communication with the backend in an Angular application.
- **Services** - manage the communication with the backend, encapsulating data retrieval, business logic, and interactions between components.
- **Modules** - organize the Angular application into cohesive blocks, facilitating modularity, encapsulation, and maintainability.
- **Assets** - contains static assets like images or fonts used in the application.

## Used technologies and libraries:
| Technology               | Version  |
|:-------------------------|:---------|
| `JDK`                    | `17`     |
| `Maven`                  | `4.0.0`  |
| `Angular`                | `16.2.10` |
| `Spring Boot`            | `3.1.5`  |
| `Spring Boot Data JPA`   | `3.1.5`  |
| `Spring Boot Web`        | `3.1.5`  |
| `Spring Boot Security`   | `3.1.5`  |
| `Spring Boot Validation` | `3.1.5`  |
| `PostgreSQL`             | `15.1.1` |
| `Mapstruct`              | `1.5.5`  |
| `Telegrambots`           | `5.6.0`  |
| `Lombok`                 | `0.2.0`  |
| `JSON`                   | `20210307` |
| `Jsonwebtoken`           | `0.11.5` |
| `Openai gpt3 api`        | `0.18.1` |
| `Log4j`                  | `2.14.1` |
| `Checkstyle`             | `3.1.1`  |
| `Docker`                 | `24.0.6` |

## Technical details
- **Entities** represent columns in the database;
- **REST** is an architectural style for defining URL structures and interactions with resources
- **DTOs** represent communication between Presentation and Service layers;
- **DTO mappers** convert DTOs to entities and vice versa
- **BCryptPasswordEncoder** is used for password encryption
- **Hibernate annotations** are used for field validation
- **Custom annotations** are used for email and password validation
- **Jackson API** is responsible for converting objects to JSON
- **JWT-token** provides URL-safe means of representing claims to be transferred between two parties
- **Docker** allows to containerize app for efficient data management
- **CORS** allows you to specify which domains have access to resources on your server.
- **GlobalExceptionHandler** providing a uniform way to handle errors and respond with customized messages
- **Config package** contains classes allow to configure Spring Security and mapping
- **Security package** contains classes, allows to create UserDetails which store user information,
create and validate JWT token and authenticate;


## Steps to run the program on your computer:
1. Clone the repo: https://github.com/mrmax24/openai-telegram-bot;
2. Install PostgreSQL;
3. Create new schema in database;
4. Add you DB properties to **application.properties** file;
5. Create connection to DB using Database option (Intellij Idea Ultimate);
6. Install Angular CLI in **/frontend** using command `npm install -g @angular/cli`;
7. Run Angular using command `ng serve`;
8. Done. Now just run Spring and navigate to http://localhost:4200;
