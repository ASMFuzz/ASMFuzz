@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -46,7 +46,6 @@
 import javax.lang.model.type.TypeMirror;
 import javax.lang.model.util.ElementKindVisitor14;
 import java.util.ArrayList;
-import java.util.Collections;
 import java.util.List;
 import java.util.Set;
 import java.util.SortedSet;
@@ -106,7 +105,7 @@ static class TypeSignature {
         private final HtmlConfiguration configuration;
         private Content modifiers;
 
-        private static final Set<String> previewModifiers = Collections.emptySet();
+        private static final Set<String> previewModifiers = Set.of();
 
          TypeSignature(TypeElement typeElement, HtmlDocletWriter writer) {
              this.typeElement = typeElement;