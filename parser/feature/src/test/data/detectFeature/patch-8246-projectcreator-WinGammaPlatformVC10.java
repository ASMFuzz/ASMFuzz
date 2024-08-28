@@ -244,7 +244,7 @@ public String getFileTagFromSuffix(String fileName) {
     }
 
     void writeFiles(Vector<BuildConfig> allConfigs, String projDir) {
-       // This code assummes there are no config specific includes.
+       // This code assumes there are no config specific includes.
        startTag("ItemGroup");
 
        String sourceBase = BuildConfig.getFieldString(null, "SourceBase");