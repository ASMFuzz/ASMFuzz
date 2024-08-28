@@ -60,6 +60,10 @@
 #include "runtime/signature.hpp"
 #include "runtime/thread.inline.hpp"
 #include "runtime/vmThread.hpp"
+#include "utilities/macros.hpp"
+#if INCLUDE_JFR
+#include "jfr/jfr.hpp"
+#endif
 
 //------------------------------------------------------------------------------------------------------------------------
 // Implementation of CallInfo
@@ -1092,6 +1096,7 @@ void LinkResolver::resolve_static_call(CallInfo& result,
 
   // setup result
   result.set_static(resolved_klass, methodHandle(THREAD, resolved_method), CHECK);
+  JFR_ONLY(Jfr::on_resolution(result, CHECK);)
 }
 
 // throws linktime exceptions
@@ -1297,6 +1302,7 @@ void LinkResolver::runtime_resolve_special_method(CallInfo& result,
 
   // setup result
   result.set_static(resolved_klass, sel_method, CHECK);
+  JFR_ONLY(Jfr::on_resolution(result, CHECK);)
 }
 
 void LinkResolver::resolve_virtual_call(CallInfo& result, Handle recv, Klass* receiver_klass,
@@ -1417,6 +1423,7 @@ void LinkResolver::runtime_resolve_virtual_method(CallInfo& result,
   }
   // setup result
   result.set_virtual(resolved_klass, resolved_method, selected_method, vtable_index, CHECK);
+  JFR_ONLY(Jfr::on_resolution(result, CHECK);)
 }
 
 void LinkResolver::resolve_interface_call(CallInfo& result, Handle recv, Klass* recv_klass,
@@ -1528,6 +1535,7 @@ void LinkResolver::runtime_resolve_interface_method(CallInfo& result,
     // This sets up the nonvirtual form of "virtual" call (as needed for final and private methods)
     result.set_virtual(resolved_klass, resolved_method, resolved_method, index, CHECK);
   }
+  JFR_ONLY(Jfr::on_resolution(result, CHECK);)
 }
 
 
@@ -1699,6 +1707,7 @@ bool LinkResolver::resolve_previously_linked_invokehandle(CallInfo& result, cons
     methodHandle method(THREAD, cpce->f1_as_method());
     Handle     appendix(THREAD, cpce->appendix_if_resolved(pool));
     result.set_handle(resolved_klass, method, appendix, CHECK_false);
+    JFR_ONLY(Jfr::on_resolution(result, CHECK_false);)
     return true;
   } else {
     return false;
@@ -1730,6 +1739,7 @@ void LinkResolver::resolve_handle_call(CallInfo& result,
   Handle resolved_appendix;
   Method* resolved_method = lookup_polymorphic_method(link_info, &resolved_appendix, CHECK);
   result.set_handle(resolved_klass, methodHandle(THREAD, resolved_method), resolved_appendix, CHECK);
+  JFR_ONLY(Jfr::on_resolution(result, CHECK);)
 }
 
 void LinkResolver::resolve_invokedynamic(CallInfo& result, const constantPoolHandle& pool, int indy_index, TRAPS) {
@@ -1811,6 +1821,7 @@ void LinkResolver::resolve_dynamic_call(CallInfo& result,
   bootstrap_specifier.resolve_newly_linked_invokedynamic(result, CHECK);
   // Exceptions::wrap_dynamic_exception not used because
   // set_handle doesn't throw linkage errors
+  JFR_ONLY(Jfr::on_resolution(result, CHECK);)
 }
 
 // Selected method is abstract.