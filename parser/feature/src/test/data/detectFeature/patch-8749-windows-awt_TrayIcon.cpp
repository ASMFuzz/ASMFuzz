@@ -496,11 +496,7 @@ MsgRouting AwtTrayIcon::WmTaskbarCreated() {
             // Update the icon image
             item->m_trayIcon->UpdateImage();
         }
-        BOOL result = item->m_trayIcon->SendTrayMessage(NIM_ADD);
-        // 6270114: Instructs the taskbar to behave according to the Shell version 5.0
-        if (result) {
-            item->m_trayIcon->SendTrayMessage(NIM_SETVERSION);
-        }
+        item->m_trayIcon->AddTrayIcon();
     }
     m_bDPIChanged = false;
     return mrDoDefault;
@@ -748,7 +744,7 @@ void AwtTrayIcon::SetToolTip(LPCTSTR tooltip)
         _tcscpy_s(m_nid.szTip, TRAY_ICON_TOOLTIP_MAX_SIZE, tooltip);
     }
 
-    SendTrayMessage(NIM_MODIFY);
+    ModifyTrayIcon();
 }
 
 void AwtTrayIcon::_SetToolTip(void *param)
@@ -816,10 +812,10 @@ void AwtTrayIcon::_UpdateIcon(void *param)
     JNI_CHECK_PEER_GOTO(self, ret);
     trayIcon = (AwtTrayIcon *)pData;
 
-    BOOL result = trayIcon->SendTrayMessage(jupdate == JNI_TRUE ? NIM_MODIFY : NIM_ADD);
-    // 6270114: Instructs the taskbar to behave according to the Shell version 5.0
-    if (result && jupdate == JNI_FALSE) {
-        trayIcon->SendTrayMessage(NIM_SETVERSION);
+    if (jupdate == JNI_TRUE) {
+        trayIcon->ModifyTrayIcon();
+    } else {
+        trayIcon->AddTrayIcon();
     }
 ret:
     env->DeleteGlobalRef(self);
@@ -868,7 +864,7 @@ void AwtTrayIcon::DisplayMessage(LPCTSTR caption, LPCTSTR text, LPCTSTR msgType)
         _tcscpy_s(m_nid.szInfo, TRAY_ICON_BALLOON_INFO_MAX_SIZE, text);
     }
 
-    SendTrayMessage(NIM_MODIFY);
+    ModifyTrayIcon();
     m_nid.uFlags &= ~NIF_INFO;
 }
 