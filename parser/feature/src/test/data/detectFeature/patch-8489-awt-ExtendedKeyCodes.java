@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2009, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2009, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -24,41 +24,39 @@
  */
 package sun.awt;
 
-import java.util.Collections;
 import java.util.HashMap;
 import java.util.HashSet;
 import java.awt.event.KeyEvent;
 
 public class ExtendedKeyCodes {
     /**
      * ATTN: These are the readonly hashes with load factor == 1;
-     * adding a value, please set the inital capacity to exact number of items
+     * adding a value, please set the initial capacity to exact number of items
      * or higher.
      */
      // Keycodes declared in KeyEvent.java with corresponding Unicode values.
-     private static final HashMap<Integer, Integer>  regularKeyCodesMap =
-                                          new HashMap<Integer,Integer>(98, 1.0f);
+     private static final HashMap<Integer, Integer> regularKeyCodesMap =
+                                          new HashMap<>(98, 1.0f);
 
      // Keycodes derived from Unicode values. Here should be collected codes
      // for characters appearing on the primary layer of at least one
      // known keyboard layout. For instance, sterling sign is on the primary layer
      // of the Mac Italian layout.
      private static final HashSet<Integer> extendedKeyCodesSet =
-                                                  new HashSet<Integer>(496, 1.0f);
-     public static final int getExtendedKeyCodeForChar( int c ) {
+                                                  new HashSet<>(496, 1.0f);
+     public static int getExtendedKeyCodeForChar( int c ) {
          int uc = Character.toUpperCase( c );
-         int lc = Character.toLowerCase( c );
-         if (regularKeyCodesMap.containsKey( c )) {
-             if(regularKeyCodesMap.containsKey(uc)) {
-                 return regularKeyCodesMap.get( uc );
-             }
-             return regularKeyCodesMap.get( c );
+         Integer regularKeyCode = regularKeyCodesMap.get(c);
+         if (regularKeyCode != null) {
+             return regularKeyCodesMap.getOrDefault(uc, regularKeyCode);
          }
          uc += 0x01000000;
-         lc += 0x01000000;
          if (extendedKeyCodesSet.contains( uc )) {
              return uc;
-         }else if (extendedKeyCodesSet.contains( lc )) {
+         }
+         int lc = Character.toLowerCase( c );
+         lc += 0x01000000;
+         if (extendedKeyCodesSet.contains( lc )) {
              return lc;
          }
          return KeyEvent.VK_UNDEFINED;