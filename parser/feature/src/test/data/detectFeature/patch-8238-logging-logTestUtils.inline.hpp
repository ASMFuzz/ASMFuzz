@@ -57,14 +57,14 @@ static inline void delete_file(const char* filename) {
 }
 
 static inline void create_directory(const char* name) {
-  assert(!file_exists(name), "can't create directory: %s already exists", name);
+  ASSERT_FALSE(file_exists(name)) << "can't create directory: " << name << " already exists";
   bool failed;
 #ifdef _WINDOWS
   failed = !CreateDirectory(name, NULL);
 #else
   failed = mkdir(name, 0777);
 #endif
-  assert(!failed, "failed to create directory %s", name);
+  ASSERT_FALSE(failed) << "failed to create directory " << name;
 }
 
 static inline void delete_empty_directory(const char* name) {