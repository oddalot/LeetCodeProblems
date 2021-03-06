plugins {
    kotlin("jvm") version "1.5.10"
}

version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
    implementation(project(":common"))
}

tasks.test {
    useJUnitPlatform()
}