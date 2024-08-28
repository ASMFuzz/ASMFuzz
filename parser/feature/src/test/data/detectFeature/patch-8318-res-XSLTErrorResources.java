@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  */
 /*
  * Licensed to the Apache Software Foundation (ASF) under one or more
@@ -31,6 +31,7 @@
  * Array. You also need to update MAX_CODE for error strings
  * and MAX_WARNING for warnings ( Needed for only information
  * purpose )
+ * @LastModified: May 2022
  */
 public class XSLTErrorResources extends ListResourceBundle
 {
@@ -1333,7 +1334,6 @@ public Object[][] getContents()
   // for the Xalan Process command line.  "Process" is the name of a Java class,
   // and should not be translated.
   { "xslProc_option", "Xalan-J command line Process class options:"},
-  { "xslProc_option", "Xalan-J command line Process class options\u003a"},
   { "xslProc_invalid_xsltc_option", "The option {0} is not supported in XSLTC mode."},
   { "xslProc_invalid_xalan_option", "The option {0} can only be used with -XSLTC."},
   { "xslProc_no_input", "Error: No stylesheet or input xml is specified. Run this command without any option for usage instructions."},