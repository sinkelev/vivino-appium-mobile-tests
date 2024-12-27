plugins {
    id("java")
}

group = "org.sinkelev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.9.0")
    testImplementation("io.appium:java-client:9.2.0")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.18.1")
    testImplementation("io.qameta.allure:allure-testng:2.17.2")
}

tasks.test {
    useTestNG()
    jvmArgs ("--add-opens", "java.base/java.lang=ALL-UNNAMED")
}

tasks.register("allureReport") {
    doLast {
        exec {
            commandLine("allure", "serve", "${buildDir}/allure-results")
        }
    }
}