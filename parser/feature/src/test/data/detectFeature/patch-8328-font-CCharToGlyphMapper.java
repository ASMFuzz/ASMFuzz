@@ -219,7 +219,7 @@ public void put(final int index, final int value) {
             }
         }
 
-        public synchronized void get(int count, char[] indicies, int[] values)
+        public synchronized void get(int count, char[] indices, int[] values)
         {
             // "missed" is the count of 'char' that are not mapped.
             // Surrogates count for 2.
@@ -230,11 +230,11 @@ public synchronized void get(int count, char[] indicies, int[] values)
             int [] unmappedCharIndices = null;
 
             for (int i = 0; i < count; i++){
-                int code = indicies[i];
+                int code = indices[i];
                 if (code >= HI_SURROGATE_START &&
                     code <= HI_SURROGATE_END && i < count - 1)
                 {
-                    char low = indicies[i + 1];
+                    char low = indices[i + 1];
                     if (low >= LO_SURROGATE_START && low <= LO_SURROGATE_END) {
                         code = (code - HI_SURROGATE_START) * 0x400 +
                             low - LO_SURROGATE_START + 0x10000;
@@ -254,13 +254,13 @@ public synchronized void get(int count, char[] indicies, int[] values)
                     if (unmappedChars == null) {
                         // This is likely to be longer than we need,
                         // but is the simplest and cheapest option.
-                        unmappedChars = new char[indicies.length];
-                        unmappedCharIndices = new int[indicies.length];
+                        unmappedChars = new char[indices.length];
+                        unmappedCharIndices = new int[indices.length];
                     }
-                    unmappedChars[missed] = indicies[i];
+                    unmappedChars[missed] = indices[i];
                     unmappedCharIndices[missed] = i;
                     if (code >= 0x10000) { // was a surrogate pair
-                        unmappedChars[++missed] = indicies[++i];
+                        unmappedChars[++missed] = indices[++i];
                     }
                     missed++;
                 }