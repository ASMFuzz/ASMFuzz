@@ -165,7 +165,13 @@ public static enum ThreadDumpFormat {
          */
         TEXT_PLAIN,
         /**
-         * JSON (JavaScript Object Notation) format.
+         * JSON (JavaScript Object Notation) format
+         * (<a href="https://tools.ietf.org/html/rfc8259">RFC 8259</a>).
+         *
+         * <p> <a href="doc-files/threadDump.schema.json">threadDump.schema.json</a>
+         * describes the thread dump format in draft
+         * <a href="https://tools.ietf.org/html/draft-json-schema-language-02">
+         * JSON Schema Language version 2</a>.
          */
         JSON,
     }