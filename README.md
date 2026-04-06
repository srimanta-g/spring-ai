# Spring AI Playground 🚀

This repository contains my experiments and learning projects using **Spring AI** with **Spring Boot**.
The goal of this repository is to understand how to integrate **Large Language Models (LLMs)** into backend applications using Java.

---

## 📌 Objectives

* Learn how to integrate **Spring AI** with Spring Boot
* Understand how **LLM APIs** can be used inside backend services
* Build small prototypes using **ChatClient**
* Explore **structured output mapping** (LLM response → Java objects)
* Experiment with **prompt engineering** and AI-powered endpoints

[//]: # (* Understand the networking stack used by Spring AI &#40;WebClient → Reactor Netty&#41;)

---

## 🛠 Tech Stack

* Java
* Spring Boot
* Spring AI
* OpenAI API
* Maven
* WebClient / Reactor Netty

---

## 📂 Project Structure

```
src/main/java
 ├── controller
 │    └── AIController
 │
 ├── entity
      └── Genre
```

---

## ⚙️ Configuration

The project uses an **OpenAI API key** which should be provided using environment variables.

Example:

```
export OPENAI_API_KEY=your_api_key_here
```

`application.yml`

```
spring:
  ai:
    openai:
      api-key: ${OPENAI_API_KEY}
```

For security reasons, the actual `application.yml` file is **not committed to the repository**.

---

## ▶️ Running the Application

Clone the repository:

```
git clone https://github.com/srimanta-g/spring-ai.git
```

Navigate to the project:

```
cd spring-ai
```

Run the application:

```
./mvnw spring-boot:run
```

Or from IntelliJ / your IDE.

---

## 🌐 Example API

Example endpoint:

```
GET /prompt?userInput=What is Kafka?
```

Example response:

```json
{
  "question": "What is Kafka?",
  "answer": "Apache Kafka is a distributed event streaming platform..."
}
```

---

## 🧠 Topics Explored

* Spring AI `ChatClient`
* Prompt-based API calls
* Structured AI responses
* DTO mapping from LLM output
* REST APIs backed by AI
* Reactive HTTP clients

---

## 🚧 Future Experiments

* Streaming responses from LLMs
* AI-powered code summarization
* AI-powered document Q&A
* Vector databases
* Retrieval Augmented Generation (RAG)

---

## 📚 References

* Spring AI Documentation
* OpenAI API Documentation
* Spring Boot Documentation

---

## 👨‍💻 Author

**Srimanta Gangopadhyay**

Software Engineer interested in:

* Java backend development
* Distributed systems
* AI-powered applications
