# Smart Campus: Sensor & Room Management API
**Module:** Client-Server Architectures (5COSC022W)
**Lead Backend Architect:** [Your Name]

---

## 1. Project Overview
[cite_start]This project is a high-performance RESTful web service built using JAX-RS (Jakarta RESTful Web Services)[cite: 35]. [cite_start]It provides a seamless interface for campus facilities managers to manage thousands of Rooms and various Sensors (CO2, occupancy, lighting) within the "Smart Campus" infrastructure[cite: 34, 36].

## 2. API Design & Hierarchy
[cite_start]The API follows a logical resource hierarchy reflecting the physical campus structure[cite: 39]:
- [cite_start]`/api/v1/rooms`: Management of campus rooms[cite: 114].
- [cite_start]`/api/v1/sensors`: Management of hardware sensors[cite: 128].
- [cite_start]`/api/v1/sensors/{id}/readings`: Nested historical data for specific sensors[cite: 141].

## 3. Setup & Build Instructions
Follow these steps to run the server locally:
1. **Prerequisites:** Ensure you have Java 17+ and Maven installed.
2. **Clone the repo:** `git clone [Your Repo Link]`
3. **Build the project:** Run `mvn clean install` in the terminal.
4. **Launch the Server:** [Insert your specific command, e.g., `mvn exec:java` or how you run your embedded server].
5. **Base URL:** The API is accessible at `http://localhost:8080/api/v1`.

## 4. Sample CURL Commands
[cite_start]Use these commands to test the API functionality[cite: 176]:

### A. Discovery Endpoint
```bash
curl -X GET http://localhost:8080/api/v1


