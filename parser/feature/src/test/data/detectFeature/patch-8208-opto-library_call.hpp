@@ -282,9 +282,9 @@ class LibraryCallKit : public GraphKit {
   bool inline_digestBase_implCompress(vmIntrinsics::ID id);
   bool inline_digestBase_implCompressMB(int predicate);
   bool inline_digestBase_implCompressMB(Node* digestBaseObj, ciInstanceKlass* instklass,
-                                        const char* state_type, address stubAddr, const char *stubName,
+                                        BasicType elem_type, address stubAddr, const char *stubName,
                                         Node* src_start, Node* ofs, Node* limit);
-  Node* get_state_from_digest_object(Node *digestBase_object, const char* state_type);
+  Node* get_state_from_digest_object(Node *digestBase_object, BasicType elem_type);
   Node* get_digest_length_from_digest_object(Node *digestBase_object);
   Node* inline_digestBase_implCompressMB_predicate(int predicate);
   bool inline_encodeISOArray(bool ascii);