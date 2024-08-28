@@ -30,89 +30,74 @@
 public final class StringPool {
     public static final int MIN_LIMIT = 16;
     public static final int MAX_LIMIT = 128; /* 0 MAX means disabled */
-    private static final long DO_NOT_POOL = -1;
-    private static final SimpleStringIdPool sp = new SimpleStringIdPool();
 
-    public static long addString(String s) {
-        return sp.addString(s);
-    }
+    private static final long DO_NOT_POOL = -1;
+    /* max size */
+    private static final int MAX_SIZE = 32 * 1024;
+    /* max size bytes */
+    private static final long MAX_SIZE_UTF16 = 16 * 1024 * 1024;
+    /* string id index */
+    private static final AtomicLong sidIdx = new AtomicLong(1);
+    /* looking at a biased data set 4 is a good value */
+    private static final String[] preCache = new String[] { "", "", "", "" };
+    /* the cache */
+    private static final ConcurrentHashMap<String, Long> cache = new ConcurrentHashMap<>(MAX_SIZE, 0.75f);
+    /* loop mask */
+    private static final int preCacheMask = 0x03;
+    /* index of oldest */
+    private static int preCacheOld = 0;
+    /* max size bytes */
+    private static long currentSizeUTF16;
 
     public static void reset() {
-        sp.reset();
+        cache.clear();
+        synchronized (StringPool.class) {
+            currentSizeUTF16 = 0;
+        }
     }
 
-    private static class SimpleStringIdPool {
-        /* string id index */
-        private final AtomicLong sidIdx = new AtomicLong(1);
-        /* the cache */
-        private final ConcurrentHashMap<String, Long> cache;
-        /* max size */
-        private final int MAX_SIZE = 32*1024;
-        /* max size bytes*/
-        private final long MAX_SIZE_UTF16 = 16*1024*1024;
-        /* max size bytes*/
-        private long currentSizeUTF16;
-        /* looking at a biased data set 4 is a good value */
-        private final String[] preCache = new String[]{"", "" , "" ,""};
-        /* index of oldest */
-        private int preCacheOld = 0;
-        /* loop mask */
-        private static final int preCacheMask = 0x03;
-
-        SimpleStringIdPool() {
-            this.cache = new ConcurrentHashMap<>(MAX_SIZE, 0.75f);
+    public static long addString(String s) {
+        Long lsid = cache.get(s);
+        if (lsid != null) {
+            return lsid.longValue();
         }
-
-        private void reset() {
-            this.cache.clear();
-            synchronized(SimpleStringIdPool.class) {
-                this.currentSizeUTF16 = 0;
-            }
+        if (!preCache(s)) {
+            /* we should not pool this string */
+            return DO_NOT_POOL;
         }
-
-        private long addString(String s) {
-            Long lsid = this.cache.get(s);
-            if (lsid != null) {
-                return lsid.longValue();
-            }
-            if (!preCache(s)) {
-                /* we should not pool this string */
-                return DO_NOT_POOL;
-            }
-            if (cache.size() > MAX_SIZE || currentSizeUTF16 > MAX_SIZE_UTF16) {
-                /* pool was full */
-                reset();
-            }
-            return storeString(s);
+        if (cache.size() > MAX_SIZE || currentSizeUTF16 > MAX_SIZE_UTF16) {
+            /* pool was full */
+            reset();
         }
+        return storeString(s);
+    }
 
-        private long storeString(String s) {
-            long sid = this.sidIdx.getAndIncrement();
-            /* we can race but it is ok */
-            this.cache.put(s, sid);
-            synchronized(SimpleStringIdPool.class) {
-                JVM.addStringConstant(sid, s);
-                currentSizeUTF16 += s.length();
-            }
-            return sid;
+    private static long storeString(String s) {
+        long sid = sidIdx.getAndIncrement();
+        /* we can race but it is ok */
+        cache.put(s, sid);
+        synchronized (StringPool.class) {
+            JVM.addStringConstant(sid, s);
+            currentSizeUTF16 += s.length();
         }
+        return sid;
+    }
 
-        private boolean preCache(String s) {
-            if (preCache[0].equals(s)) {
-                return true;
-            }
-            if (preCache[1].equals(s)) {
-                return true;
-            }
-            if (preCache[2].equals(s)) {
-                return true;
-            }
-            if (preCache[3].equals(s)) {
-                return true;
-            }
-            preCacheOld = (preCacheOld - 1) & preCacheMask;
-            preCache[preCacheOld] = s;
-            return false;
+    private static boolean preCache(String s) {
+        if (preCache[0].equals(s)) {
+            return true;
+        }
+        if (preCache[1].equals(s)) {
+            return true;
+        }
+        if (preCache[2].equals(s)) {
+            return true;
+        }
+        if (preCache[3].equals(s)) {
+            return true;
         }
+        preCacheOld = (preCacheOld - 1) & preCacheMask;
+        preCache[preCacheOld] = s;
+        return false;
     }
 }