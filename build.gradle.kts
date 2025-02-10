plugins {
    id("java")
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
    testImplementation("io.qameta.allure:allure-testng:2.17.2")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
}

tasks.test {
    useTestNG(){
        suites("/src/test/resources/testng.xml")
    }
}

tasks.register("allureReport") {
    doLast {
        exec {
            commandLine("allure", "serve", "${layout.buildDirectory.get().asFile.absolutePath}/allure-results")
        }
    }
}