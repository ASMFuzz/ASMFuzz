@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,13 +25,19 @@
 package jdk.jpackage.internal;
 
 import java.io.IOException;
+import java.lang.reflect.InvocationHandler;
+import java.lang.reflect.Method;
+import java.lang.reflect.Proxy;
 import java.nio.file.Path;
 import java.text.MessageFormat;
 import java.util.ArrayList;
 import java.util.Collection;
 import java.util.List;
 import java.util.Map;
 import java.util.Optional;
+import java.util.regex.Matcher;
+import java.util.regex.Pattern;
+import javax.xml.stream.XMLStreamWriter;
 import jdk.jpackage.internal.IOUtils.XmlConsumer;
 import jdk.jpackage.internal.OverridableResource.Source;
 import static jdk.jpackage.internal.OverridableResource.createResource;
@@ -131,7 +137,9 @@ static void createWixSource(Path file, XmlConsumer xmlConsumer)
             xml.writeNamespace("util",
                     "http://schemas.microsoft.com/wix/UtilExtension");
 
-            xmlConsumer.accept(xml);
+            xmlConsumer.accept((XMLStreamWriter) Proxy.newProxyInstance(
+                    XMLStreamWriter.class.getClassLoader(), new Class<?>[]{
+                XMLStreamWriter.class}, new WixPreprocessorEscaper(xml)));
 
             xml.writeEndElement(); // <Wix>
         });
@@ -147,6 +155,58 @@ private static class ResourceWithName {
         private final String saveAsName;
     }
 
+    private static class WixPreprocessorEscaper implements InvocationHandler {
+
+        WixPreprocessorEscaper(XMLStreamWriter target) {
+            this.target = target;
+        }
+
+        @Override
+        public Object invoke(Object proxy, Method method, Object[] args) throws
+                Throwable {
+            switch (method.getName()) {
+                case "writeAttribute" -> {
+                    Object newArgs[] = new Object[args.length];
+                    for (int i = 0; i < args.length - 1; ++i) {
+                        newArgs[i] = args[i];
+                    }
+                    newArgs[args.length - 1] = escape(
+                            (CharSequence) args[args.length - 1]);
+                    return method.invoke(target, newArgs);
+                }
+                case "writeCData" -> {
+                    target.writeCData(escape((CharSequence) args[0]));
+                    return null;
+                }
+                case "writeCharacters" -> {
+                    if (args.length == 3) {
+                        // writeCharacters(char[] text, int start, int len)
+                        target.writeCharacters(escape(String.copyValueOf(
+                                (char[]) args[0], (int) args[1], (int) args[2])));
+                    } else {
+                        target.writeCharacters(escape((CharSequence) args[0]));
+                    }
+                    return null;
+                }
+            }
+            return method.invoke(target, args);
+        }
+
+        private String escape(CharSequence str) {
+            Matcher m = dollarPattern.matcher(str);
+            StringBuilder sb = new StringBuilder();
+            while (m.find()) {
+                m.appendReplacement(sb, "\\$\\$");
+            }
+            m.appendTail(sb);
+            return sb.toString();
+        }
+
+        // Match '$', but don't match $(var.foo)
+        private final Pattern dollarPattern = Pattern.compile("\\$(?!\\([^)]*\\))");
+        private final XMLStreamWriter target;
+    }
+
     private DottedVersion wixVersion;
     private WixVariables wixVariables;
     private List<ResourceWithName> additionalResources;