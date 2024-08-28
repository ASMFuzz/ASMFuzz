@@ -6601,31 +6601,31 @@ bool LibraryCallKit::inline_digestBase_implCompress(vmIntrinsics::ID id) {
   switch(id) {
   case vmIntrinsics::_md5_implCompress:
     assert(UseMD5Intrinsics, "need MD5 instruction support");
-    state = get_state_from_digest_object(digestBase_obj, "[I");
+    state = get_state_from_digest_object(digestBase_obj, T_INT);
     stubAddr = StubRoutines::md5_implCompress();
     stubName = "md5_implCompress";
     break;
   case vmIntrinsics::_sha_implCompress:
     assert(UseSHA1Intrinsics, "need SHA1 instruction support");
-    state = get_state_from_digest_object(digestBase_obj, "[I");
+    state = get_state_from_digest_object(digestBase_obj, T_INT);
     stubAddr = StubRoutines::sha1_implCompress();
     stubName = "sha1_implCompress";
     break;
   case vmIntrinsics::_sha2_implCompress:
     assert(UseSHA256Intrinsics, "need SHA256 instruction support");
-    state = get_state_from_digest_object(digestBase_obj, "[I");
+    state = get_state_from_digest_object(digestBase_obj, T_INT);
     stubAddr = StubRoutines::sha256_implCompress();
     stubName = "sha256_implCompress";
     break;
   case vmIntrinsics::_sha5_implCompress:
     assert(UseSHA512Intrinsics, "need SHA512 instruction support");
-    state = get_state_from_digest_object(digestBase_obj, "[J");
+    state = get_state_from_digest_object(digestBase_obj, T_LONG);
     stubAddr = StubRoutines::sha512_implCompress();
     stubName = "sha512_implCompress";
     break;
   case vmIntrinsics::_sha3_implCompress:
     assert(UseSHA3Intrinsics, "need SHA3 instruction support");
-    state = get_state_from_digest_object(digestBase_obj, "[B");
+    state = get_state_from_digest_object(digestBase_obj, T_BYTE);
     stubAddr = StubRoutines::sha3_implCompress();
     stubName = "sha3_implCompress";
     digest_length = get_digest_length_from_digest_object(digestBase_obj);
@@ -6689,7 +6689,7 @@ bool LibraryCallKit::inline_digestBase_implCompressMB(int predicate) {
   const char* klass_digestBase_name = NULL;
   const char* stub_name = NULL;
   address     stub_addr = NULL;
-  const char* state_type = "[I";
+  BasicType elem_type = T_INT;
 
   switch (predicate) {
   case 0:
@@ -6718,15 +6718,15 @@ bool LibraryCallKit::inline_digestBase_implCompressMB(int predicate) {
       klass_digestBase_name = "sun/security/provider/SHA5";
       stub_name = "sha512_implCompressMB";
       stub_addr = StubRoutines::sha512_implCompressMB();
-      state_type = "[J";
+      elem_type = T_LONG;
     }
     break;
   case 4:
     if (vmIntrinsics::is_intrinsic_available(vmIntrinsics::_sha3_implCompress)) {
       klass_digestBase_name = "sun/security/provider/SHA3";
       stub_name = "sha3_implCompressMB";
       stub_addr = StubRoutines::sha3_implCompressMB();
-      state_type = "[B";
+      elem_type = T_BYTE;
     }
     break;
   default:
@@ -6744,21 +6744,21 @@ bool LibraryCallKit::inline_digestBase_implCompressMB(int predicate) {
     ciKlass* klass_digestBase = tinst->klass()->as_instance_klass()->find_klass(ciSymbol::make(klass_digestBase_name));
     assert(klass_digestBase->is_loaded(), "predicate checks that this class is loaded");
     ciInstanceKlass* instklass_digestBase = klass_digestBase->as_instance_klass();
-    return inline_digestBase_implCompressMB(digestBase_obj, instklass_digestBase, state_type, stub_addr, stub_name, src_start, ofs, limit);
+    return inline_digestBase_implCompressMB(digestBase_obj, instklass_digestBase, elem_type, stub_addr, stub_name, src_start, ofs, limit);
   }
   return false;
 }
 
 //------------------------------inline_digestBase_implCompressMB-----------------------
 bool LibraryCallKit::inline_digestBase_implCompressMB(Node* digestBase_obj, ciInstanceKlass* instklass_digestBase,
-                                                      const char* state_type, address stubAddr, const char *stubName,
+                                                      BasicType elem_type, address stubAddr, const char *stubName,
                                                       Node* src_start, Node* ofs, Node* limit) {
   const TypeKlassPtr* aklass = TypeKlassPtr::make(instklass_digestBase);
   const TypeOopPtr* xtype = aklass->as_instance_type()->cast_to_ptr_type(TypePtr::NotNull);
   Node* digest_obj = new CheckCastPPNode(control(), digestBase_obj, xtype);
   digest_obj = _gvn.transform(digest_obj);
 
-  Node* state = get_state_from_digest_object(digest_obj, state_type);
+  Node* state = get_state_from_digest_object(digest_obj, elem_type);
   if (state == NULL) return false;
 
   Node* digest_length = NULL;
@@ -6918,13 +6918,20 @@ Node* LibraryCallKit::inline_galoisCounterMode_AESCrypt_predicate() {
 }
 
 //------------------------------get_state_from_digest_object-----------------------
-Node * LibraryCallKit::get_state_from_digest_object(Node *digest_object, const char *state_type) {
+Node * LibraryCallKit::get_state_from_digest_object(Node *digest_object, BasicType elem_type) {
+  const char* state_type;
+  switch (elem_type) {
+    case T_BYTE: state_type = "[B"; break;
+    case T_INT:  state_type = "[I"; break;
+    case T_LONG: state_type = "[J"; break;
+    default: ShouldNotReachHere();
+  }
   Node* digest_state = load_field_from_object(digest_object, "state", state_type);
   assert (digest_state != NULL, "wrong version of sun.security.provider.MD5/SHA/SHA2/SHA5/SHA3");
   if (digest_state == NULL) return (Node *) NULL;
 
   // now have the array, need to get the start address of the state array
-  Node* state = array_element_address(digest_state, intcon(0), T_INT);
+  Node* state = array_element_address(digest_state, intcon(0), elem_type);
   return state;
 }
 