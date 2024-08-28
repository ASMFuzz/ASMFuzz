@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -53,8 +53,6 @@ class ciSymbol : public ciBaseObject {
 
   DEBUG_ONLY(bool sid_ok();)
 
-  Symbol* get_symbol() const { return _symbol; }
-
   const char* type_string() { return "ciSymbol"; }
 
   void print_impl(outputStream* st);
@@ -106,6 +104,9 @@ class ciSymbol : public ciBaseObject {
   bool equals(ciSymbol* obj) { return this->_symbol == obj->get_symbol(); }
 
   bool is_signature_polymorphic_name() const;
+
+  Symbol* get_symbol() const { return _symbol; }
+
 };
 
 #endif // SHARE_CI_CISYMBOL_HPP