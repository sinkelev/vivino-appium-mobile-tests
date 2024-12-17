plugins {
    id("java")
}

group = "org.sinkelev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.4.0")
    testImplementation("io.appium:java-client:7.3.0")
    testImplementation("org.seleniumhq.selenium:selenium-java:3.141.59")
}

tasks.test {
    useTestNG()
}