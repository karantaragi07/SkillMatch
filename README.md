# SkillMatch

SkillMatch is a Spring Boot-based web application that matches user resume skills with predefined job roles. It parses PDF resumes, extracts technical skills, and provides job role suggestions based on skill compatibility.

## 🌟 Features

- Upload a PDF resume and extract skills
- Match skills with predefined job roles
- REST API with Swagger UI documentation
- MongoDB for storing job roles
- Simple HTML frontend for testing

---

## 🛠️ Tech Stack

- **Backend:** Java 17, Spring Boot, Spring Data JPA
- **Database:** MongoDB
- **PDF Parsing:** Apache PDFBox
- **API Docs:** Swagger (springdoc-openapi)
- **Build Tool:** Maven
- **Frontend:** HTML + JavaScript (basic)

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven
- MongoDB running locally or via Docker

### Clone the Repo

```bash
git clone https://github.com/karantaragi07/SkillMatch.git
cd SkillMatch
```

### Run the Application
```bash
mvn spring-boot:run
```

### Or build and run:
```bash
mvn clean install
java -jar target/skillmatch-0.0.1-SNAPSHOT.jar
```

📂 API Endpoints
Swagger UI:
➡️ http://localhost:8080/swagger-ui/index.html

### Upload Resume & Extract Skills
POST /api/resume/extract-skills

- Upload a PDF file using form-data (key: file)

- Returns detected skills from the resume

### Match with Job Roles
POST /api/match

- Upload a resume PDF

- Returns best-matched job roles based on skill compatibility


🗃️ Project Structure

SkillMatch
│
├── controller         → API controllers
├── service            → Business logic
├── model              → MongoDB document models
├── util               → Utility classes (e.g., PDF parsing)
├── resources/static   → HTML frontend
└── resources          → Application config (application.yml)


🧪 Testing the App

- Open your browser and go to: http://localhost:8080

- Upload a PDF resume and get matched job roles


📌 Author
Karan Taragi
