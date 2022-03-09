tasks.register("createNewModule") {
    doLast {
        val moduleName = project.property("moduleName")
        if (moduleName !is String) throw RuntimeException("moduleName could not be cast to String")

        mkdir("$moduleName/src/main/kotlin")
        mkdir("$moduleName/src/test/kotlin")
        File("$moduleName/src/main/kotlin/Solution.kt").appendText(
            """
                class Solution {
                }
            """.trimIndent()
        )

        File("$moduleName/src/test/kotlin/Test.kt").appendText(
            """
                class Test {
                }
            """.trimIndent()
        )

        File("$moduleName", "build.gradle.kts").appendText(
            """
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
                }

                tasks.test {
                    useJUnitPlatform()
                }
            """.trimIndent()
        )

        File("settings.gradle.kts").appendText(
            "\n" +
            """
                include("$moduleName")
            """.trimIndent()
        )
    }
}
