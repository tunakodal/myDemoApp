# myDemoApp

[![Build Status](https://app.travis-ci.com/tunakodal/myDemoApp.svg?token=yEfF2zeaybgqPpoBLsmG&branch=main)](https://app.travis-ci.com/tunakodal/myDemoApp)

> **Course homework: BIL481 (Software Engineering) - Homework 1.** Tuna Kodal, 221101024. This repository contains an assignment submission, not a production application.

A small web application that generates a password. It takes two strings, two number lists and a password length, and builds the password from characters selected by the numbers in the lists.

Demo site: https://mysterious-savannah-86581-262f266244f6.herokuapp.com/

## How It Works

- Characters alternate between the two strings: even positions use string 1 with list 1, odd positions use string 2 with list 2.
- The character at each position is chosen by `number % string length`.
- No password is produced (the result is empty) if the lists are empty or of different sizes, a string is empty, a list is shorter than the password length, or the length is 6 or less.
- The app is built with Spark (Java web framework) and Mustache templates. The project also demonstrates continuous integration (Travis CI) and automatic deployment (Heroku).

## Repository Structure

```
.
├── src/
│   ├── main/java/com/mycompany/app/App.java       routes and password logic
│   ├── main/resources/templates/compute.mustache  form and result page
│   └── test/java/com/mycompany/app/AppTest.java   unit tests
├── pom.xml                                         Maven build
├── Procfile, system.properties                     Heroku deployment settings
├── .travis.yml                                     CI configuration
└── README.md
```

## Usage

Requires JDK 19 and Maven.

```bash
mvn package
java -jar target/myDemoApp-1.0-SNAPSHOT.jar
```

Then open `http://localhost:4567/compute` and fill in the form. The port can be overridden with the `PORT` environment variable.
