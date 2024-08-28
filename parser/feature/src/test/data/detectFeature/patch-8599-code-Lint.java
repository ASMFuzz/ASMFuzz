@@ -214,6 +214,11 @@ public enum LintCategory {
          */
         FINALLY("finally"),
 
+        /**
+          * Warn about compiler possible lossy conversions.
+          */
+        LOSSY_CONVERSIONS("lossy-conversions"),
+
         /**
           * Warn about compiler generation of a default constructor.
           */