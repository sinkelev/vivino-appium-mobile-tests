plugins {
    id("java")
    id("io.qameta.allure") version "2.12.0"
    id("checkstyle")
}

group = "org.sinkelev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.30")
    testImplementation("org.testng:testng:7.9.0")
    testImplementation("io.appium:java-client:9.2.0")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.18.1")
    testImplementation("io.qameta.allure:allure-testng:2.8.1")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testImplementation("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
}

allure {
    version = "2.12.0"
}

checkstyle {
    configFile = file("checkstyle.xml")
    toolVersion = "10.12.4"
}

tasks.test {
    useTestNG {
        suites("/src/test/resources/testng.xml")
    }
    dependsOn(tasks.checkstyleTest)
}
tasks.clean {
    finalizedBy(tasks.allureServe)
}