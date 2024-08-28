@@ -257,7 +257,7 @@ int expandLogicalImmediate(uint32_t immN, uint32_t immr,
 // constructor to initialise the lookup tables
 
 static void initLITables();
-// Use an empty struct with a construtor as MSVC doesn't support `__attribute__ ((constructor))`
+// Use an empty struct with a constructor as MSVC doesn't support `__attribute__ ((constructor))`
 // See https://stackoverflow.com/questions/1113409/attribute-constructor-equivalent-in-vc
 static struct initLITables_t { initLITables_t(void) { initLITables(); } } _initLITables;
 static void initLITables()