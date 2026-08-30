# ✨ Packtorium

> A cosmic fortune cookie app built with Kotlin and Jetpack Compose.

Packtorium is a mobile fortune cookie application with a cosmic and mystical
visual style.

The project is being developed from scratch as a personal Android development
and portfolio project, with a focus on modern Android development practices.

## 📱 Preview

> Screenshots will be added as the application develops.

<!--
Add screenshots here:

![Main screen](screenshots/main_screen.png)
![Prediction screen](screenshots/prediction_screen.png)
-->

## 🚧 Project status

**Early MVP — In Development**

The application is currently under active development.

### Implemented

- [x] Initial UI
- [x] Material 3 theme
- [x] Navigation between screens
- [x] ViewModel
- [x] UI state management
- [x] Repository layer
- [x] Mock data source

### In progress

- [ ] Firebase / Firestore integration
- [ ] Real prediction loading
- [ ] Loading and error UI
- [ ] Cookie opening interaction
- [ ] Prediction history
- [ ] Notifications
- [ ] User-generated predictions

## 🛠 Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **Navigation Compose**
- **Coroutines / Flow**
- **ViewModel**
- **Firebase / Cloud Firestore**
- **Koin**
- **Gradle**
- **Git / GitHub**

## 🏗 Architecture

The project uses a layered architecture with separation between UI,
presentation logic, domain models and data sources.

```text
┌─────────────────────┐
│         UI          │
│    Jetpack Compose  │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│      ViewModel      │
│   State + Events    │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│     Repository      │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│     Data Source     │
│   Mock / Firebase   │
└─────────────────────┘
```

The repository abstraction keeps the presentation layer independent from the
concrete data source, allowing the mock implementation to be replaced with
Firebase without changing the UI.

## ✨ Planned Features
- Fortune Cookies
- Open a fortune cookie
- Receive a prediction
- View prediction details
- See the source and date of a prediction
- Collection
- Save interesting predictions
- Browse previously received predictions
- Social
- Send predictions to other users
- Create and share your own predictions
- Notifications
- Receive a daily fortune
- Optional reminders

## 🎨 Design

The application UI is designed in Figma.
The visual concept is inspired by cosmic, mystical and fortune-telling
aesthetics.

## 🎯 Project Goals

This project is primarily a learning and portfolio project.

It is being developed from scratch to practice:

Building UI with Jetpack Compose
Material 3 theming
State management
Navigation
Coroutines and asynchronous operations
Repository pattern
Firebase integration
Dependency injection
Testing
Git workflow
Incremental feature development

The project is intentionally developed feature by feature rather than using a
pre-built application architecture.
