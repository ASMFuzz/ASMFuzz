@@ -38,7 +38,7 @@
 
 /*
  * @test
- * @bug 8285295
+ * @bug 8285295 8178355
  * @summary Basic tests for IdentityHashMap
  * @run testng Basic
  */
@@ -49,8 +49,6 @@
 // the identities of Map.Entry instances obtained from the entrySet; however, the keys and
 // values they contain are guaranteed to have the right identity.
 
-// TODO remove(k, v)
-// TODO replace(k, v1, v2)
 // TODO add tests using null keys and values
 // TODO deeper testing of view collections including iterators, equals, contains, etc.
 // TODO Map.Entry::setValue
@@ -484,6 +482,97 @@ public void testRemoveKey() {
                                      entry(k2, v2));
     }
 
+    // remove(Object, Object) absent key, absent value
+    @Test
+    public void testRemoveAA() {
+        Box k1c = new Box(k1a);
+        Box v1c = new Box(v1a);
+        assertFalse(map.remove(k1c, v1c));
+        checkEntries(map.entrySet(),
+                entry(k1a, v1a),
+                entry(k1b, v1b),
+                entry(k2, v2));
+    }
+
+    // remove(Object, Object) absent key, present value
+    @Test
+    public void testRemoveAV() {
+        Box k1c = new Box(k1a);
+        assertFalse(map.remove(k1c, v1a));
+        checkEntries(map.entrySet(),
+                     entry(k1a, v1a),
+                     entry(k1b, v1b),
+                     entry(k2, v2));
+    }
+
+    // remove(Object, Object) present key, absent value
+    @Test
+    public void testRemoveKA() {
+        Box v1c = new Box(v1a);
+        assertFalse(map.remove(k1a, v1c));
+        checkEntries(map.entrySet(),
+                entry(k1a, v1a),
+                entry(k1b, v1b),
+                entry(k2, v2));
+    }
+
+    // remove(Object, Object) present key, present value
+    @Test
+    public void testRemoveKV() {
+        assertTrue(map.remove(k1a, v1a));
+        checkEntries(map.entrySet(),
+                entry(k1b, v1b),
+                entry(k2, v2));
+    }
+
+    // replace(K, V, V) absent key, absent oldValue
+    @Test
+    public void testReplaceAA() {
+        Box k1c = new Box(k1a);
+        Box v1c = new Box(v1a);
+        Box newVal = new Box(v2);
+        assertFalse(map.replace(k1c, v1c, newVal));
+        checkEntries(map.entrySet(),
+                entry(k1a, v1a),
+                entry(k1b, v1b),
+                entry(k2, v2));
+    }
+
+    // replace(K, V, V) absent key, present oldValue
+    @Test
+    public void testReplaceAV() {
+        Box k1c = new Box(k1a);
+        Box newVal = new Box(v2);
+        assertFalse(map.replace(k1c, v1a, newVal));
+        checkEntries(map.entrySet(),
+                entry(k1a, v1a),
+                entry(k1b, v1b),
+                entry(k2, v2));
+    }
+
+    // replace(K, V, V) present key, absent oldValue
+    @Test
+    public void testReplaceKA() {
+        Box v1c = new Box(v1a);
+        Box newVal = new Box(v2);
+        assertFalse(map.replace(k1a, v1c, newVal));
+        checkEntries(map.entrySet(),
+                entry(k1a, v1a),
+                entry(k1b, v1b),
+                entry(k2, v2));
+    }
+
+    // replace(K, V, V) present key, present oldValue
+    @Test
+    public void testReplaceKV() {
+        Box newVal = new Box(v2);
+        assertTrue(map.replace(k1a, v1a, newVal));
+        checkEntries(map.entrySet(),
+                entry(k1a, newVal),
+                entry(k1b, v1b),
+                entry(k2, v2));
+    }
+
     // AN: key absent, remappingFunction returns null
     @Test
     public void testComputeAN() {