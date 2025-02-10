# Vivino Mobile App Automated Tests

## Overview

This project contains automated tests for the Vivino mobile application.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 11 or higher
- Gradle 6.0 or higher
- Appium Server 1.22.0 or higher
- Android SDK
- An Android emulator or a physical device for testing

## Setup

1. **Clone the repository:**

    ```sh
    git clone https://github.com/your-username/vivino-mobile-tests.git
    cd vivino-mobile-tests
    ```

2. **Install dependencies:**

    ```sh
    ./gradlew build
    ```

3. **Start the Appium server:**

    ```sh
    appium
    ```

4. **Configure the Android emulator or connect a physical device:**

   Ensure that the emulator is running or the physical device is connected and recognized by `adb`.

## Running the Tests

To run the tests, use the following Gradle command:

```sh
./gradlew test
