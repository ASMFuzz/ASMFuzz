@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -117,8 +117,9 @@ private void createLauncherForEntryPoint(Map<String, ? super Object> params,
                 mainParams);
         Path iconTarget = null;
         if (iconResource != null) {
-            iconTarget = appLayout.destktopIntegrationDirectory().resolve(
-                    APP_NAME.fetchFrom(params) + ".ico");
+            Path iconDir = StandardBundlerParam.TEMP_ROOT.fetchFrom(params).resolve(
+                    "icons");
+            iconTarget = iconDir.resolve(APP_NAME.fetchFrom(params) + ".ico");
             if (null == iconResource.saveToFile(iconTarget)) {
                 iconTarget = null;
             }