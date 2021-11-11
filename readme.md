# SQLiteMC

[![Java CI with Gradle](https://github.com/Kill00/SQLiteMC/actions/workflows/action.yml/badge.svg)](https://github.com/Kill00/SQLiteMC/actions/workflows/action.yml) [![](https://jitpack.io/v/Kill00/SQLiteMC.svg)](https://jitpack.io/#Kill00/SQLiteMC)
---
## SQLiteMC Docs
> * JavaDocs : [Click](https://kill00.github.io/SQLiteMC/)
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
            name = 'jitpack'
            url = 'https://jitpack.io'
        }
    }
}
```
```groovy
dependencies {
    implementation 'com.github.kill00.SQLiteMC:sqlitemc-core:<Version>'
}
```
---
> * #### Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
```xml
<dependency>
    <groupId>com.github.kill00.SQLiteMC</groupId>
    <artifactId>sqlitemc-core</artifactId>
    <version>Version</version>
</dependency>
```
---