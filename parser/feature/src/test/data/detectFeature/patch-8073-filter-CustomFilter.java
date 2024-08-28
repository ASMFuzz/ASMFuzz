@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2015, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,16 +25,8 @@
 package com.sun.hotspot.igv.filter;
 
 import com.sun.hotspot.igv.graph.Diagram;
-import java.io.BufferedReader;
-import java.io.IOException;
-import java.io.InputStream;
-import java.io.InputStreamReader;
-import java.util.logging.Level;
-import java.util.logging.Logger;
 import javax.script.*;
 import org.openide.cookies.OpenCookie;
-import org.openide.filesystems.FileObject;
-import org.openide.filesystems.FileUtil;
 import org.openide.util.Exceptions;
 
 /**
@@ -43,13 +35,14 @@
  */
 public class CustomFilter extends AbstractFilter {
 
-    public static final String JAVASCRIPT_HELPER_ID = "JavaScriptHelper";
     private String code;
     private String name;
+    private ScriptEngine engine;
 
-    public CustomFilter(String name, String code) {
+    public CustomFilter(String name, String code, ScriptEngine engine) {
         this.name = name;
         this.code = code;
+        this.engine = engine;
         getProperties().setProperty("name", name);
     }
 
@@ -96,46 +89,13 @@ public String toString() {
         return getName();
     }
 
-    private static String getJsHelperText() {
-        InputStream is = null;
-        StringBuilder sb = new StringBuilder("if (typeof importPackage === 'undefined') { try { load('nashorn:mozilla_compat.js'); } catch (e) {} }"
-                + "importPackage(Packages.com.sun.hotspot.igv.filter);"
-                + "importPackage(Packages.com.sun.hotspot.igv.graph);"
-                + "importPackage(Packages.com.sun.hotspot.igv.data);"
-                + "importPackage(Packages.com.sun.hotspot.igv.util);"
-                + "importPackage(java.awt);");
-        try {
-            FileObject fo = FileUtil.getConfigRoot().getFileObject(JAVASCRIPT_HELPER_ID);
-            is = fo.getInputStream();
-            BufferedReader r = new BufferedReader(new InputStreamReader(is));
-            String s;
-            while ((s = r.readLine()) != null) {
-                sb.append(s);
-                sb.append("\n");
-            }
-
-        } catch (IOException ex) {
-            Logger.getLogger("global").log(Level.SEVERE, null, ex);
-        } finally {
-            try {
-                is.close();
-            } catch (IOException ex) {
-                Exceptions.printStackTrace(ex);
-            }
-        }
-        return sb.toString();
-    }
 
     @Override
     public void apply(Diagram d) {
         try {
-            ScriptEngineManager sem = new ScriptEngineManager();
-            ScriptEngine e = sem.getEngineByName("ECMAScript");
-            e.eval(getJsHelperText());
-            Bindings b = e.getContext().getBindings(ScriptContext.ENGINE_SCOPE);
+            Bindings b = engine.getContext().getBindings(ScriptContext.ENGINE_SCOPE);
             b.put("graph", d);
-            b.put("IO", System.out);
-            e.eval(code, b);
+            engine.eval(code, b);
         } catch (ScriptException ex) {
             Exceptions.printStackTrace(ex);
         }