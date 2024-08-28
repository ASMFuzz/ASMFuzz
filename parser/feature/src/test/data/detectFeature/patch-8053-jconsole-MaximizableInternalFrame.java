@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2006, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2006, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -239,15 +239,7 @@ public void layoutContainer(Container target) {
                     UIManager.put(key,
                                   new MDIButtonIcon(UIManager.getIcon(key)));
                 }
-            } catch (ClassNotFoundException ex) {
-                if (JConsole.debug) {
-                    ex.printStackTrace();
-                }
-            } catch (NoSuchFieldException ex) {
-                if (JConsole.debug) {
-                    ex.printStackTrace();
-                }
-            } catch (IllegalAccessException ex) {
+            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException ex) {
                 if (JConsole.debug) {
                     ex.printStackTrace();
                 }