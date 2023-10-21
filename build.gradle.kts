import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
}

group = "me.evbor"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.20")
    testImplementation(kotlin("test"))
    implementation ("org.seleniumhq.selenium:selenium-chrome-driver:2.50.0")
    implementation ("org.seleniumhq.selenium:selenium-support:2.50.0")
    implementation("org.springframework:spring-context:5.0.6.RELEASE")
    implementation("org.springframework:spring-web:6.0.13")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}