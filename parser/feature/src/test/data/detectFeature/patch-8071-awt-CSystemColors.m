@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2011, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2011, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -96,7 +96,11 @@ + (void)reloadColors {
     sColors[java_awt_SystemColor_TEXT_INACTIVE_TEXT] =        [NSColor disabledControlTextColor];
     sColors[java_awt_SystemColor_CONTROL] =                    [NSColor controlColor];
     sColors[java_awt_SystemColor_CONTROL_TEXT] =            [NSColor controlTextColor];
-    sColors[java_awt_SystemColor_CONTROL_HIGHLIGHT] =        [NSColor alternateSelectedControlColor];
+    if (@available(macOS 10.14, *)) {
+        sColors[java_awt_SystemColor_CONTROL_HIGHLIGHT] =        [NSColor selectedContentBackgroundColor];
+    } else {
+        sColors[java_awt_SystemColor_CONTROL_HIGHLIGHT] =        [NSColor alternateSelectedControlColor];
+    }
     sColors[java_awt_SystemColor_CONTROL_LT_HIGHLIGHT] =    [NSColor alternateSelectedControlTextColor];
     sColors[java_awt_SystemColor_CONTROL_SHADOW] =            [NSColor controlShadowColor];
     sColors[java_awt_SystemColor_CONTROL_DK_SHADOW] =        [NSColor controlDarkShadowColor];