@@ -187,6 +187,7 @@ public boolean isPreview(Feature feature) {
             case CASE_NULL -> true;
             case PATTERN_SWITCH -> true;
             case UNCONDITIONAL_PATTERN_IN_INSTANCEOF -> true;
+            case RECORD_PATTERNS -> true;
 
             //Note: this is a backdoor which allows to optionally treat all features as 'preview' (for testing).
             //When real preview features will be added, this method can be implemented to return 'true'