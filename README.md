# gRPC with Spring Boot - Modular Example

This project demonstrates how to integrate **gRPC** into a **Spring Boot microservices** architecture using a modular approach. It contains three modules:

- `grpc-library` – defines the `.proto` files and generates gRPC Java stubs.
- `grpc-server` – a Spring Boot app that implements and exposes a gRPC service.
- `grpc-client` – a Spring Boot app that consumes the gRPC service via the generated stubs.

---


---

## Module Breakdown

### `grpc-library`
- Contains the `.proto` file(s).
- Configured to generate Java stubs during the build process.
- These stubs are used by both `grpc-client` and `grpc-server`.

### `grpc-server`
- Exposes a gRPC endpoint using the generated code from `grpc-library`.
- Uses `@GrpcService` (via grpc-spring-boot-starter or custom setup).
- Runs on a configurable gRPC port (e.g., 9090).

### `grpc-client`
- Injects the gRPC stub and invokes remote procedures exposed by the server.
- Configurable with the gRPC server address and port (e.g., localhost:9090).
- Runs on a separate HTTP port from the server to avoid conflicts.

---

## Prerequisites

- Java 17+
- Maven 3.6+
- IntelliJ IDEA or any Java IDE with Maven support

---

## Running the Example

### 1. Clone the repository

```bash
git clone https://github.com/rahulk270486/grpc-example.git
cd grpc-example
mvn clean install
```

#### This will generate gRPC stubs in grpc-library and make them available to the client and server.

### 2. Start the gRPC Server

```bash
cd grpc-server
mvn spring-boot:run
```

#### The server will start and listen for gRPC requests on the configured port (e.g., 9090).

### 3. Start the gRPC Client (in a new terminal)

```bash
cd grpc-client
mvn spring-boot:run
```

#### The client will call the gRPC service and log the response whenever invoked through controller.

---

👤 Author

Rahul K

Senior Technical Architect | Java • Spring Boot • Kafka • Cloud

🔗 [LinkedIn](https://www.linkedin.com/in/rahul-kumar-9754b919/)




