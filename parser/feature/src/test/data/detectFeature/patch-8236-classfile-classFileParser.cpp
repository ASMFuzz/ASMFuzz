@@ -141,6 +141,8 @@
 
 #define JAVA_19_VERSION                   63
 
+#define JAVA_20_VERSION                   64
+
 void ClassFileParser::set_class_bad_constant_seen(short bad_constant) {
   assert((bad_constant == JVM_CONSTANT_Module ||
           bad_constant == JVM_CONSTANT_Package) && _major_version >= JAVA_9_VERSION,