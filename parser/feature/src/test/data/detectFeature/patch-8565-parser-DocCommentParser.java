@@ -1579,15 +1579,32 @@ public DCTree parse(int pos) throws ParseException {
                 }
             },
 
-            // {@value package.class#field}
+            // {@value [format-string] package.class#field}
             new TagParser(TagParser.Kind.INLINE, DCTree.Kind.VALUE) {
                 @Override
                 public DCTree parse(int pos) throws ParseException {
+                    skipWhitespace();
+                    DCText format;
+                    switch (ch) {
+                        case '%' -> {
+                            format = inlineWord();
+                            skipWhitespace();
+                        }
+                        case '"' -> {
+                            format = quotedString();
+                            skipWhitespace();
+                        }
+                        default -> {
+                            format = null;
+                        }
+                    }
                     DCReference ref = reference(true);
                     skipWhitespace();
                     if (ch == '}') {
                         nextChar();
-                        return m.at(pos).newValueTree(ref);
+                        return format == null
+                                ? m.at(pos).newValueTree(ref)
+                                : m.at(pos).newValueTree(format, ref);
                     }
                     nextChar();
                     throw new ParseException("dc.unexpected.content");