@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -265,7 +265,6 @@ class ciInstanceKlass : public ciKlass {
   BasicType box_klass_type() const;
   bool is_box_klass() const;
   bool is_boxed_value_offset(int offset) const;
-  bool is_box_cache_valid() const;
 
   // Is this klass in the given package?
   bool is_in_package(const char* packagename) {