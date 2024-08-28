@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2007, 2013, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2007, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -48,6 +48,7 @@ public interface WatchEvent<T> {
 
     /**
      * An event kind, for the purposes of identification.
+     * @param <T> The type of the context object associated with the event
      *
      * @since 1.7
      * @see StandardWatchEventKinds