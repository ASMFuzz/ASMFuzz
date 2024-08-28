@@ -65,4 +65,16 @@ public enum E {
 
     /** invalid enum constant: {@value Thread.State#NEW} */
     public int badEnum;
+
+    /** valid: {@value %04x} */
+    public static final int maxShort = 65535;
+
+    /** valid: {@value "%5.2f"} */
+    public static final double pi = 3.14159265358979323846;
+
+    /** invalid format: {@value %%04x} */
+    public static final int f3 = 0;
+
+    /** invalid format: {@value "04x"} */
+    public static final int f4 = 0;
 }