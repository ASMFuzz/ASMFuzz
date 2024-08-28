@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -40,6 +40,9 @@ class GroupEntry extends BaseEntry {
     static final int ATTRIBUTE_DEFFER = 1;
     static final int ATTRIBUTE_RESOLUTION = 2;
 
+    //Indicates a continuous session, should not reset state
+    boolean shouldKeepState = false;
+
     //Unmodifiable features when the Catalog is created
     CatalogFeatures features;
 
@@ -164,6 +167,16 @@ public void reset() {
         longestSuffixMatch = 0;
         systemEntrySearched = false;
     }
+
+    /**
+     * Resets the state of the Catalog instance, allowing it to be reused.
+     */
+    private void resetOnStart() {
+        if (this instanceof Catalog  && !shouldKeepState) {
+            reset();
+        }
+    }
+
     /**
      * Constructs a group entry.
      * @param catalog the catalog this GroupEntry belongs to
@@ -228,6 +241,7 @@ public boolean isPreferPublic() {
      * @return a URI string if a mapping is found, or null otherwise.
      */
     public String matchSystem(String systemId) {
+        resetOnStart();
         systemEntrySearched = true;
         String match = null;
         for (BaseEntry entry : entries) {
@@ -296,6 +310,7 @@ public String matchSystem(String systemId) {
      * @return a URI string if a mapping is found, or null otherwise.
      */
     public String matchPublic(String publicId) {
+        resetOnStart();
         /*
            When both public and system identifiers are specified, and prefer is
         not public (that is, system), only system entry will be used.
@@ -326,6 +341,51 @@ not public (that is, system), only system entry will be used.
         return matchDelegate(CatalogEntryType.DELEGATEPUBLIC, publicId);
     }
 
+    /**
+     * Attempt to find a matching entry in the catalog by publicId or systemId.
+     *
+     * <p>
+     * The resolution follows the following rules determined by the prefer
+     * setting:
+     *
+     * prefer "system": attempts to resolve with a system entry; attempts to
+     * resolve with a public entry when only publicId is specified.
+     *
+     * prefer "public": attempts to resolve with a system entry; attempts to
+     * resolve with a public entry if no matching system entry is found.
+     *
+     * If no match is found, continue searching uri entries.
+     *
+     * @param publicId The public identifier of the external entity being
+     * referenced.
+     *
+     * @param systemId The system identifier of the external entity being
+     * referenced.
+     *
+     * @return the resolved systemId if a match is found, null otherwise
+     */
+    String resolve(String publicId, String systemId) {
+        String resolvedSystemId = null;
+        shouldKeepState = true;
+        if (systemId != null) {
+            /*
+             If a system identifier is specified, it is used no matter how
+             prefer is set.
+             */
+            resolvedSystemId = matchSystem(systemId);
+        }
+
+        if (resolvedSystemId == null && publicId != null) {
+            resolvedSystemId = matchPublic(publicId);
+        }
+
+        if (resolvedSystemId == null && systemId != null) {
+            resolvedSystemId = matchURI(systemId);
+        }
+        shouldKeepState = false;
+        return resolvedSystemId;
+    }
+
     /**
      * Attempt to find a matching entry in the catalog by the uri element.
      *
@@ -340,6 +400,7 @@ not public (that is, system), only system entry will be used.
      * @return a URI string if a mapping is found, or null otherwise.
      */
     public String matchURI(String uri) {
+        resetOnStart();
         String match = null;
         for (BaseEntry entry : entries) {
             switch (entry.type) {
@@ -399,6 +460,7 @@ public String matchURI(String uri) {
      * @return the URI string if a mapping is found, or null otherwise.
      */
     private String matchDelegate(CatalogEntryType type, String id) {
+        resetOnStart();
         String match = null;
         int longestMatch = 0;
         URI catalogId = null;