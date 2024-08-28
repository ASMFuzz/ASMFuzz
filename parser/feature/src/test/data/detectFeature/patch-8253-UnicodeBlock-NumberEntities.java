@@ -23,9 +23,10 @@
 
 /**
  * @test
- * @bug 8080535 8191410 8215194 8221431 8239383 8268081 8283465
+ * @bug 8080535 8191410 8215194 8221431 8239383 8268081 8283465 8284856
  * @summary Check if the NUM_ENTITIES field reflects the correct number
- *      of Character.UnicodeBlock constants.
+ *      of Character.UnicodeBlock constants. Also checks the size of
+ *      Character.UnicodeScript's "aliases" map.
  * @modules java.base/java.lang:open
  * @run testng NumberEntities
  */
@@ -38,7 +39,7 @@
 
 @Test
 public class NumberEntities {
-    public void test_NumberEntities() throws Throwable {
+    public void test_UnicodeBlock_NumberEntities() throws Throwable {
         // The number of entries in Character.UnicodeBlock.map.
         // See src/java.base/share/classes/java/lang/Character.java
         Field n = Character.UnicodeBlock.class.getDeclaredField("NUM_ENTITIES");
@@ -47,4 +48,11 @@ public void test_NumberEntities() throws Throwable {
         m.setAccessible(true);
         assertEquals(((Map)m.get(null)).size(), n.getInt(null));
     }
+    public void test_UnicodeScript_aliases() throws Throwable {
+        // The number of entries in Character.UnicodeScript.aliases.
+        // See src/java.base/share/classes/java/lang/Character.java
+        Field aliases = Character.UnicodeScript.class.getDeclaredField("aliases");
+        aliases.setAccessible(true);
+        assertEquals(((Map)aliases.get(null)).size(), Character.UnicodeScript.UNKNOWN.ordinal() + 1);
+    }
 }