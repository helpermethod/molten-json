# Usage

```java
JSONObject actual = new JSONObject()
    .put("menu", new JSONObject()
        .put("id", "file")
        .put("value", "File")
        .put("popup", new JSONObject()
            .put("menuitems", new JSONArray()
                .put(new JSONObject()
                    .put("value", "New")
                    .put("onclick", "CreateNewDoc()"))
                .put(new JSONObject()
                    .put("value", "Open")
                    .put("onclick", "OpenDoc()"))
                .put(new JSONObject()
                    .put("value", "Close")
                    .put("onclick", "CloseDoc()")))));
```

```java
JSONObject expected = object(o -> o
    .object("menu", menu -> menu
        .string("id", "file")
        .string("value", "File")
        .object("popup", popup -> popup
            .array("menuitems", menuitems -> menuitems
                .object(menuitem -> menuitem
                    .string("value", "New")
                    .string("onclick", "CreateNewDoc()"))
                .object(menuitem -> menuitem
                    .string("value", "Open")
                    .string("onclick", "OpenDoc()"))
                .object(menuitem -> menuitem
                    .string("value", "Close")
                    .string("onclick", "CloseDoc()")))))).toJson();
```