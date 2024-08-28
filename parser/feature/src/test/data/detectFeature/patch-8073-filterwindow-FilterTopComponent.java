@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2008, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2008, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -35,6 +35,9 @@
 import java.awt.event.ActionListener;
 import java.io.*;
 import java.util.*;
+import java.util.logging.Level;
+import java.util.logging.Logger;
+import javax.script.*;
 import javax.swing.JComboBox;
 import javax.swing.UIManager;
 import javax.swing.border.Border;
@@ -67,10 +70,12 @@ public final class FilterTopComponent extends TopComponent implements LookupList
     public static final String AFTER_ID = "after";
     public static final String ENABLED_ID = "enabled";
     public static final String PREFERRED_ID = "FilterTopComponent";
+    public static final String JAVASCRIPT_HELPER_ID = "JavaScriptHelper";
     private CheckListView view;
     private ExplorerManager manager;
     private FilterChain filterChain;
     private FilterChain sequence;
+    private ScriptEngine engine;
     private Lookup.Result<FilterChain> result;
     private JComboBox comboBox;
     private List<FilterSetting> filterSettings;
@@ -300,6 +305,36 @@ public FilterChain getFilterChain() {
         return filterChain;
     }
 
+    private static String getJsHelperText() {
+        InputStream is = null;
+        StringBuilder sb = new StringBuilder("if (typeof importPackage === 'undefined') { try { load('nashorn:mozilla_compat.js'); } catch (e) {} }"
+                + "importPackage(Packages.com.sun.hotspot.igv.filter);"
+                + "importPackage(Packages.com.sun.hotspot.igv.graph);"
+                + "importPackage(Packages.com.sun.hotspot.igv.data);"
+                + "importPackage(Packages.com.sun.hotspot.igv.util);"
+                + "importPackage(java.awt);");
+        try {
+            FileObject fo = FileUtil.getConfigRoot().getFileObject(JAVASCRIPT_HELPER_ID);
+            is = fo.getInputStream();
+            BufferedReader r = new BufferedReader(new InputStreamReader(is));
+            String s;
+            while ((s = r.readLine()) != null) {
+                sb.append(s);
+                sb.append("\n");
+            }
+
+        } catch (IOException ex) {
+            Logger.getLogger("global").log(Level.SEVERE, null, ex);
+        } finally {
+            try {
+                is.close();
+            } catch (IOException ex) {
+                Exceptions.printStackTrace(ex);
+            }
+        }
+        return sb.toString();
+    }
+
     private FilterTopComponent() {
         filterSettingsChangedEvent = new ChangedEvent<>(this);
         initComponents();
@@ -309,6 +344,14 @@ private FilterTopComponent() {
 
         sequence = new FilterChain();
         filterChain = new FilterChain();
+        ScriptEngineManager sem = new ScriptEngineManager();
+        engine = sem.getEngineByName("ECMAScript");
+        try {
+            engine.eval(getJsHelperText());
+        } catch (ScriptException ex) {
+            Exceptions.printStackTrace(ex);
+        }
+        engine.getContext().getBindings(ScriptContext.ENGINE_SCOPE).put("IO", System.out);
         initFilters();
         manager = new ExplorerManager();
         manager.setRootContext(new AbstractNode(new FilterChildren()));
@@ -339,7 +382,7 @@ private FilterTopComponent() {
     }
 
     public void newFilter() {
-        CustomFilter cf = new CustomFilter("My custom filter", "");
+        CustomFilter cf = new CustomFilter("My custom filter", "", engine);
         if (cf.openInEditor()) {
             sequence.addFilter(cf);
             FileObject fo = getFileObject(cf);
@@ -437,7 +480,7 @@ public void initFilters() {
             String displayName = fo.getName();
 
 
-            final CustomFilter cf = new CustomFilter(displayName, code);
+            final CustomFilter cf = new CustomFilter(displayName, code, engine);
             map.put(displayName, cf);
 
             String after = (String) fo.getAttribute(AFTER_ID);