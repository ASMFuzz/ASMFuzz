@@ -56,6 +56,7 @@ public HotSpotPidFileParser(String testClass) {
     public void setCompilationsMap(Map<String, IRMethod> compilationsMap) {
         this.compilationsMap = compilationsMap;
     }
+
     /**
      * Parse the hotspot_pid*.log file from the test VM. Read the PrintIdeal and PrintOptoAssembly outputs for all
      * methods of the test class that need to be IR matched (found in compilations map).
@@ -75,18 +76,28 @@ private void processFileLines(String hotspotPidFileName) throws IOException {
         Map<Integer, IRMethod> compileIdMap = new HashMap<>();
         try (var reader = Files.newBufferedReader(Paths.get(hotspotPidFileName))) {
             Line line = new Line(reader, compileIdPatternForTestClass);
-            BlockOutputReader blockOutputReader = new BlockOutputReader(reader);
+            BlockOutputReader blockOutputReader = new BlockOutputReader(reader, compileIdPatternForTestClass);
             while (line.readLine()) {
                 if (line.isTestClassCompilation()) {
                     parseTestMethodCompileId(compileIdMap, line.getLine());
                 } else if (isTestMethodBlockStart(line, compileIdMap)) {
-                    String blockOutput = blockOutputReader.readBlock();
-                    setIRMethodOutput(blockOutput, line, compileIdMap);
+                    processMethodBlock(compileIdMap, line, blockOutputReader);
                 }
             }
         }
     }
 
+    private void processMethodBlock(Map<Integer, IRMethod> compileIdMap, Line line, BlockOutputReader blockOutputReader)
+            throws IOException {
+        Block block = blockOutputReader.readBlock();
+        if (block.containsTestClassCompilations()) {
+            // Register all test method compilations that could have been emitted during a rare safepoint while
+            // dumping the PrintIdeal/PrintOptoAssembly output.
+            block.getTestClassCompilations().forEach(l -> parseTestMethodCompileId(compileIdMap, l));
+        }
+        setIRMethodOutput(block.getOutput(), line, compileIdMap);
+    }
+
     private void parseTestMethodCompileId(Map<Integer, IRMethod> compileIdMap, String line) {
         String methodName = parseMethodName(line);
         if (isTestAnnotatedMethod(methodName)) {
@@ -101,6 +112,9 @@ private String parseMethodName(String line) {
         return matcher.group(2);
     }
 
+    /**
+     * Is this a @Test method?
+     */
     private boolean isTestAnnotatedMethod(String testMethodName) {
         return compilationsMap.containsKey(testMethodName);
     }
@@ -109,8 +123,6 @@ private IRMethod getIrMethod(String testMethodName) {
         return compilationsMap.get(testMethodName);
     }
 
-
-
     private int getCompileId(String line) {
         Matcher matcher = COMPILE_ID_PATTERN.matcher(line);
         if (!matcher.find()) {
@@ -119,6 +131,9 @@ private int getCompileId(String line) {
         return Integer.parseInt(matcher.group(1));
     }
 
+    /**
+     * Is this line the start of a PrintIdeal/PrintOptoAssembly output block of a @Test method?
+     */
     private boolean isTestMethodBlockStart(Line line, Map<Integer, IRMethod> compileIdMap) {
       return line.isBlockStart() && isTestClassMethodBlock(line, compileIdMap);
     }