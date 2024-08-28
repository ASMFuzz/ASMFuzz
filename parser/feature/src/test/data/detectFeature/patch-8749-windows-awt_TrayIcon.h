@@ -52,7 +52,6 @@ class AwtTrayIcon: public AwtObject {
 
     virtual void Dispose();
 
-    BOOL SendTrayMessage(DWORD dwMessage);
     void LinkObjects(JNIEnv *env, jobject peer);
     void UnlinkObjects();
 
@@ -154,6 +153,20 @@ class AwtTrayIcon: public AwtObject {
         TrayIconListItem* m_next;
     };
 
+    BOOL SendTrayMessage(DWORD dwMessage);
+
+    INLINE void AddTrayIcon() {
+        BOOL result = SendTrayMessage(NIM_ADD);
+        // 6270114: Instructs the taskbar to behave according to the Shell version 5.0
+        if (result) {
+            SendTrayMessage(NIM_SETVERSION);
+        }
+    }
+
+    INLINE void ModifyTrayIcon() {
+        SendTrayMessage(NIM_MODIFY);
+    }
+
     static bool m_bDPIChanged;
 
 public: