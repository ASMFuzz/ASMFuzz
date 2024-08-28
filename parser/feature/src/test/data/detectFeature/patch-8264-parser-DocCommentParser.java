@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1199,9 +1199,10 @@ public DCTree parse(int pos) throws ParseException {
                         nextChar();
                         return m.at(pos).newDocRootTree();
                     }
+                    final int savedPos = bp;
                     inlineText(WhitespaceRetentionPolicy.REMOVE_ALL); // skip unexpected content
                     nextChar();
-                    throw new ParseException(pos, "dc.unexpected.content");
+                    throw new ParseException(savedPos, "dc.unexpected.content");
                 }
             },
 
@@ -1256,9 +1257,10 @@ public DCTree parse(int pos) throws ParseException {
                         nextChar();
                         return m.at(pos).newInheritDocTree();
                     }
+                    final int errorPos = bp;
                     inlineText(WhitespaceRetentionPolicy.REMOVE_ALL); // skip unexpected content
                     nextChar();
-                    throw new ParseException(pos, "dc.unexpected.content");
+                    throw new ParseException(errorPos, "dc.unexpected.content");
                 }
             },
 
@@ -1308,7 +1310,7 @@ public DCTree parse(int pos) throws ParseException {
 
                     if (typaram) {
                         if (ch != '>')
-                            throw new ParseException("dc.gt.expected");
+                            throw new ParseException(bp, "dc.gt.expected");
                         nextChar();
                     }
 