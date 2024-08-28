@@ -175,11 +175,6 @@ public static int installCode(TargetDescription target,
         return CTVM.installCode(target, compiledCode, code, failedSpeculationsAddress, speculations);
     }
 
-    public static int getMetadata(TargetDescription target,
-            HotSpotCompiledCode compiledCode, HotSpotMetaData metaData) {
-        return CTVM.getMetadata(target, compiledCode, metaData);
-    }
-
     public static void resetCompilationStatistics() {
         CTVM.resetCompilationStatistics();
     }