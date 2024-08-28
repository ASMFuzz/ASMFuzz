@@ -331,8 +331,6 @@ class G1CardSet : public CHeapObj<mtGCCardSet> {
   // Clear the entire contents of this remembered set.
   void clear();
 
-  void print(outputStream* os);
-
   // Iterate over the container, calling a method on every card or card range contained
   // in the card container.
   // For every container, first calls