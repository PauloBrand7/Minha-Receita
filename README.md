# Recipe App (Android)

This is a native Android application, with its UI and content presented in Brazilian Portuguese, that displays food recipes sourced from [TheMealDB API](https://www.themealdb.com/). Users can browse recipes by category and view detailed cooking instructions.

---

## Features

* Browse a list of food categories.
* View all meals available for a selected category.
* See detailed recipe information, including ingredients, measurements, and instructions.

## Tech Stack & Architecture

This project follows modern Android development standards, implementing a clean, scalable, and testable architecture.

* **Language:** Kotlin
* **Architecture:** MVVM (Model-View-ViewModel) + Clean Architecture
* **UI:** XML Layouts & Navigation Component
* **Dependency Injection:** Hilt
* **Networking:** Retrofit & Gson
* **Asynchronous:** Coroutines

## Getting Started

To clone and run this project locally, you will need Android Studio installed.

### Installation

1.  Clone the repository to your local machine:
    ```bash
    git clone [https://github.com/PauloBrand7/Minha-Receita.git](https://github.com/PauloBrand7/Minha-Receita.git)
    ```
2.  Open the project in Android Studio.
3.  Wait for Gradle to sync and build the project.
4.  Run the application on an Android emulator or a physical device.

## Screenshots

<table align="center" style="border:none;">
  <tr style="border:none;">
    <td align="center" valign="top">
      <strong>Categories</strong><br><br>
      <img src="https://github.com/PauloBrand7/Minha-Receita/raw/main/categorias.png" alt="Categories Screen" width="270"/>
    </td>
    <td align="center" valign="top">
      <strong>Meals List</strong><br><br>
      <img src="https://github.com/PauloBrand7/Minha-Receita/raw/main/refei%C3%A7%C3%B5es.png" alt="Meals List Screen" width="270"/>
    </td>
    <td align="center" valign="top">
      <strong>Recipe Details</strong><br><br>
      <img src="https://github.com/PauloBrand7/Minha-Receita/raw/main/receita.png" alt="Recipe Detail Screen" width="270"/>
    </td>
  </tr>
</table>
