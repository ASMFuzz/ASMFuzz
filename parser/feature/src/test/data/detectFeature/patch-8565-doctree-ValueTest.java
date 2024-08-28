@@ -43,6 +43,7 @@ int no_ref() { }
   firstSentence: 2
     Text[TEXT, pos:1, abc_]
     Value[VALUE, pos:5
+      format: null
       reference: null
     ]
   body: empty
@@ -59,6 +60,7 @@ int typical() { }
   firstSentence: 2
     Text[TEXT, pos:1, abc_]
     Value[VALUE, pos:5
+      format: null
       reference:
         Reference[REFERENCE, pos:13, java.awt.Color#RED]
     ]
@@ -76,6 +78,7 @@ int trailing_ws() { }
   firstSentence: 2
     Text[TEXT, pos:1, abc_]
     Value[VALUE, pos:5
+      format: null
       reference:
         Reference[REFERENCE, pos:13, java.awt.Color#RED]
     ]
@@ -102,6 +105,79 @@ int trailing_junk() { }
 ]
 */
 
+    /**
+     * abc {@value %d java.awt.Color#RED}
+     */
+    int format_plain() { }
+/*
+DocComment[DOC_COMMENT, pos:1
+  firstSentence: 2
+    Text[TEXT, pos:1, abc_]
+    Value[VALUE, pos:5
+      format:
+        Text[TEXT, pos:13, %d]
+      reference:
+        Reference[REFERENCE, pos:16, java.awt.Color#RED]
+    ]
+  body: empty
+  block tags: empty
+]
+*/
+
+    /**
+     * abc {@value "%d" java.awt.Color#RED}
+     */
+    int format_quoted() { }
+/*
+DocComment[DOC_COMMENT, pos:1
+  firstSentence: 2
+    Text[TEXT, pos:1, abc_]
+    Value[VALUE, pos:5
+      format:
+        Text[TEXT, pos:13, "%d"]
+      reference:
+        Reference[REFERENCE, pos:18, java.awt.Color#RED]
+    ]
+  body: empty
+  block tags: empty
+]
+*/
+
+    /**
+     * abc {@value 0x%x4 java.awt.Color#RED}
+     */
+    int format_invalid() { }
+/*
+DocComment[DOC_COMMENT, pos:1
+  firstSentence: 3
+    Text[TEXT, pos:1, abc_]
+    Erroneous[ERRONEOUS, pos:5, prefPos:13
+      code: compiler.err.dc.ref.unexpected.input
+      body: {@value_0x%x4
+    ]
+    Text[TEXT, pos:18, _java.awt.Color#RED}]
+  body: empty
+  block tags: empty
+]
+*/
+
+    /**
+     * abc {@value "%d" java.awt.Color#RED junk}
+     */
+    int format_trailing_junk() { }
+/*
+DocComment[DOC_COMMENT, pos:1
+  firstSentence: 3
+    Text[TEXT, pos:1, abc_]
+    Erroneous[ERRONEOUS, pos:5, prefPos:37
+      code: compiler.err.dc.unexpected.content
+      body: {@value_"%d"_jav...a.awt.Color#RED_j
+    ]
+    Text[TEXT, pos:38, unk}]
+  body: empty
+  block tags: empty
+]
+*/
 }
 
 