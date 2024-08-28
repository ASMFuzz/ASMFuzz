@@ -38,7 +38,7 @@ static jobject install_chunk_monitor(JavaThread* thread) {
   // read static field
   HandleMark hm(thread);
   static const char klass[] = "jdk/jfr/internal/JVM";
-  static const char field[] = "FILE_DELTA_CHANGE";
+  static const char field[] = "CHUNK_ROTATION_MONITOR";
   static const char signature[] = "Ljava/lang/Object;";
   JavaValue result(T_OBJECT);
   JfrJavaArguments field_args(&result, klass, field, signature, thread);