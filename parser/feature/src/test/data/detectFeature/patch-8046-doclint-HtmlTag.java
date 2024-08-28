@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2010, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2010, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,7 +25,6 @@
 
 package jdk.javadoc.internal.doclint;
 
-import java.util.Collections;
 import java.util.EnumMap;
 import java.util.EnumSet;
 import java.util.HashMap;
@@ -554,11 +553,11 @@ private static class AttrMap extends EnumMap<Attr,AttrKind>  {
     private final Map<Attr,AttrKind> attrs;
 
     HtmlTag(BlockType blockType, EndKind endKind, AttrMap... attrMaps) {
-        this(ElemKind.OK, blockType, endKind, Collections.emptySet(), attrMaps);
+        this(ElemKind.OK, blockType, endKind, Set.of(), attrMaps);
     }
 
     HtmlTag(ElemKind elemKind, BlockType blockType, EndKind endKind, AttrMap... attrMaps) {
-        this(elemKind, blockType, endKind, Collections.emptySet(), attrMaps);
+        this(elemKind, blockType, endKind, Set.of(), attrMaps);
     }
 
     HtmlTag(BlockType blockType, EndKind endKind, Set<Flag> flags, AttrMap... attrMaps) {