# Molten JSON

[![Download](https://api.bintray.com/packages/helpermethod/maven/molten-json/images/download.svg)](https://bintray.com/helpermethod/maven/molten-json/_latestVersion)
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](https://raw.githubusercontent.com/helpermethod/molten-json/master/LICENSE)

`molten-json` is a fluent Java 8 DSL for building JSON documents.

## Example

```json
{
    "name": "molten-json",
    "version": "0.1.0",
    "description": "A fluent Java 8 DSL for working with JSON.",
    "repository": {
        "type": "git",
        "url": "https://github.com/helpermethod/molten-json"
    },
    "keywords": ["json", "java-8", "fluent", "dsl"],
    "author": "helpermethod",
    "license": "Apache 2",
    "bugs": {
        "url": "https://github.com/helpermethod/molten-json/issues"
    }
}
```

```java
String project = new Json()
    .object(o -> o
        .string("name", "molten-json")
        .string("version", "0.1.0")
        .string("description", "A fluent Java 8 DSL for working with JSON.")
        .object("repository", r -> r
            .string("type", "git")
            .string("url", "https://github.com/helpermethod/molten-json"))
        .array("keywords", k -> k.strings("json", "java-8", "fluent", "dsl"))
        .string("author", "helpermethod")
        .string("license", "Apache 2")
        .object("bugs", b -> b
            .string("url", "https://github.com/helpermethod/molten-json/issues")))
    .toPrettyString();
```

## Getting Started

### Maven

```xml
<repositories>
    <repository>
        <id>bintray</id>
        <url>http://dl.bintray.com/helpermethod/maven</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.helpermethod</groupId>
        <artifactId>molten-json</artifactId>
        <version>0.1.0</version>
    </dependency>
</dependencies>
```

### Gradle

```groovy
repositories {
    maven {
        url 'http://dl.bintray.com/helpermethod/maven'
    }
}

dependencies {
    compile 'com.helpermethod:molten-json:0.1.0'
}
```

## Usage

### Creating an empty JSONObject

```java
JSONObject project = new Json().object().toJson();
```

### Creating a JSONObject with one string property

```java
JSONObject project = new Json().object(o -> o.string("name", "molten-json"));
```

### Creating an empty JSONArray

```java
JSONArray keywords = new Json().array().toJson();
```

### Creating a JSONArray with one string element

```java
JSONArray keywords = new Json().array(a -> a.strings("json"))
```

### Creating a JSONArray with multiple string elements

```java
JSONArray keywords = new Json().array(a -> a.strings("json", "java-8", "fluent", "dsl"))
```

### Creating a JSON string

```java
String project = new Json().object(o -> o.string("name", "molten-json")).toString();
```

### Creating a pretty-printed JSON string

```java
String project = new Json().object(o -> o.string("name", "molten-json")).toPrettyString();
```

### Creating a nested JSONObject

```java
JSONObject project = new Json()
    .object(o -> o
        .string("name", "molten-json")
        .string("version", "0.1.0"))
        .object("repository", r -> r
            .string("type", "git")
            .string("url", "https://github.com/helpermethod/molten-json")))
    .toJson();    
```

### Ignoring properties with null values

```java
String version = null;

JSONObject project = new Json(NullHandlingStrategy.IGNORE_NULL)
    .object(o -> o
        .string("name", "molten-json")
        .string("version", version))
    .toJson();
```
