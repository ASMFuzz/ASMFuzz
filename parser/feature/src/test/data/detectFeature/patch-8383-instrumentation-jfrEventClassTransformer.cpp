@@ -32,13 +32,13 @@
 #include "classfile/modules.hpp"
 #include "classfile/stackMapTable.hpp"
 #include "classfile/symbolTable.hpp"
-#include "classfile/systemDictionary.hpp"
 #include "classfile/verificationType.hpp"
 #include "interpreter/bytecodes.hpp"
 #include "jfr/instrumentation/jfrEventClassTransformer.hpp"
 #include "jfr/jfr.hpp"
 #include "jfr/jni/jfrJavaSupport.hpp"
 #include "jfr/jni/jfrUpcalls.hpp"
+#include "jfr/recorder/jfrRecorder.hpp"
 #include "jfr/recorder/checkpoint/types/traceid/jfrTraceId.inline.hpp"
 #include "jfr/support/jfrJdkJfrEvent.hpp"
 #include "jfr/utilities/jfrBigEndian.hpp"
@@ -47,16 +47,19 @@
 #include "memory/allocation.inline.hpp"
 #include "memory/resourceArea.hpp"
 #include "oops/array.hpp"
+#include "oops/constMethod.hpp"
 #include "oops/instanceKlass.hpp"
 #include "oops/klass.inline.hpp"
 #include "oops/method.hpp"
 #include "prims/jvmtiRedefineClasses.hpp"
+#include "prims/jvmtiThreadState.hpp"
 #include "runtime/handles.inline.hpp"
 #include "runtime/jniHandles.hpp"
 #include "runtime/os.hpp"
 #include "runtime/thread.inline.hpp"
 #include "utilities/exceptions.hpp"
 #include "utilities/globalDefinitions.hpp"
+#include "utilities/growableArray.hpp"
 #include "utilities/macros.hpp"
 
 static const u2 number_of_new_methods = 5;
@@ -68,7 +71,7 @@ static const char* utf8_constants[] = {
   "Code",         // 0
   "J",            // 1
   "commit",       // 2
-  "eventHandler", // 3
+  "eventConfiguration", // 3
   "duration",     // 4
   "begin",        // 5
   "()V",          // 6
@@ -77,7 +80,7 @@ static const char* utf8_constants[] = {
   "end",          // 9
   "shouldCommit", // 10
   "startTime",    // 11 // LAST_REQUIRED_UTF8
-  "Ljdk/jfr/internal/handlers/EventHandler;", // 12
+  "Ljdk/jfr/internal/event/EventConfiguration;", // 12
   "Ljava/lang/Object;", // 13
   "<clinit>",     // 14
   "jdk/jfr/FlightRecorder", // 15
@@ -95,7 +98,7 @@ enum utf8_req_symbols {
   UTF8_REQ_Code,
   UTF8_REQ_J_FIELD_DESC,
   UTF8_REQ_commit,
-  UTF8_REQ_eventHandler,
+  UTF8_REQ_eventConfiguration,
   UTF8_REQ_duration,
   UTF8_REQ_begin,
   UTF8_REQ_EMPTY_VOID_METHOD_DESC,
@@ -108,7 +111,7 @@ enum utf8_req_symbols {
 };
 
 enum utf8_opt_symbols {
-  UTF8_OPT_eventHandler_FIELD_DESC = NOF_UTF8_REQ_SYMBOLS,
+  UTF8_OPT_eventConfiguration_FIELD_DESC = NOF_UTF8_REQ_SYMBOLS,
   UTF8_OPT_LjavaLangObject,
   UTF8_OPT_clinit,
   UTF8_OPT_FlightRecorder,
@@ -565,11 +568,11 @@ static jlong add_field_info(JfrBigEndianWriter& writer, u2 name_index, u2 desc_i
   return writer.current_offset();
 }
 
-static u2 add_field_infos(JfrBigEndianWriter& writer, const u2* utf8_indexes, bool untypedEventHandler) {
+static u2 add_field_infos(JfrBigEndianWriter& writer, const u2* utf8_indexes, bool untypedEventConfiguration) {
   assert(utf8_indexes != NULL, "invariant");
   add_field_info(writer,
-                 utf8_indexes[UTF8_REQ_eventHandler],
-                 untypedEventHandler ? utf8_indexes[UTF8_OPT_LjavaLangObject] : utf8_indexes[UTF8_OPT_eventHandler_FIELD_DESC],
+                 utf8_indexes[UTF8_REQ_eventConfiguration],
+                 untypedEventConfiguration ? utf8_indexes[UTF8_OPT_LjavaLangObject] : utf8_indexes[UTF8_OPT_eventConfiguration_FIELD_DESC],
                  true); // static
 
   add_field_info(writer,
@@ -1111,11 +1114,40 @@ static jlong insert_clinit_method(const InstanceKlass* ik,
   return writer.current_offset();
 }
 
+static Symbol* begin = NULL;
+static Symbol* end = NULL;
+static Symbol* commit = NULL;
+static Symbol* isEnabled = NULL;
+static Symbol* shouldCommit = NULL;
+static Symbol* void_method_sig = NULL;
+static Symbol* boolean_method_sig = NULL;
+
+static void initialize_symbols() {
+  if (begin == NULL) {
+    begin = SymbolTable::probe("begin", 5);
+    assert(begin != NULL, "invariant");
+    end = SymbolTable::probe("end", 3);
+    assert(end != NULL, "invariant");
+    commit = SymbolTable::probe("commit", 6);
+    assert(commit != NULL, "invariant");
+    isEnabled = SymbolTable::probe("isEnabled", 9);
+    assert(isEnabled != NULL, "invariant");
+    shouldCommit = SymbolTable::probe("shouldCommit", 12);
+    assert(shouldCommit != NULL, "invariant");
+    void_method_sig = SymbolTable::probe("()V", 3);
+    assert(void_method_sig != NULL, "invariant");
+    boolean_method_sig = SymbolTable::probe("()Z", 3);
+    assert(boolean_method_sig != NULL, "invariant");
+  }
+}
+
 // Caller needs ResourceMark
-static ClassFileStream* create_new_bytes_for_event_klass(const InstanceKlass* ik, const ClassFileParser& parser, TRAPS) {
+static ClassFileStream* schema_extend_event_klass_bytes(const InstanceKlass* ik, const ClassFileParser& parser, TRAPS) {
   DEBUG_ONLY(JfrJavaSupport::check_java_thread_in_vm(THREAD));
+  initialize_symbols();
   static const u2 public_final_flag_mask = JVM_ACC_PUBLIC | JVM_ACC_FINAL;
   const ClassFileStream* const orig_stream = parser.clone_stream();
+  assert(orig_stream != NULL, "invariant");
   const int orig_stream_length = orig_stream->length();
   // allocate an identically sized buffer
   u1* const new_buffer = NEW_RESOURCE_ARRAY_IN_THREAD_RETURN_NULL(THREAD, u1, orig_stream_length);
@@ -1202,7 +1234,7 @@ static u2 resolve_utf8_indexes(JfrBigEndianWriter& writer,
                                u2 orig_cp_len,
                                const Method* clinit_method,
                                bool register_klass,
-                               bool untypedEventHandler,
+                               bool untypedEventConfiguration,
                                TRAPS) {
   assert(utf8_indexes != NULL, "invariant");
   u2 added_cp_entries = 0;
@@ -1212,10 +1244,10 @@ static u2 resolve_utf8_indexes(JfrBigEndianWriter& writer,
   }
 
   // resolve optional constants
-  utf8_indexes[UTF8_OPT_eventHandler_FIELD_DESC] = untypedEventHandler ? invalid_cp_index :
-    find_or_add_utf8_info(writer, ik, utf8_constants[UTF8_OPT_eventHandler_FIELD_DESC], orig_cp_len, added_cp_entries, THREAD);
+  utf8_indexes[UTF8_OPT_eventConfiguration_FIELD_DESC] = untypedEventConfiguration ? invalid_cp_index :
+    find_or_add_utf8_info(writer, ik, utf8_constants[UTF8_OPT_eventConfiguration_FIELD_DESC], orig_cp_len, added_cp_entries, THREAD);
 
-  utf8_indexes[UTF8_OPT_LjavaLangObject] = untypedEventHandler ?
+  utf8_indexes[UTF8_OPT_LjavaLangObject] = untypedEventConfiguration ?
     find_or_add_utf8_info(writer, ik, utf8_constants[UTF8_OPT_LjavaLangObject], orig_cp_len, added_cp_entries, THREAD) : invalid_cp_index;
 
   if (register_klass) {
@@ -1261,7 +1293,7 @@ static u2 resolve_utf8_indexes(JfrBigEndianWriter& writer,
   return added_cp_entries;
 }
 
-static u1* new_bytes_for_lazy_instrumentation(const InstanceKlass* ik,
+static u1* schema_extend_event_subklass_bytes(const InstanceKlass* ik,
                                               const ClassFileParser& parser,
                                               jint& size_of_new_bytes,
                                               TRAPS) {
@@ -1283,7 +1315,7 @@ static u1* new_bytes_for_lazy_instrumentation(const InstanceKlass* ik,
   u1* const new_buffer = NEW_RESOURCE_ARRAY_IN_THREAD_RETURN_NULL(THREAD, u1, new_buffer_size);
   if (new_buffer == NULL) {
     log_error(jfr, system) ("Thread local allocation (native) for " SIZE_FORMAT
-      " bytes failed in JfrClassAdapter::on_klass_creation", (size_t)new_buffer_size);
+      " bytes failed in JfrEventClassTransformer::on_klass_creation", static_cast<size_t>(new_buffer_size));
     return NULL;
   }
   assert(new_buffer != NULL, "invariant");
@@ -1382,6 +1414,10 @@ static u1* new_bytes_for_lazy_instrumentation(const InstanceKlass* ik,
   return new_buffer;
 }
 
+static bool should_force_instrumentation() {
+  return !JfrOptionSet::allow_event_retransforms() || JfrEventClassTransformer::is_force_instrumentation();
+}
+
 static void log_pending_exception(oop throwable) {
   assert(throwable != NULL, "invariant");
   oop msg = java_lang_Throwable::message(throwable);
@@ -1393,73 +1429,254 @@ static void log_pending_exception(oop throwable) {
   }
 }
 
-static bool should_force_instrumentation() {
-  return !JfrOptionSet::allow_event_retransforms() || JfrEventClassTransformer::is_force_instrumentation();
+static bool has_pending_exception(TRAPS) {
+  assert(THREAD != NULL, "invariant");
+  if (HAS_PENDING_EXCEPTION) {
+    log_pending_exception(PENDING_EXCEPTION);
+    CLEAR_PENDING_EXCEPTION;
+    return true;
+  }
+  return false;
+}
+
+static bool has_local_method_implementation(const InstanceKlass* ik, const Symbol* name, const Symbol* signature) {
+  assert(ik != NULL, "invariant");
+  assert(name != NULL, "invariant");
+  assert(signature != NULL, "invariant");
+  return NULL != ik->find_local_method(name, signature, Klass::OverpassLookupMode::skip, Klass::StaticLookupMode::find,
+                                          Klass::PrivateLookupMode::find);
 }
 
-static ClassFileStream* create_new_bytes_for_subklass(const InstanceKlass* ik, const ClassFileParser& parser, JavaThread* t) {
+// If for a subklass, on initial class load, an implementation exist for any of the final methods declared in Event,
+// then constraints are considered breached.
+static bool invalid_preconditions_for_subklass_on_initial_load(const InstanceKlass* ik) {
+  assert(ik != NULL, "invariant");
+  return has_local_method_implementation(ik, begin, void_method_sig) ||
+         has_local_method_implementation(ik, end, void_method_sig) ||
+         has_local_method_implementation(ik, commit, void_method_sig) ||
+         has_local_method_implementation(ik, isEnabled, boolean_method_sig) ||
+         has_local_method_implementation(ik, shouldCommit, boolean_method_sig);
+}
+
+static ClassFileStream* schema_extend_event_subklass_bytes(const InstanceKlass* ik, const ClassFileParser& parser, bool& is_instrumented, TRAPS) {
   assert(JdkJfrEvent::is_a(ik), "invariant");
-  DEBUG_ONLY(JfrJavaSupport::check_java_thread_in_vm(t));
+  assert(!is_instrumented, "invariant");
+  DEBUG_ONLY(JfrJavaSupport::check_java_thread_in_vm(THREAD));
+  if (invalid_preconditions_for_subklass_on_initial_load(ik)) {
+    // Remove the tag denoting this as a jdk.jfr.Event subklass. No instrumentation, hence no events can be written.
+    // The class is allowed to load as-is, but it is classified as outside of the jfr system.
+    JdkJfrEvent::remove(ik);
+    return NULL;
+  }
   jint size_of_new_bytes = 0;
-  const u1* new_bytes = new_bytes_for_lazy_instrumentation(ik, parser, size_of_new_bytes, t);
+  const u1* new_bytes = schema_extend_event_subklass_bytes(ik, parser, size_of_new_bytes, THREAD);
   if (new_bytes == NULL) {
     return NULL;
   }
   assert(new_bytes != NULL, "invariant");
   assert(size_of_new_bytes > 0, "invariant");
-
-  bool force_instrumentation = should_force_instrumentation();
+  const bool force_instrumentation = should_force_instrumentation();
   if (Jfr::is_recording() || force_instrumentation) {
-    jint size_instrumented_data = 0;
-    unsigned char* instrumented_data = NULL;
-    const jclass super = (jclass)JNIHandles::make_local(ik->super()->java_mirror());
+    jint size_of_instrumented_bytes = 0;
+    unsigned char* instrumented_bytes = NULL;
+    const jclass super = static_cast<jclass>(JfrJavaSupport::local_jni_handle(ik->super()->java_mirror(), THREAD));
+    const jboolean boot_class_loader = ik->class_loader_data()->is_boot_class_loader_data();
     JfrUpcalls::new_bytes_eager_instrumentation(JfrTraceId::load_raw(ik),
                                                 force_instrumentation,
+                                                boot_class_loader,
                                                 super,
                                                 size_of_new_bytes,
                                                 new_bytes,
-                                                &size_instrumented_data,
-                                                &instrumented_data,
-                                                t);
-    if (t->has_pending_exception()) {
-      log_pending_exception(t->pending_exception());
-      t->clear_pending_exception();
+                                                &size_of_instrumented_bytes,
+                                                &instrumented_bytes,
+                                                THREAD);
+    JfrJavaSupport::destroy_local_jni_handle(super);
+    if (has_pending_exception(THREAD)) {
       return NULL;
     }
-    assert(instrumented_data != NULL, "invariant");
-    assert(size_instrumented_data > 0, "invariant");
-    return new ClassFileStream(instrumented_data, size_instrumented_data, NULL, ClassFileStream::verify);
+    assert(instrumented_bytes != NULL, "invariant");
+    assert(size_of_instrumented_bytes > 0, "invariant");
+    new_bytes = instrumented_bytes;
+    size_of_new_bytes = size_of_instrumented_bytes;
+    is_instrumented = true;
   }
   return new ClassFileStream(new_bytes, size_of_new_bytes, NULL, ClassFileStream::verify);
 }
 
-static bool cache_bytes(InstanceKlass* ik, ClassFileStream* new_stream, InstanceKlass* new_ik, TRAPS) {
-  assert(ik != NULL, "invariant");
+static bool _force_instrumentation = false;
+
+void JfrEventClassTransformer::set_force_instrumentation(bool force_instrumentation) {
+  _force_instrumentation = force_instrumentation;
+}
+
+bool JfrEventClassTransformer::is_force_instrumentation() {
+  return _force_instrumentation;
+}
+
+static ClassFileStream* retransform_bytes(const Klass* existing_klass, const ClassFileParser& parser, bool& is_instrumented, TRAPS) {
+  assert(existing_klass != NULL, "invariant");
+  assert(!is_instrumented, "invariant");
+  assert(JdkJfrEvent::is_a(existing_klass) || JdkJfrEvent::is_host(existing_klass), "invariant");
+  DEBUG_ONLY(JfrJavaSupport::check_java_thread_in_vm(THREAD));
+  jint size_of_new_bytes = 0;
+  unsigned char* new_bytes = NULL;
+  {
+    ResourceMark rm(THREAD);
+    const ClassFileStream* const stream = parser.clone_stream();
+    assert(stream != NULL, "invariant");
+    const jclass clazz = static_cast<jclass>(JfrJavaSupport::local_jni_handle(existing_klass->java_mirror(), THREAD));
+    JfrUpcalls::on_retransform(JfrTraceId::load_raw(existing_klass),
+                               clazz,
+                               stream->length(),
+                               stream->buffer(),
+                               &size_of_new_bytes,
+                               &new_bytes,
+                               THREAD);
+    JfrJavaSupport::destroy_local_jni_handle(clazz);
+    if (has_pending_exception(THREAD)) {
+      return NULL;
+    }
+  }
+  assert(new_bytes != NULL, "invariant");
+  assert(size_of_new_bytes > 0, "invariant");
+  is_instrumented = true;
+  return new ClassFileStream(new_bytes, size_of_new_bytes, NULL, ClassFileStream::verify);
+}
+
+// On initial class load.
+static void cache_class_file_data(InstanceKlass* new_ik, const ClassFileStream* new_stream, const JavaThread* thread) {
   assert(new_ik != NULL, "invariant");
-  assert(new_ik->name() != NULL, "invariant");
   assert(new_stream != NULL, "invariant");
-  assert(!HAS_PENDING_EXCEPTION, "invariant");
-  static const bool can_retransform = JfrOptionSet::allow_retransforms();
-  if (!can_retransform) {
-    return true;
+  assert(thread != NULL, "invariant");
+  assert(!thread->has_pending_exception(), "invariant");
+  if (!JfrOptionSet::allow_retransforms()) {
+    return;
   }
   const jint stream_len = new_stream->length();
   JvmtiCachedClassFileData* p =
     (JvmtiCachedClassFileData*)NEW_C_HEAP_ARRAY_RETURN_NULL(u1, offset_of(JvmtiCachedClassFileData, data) + stream_len, mtInternal);
   if (p == NULL) {
-    log_error(jfr, system)("Allocation using C_HEAP_ARRAY for " SIZE_FORMAT
-      " bytes failed in JfrClassAdapter::on_klass_creation", (size_t)offset_of(JvmtiCachedClassFileData, data) + stream_len);
-    return false;
+    log_error(jfr, system)("Allocation using C_HEAP_ARRAY for " SIZE_FORMAT " bytes failed in JfrEventClassTransformer::cache_class_file_data",
+      static_cast<size_t>(offset_of(JvmtiCachedClassFileData, data) + stream_len));
+    return;
   }
   p->length = stream_len;
   memcpy(p->data, new_stream->buffer(), stream_len);
   new_ik->set_cached_class_file(p);
-  JvmtiCachedClassFileData* const cached_class_data = ik->get_cached_class_file();
-  if (cached_class_data != NULL) {
-    os::free(cached_class_data);
+}
+
+// On redefine / retransform, in case an agent modified the class, the original bytes are cached onto the scratch klass.
+static void transfer_cached_class_file_data(InstanceKlass* ik, InstanceKlass* new_ik, const ClassFileParser& parser, JavaThread* thread) {
+  assert(ik != NULL, "invariant");
+  assert(new_ik != NULL, "invariant");
+  JvmtiCachedClassFileData* const p = ik->get_cached_class_file();
+  if (p != NULL) {
+    new_ik->set_cached_class_file(p);
     ik->set_cached_class_file(NULL);
+    return;
+  }
+  // No cached classfile indicates that no agent modified the klass.
+  // This means that the parser is holding the original bytes. Hence, we cache it onto the scratch klass.
+  const ClassFileStream* const stream = parser.clone_stream();
+  cache_class_file_data(new_ik, stream, thread);
+}
+
+static void rewrite_klass_pointer(InstanceKlass*& ik, InstanceKlass* new_ik, ClassFileParser& parser, const JavaThread* thread) {
+  assert(ik != NULL, "invariant");
+  assert(new_ik != NULL, "invariant");
+  assert(thread != NULL, "invariant");
+  assert(IS_EVENT_OR_HOST_KLASS(new_ik), "invariant");
+  assert(TRACE_ID(ik) == TRACE_ID(new_ik), "invariant");
+  assert(!thread->has_pending_exception(), "invariant");
+  // Assign original InstanceKlass* back onto "its" parser object for proper destruction.
+  parser.set_klass_to_deallocate(ik);
+  // Finally rewrite the original pointer to the newly created InstanceKlass.
+  ik = new_ik;
+}
+
+// If code size is 1, it is 0xb1, i.e. the return instruction.
+static inline bool is_commit_method_instrumented(const Method* m) {
+  assert(m != NULL, "invariant");
+  assert(m->name() == commit, "invariant");
+  assert(m->constMethod()->code_size() > 0, "invariant");
+  return m->constMethod()->code_size() > 1;
+}
+
+static bool bless_static_commit_method(const Array<Method*>* methods) {
+  assert(methods != NULL, "invariant");
+  for (int i = 0; i < methods->length(); ++i) {
+    const Method* const m = methods->at(i);
+    // Method is of the form "static void UserEvent::commit(...)" and instrumented
+    if (m->is_static() && m->name() == commit && is_commit_method_instrumented(m)) {
+      BLESS_METHOD(m);
+      return true;
+    }
+  }
+  return false;
+}
+
+static void bless_instance_commit_method(const Array<Method*>* methods) {
+  assert(methods != NULL, "invariant");
+  for (int i = 0; i < methods->length(); ++i) {
+    const Method* const m = methods->at(i);
+    // Method is of the form "void UserEvent:commit()" and instrumented
+    if (!m->is_static() &&
+         m->name() == commit &&
+         m->signature() == void_method_sig &&
+         is_commit_method_instrumented(m)) {
+      BLESS_METHOD(m);
+    }
   }
-  return true;
+}
+
+// A blessed method is a method that is allowed to link to system sensitive code.
+// It is primarily the class file schema extended instance 'commit()V' method.
+// Jdk events can also define a static commit method with an arbitrary signature.
+static void bless_commit_method(const InstanceKlass* new_ik) {
+  assert(new_ik != NULL, "invariant");
+  assert(JdkJfrEvent::is_subklass(new_ik), "invariant");
+  const Array<Method*>* const methods = new_ik->methods();
+  if (new_ik->class_loader() == NULL) {
+    // JDK events are allowed an additional commit method that is static.
+    // Search precedence must therefore inspect static methods first.
+    if (bless_static_commit_method(methods)) {
+      return;
+    }
+  }
+  bless_instance_commit_method(methods);
+}
+
+static void copy_traceid(const InstanceKlass* ik, const InstanceKlass* new_ik) {
+  assert(ik != NULL, "invariant");
+  assert(new_ik != NULL, "invariant");
+  new_ik->set_trace_id(ik->trace_id());
+  assert(TRACE_ID(ik) == TRACE_ID(new_ik), "invariant");
+}
+
+static const Klass* klass_being_redefined(const InstanceKlass* ik, JvmtiThreadState* state) {
+  assert(ik != NULL, "invariant");
+  assert(state != NULL, "invariant");
+  const GrowableArray<Klass*>* const redef_klasses = state->get_classes_being_redefined();
+  if (redef_klasses == NULL || redef_klasses->is_empty()) {
+    return NULL;
+  }
+  for (int i = 0; i < redef_klasses->length(); ++i) {
+    const Klass* const existing_klass = redef_klasses->at(i);
+    assert(existing_klass != NULL, "invariant");
+    if (ik->name() == existing_klass->name() && ik->class_loader_data() == existing_klass->class_loader_data()) {
+      // 'ik' is a scratch klass. Return the klass being redefined.
+      return existing_klass;
+    }
+  }
+  return NULL;
+}
+
+// Redefining / retransforming?
+static const Klass* find_existing_klass(const InstanceKlass* ik, JavaThread* thread) {
+  assert(ik != NULL, "invariant");
+  assert(thread != NULL, "invariant");
+  JvmtiThreadState* const state = thread->jvmti_thread_state();
+  return state != NULL ? klass_being_redefined(ik, state) : NULL;
 }
 
 static InstanceKlass* create_new_instance_klass(InstanceKlass* ik, ClassFileStream* stream, TRAPS) {
@@ -1491,88 +1708,105 @@ static InstanceKlass* create_new_instance_klass(InstanceKlass* ik, ClassFileStre
   assert(new_ik != NULL, "invariant");
   assert(new_ik->name() != NULL, "invariant");
   assert(strncmp(ik->name()->as_C_string(), new_ik->name()->as_C_string(), strlen(ik->name()->as_C_string())) == 0, "invariant");
-  return cache_bytes(ik, stream, new_ik, THREAD) ? new_ik : NULL;
+  return new_ik;
 }
 
-static void rewrite_klass_pointer(InstanceKlass*& ik, InstanceKlass* new_ik, ClassFileParser& parser, TRAPS) {
-  assert(ik != NULL, "invariant");
-  assert(new_ik != NULL, "invariant");
-  assert(new_ik->name() != NULL, "invariant");
-  assert(JdkJfrEvent::is(new_ik) || JdkJfrEvent::is_subklass(new_ik), "invariant");
-  assert(!HAS_PENDING_EXCEPTION, "invariant");
-  // assign original InstanceKlass* back onto "its" parser object for proper destruction
-  parser.set_klass_to_deallocate(ik);
-  // now rewrite original pointer to newly created InstanceKlass
-  ik = new_ik;
+static InstanceKlass* create_instance_klass(InstanceKlass*& ik, ClassFileStream* stream, bool is_initial_load, JavaThread* thread) {
+  if (stream == NULL) {
+    if (is_initial_load) {
+      log_error(jfr, system)("JfrEventClassTransformer: unable to create ClassFileStream for %s", ik->external_name());
+    }
+    return NULL;
+  }
+  InstanceKlass* const new_ik = create_new_instance_klass(ik, stream, thread);
+  if (new_ik == NULL) {
+    if (is_initial_load) {
+      log_error(jfr, system)("JfrEventClassTransformer: unable to create InstanceKlass for %s", ik->external_name());
+    }
+  }
+  return new_ik;
 }
 
-static bool is_retransforming(const InstanceKlass* ik, TRAPS) {
-  assert(ik != NULL, "invariant");
-  assert(JdkJfrEvent::is_a(ik), "invariant");
-  Symbol* const name = ik->name();
-  assert(name != NULL, "invariant");
-  Handle class_loader(THREAD, ik->class_loader());
-  Handle protection_domain(THREAD, ik->protection_domain());
-  return SystemDictionary::find_instance_klass(name, class_loader, protection_domain) != NULL;
+static void transform(InstanceKlass*& ik, ClassFileParser& parser, JavaThread* thread) {
+  assert(IS_EVENT_OR_HOST_KLASS(ik), "invariant");
+  bool is_instrumented = false;
+  ClassFileStream* stream = NULL;
+  const Klass* const existing_klass = find_existing_klass(ik, thread);
+  if (existing_klass != NULL) {
+    // There is already a klass defined, implying we are redefining / retransforming.
+    stream = retransform_bytes(existing_klass, parser, is_instrumented, thread);
+  } else {
+    // No existing klass, implying this is the initial load.
+    stream = JdkJfrEvent::is(ik) ? schema_extend_event_klass_bytes(ik, parser, thread) : schema_extend_event_subklass_bytes(ik, parser, is_instrumented, thread);
+  }
+  InstanceKlass* const new_ik = create_instance_klass(ik, stream, existing_klass == NULL, thread);
+  if (new_ik == NULL) {
+    return;
+  }
+  if (existing_klass != NULL) {
+    transfer_cached_class_file_data(ik, new_ik, parser, thread);
+  } else {
+    cache_class_file_data(new_ik, stream, thread);
+  }
+  if (is_instrumented && JdkJfrEvent::is_subklass(new_ik)) {
+    bless_commit_method(new_ik);
+  }
+  copy_traceid(ik, new_ik);
+  rewrite_klass_pointer(ik, new_ik, parser, thread);
 }
 
-// target for JFR_ON_KLASS_CREATION hook
+// Target for the JFR_ON_KLASS_CREATION hook.
+// Extends the class file schema on initial class load or reinstruments on redefine / retransform.
+// The passed in parameter 'ik' acts as an in-out parameter: it is rewritten to point to a replaced
+// instance of the passed in InstanceKlass. The original 'ik' will be set onto the passed parser,
+// for destruction when the parser goes out of scope.
 void JfrEventClassTransformer::on_klass_creation(InstanceKlass*& ik, ClassFileParser& parser, TRAPS) {
   assert(ik != NULL, "invariant");
-  if (JdkJfrEvent::is(ik)) {
-    ResourceMark rm(THREAD);
-    HandleMark hm(THREAD);
-    ClassFileStream* new_stream = create_new_bytes_for_event_klass(ik, parser, THREAD);
-    if (new_stream == NULL) {
-      log_error(jfr, system)("JfrClassAdapter: unable to create ClassFileStream");
-      return;
-    }
-    assert(new_stream != NULL, "invariant");
-    InstanceKlass* new_ik = create_new_instance_klass(ik, new_stream, THREAD);
-    if (new_ik == NULL) {
-      log_error(jfr, system)("JfrClassAdapter: unable to create InstanceKlass");
-      return;
-    }
-    assert(new_ik != NULL, "invariant");
-    // We now need to explicitly tag the replaced klass as the jdk.jfr.Event klass
-    assert(!JdkJfrEvent::is(new_ik), "invariant");
-    JdkJfrEvent::tag_as(new_ik);
-    assert(JdkJfrEvent::is(new_ik), "invariant");
-    rewrite_klass_pointer(ik, new_ik, parser, THREAD);
-    return;
-  }
-  assert(JdkJfrEvent::is_subklass(ik), "invariant");
-  if (ik->is_abstract() || is_retransforming(ik, THREAD)) {
-    // abstract and scratch classes are not instrumented
+  assert(IS_EVENT_OR_HOST_KLASS(ik), "invariant");
+  if (ik->is_abstract() && !JdkJfrEvent::is(ik)) {
+    assert(JdkJfrEvent::is_subklass(ik), "invariant");
+    // Abstract subklasses are not instrumented.
     return;
   }
   ResourceMark rm(THREAD);
   HandleMark hm(THREAD);
-  ClassFileStream* const new_stream = create_new_bytes_for_subklass(ik, parser, THREAD);
-  if (NULL == new_stream) {
-    log_error(jfr, system)("JfrClassAdapter: unable to create ClassFileStream");
-    return;
-  }
-  assert(new_stream != NULL, "invariant");
-  InstanceKlass* new_ik = create_new_instance_klass(ik, new_stream, THREAD);
-  if (new_ik == NULL) {
-    log_error(jfr, system)("JfrClassAdapter: unable to create InstanceKlass");
-    return;
+  transform(ik, parser, THREAD);
+}
+
+static bool is_static_commit_method_blessed(const Array<Method*>* methods) {
+  assert(methods != NULL, "invariant");
+  for (int i = 0; i < methods->length(); ++i) {
+    const Method* const m = methods->at(i);
+    // Must be of form: static void UserEvent::commit(...)
+    if (m->is_static() && m->name() == commit) {
+      return IS_METHOD_BLESSED(m);
+    }
   }
-  assert(new_ik != NULL, "invariant");
-  // would have been tagged already as a subklass during the normal process of traceid assignment
-  assert(JdkJfrEvent::is_subklass(new_ik), "invariant");
-  traceid id = ik->trace_id();
-  ik->set_trace_id(0);
-  new_ik->set_trace_id(id);
-  rewrite_klass_pointer(ik, new_ik, parser, THREAD);
+  return false;
 }
 
-static bool _force_instrumentation = false;
-void JfrEventClassTransformer::set_force_instrumentation(bool force_instrumentation) {
-  _force_instrumentation = force_instrumentation;
+static bool is_instance_commit_method_blessed(const Array<Method*>* methods) {
+  assert(methods != NULL, "invariant");
+  for (int i = 0; i < methods->length(); ++i) {
+    const Method* const m = methods->at(i);
+    // Must be of form: void UserEvent::commit()
+    if (!m->is_static() && m->name() == commit && m->signature() == void_method_sig) {
+      return IS_METHOD_BLESSED(m);
+    }
+  }
+  return false;
 }
 
-bool JfrEventClassTransformer::is_force_instrumentation() {
-  return _force_instrumentation;
+bool JfrEventClassTransformer::is_instrumented(const InstanceKlass* ik) {
+  assert(ik != NULL, "invariant");
+  assert(JdkJfrEvent::is_subklass(ik), "invariant");
+  const Array<Method*>* const methods = ik->methods();
+  if (ik->class_loader() == NULL) {
+    // JDK events are allowed an additional commit method that is static.
+    // Search precedence must therefore inspect static methods first.
+    if (is_static_commit_method_blessed(methods)) {
+      return true;
+    }
+  }
+  return is_instance_commit_method_blessed(methods);
 }