@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -288,8 +288,8 @@ find_positions(int fd, Byte *eb, jlong* base_offset, jlong* censtart)
     for (cp = &buffer[bytes - ENDHDR]; cp >= &buffer[0]; cp--)
         if (ENDSIG_AT(cp) && (cp + ENDHDR + ENDCOM(cp) == endpos)) {
             (void) memcpy(eb, cp, ENDHDR);
-            free(buffer);
             pos = flen - (endpos - cp);
+            free(buffer);
             return find_positions64(fd, eb, pos, base_offset, censtart);
         }
     free(buffer);