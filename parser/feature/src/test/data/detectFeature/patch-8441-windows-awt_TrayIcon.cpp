@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -70,10 +70,12 @@ typedef struct tagBitmapheader  {
 
 jfieldID AwtTrayIcon::idID;
 jfieldID AwtTrayIcon::actionCommandID;
+jmethodID AwtTrayIcon::updateImageID;
 
 HWND AwtTrayIcon::sm_msgWindow = NULL;
 AwtTrayIcon::TrayIconListItem* AwtTrayIcon::sm_trayIconList = NULL;
 int AwtTrayIcon::sm_instCount = 0;
+bool AwtTrayIcon::m_bDPIChanged = false;
 
 /************************************************************************
  * AwtTrayIcon methods
@@ -221,6 +223,18 @@ void AwtTrayIcon::InitNID(UINT uID)
     m_nid.uVersion = NOTIFYICON_VERSION;
 }
 
+// Call updateImage() method on the peer when screen scale changes
+void AwtTrayIcon::UpdateImage()
+{
+    JNIEnv *env =(JNIEnv *)JNU_GetEnv(jvm, JNI_VERSION_1_2);
+
+    jobject peer = GetPeer(env);
+    if (peer != NULL) {
+        env->CallVoidMethod(peer, updateImageID);
+        env->ExceptionClear();
+    }
+}
+
 BOOL AwtTrayIcon::SendTrayMessage(DWORD dwMessage)
 {
     return Shell_NotifyIcon(dwMessage, (PNOTIFYICONDATA)&m_nid);
@@ -248,6 +262,10 @@ LRESULT CALLBACK AwtTrayIcon::TrayWindowProc(HWND hwnd, UINT uMsg, WPARAM wParam
                 }
             }
             break;
+        case WM_DPICHANGED:
+            // Set the flag to update icon images, see WmTaskbarCreated
+            m_bDPIChanged = true;
+            break;
         default:
             if(uMsg == s_msgTaskbarCreated) {
                 if (hwnd == AwtTrayIcon::sm_msgWindow) {
@@ -474,12 +492,17 @@ MsgRouting AwtTrayIcon::WmContextMenu(UINT flags, int x, int y)
 MsgRouting AwtTrayIcon::WmTaskbarCreated() {
     TrayIconListItem* item;
     for (item = sm_trayIconList; item != NULL; item = item->m_next) {
+        if (m_bDPIChanged) {
+            // Update the icon image
+            item->m_trayIcon->UpdateImage();
+        }
         BOOL result = item->m_trayIcon->SendTrayMessage(NIM_ADD);
         // 6270114: Instructs the taskbar to behave according to the Shell version 5.0
         if (result) {
             item->m_trayIcon->SendTrayMessage(NIM_SETVERSION);
         }
     }
+    m_bDPIChanged = false;
     return mrDoDefault;
 }
 
@@ -917,6 +940,14 @@ Java_java_awt_TrayIcon_initIDs(JNIEnv *env, jclass cls)
     DASSERT(AwtTrayIcon::actionCommandID != NULL);
     CHECK_NULL( AwtTrayIcon::actionCommandID);
 
+    jclass wPeerCls = env->FindClass("sun/awt/windows/WTrayIconPeer");
+    DASSERT(wPeerCls != NULL);
+    CHECK_NULL(wPeerCls);
+
+    AwtTrayIcon::updateImageID = env->GetMethodID(wPeerCls, "updateImage", "()V");
+    DASSERT(AwtTrayIcon::updateImageID != NULL);
+    CHECK_NULL(AwtTrayIcon::updateImageID);
+
     CATCH_BAD_ALLOC;
 }
 