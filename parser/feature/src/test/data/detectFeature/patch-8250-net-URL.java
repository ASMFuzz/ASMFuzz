@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1995, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1995, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -723,7 +723,7 @@ static URL fromURI(URI uri) throws MalformedURLException {
         String protocol = uri.getScheme();
 
         // In general we need to go via Handler.parseURL, but for the jrt
-        // protocol we enforce that the Handler is not overrideable and can
+        // protocol we enforce that the Handler is not overridable and can
         // optimize URI to URL conversion.
         //
         // Case-sensitive comparison for performance; malformed protocols will