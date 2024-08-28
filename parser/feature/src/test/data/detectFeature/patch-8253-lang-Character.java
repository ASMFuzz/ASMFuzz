@@ -5285,7 +5285,7 @@ public static enum UnicodeScript {
         /**
          * Unicode script "Unknown".
          */
-        UNKNOWN;
+        UNKNOWN; // must be the last enum constant for calculating the size of "aliases" hash map.
 
         private static final int[] scriptStarts = {
             0x0000,   // 0000..0040; COMMON
@@ -8571,7 +8571,7 @@ public static enum UnicodeScript {
 
         private static final HashMap<String, Character.UnicodeScript> aliases;
         static {
-            aliases = HashMap.newHashMap(162);
+            aliases = HashMap.newHashMap(UNKNOWN.ordinal() + 1);
             aliases.put("ADLM", ADLAM);
             aliases.put("AGHB", CAUCASIAN_ALBANIAN);
             aliases.put("AHOM", AHOM);