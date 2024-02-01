import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.jvm)
    `java-library`
    jacoco
    alias(libs.plugins.pitest)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.kotlin.test.junit5)
    testImplementation(libs.junit.jupiter.engine)
    testRuntimeOnly(libs.junit.platform.launcher)
    testImplementation(libs.kotest.assertions)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
        vendor.set(JvmVendorSpec.ADOPTIUM)
    }
}

tasks.withType<JavaCompile>().configureEach {
    javaCompiler = javaToolchains.compilerFor {
        languageVersion = JavaLanguageVersion.of(8)
        vendor.set(JvmVendorSpec.ADOPTIUM)
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_1_8
    }
}

tasks.named<Test>("test") {
    finalizedBy(
        tasks.jacocoTestReport,
        tasks.jacocoTestCoverageVerification
    )
    useJUnitPlatform()
}

tasks.jacocoTestReport {
    reports {
        xml.required = false
        csv.required = false
    }
    dependsOn(tasks.test)
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            includes = listOf("*")
            limit {
                counter = "BRANCH"
                value = "COVEREDRATIO"
                minimum = "1.0".toBigDecimal()
            }
        }

        rule {
            includes = listOf("*")
            limit {
                counter = "LINE"
                value = "COVEREDRATIO"
                minimum = "1.0".toBigDecimal()
            }
        }
    }
}

pitest {
    targetClasses.set(setOf("com.guillaume.taffin.*"))
    pitestVersion = "1.15.2" //not needed when a default PIT version should be used
    threads = 4
    outputFormats.set(setOf("XML", "HTML"))
    timestampedReports = false
    junit5PluginVersion = "1.2.1"
    testStrengthThreshold.set(100)
    mutationThreshold.set(100)
}
