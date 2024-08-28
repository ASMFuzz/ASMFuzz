@@ -324,7 +324,7 @@ class G1CardSet : public CHeapObj<mtGCCardSet> {
 
   // Returns size of the actual remembered set containers in bytes.
   size_t mem_size() const;
-  size_t wasted_mem_size() const;
+  size_t unused_mem_size() const;
   // Returns the size of static data in bytes.
   static size_t static_mem_size();
 