@@ -28,6 +28,7 @@
 #include "memory/allStatic.hpp"
 #include "utilities/exceptions.hpp"
 
+class CallInfo;
 class ClassFileParser;
 class InstanceKlass;
 
@@ -38,6 +39,7 @@ class InstanceKlass;
 class JfrEventClassTransformer : AllStatic {
  public:
   static void on_klass_creation(InstanceKlass*& ik, ClassFileParser& parser, TRAPS);
+  static bool is_instrumented(const InstanceKlass* ik);
   static void set_force_instrumentation(bool force_instrumentation);
   static bool is_force_instrumentation();
 };