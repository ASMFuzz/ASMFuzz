@@ -137,6 +137,7 @@ public class IRNode {
 
     public static final String SCOPE_OBJECT = "(.*# ScObj.*" + END;
     public static final String MEMBAR = START + "MemBar" + MID + END;
+    public static final String MEMBAR_STORESTORE = START + "MemBarStoreStore" + MID + END;
     public static final String SAFEPOINT = START + "SafePoint" + MID + END;
 
     public static final String ABS_I = START + "AbsI" + MID + END;
@@ -188,6 +189,9 @@ public class IRNode {
     public static final String VECTOR_UCAST_I2X = START + "VectorUCastI2X" + MID + END;
     public static final String VECTOR_REINTERPRET = START + "VectorReinterpret" + MID + END;
 
+    public static final String FAST_LOCK   = START + "FastLock" + MID + END;
+    public static final String FAST_UNLOCK = START + "FastUnlock" + MID + END;
+
     /**
      * Called by {@link IRMatcher} to merge special composite nodes together with additional user-defined input.
      */