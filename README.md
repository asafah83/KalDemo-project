# KalDemo Project 🚀

## 📖 Introduction
KalDemo Project is a Java-based automation testing project utilizing the Page Object Model (POM) design pattern with Selenium WebDriver.

The project includes:
- 🧪 End-to-End (E2E) automated tests.
- 🔍 Test coverage for form wizards, dynamic lists, and validations.
- 🧹 Clean browser state with cache and cookies management.
- 📋 Generic utilities for waiting and page transitions.

---

### 🛠️ **Project Structure Overview**

- **pages/** – מכיל את כל דפי המערכת (Page Object Model).  
- **publishAdWizard/** – תתי-עמודים השייכים לאשף פרסום מודעות.  
- **utils/** – פונקציות עזר לניהול WebDriver, קריאת פרופרטיז, ועוד.  
- **tests/** – בדיקות אוטומטיות עם TestNG.  
- **resources/data/** – הגדרות וקבצי נתוני בדיקה.  


## ⚙️ Tech Stack
- 🛠️ **Java**: Core language for automation.
- 🌐 **Selenium WebDriver**: For browser automation.
- 🎯 **JUnit**: Test execution and validation.
- 💾 **Maven**: Dependency management.
- 🖥️ **POM (Page Object Model)**: For better test maintainability.

---

## 🛠️ Project Structure
src
 └─ main
     └─ java
         ├─ pages
         │    ├─ BasePage.java
         │    ├─ LoginPage.java
         │    └─ publishAdWizard
         │         ├─ StepOnePage.java
         │         └─ StepTwoPage.java
         │
         └─ utils
              ├─ WaitUtils.java
              └─ DriverFactory.java
 └─ test
     └─ java
         └─ tests
             ├─ E2ETest.java
             └─ LoginTest.java
resources
 └─ data
     └─ config.properties



---

## 🚀 Installation & Usage

1. **Clone the repository**:
   ```bash
   git clone https://github.com/asafah83/KalDemo-project.git

2. **Navigate to the project directory**:
   ```bash
   cd KalDemo-project

3. **Run tests with Maven**:
  ```bash
   mvn clean test

   




