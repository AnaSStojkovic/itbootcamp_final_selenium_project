# itbootcamp_final_selenium_project

This is a final project on my ITbootcamp journey written in Java and designed to automatically test web page elements and functionalities with Selenium and TestNG. The test was designed with Page Object Model (POM) concept. My task on project was to do automation tests for the website: https://vue-demo.daniel-avellaneda.com/. I did it for the following pages: Login Page, Navigation Page, Signup Page, Cities Page, Message Pop Up Page and My Profile Page.

The following functionalities and web elements were tested: Login Tests (Visits the login page, Checks input types, Displays errors when user does not exist, Displays errors when password is wrong, Login, Logout); Signup Tests (Visits the signup page, Checks input types, Displays errors when user already exists, Signup); Admin Cities Tests (Visits the admin cities page and list cities, Checks input types for create/edit new city, Create new city, Edit city, Search city, Delete city); Auth Routes Tests (Forbids visits to home url if not authenticated, Forbids visits to profile url if not authenticated, Forbids visits to admin cities url if not authenticated, Forbids visits to admin users url if not authenticated); Locale Tests (Set locale to ES, Set locale to EN, Set locale to CN, Set locale to FR); Profile Tests (Visits the profile page, Checks input types, Edits profile).

Technologies and Key Concepts: Java OOP, Selenium, POM, Test NG, Intellij IDE.


