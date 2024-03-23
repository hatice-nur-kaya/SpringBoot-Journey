# Socket.io
This is an example project demonstrating how to use Socket.io with a Spring Boot application.

## Technologies Used

- Java
- Spring Boot
- Socket.io
- MongoDB (optional, if used in the project)

## Project Structure

The project is structured as follows:

- `src/`: Contains the source code of the Spring Boot application.
  - `main/`: Main source code.
    - `java/`: Java source files.
      - `com/example/socketio/`: Main package for Socket.io related code.
    - `resources/`: Resource files such as application.properties.
  - `test/`: Contains test files.

## Getting Started

To run the project locally, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/socket-io-example.git`
2. Navigate to the project directory: `cd socket-io-example`
3. Build the project: `./mvnw clean package`
4. Run the project: `java -jar target/socket-io-example.jar`
5. Open your web browser and go to: `http://localhost:8080`

## Usage

- Register/Login: Use the provided forms to register or login to the application.
- Messaging: Once logged in, you can send and receive real-time messages using Socket.io.
- Chat Rooms: Create or join chat rooms to communicate with other users.

## Credits

This project is inspired by [Socket.io documentation](https://socket.io/docs/) and [Spring Boot documentation](https://spring.io/projects/spring-boot).

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
