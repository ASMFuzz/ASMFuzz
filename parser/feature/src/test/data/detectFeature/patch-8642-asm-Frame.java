@@ -611,11 +611,11 @@ private int pop() {
       */
     private void pop(final int elements) {
         if (outputStackTop >= elements) {
-            outputStackTop -= elements;
+            outputStackTop -= (short) elements;
         } else {
             // If the number of elements to be popped is greater than the number of elements in the output
             // stack, clear it, and pop the remaining elements from the input stack.
-            outputStackStart -= elements - outputStackTop;
+            outputStackStart -= (short) (elements - outputStackTop);
             outputStackTop = 0;
         }
     }
@@ -1503,4 +1503,3 @@ static void putAbstractType(
         }
     }
 }
-