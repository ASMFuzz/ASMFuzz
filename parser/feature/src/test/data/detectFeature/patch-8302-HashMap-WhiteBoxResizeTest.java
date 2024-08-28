@@ -29,13 +29,16 @@
 import java.lang.invoke.MethodHandles;
 import java.lang.invoke.MethodType;
 import java.lang.invoke.VarHandle;
+import java.lang.reflect.Field;
 import java.util.AbstractMap;
 import java.util.AbstractSet;
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.HashMap;
+import java.util.HashSet;
 import java.util.Iterator;
 import java.util.LinkedHashMap;
+import java.util.LinkedHashSet;
 import java.util.List;
 import java.util.Map;
 import java.util.Set;
@@ -48,7 +51,7 @@
 
 /*
  * @test
- * @bug 8186958 8210280 8281631 8285386
+ * @bug 8186958 8210280 8281631 8285386 8284780
  * @modules java.base/java.util:open
  * @summary White box tests for HashMap-related internals around table sizing
  * @run testng/othervm -Xmx2g WhiteBoxResizeTest
@@ -58,6 +61,7 @@ public class WhiteBoxResizeTest {
     final MethodHandle TABLE_SIZE_FOR;
     final VarHandle HM_TABLE;
     final VarHandle WHM_TABLE;
+    final VarHandle HS_MAP;
 
     public WhiteBoxResizeTest() throws ReflectiveOperationException {
         MethodHandles.Lookup hmlookup = MethodHandles.privateLookupIn(HashMap.class, MethodHandles.lookup());
@@ -67,6 +71,9 @@ public WhiteBoxResizeTest() throws ReflectiveOperationException {
 
         MethodHandles.Lookup whmlookup = MethodHandles.privateLookupIn(WeakHashMap.class, MethodHandles.lookup());
         WHM_TABLE = whmlookup.unreflectVarHandle(WeakHashMap.class.getDeclaredField("table"));
+
+        MethodHandles.Lookup hslookup = MethodHandles.privateLookupIn(HashSet.class, MethodHandles.lookup());
+        HS_MAP = hslookup.unreflectVarHandle(HashSet.class.getDeclaredField("map"));
     }
 
     /*
@@ -328,15 +335,17 @@ public void populatedCapacity(String label, // unused, included for diagnostics
     Object[] rsc(String label,
                  int size,
                  int expectedCapacity,
-                 Supplier<Map<String, String>> supplier) {
+                 Supplier<Capacitiable> supplier) {
         return new Object[]{label, size, expectedCapacity, supplier};
     }
 
     List<Object[]> genRequestedSizeCases(int size, int cap) {
         return Arrays.asList(
-                rsc("rshm", size, cap, () -> HashMap.newHashMap(size)),
-                rsc("rslm", size, cap, () -> LinkedHashMap.newLinkedHashMap(size)),
-                rsc("rswm", size, cap, () -> WeakHashMap.newWeakHashMap(size))
+                rsc("rshm", size, cap, () -> new MapCapacitiable(HashMap.newHashMap(size))),
+                rsc("rslm", size, cap, () -> new MapCapacitiable(LinkedHashMap.newLinkedHashMap(size))),
+                rsc("rswm", size, cap, () -> new MapCapacitiable(WeakHashMap.newWeakHashMap(size))),
+                rsc("rshs", size, cap, () -> new SetCapacitiable(HashSet.newHashSet(size))),
+                rsc("rsls", size, cap, () -> new SetCapacitiable(LinkedHashSet.newLinkedHashSet(size)))
         );
     }
 
@@ -364,9 +373,57 @@ public Iterator<Object[]> requestedSizeCases() {
     public void requestedSize(String label,  // unused, included for diagnostics
                               int size,      // unused, included for diagnostics
                               int expectedCapacity,
-                              Supplier<Map<String, String>> s) {
-        Map<String, String> map = s.get();
-        map.put("", "");
-        assertEquals(capacity(map), expectedCapacity);
+                              Supplier<Capacitiable> s) {
+        Capacitiable capacitiable = s.get();
+        capacitiable.init();
+        assertEquals(capacitiable.capacity(), expectedCapacity);
+    }
+
+    interface Capacitiable {
+
+        void init();
+
+        int capacity();
+
+    }
+
+    class MapCapacitiable implements Capacitiable {
+
+        private final Map<String, String> content;
+
+        public MapCapacitiable(Map<String, String> content) {
+            this.content = content;
+        }
+
+        @Override
+        public void init() {
+            content.put("", "");
+        }
+
+        @Override
+        public int capacity() {
+            return table(content).length;
+        }
+    }
+
+    class SetCapacitiable implements Capacitiable {
+
+        private final Set<String> content;
+
+        public SetCapacitiable(Set<String> content) {
+            this.content = content;
+        }
+
+        @Override
+        public void init() {
+            content.add("");
+        }
+
+        @Override
+        public int capacity() {
+            HashMap<?, ?> hashMap = (HashMap<?, ?>) HS_MAP.get(content);
+            return table(hashMap).length;
+        }
     }
+
 }