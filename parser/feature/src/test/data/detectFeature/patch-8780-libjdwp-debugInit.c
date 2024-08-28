@@ -877,7 +877,9 @@ printUsage(void)
  "onthrow=<exception name>         debug on throw                    none\n"
  "onuncaught=y|n                   debug on any uncaught?            n\n"
  "timeout=<timeout value>          for listen/attach in milliseconds n\n"
- "enumeratevthreads=y|n            thread lists include all vthreads n\n"
+ "includevirtualthreads=y|n        List of all threads includes virtual threads as well as platform threads.\n"
+ "                                 Virtual threads are a preview feature of the Java platform.\n"
+ "                                                                   n\n"
  "mutf8=y|n                        output modified utf-8             n\n"
  "quiet=y|n                        control over terminal messages    n\n"));
 
@@ -1026,7 +1028,7 @@ parseOptions(char *options)
 
     /* Set vthread debugging level. */
     gdata->vthreadsSupported = JNI_TRUE;
-    gdata->enumerateVThreads = JNI_FALSE;
+    gdata->includeVThreads = JNI_FALSE;
 
     /* Options being NULL will end up being an error. */
     if (options == NULL) {
@@ -1130,14 +1132,14 @@ parseOptions(char *options)
             }
             currentTransport->timeout = atol(current);
             current += strlen(current) + 1;
-        } else if (strcmp(buf, "enumeratevthreads") == 0) {
+        } else if (strcmp(buf, "includevirtualthreads") == 0) {
             if (!get_tok(&str, current, (int)(end - current), ',')) {
                 goto syntax_error;
             }
             if (strcmp(current, "y") == 0) {
-                gdata->enumerateVThreads = JNI_TRUE;
+                gdata->includeVThreads = JNI_TRUE;
             } else if (strcmp(current, "n") == 0) {
-                gdata->enumerateVThreads = JNI_FALSE;
+                gdata->includeVThreads = JNI_FALSE;
             } else {
                 goto syntax_error;
             }