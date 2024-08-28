@@ -62,7 +62,7 @@
  * @author <a href="mailto:pholser@alumni.rice.edu">Paul Holser</a>
  */
 public final class Classes {
-    private static final Map<Class<?>, Class<?>> WRAPPERS = new HashMap<>( 13 );
+    private static final Map<Class<?>, Class<?>> WRAPPERS = HashMap.newHashMap(9);
 
     static {
         WRAPPERS.put( boolean.class, Boolean.class );