+[![Download](https://api.bintray.com/packages/helpermethod/maven/molten-json/images/download.svg) ](https://bintray.com/helpermethod/maven/molten-json/_latestVersion)

# Usage

```java
JSONObject project = new JSONObject()
    .put("name", "molten-json")
    .put("version", "0.1.0")
    .put("description", "A fluent Java 8 DSL for working with JSON.")
    .put("repository", new JSONObject()
        .put("type", "git")
        .put("url", "https://github.com/helpermethod/molten-json"))
    .put("keywords", new JSONArray()
        .put("json")
        .put("java-8")
        .put("fluent")
        .put("dsl"))
    .put("author", "helpermethod")
    .put("license", "Apache 2")
    .put("bugs", new JSONObject()
        .put("url", "https://github.com/helpermethod/molten-json/issues"));
```

```java
JSONObject project = new Json()
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
        .object("bugs", b -> b.string("url", "https://github.com/helpermethod/molten-json/issues")))
    .toJson();
```
