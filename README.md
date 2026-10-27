# Android Login App - Developer Guide

This repository provides a complete technical overview and implementation details for the **Android Login App**.  
It helps students/developers understand the project structure, environmental setup, and functionality.

---

## Overview

This Android application demonstrates:
- Basic **UI design** using XML layouts
- Handling **user input** through EditText
- Button **event handling** in Java
- Displaying **Toast** messages and **TextView updates**

---

## Project Setup

Follow these steps to clone and open the project in **Android Studio**:

### 1 Clone the Repository
```bash
git clone https://github.com/Azzzhar7/android-login-app.git
cd android-login-app
```

### 2 Open in Android Studio
1. Launch **Android Studio**  
2. Click **File → Open**  
3. Select the cloned project folder  
4. Wait for **Gradle build** and **sync** to complete automatically  
   *(If prompted, click **Sync Now** or **Build → Rebuild Project**)*

### 3 Run the App
1. Connect a physical device or start an **Android Emulator**  
2. Click the **Run ▶️** button  
3. The app will install and launch automatically  

---

## Gradle Configuration (for reference)
The following key settings are already defined in the `build.gradle (Module: app)` file:

- **compileSdk:** 36  
- **minSdk:** 24  
- **targetSdk:** 36  
- **Java version:** 11  

No manual changes are needed.

---

## Alternatively Create a New Project

Follow these steps to use it's code for your existing/new android project in **Android Studio**:

### 1 Create a New Project
1. Open **Android Studio**
2. Select **New Project → Empty Activity**
3. Set:
   - Name: `MyApplication`
   - Package name: `com.example.myapplication`
   - Language: **Java**
   - Minimum SDK: **API 24: Android 7.0 (Nougat)** or higher
4. Click **Finish**

---

### 2 Add New Activity Layout and Java Class Files
1. Replace the default `activity_main.xml` layout with your custom login UI design.  
   - Add input fields for **username** and **password**  
   - Add **Login** and **Reset** buttons  
   - Add a **TextView** to show output messages  

2. In `MainActivity.java`, implement:
   - `onCreate()` method to handle layout setup and button listeners  
   - `login(View v)` method for validating inputs and showing messages  
   - A **Reset** button to clear fields and display a Toast message  

---

### 3 Add Drawable Resources
- Place your logo image inside `app/src/main/res/drawable/`  
- Example file name: `logo.png`  

---

### 4 Run the App
1. Click **Run ▶️** in Android Studio  
2. Enter any username and password  
3. Click **Login** or **Reset**  
4. Observe the Toast and TextView messages  

---

## Developer Notes
- Use **Toast** for short notifications  
- Use **TextView** for output messages  
- Validate user input to prevent empty fields  
- Add database or Firebase authentication later for production use  
- Use **Material Design components** for modern UI styling  

---

## Git Setup

Run the following commands to initialize and push this project to your GitHub repository:

```bash
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/your-username/android-login-app.git
git push -u origin main
```

---

## **Contact**
**Author:** Muhammad Azhar  
- *Email: [muhammadazhar@uaar.edu.pk](mailto:muhammadazhar@uaar.edu.pk)*  
- *LinkedIn: [https://www.linkedin.com/in/azzzhar7/](https://www.linkedin.com/in/azzzhar7/)*
