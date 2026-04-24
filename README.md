# SmartCampus API

## Overview
The **SmartCampus API** is a RESTful service for managing rooms, sensors, and sensor readings in a campus environment.  
It demonstrates:
- A **Discovery endpoint** (`GET /api/v1`) for API metadata.
- **CRUD operations** for rooms and sensors.
- **Validation and error handling** with proper HTTP codes (404, 409, 422, 403).
- **Cross-cutting logging** using JAX-RS filters.
- Support for **Java 8 date/time types** via Jackson JSR310 module.

---

## Build & Launch Instructions

### Prerequisites
- Java JDK 21  
- Apache Maven 3.8+  
- NetBeans 24 (optional, for IDE integration)

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/smartcampus-api.git
   cd smartcampus-api
   
2. Build the project:
   mvn clean install

3. Launch the server:
   mvn exec:java -Dexec.mainClass="com.smartcampus.Main"

4. Access the API at:
   http://localhost:9091/api/v1/

### Sample curl commands
1. Discovery endpoint
   curl -X GET http://localhost:9091/api/v1

2. Create a room
   curl -X POST http://localhost:9091/api/v1/rooms \
     -H "Content-Type: application/json" \
     -d '{"id":101,"name":"Lab A","capacity":40}'

3. List all rooms
   curl -X GET http://localhost:9091/api/v1/rooms

4. Add a sensor to a room
   curl -X POST http://localhost:9091/api/v1/sensors \
     -H "Content-Type: application/json" \
     -d '{"id":201,"type":"CO2","roomId":101}'

5. Add a sensor reading
   curl -X POST http://localhost:9091/api/v1/sensors/201/readings \
     -H "Content-Type: application/json" \
     -d '{"timestamp":"2026-04-24T03:00:00","value":215}'

    



