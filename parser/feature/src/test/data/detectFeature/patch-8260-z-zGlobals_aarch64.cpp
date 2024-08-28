@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -154,12 +154,12 @@ static size_t probe_valid_max_address_bit() {
   for (size_t i = DEFAULT_MAX_ADDRESS_BIT; i > MINIMUM_MAX_ADDRESS_BIT; --i) {
     const uintptr_t base_addr = ((uintptr_t) 1U) << i;
     if (msync((void*)base_addr, page_size, MS_ASYNC) == 0) {
-      // msync suceeded, the address is valid, and maybe even already mapped.
+      // msync succeeded, the address is valid, and maybe even already mapped.
       max_address_bit = i;
       break;
     }
     if (errno != ENOMEM) {
-      // Some error occured. This should never happen, but msync
+      // Some error occurred. This should never happen, but msync
       // has some undefined behavior, hence ignore this bit.
 #ifdef ASSERT
       fatal("Received '%s' while probing the address space for the highest valid bit", os::errno_name(errno));