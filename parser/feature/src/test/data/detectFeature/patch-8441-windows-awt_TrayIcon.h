@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2008, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -86,6 +86,8 @@ class AwtTrayIcon: public AwtObject {
 
     void DisplayMessage(LPCTSTR caption, LPCTSTR text, LPCTSTR msgType);
 
+    void UpdateImage();
+
     // Adds to the head of the list
     INLINE void AddTrayIconItem(UINT id) {
         TrayIconListItem* item = new TrayIconListItem(id, this);
@@ -121,6 +123,7 @@ class AwtTrayIcon: public AwtObject {
      */
     static jfieldID idID;
     static jfieldID actionCommandID;
+    static jmethodID updateImageID;
 
     // ************************
 
@@ -151,6 +154,8 @@ class AwtTrayIcon: public AwtObject {
         TrayIconListItem* m_next;
     };
 
+    static bool m_bDPIChanged;
+
 public:
     static TrayIconListItem* sm_trayIconList;
 };