import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel
import org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES

plugins {
    idea
    id("io.spring.dependency-management")
    id("org.springframework.boot") apply false
}

idea {
    project {
        languageLevel = IdeaLanguageLevel(21)
    }
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

allprojects {
    group = "ru.otus"

    repositories {
        mavenLocal()
        mavenCentral()
    }

    val guava: String by project

    apply(plugin = "io.spring.dependency-management")
    dependencyManagement {
        dependencies {
            imports {
                mavenBom(BOM_COORDINATES)
            }
            dependency("com.google.guava:guava:$guava")
        }
    }

    plugins.apply(JavaPlugin::class.java)
    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}