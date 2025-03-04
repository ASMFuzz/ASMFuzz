@@ -0,0 +1,103 @@
+/*
+ * Copyright (c) 2022, Oracle and/or its affiliates. All rights reserved.
+ * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
+ *
+ * This code is free software; you can redistribute it and/or modify it
+ * under the terms of the GNU General Public License version 2 only, as
+ * published by the Free Software Foundation.
+ *
+ * This code is distributed in the hope that it will be useful, but WITHOUT
+ * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
+ * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
+ * version 2 for more details (a copy is included in the LICENSE file that
+ * accompanied this code).
+ *
+ * You should have received a copy of the GNU General Public License version
+ * 2 along with this work; if not, write to the Free Software Foundation,
+ * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
+ *
+ * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
+ * or visit www.oracle.com if you need additional information or have any
+ * questions.
+ *
+ */
+
+#include "precompiled.hpp"
+#include "c1/c1_GraphBuilder.hpp"
+#include "ci/ciKlass.hpp"
+#include "ci/ciMethod.hpp"
+#include "classfile/vmSymbols.hpp"
+#include "interpreter/linkResolver.hpp"
+#include "jfr/instrumentation/jfrResolution.hpp"
+#include "jfr/recorder/checkpoint/types/traceid/jfrTraceIdMacros.hpp"
+#include "oops/method.inline.hpp"
+#include "opto/parse.hpp"
+#include "runtime/thread.hpp"
+#include "runtime/vframe.inline.hpp"
+
+static const char* const link_error_msg = "illegal access linking method 'jdk.jfr.internal.event.EventWriterFactory.getEventWriter(long)'";
+
+static const Method* ljf_sender_method(JavaThread* jt) {
+  assert(jt != nullptr, "invariant");
+  if (!jt->has_last_Java_frame()) {
+    return nullptr;
+  }
+  const vframeStream ljf(jt, false, false);
+  return ljf.method();
+}
+
+void JfrResolution::on_runtime_resolution(const CallInfo & info, TRAPS) {
+  assert(info.selected_method() != nullptr, "invariant");
+  assert(info.resolved_klass() != nullptr, "invariant");
+  static const Symbol* const event_writer_method_name = vmSymbols::getEventWriter_name();
+  assert(event_writer_method_name != nullptr, "invariant");
+  // Fast path
+  if (info.selected_method()->name() != event_writer_method_name) {
+    return;
+  }
+  static const Symbol* const event_writer_factory_klass_name = vmSymbols::jdk_jfr_internal_event_EventWriterFactory();
+  assert(event_writer_factory_klass_name != nullptr, "invariant");
+  if (info.resolved_klass()->name() != event_writer_factory_klass_name) {
+    return;
+  }
+  // Attempting to link against jdk.jfr.internal.event.EventWriterFactory.getEventWriter().
+  // The sender, i.e. the method attempting to link, is in the ljf (if one exists).
+  const Method* const sender = ljf_sender_method(THREAD);
+  if (sender == nullptr) {
+    // A compiler thread is doing linktime resolution but there is no information about the sender available.
+    // For the compiler threads, the sender is instead found as part of bytecode parsing.
+    return;
+  }
+  // Is the sender method blessed for linkage?
+  if (IS_METHOD_BLESSED(sender)) {
+    return;
+  }
+  THROW_MSG(vmSymbols::java_lang_IllegalAccessError(), link_error_msg);
+}
+
+static inline bool is_compiler_linking_event_writer(const ciKlass * holder, const ciMethod * target) {
+  assert(holder != nullptr, "invariant");
+  assert(target != nullptr, "invariant");
+  static const Symbol* const event_writer_factory_klass_name = vmSymbols::jdk_jfr_internal_event_EventWriterFactory();
+  assert(event_writer_factory_klass_name != nullptr, "invariant");
+  if (holder->name()->get_symbol() != event_writer_factory_klass_name) {
+    return false;
+  }
+  static const Symbol* const event_writer_method_name = vmSymbols::getEventWriter_name();
+  assert(event_writer_method_name != nullptr, "invariant");
+  return target->name()->get_symbol() == event_writer_method_name;
+}
+
+// C1
+void JfrResolution::on_c1_resolution(const GraphBuilder * builder, const ciKlass * holder, const ciMethod * target) {
+  if (is_compiler_linking_event_writer(holder, target) && !IS_METHOD_BLESSED(builder->method()->get_Method())) {
+    builder->bailout(link_error_msg);
+  }
+}
+
+// C2
+void JfrResolution::on_c2_resolution(const Parse * parse, const ciKlass * holder, const ciMethod * target) {
+  if (is_compiler_linking_event_writer(holder, target) && !IS_METHOD_BLESSED(parse->method()->get_Method())) {
+    parse->C->record_failure(link_error_msg);
+  }
+}