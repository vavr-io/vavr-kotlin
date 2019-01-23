import groovy.lang.Closure
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.URI

plugins {
    `jvm-component`
    `java-lang`
    maven
    jacoco
    id("com.bmuschko.nexus") version "2.3.1"
    id("org.jetbrains.kotlin.jvm") version "1.3.11"
}

// https://guides.gradle.org/migrating-build-logic-from-groovy-to-kotlin/
// The Kotlin DSL will not support model {} elements. This is part of the discontinued Gradle Software Model.
//
//model {
//    components {
//        main(JvmLibrarySpec)
//    }
//}

group = "io.vavr"
version = "0.9.3"

repositories {
    mavenCentral()
    maven {
        url = URI("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("io.vavr:vavr:0.9.3")
    testCompile("junit:junit:4.12")
}

tasks {

    create<JacocoReport>("codeCoverageReport") {
        executionData(fileTree(project.rootDir.absolutePath).include("**/build/jacoco/*.exec"))

        sourceSets(sourceSets["main"])

        reports {
            xml.isEnabled = true
            xml.destination = file("$buildDir/reports/jacoco/report.xml")
            html.isEnabled = true
            csv.isEnabled = false
        }

        dependsOn(project.getTasksByName("test", false))

    }

    getByName<KotlinCompile>("compileKotlin") {
        kotlinOptions.jvmTarget = "1.8"
    }

    getByName<Jar>("jar") {
        manifest {
            attributes(mutableMapOf(
                    "Automatic-Module-Name" to "io.vavr.kotlin"
            ))
        }
    }

}

val modifyPom : Closure<MavenPom> by ext

modifyPom(closureOf<MavenPom> {
    project {
        withGroovyBuilder {
            "name"("Vavr Kotlin")
            "description"("Vavr integration for Kotlin")
            "url"("http://vavr.io")
            "inceptionYear"("2017")

            "scm" {
                "connection"("scm:git:git@github.com:vavr-io/vavr-kotlin.git")
                "developerConnection"("scm:git:git@github.com:vavr-io/vavr-kotlin.git")
                "url"("git@github.com:vavr-io/vavr-kotlin.git")
            }

            "licenses" {
                "license" {
                    "name"("The Apache Software License, Version 2.0")
                    "url"("http://www.apache.org/licenses/LICENSE-2.0.txt")
                }
            }

            "developers" {
                "developer" {
                    "id"("zvozin")
                    "name"("Alex Zuzin")
                    "url"("https://github.com/zvozin")
                }
                "developer" {
                    "id"("ruslansennov")
                    "name"("Ruslan Sennov")
                    "email"("ruslan.sennov@gmail.com")
                }
            }

        }
    }
})

nexus {
    sign = !version.toString().endsWith("SNAPSHOT")
}

