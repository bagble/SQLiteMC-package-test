# SQLiteMC

[![Java CI with Gradle](https://github.com/bagble/SQLiteMC-package-test/actions/workflows/action.yml/badge.svg)](https://github.com/bagble/SQLiteMC-package-test/actions/workflows/action.yml) [![Publish Gradle Project](https://github.com/bagble/SQLiteMC-package-test/actions/workflows/publish.yml/badge.svg)](https://github.com/bagble/SQLiteMC-package-test/actions/workflows/publish.yml)
---
## SQLiteMC Docs
> * JavaDocs : [Click](https://bagble.github.io/SQLiteMC-package-test/)
---
> * ### LICENSE
> 1. server-script - `MIT License`
>    * https://github.com/monun/server-script
>    * https://github.com/monun/server-script/blob/master/LICENSE
---
> * ## Features
>   * To-Do
---
> * ## Application

> * #### Gradle
```groovy
allprojects {
    repositories {
        ...
        maven {
            name = 'github'
            url = 'https://maven.pkg.github.com/bagble/SQLite-package-test'
        }
    }
}
```
```groovy
dependencies {
    implementation 'io.github.kill00.SQLiteMC:sqlitemc-core:<Version>'
}
```
---
> * #### Maven
```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/bagble/SQLite-package-test</url>
    </repository>
</repositories>
```
```xml
<dependency>
    <groupId>io.github.kill00.SQLiteMC</groupId>
    <artifactId>sqlitemc-core</artifactId>
    <version>Version</version>
</dependency>
```
---