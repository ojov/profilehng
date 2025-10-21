# Backend Wizards — Stage 0 Task

A simple REST API that returns my profile information and a random cat fact.

---

## 🚀 Endpoint

**GET** `/me`

### Example Response
```json

{
  "status": "success",
  "user": {
    "email": "osamudiamen@example.com",
    "name": "Osamudiamen Ojo",
    "stack": "Java/Spring Boot"
  },
  "timestamp": "2025-10-16T12:34:56.789Z",
  "fact": "Cats sleep for 70% of their lives."
}