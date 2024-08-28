@@ -85,7 +85,7 @@ typedef struct {
     jboolean assertOn;
     jboolean assertFatal;
     jboolean vthreadsSupported; /* If true, debugging support for vthreads is enabled. */
-    jboolean enumerateVThreads; /* If true, JDWP APIs return vthreads in thread lists. */
+    jboolean includeVThreads;   /* If true, VM.AllThreads includes vthreads. */
     jboolean doerrorexit;
     jboolean modifiedUtf8;
     jboolean quiet;