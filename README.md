# SimpleBlog

SimpleBlog is a basic blog engine built with Java and Spring MVC. It
supports markdown syntax and pretty coloring of code blocks.

This project is still in an early stage of development and also a
reference project for me to learn about Java and Spring MVC development

I have a day job as a Microsoft .NET developer and it's fun to do something
different once in a while.

My development environment consists of:
- Ubuntu Linux LTS
- Java 8 JDK
- Gradle
- NetBeans

![screenshot image](ubuntu.png "Screenshot")

Working:

1. It shows blog messages from the database (PostgreSQL).
2. A user can navigate between blog posts.
3. Syntax coloring of code blocks (prettify.js).
4. You can log in and post / edit new items.

Todo:

1. User registration.
2. Archive view with search functionality.
3. AngularJS integration.
4. Much more :-)

You can run this project using Gradle with the gretty plugin.

The command for this is:

gradle appRun

