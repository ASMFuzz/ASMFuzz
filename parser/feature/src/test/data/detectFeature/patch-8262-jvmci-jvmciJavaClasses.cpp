@@ -80,14 +80,19 @@ void HotSpotJVMCI::compute_offset(int &dest_offset, Klass* klass, const char* na
     fatal("Could not find field %s.%s with signature %s", ik->external_name(), name, signature);
   }
   guarantee(fd.is_static() == static_field, "static/instance mismatch");
-  dest_offset = fd.offset();
-  assert(dest_offset != 0, "must be valid offset");
-  if (static_field) {
-    // Must ensure classes for static fields are initialized as the
-    // accessor itself does not include a class initialization check.
-    ik->initialize(CHECK);
+  assert(fd.offset() != 0, "must be valid offset");
+  if (dest_offset != fd.offset()) {
+    if (dest_offset != 0) {
+      fatal("offset for %s %s.%s re-initialized: %d -> %d", signature, ik->external_name(), name, dest_offset, fd.offset());
+    }
+    dest_offset = fd.offset();
+    if (static_field) {
+      // Must ensure classes for static fields are initialized as the
+      // accessor itself does not include a class initialization check.
+      ik->initialize(CHECK);
+    }
+    JVMCI_event_2("   field offset for %s %s.%s = %d", signature, ik->external_name(), name, dest_offset);
   }
-  JVMCI_event_2("   field offset for %s %s.%s = %d", signature, ik->external_name(), name, dest_offset);
 }
 
 #ifndef PRODUCT
@@ -120,11 +125,18 @@ jmethodID JNIJVMCI::_HotSpotConstantPool_fromMetaspace_method;
 jmethodID JNIJVMCI::_HotSpotResolvedObjectTypeImpl_fromMetaspace_method;
 jmethodID JNIJVMCI::_HotSpotResolvedPrimitiveType_fromMetaspace_method;
 
-#define START_CLASS(className, fullClassName)                          { \
+#define START_CLASS(className, fullClassName)                          {                 \
   Klass* k = SystemDictionary::resolve_or_fail(vmSymbols::fullClassName(), true, CHECK); \
-  className::_klass = InstanceKlass::cast(k);                                     \
-  JVMCI_event_2(" klass for %s = " PTR_FORMAT, k->external_name(), p2i(k));       \
-  className::_klass->initialize(CHECK);
+  InstanceKlass* current = className::_klass;                                            \
+  if (current != InstanceKlass::cast(k)) {                                               \
+    if (current != nullptr) {                                                            \
+      fatal("klass for %s re-initialized: " PTR_FORMAT " -> " PTR_FORMAT,                \
+          k->external_name(), p2i(current), p2i(k));                                     \
+    }                                                                                    \
+    JVMCI_event_2(" klass for %s = " PTR_FORMAT, k->external_name(), p2i(k));            \
+    className::_klass = InstanceKlass::cast(k);                                          \
+    className::_klass->initialize(CHECK);                                                \
+  }
 
 #define END_CLASS }
 
@@ -300,7 +312,16 @@ void JNIJVMCI::initialize_field_id(JNIEnv* env, jfieldID &fieldid, jclass clazz,
     // Class initialization barrier
     fieldid = env->GetFieldID(clazz, name, signature);
   }
-  JVMCI_event_2("   jfieldID for %s %s.%s = " PTR_FORMAT, signature, class_name, name, p2i(fieldid));
+  // SVM guarantees that jfieldIDs for fields in the native image are also
+  // in the image and thus always have the same address.
+  if (current != fieldid) {
+    if (current != nullptr) {
+      fatal("jfieldID for %s %s.%s re-initialized: " PTR_FORMAT " -> " PTR_FORMAT,
+         signature, class_name, name, p2i(current), p2i(fieldid));
+    }
+    JVMCI_event_2("   jfieldID for %s %s.%s = " PTR_FORMAT, signature, class_name, name, p2i(fieldid));
+  }
+
 
   if (env->ExceptionCheck()) {
     env->ExceptionDescribe();
@@ -312,16 +333,26 @@ void JNIJVMCI::initialize_field_id(JNIEnv* env, jfieldID &fieldid, jclass clazz,
 
 #define START_CLASS(className, fullClassName) {                                             \
   current_class_name = vmSymbols::fullClassName()->as_C_string();                           \
-  if (JVMCILibDumpJNIConfig != NULL) {                                                      \
+  if (JVMCILibDumpJNIConfig != nullptr) {                                                   \
     fileStream* st = JVMCIGlobals::get_jni_config_file();                                   \
     st->print_cr("class %s", current_class_name);                                           \
   } else {                                                                                  \
     jclass k = env->FindClass(current_class_name);                                          \
     JVMCI_EXCEPTION_CHECK(env, "FindClass(%s)", current_class_name);                        \
-    assert(k != NULL, #fullClassName " not initialized");                                   \
+    assert(k != nullptr, #fullClassName " not initialized");                                \
     k = (jclass) env->NewGlobalRef(k);                                                      \
-    JVMCI_event_2(" jclass for %s = " PTR_FORMAT, current_class_name, p2i(k));              \
-    className::_class = k;                                                                  \
+    jclass current = className::_class;                                                     \
+    if (current != k) {                                                                     \
+      JVMCI_event_2(" jclass for %s = " PTR_FORMAT, current_class_name, p2i(k));            \
+      /* SVM guarantees that jclass handles to classes in a native image are also */        \
+      /* in the image. Further calling NewGlobalRef on such a handle returns a stable */    \
+      /* values across all JavaVMs executing on the same native image. */                   \
+      if (current != nullptr) {                                                             \
+           fatal("jclass for %s re-initialized: " PTR_FORMAT " -> " PTR_FORMAT,             \
+           current_class_name, p2i(current), p2i(k));                                       \
+      }                                                                                     \
+      className::_class = k;                                                                \
+    }                                                                                       \
   }
 
 #define END_CLASS current_class_name = NULL; }
@@ -338,17 +369,25 @@ void JNIJVMCI::initialize_field_id(JNIEnv* env, jfieldID &fieldid, jclass clazz,
 #define STATIC_BOOLEAN_FIELD(className, name) FIELD(className, name, "Z", true)
 
 #define GET_JNI_METHOD(jniGetMethod, dst, clazz, methodName, signature)                        \
-    if (JVMCILibDumpJNIConfig != NULL) {                                                       \
+    if (JVMCILibDumpJNIConfig != nullptr) {                                                    \
       fileStream* st = JVMCIGlobals::get_jni_config_file();                                    \
       st->print_cr("method %s %s %s", current_class_name, methodName, signature);              \
     } else {                                                                                   \
       jmethodID current = dst;                                                                 \
       dst = env->jniGetMethod(clazz, methodName, signature);                                   \
-      JVMCI_EXCEPTION_CHECK(env, #jniGetMethod "(%s.%s%s)",                                    \
-                  current_class_name, methodName, signature);                                  \
-      assert(dst != NULL, "uninitialized");                                                    \
-      JVMCI_event_2("   jmethodID for %s.%s%s = " PTR_FORMAT,                                  \
-                  current_class_name, methodName, signature, p2i(dst));                        \
+      assert(dst != nullptr, "uninitialized");                                                 \
+      if (current != dst) {                                                                    \
+        JVMCI_event_2("   jmethodID for %s.%s%s = " PTR_FORMAT,                                \
+                    current_class_name, methodName, signature, p2i(dst));                      \
+        /* SVM guarantees that jmethodIDs for methods in the native image are also */          \
+        /* in the image and thus always have the same address. */                              \
+        if (current != nullptr) {                                                              \
+          fatal("jmethod for %s.%s%s re-initialized: " PTR_FORMAT " -> " PTR_FORMAT,           \
+                        current_class_name, methodName, signature, p2i(current), p2i(dst));    \
+        }                                                                                      \
+        JVMCI_EXCEPTION_CHECK(env, #jniGetMethod "(%s.%s%s)",                                  \
+                            current_class_name, methodName, signature);                        \
+      }                                                                                        \
     }
 
 #define GET_JNI_CONSTRUCTOR(clazz, signature) \