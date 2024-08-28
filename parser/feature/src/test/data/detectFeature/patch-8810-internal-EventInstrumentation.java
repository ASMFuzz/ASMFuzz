@@ -102,6 +102,8 @@ record FieldInfo(String fieldName, String fieldDescriptor, String internalClassN
     private static final Method METHOD_EVENT_CONFIGURATION_GET_SETTING = new Method("getSetting", TYPE_SETTING_CONTROL, new Type[] { Type.INT_TYPE });
     private static final Method METHOD_DURATION = new Method("duration", Type.LONG_TYPE, new Type[] { Type.LONG_TYPE });
     private static final Method METHOD_RESET = new Method("reset", "()V");
+    private static final Method METHOD_ENABLED = new Method("enabled", Type.BOOLEAN_TYPE, new Type[0]);
+    private static final Method METHOD_SHOULD_COMMIT_LONG = new Method("shouldCommit", Type.BOOLEAN_TYPE, new Type[] { Type.LONG_TYPE });
 
     private final ClassNode classNode;
     private final List<SettingInfo> settingInfos;
@@ -112,21 +114,23 @@ record FieldInfo(String fieldName, String fieldDescriptor, String internalClassN
     private final Method staticCommitMethod;
     private final long eventTypeId;
     private final boolean guardEventConfiguration;
+    private final boolean isJDK;
 
-    EventInstrumentation(Class<?> superClass, byte[] bytes, long id, boolean bootClass, boolean guardEventConfiguration) {
+    EventInstrumentation(Class<?> superClass, byte[] bytes, long id, boolean isJDK, boolean guardEventConfiguration) {
         this.eventTypeId = id;
         this.superClass = superClass;
         this.classNode = createClassNode(bytes);
         this.settingInfos = buildSettingInfos(superClass, classNode);
         this.fieldInfos = buildFieldInfos(superClass, classNode);
         String n = annotationValue(classNode, ANNOTATION_NAME_DESCRIPTOR, String.class);
         this.eventName = n == null ? classNode.name.replace("/", ".") : n;
-        this.staticCommitMethod = bootClass ? findStaticCommitMethod(classNode, fieldInfos) : null;
+        this.staticCommitMethod = isJDK ? findStaticCommitMethod(classNode, fieldInfos) : null;
         this.untypedEventConfiguration = hasUntypedConfiguration();
         // Corner case when we are forced to generate bytecode (bytesForEagerInstrumentation)
         // We can't reference EventConfiguration::isEnabled() before event class has been registered,
         // so we add a guard against a null reference.
         this.guardEventConfiguration = guardEventConfiguration;
+        this.isJDK = isJDK;
     }
 
     public static Method findStaticCommitMethod(ClassNode classNode, List<FieldInfo> fields) {
@@ -334,22 +338,8 @@ public byte[] buildUninstrumented() {
     }
 
     private void makeInstrumented() {
-        updateMethod(METHOD_IS_ENABLED, methodVisitor -> {
-            Label nullLabel = new Label();
-            if (guardEventConfiguration) {
-                getEventConfiguration(methodVisitor);
-                methodVisitor.visitJumpInsn(Opcodes.IFNULL, nullLabel);
-            }
-            getEventConfiguration(methodVisitor);
-            invokeVirtual(methodVisitor, TYPE_EVENT_CONFIGURATION, METHOD_IS_ENABLED);
-            methodVisitor.visitInsn(Opcodes.IRETURN);
-            if (guardEventConfiguration) {
-                methodVisitor.visitLabel(nullLabel);
-                methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
-                methodVisitor.visitInsn(Opcodes.ICONST_0);
-                methodVisitor.visitInsn(Opcodes.IRETURN);
-            }
-        });
+        // MyEvent#isEnabled()
+        updateEnabledMethod(METHOD_IS_ENABLED);
 
         // MyEvent#begin()
         updateMethod(METHOD_BEGIN, methodVisitor -> {
@@ -668,6 +658,74 @@ private void makeInstrumented() {
             methodVisitor.visitInsn(Opcodes.ICONST_0);
             methodVisitor.visitInsn(Opcodes.IRETURN);
         });
+
+        if (isJDK) {
+            if (hasStaticMethod(METHOD_ENABLED)) {
+                updateEnabledMethod(METHOD_ENABLED);
+            };
+            updateIfStaticMethodExists(METHOD_SHOULD_COMMIT_LONG, methodVisitor -> {
+                Label fail = new Label();
+                if (guardEventConfiguration) {
+                    // if (eventConfiguration == null) goto fail;
+                    getEventConfiguration(methodVisitor);
+                    methodVisitor.visitJumpInsn(Opcodes.IFNULL, fail);
+                }
+                // return eventConfiguration.shouldCommit(duration);
+                getEventConfiguration(methodVisitor);
+                methodVisitor.visitVarInsn(Opcodes.LLOAD, 0);
+                invokeVirtual(methodVisitor, TYPE_EVENT_CONFIGURATION, METHOD_EVENT_CONFIGURATION_SHOULD_COMMIT);
+                methodVisitor.visitInsn(Opcodes.IRETURN);
+                // fail:
+                methodVisitor.visitLabel(fail);
+                // return false
+                methodVisitor.visitInsn(Opcodes.ICONST_0);
+                methodVisitor.visitInsn(Opcodes.IRETURN);
+                methodVisitor.visitMaxs(0, 0);
+                methodVisitor.visitEnd();
+            });
+            updateIfStaticMethodExists(METHOD_TIME_STAMP, methodVisitor -> {
+                invokeStatic(methodVisitor, TYPE_EVENT_CONFIGURATION.getInternalName(), METHOD_TIME_STAMP);
+                methodVisitor.visitInsn(Opcodes.LRETURN);
+                methodVisitor.visitMaxs(0, 0);
+                methodVisitor.visitEnd();
+            });
+        }
+    }
+
+    private void updateEnabledMethod(Method method) {
+        updateMethod(method, methodVisitor -> {
+            Label nullLabel = new Label();
+            if (guardEventConfiguration) {
+                getEventConfiguration(methodVisitor);
+                methodVisitor.visitJumpInsn(Opcodes.IFNULL, nullLabel);
+            }
+            getEventConfiguration(methodVisitor);
+            invokeVirtual(methodVisitor, TYPE_EVENT_CONFIGURATION, METHOD_IS_ENABLED);
+            methodVisitor.visitInsn(Opcodes.IRETURN);
+            if (guardEventConfiguration) {
+                methodVisitor.visitLabel(nullLabel);
+                methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
+                methodVisitor.visitInsn(Opcodes.ICONST_0);
+                methodVisitor.visitInsn(Opcodes.IRETURN);
+            }
+            methodVisitor.visitMaxs(0, 0);
+            methodVisitor.visitEnd();
+        });
+    }
+
+    private void updateIfStaticMethodExists(Method method, Consumer<MethodVisitor> code) {
+        if (hasStaticMethod(method)) {
+            updateMethod(method, code);
+        }
+    }
+
+    private boolean hasStaticMethod(Method method) {
+        for (MethodNode m : classNode.methods) {
+            if (m.name.equals(method.getName()) && m.desc.equals(method.getDescriptor())) {
+                return Modifier.isStatic(m.access);
+            }
+        }
+        return false;
     }
 
     private void getEventWriter(MethodVisitor mv) {