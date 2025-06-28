# Japstudy

Japstudy is a web application for practicing Japanese scripts (Hiragana, Katakana) and the Joyō Kanji using interactive flashcards. Built with Spring Boot and Thymeleaf, it provides a simple interface for learners

## Features
- Flashcard practice for Hiragana and Katakana
- Joyō Kanji study section (in progress)
- REST API endpoints for random and full card lists
- Responsive and centered UI
- Custom web component for card display

## Getting Started

### Prerequisites
- Java 21 or higher
- Maven

### Running the Application

1. Clone the repository:
   ```sh
   git clone https://github.com/Dieg0407/japstudy.git
   cd japstudy
   ```
2. Build and run the app:
   ```sh
   ./mvnw spring-boot:run
   ```
3. Open your browser and go to [http://localhost:8080](http://localhost:8080)

## Project Structure
- `src/main/java/com/dieg0407/japstudy/` - Java source code
  - `controller/` - Spring MVC controllers for web and API endpoints
  - `service/` - Business logic and card data
  - `model/` - Card data model
- `src/main/resources/templates/` - Thymeleaf HTML templates
- `src/main/resources/static/` - Static assets (CSS, JS)

## API Endpoints
- `GET /api/v1/hiragana/random` - Get a random Hiragana card
- `GET /api/v1/hiragana/all` - Get all Hiragana cards
- `GET /api/v1/katakana/random` - Get a random Katakana card
- `GET /api/v1/katakana/all` - Get all Katakana cards

## Custom Elements
- The app uses a custom web component `<card-container type="hiragana|katakana">` for flashcard display and interaction.

## License
This project is licensed under the Apache License 2.0.
