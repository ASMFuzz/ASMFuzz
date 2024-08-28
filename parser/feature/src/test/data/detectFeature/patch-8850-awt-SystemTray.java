@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -131,15 +131,7 @@ public class SystemTray {
     private static final TrayIcon[] EMPTY_TRAY_ARRAY = new TrayIcon[0];
 
     static {
-        AWTAccessor.setSystemTrayAccessor(
-            new AWTAccessor.SystemTrayAccessor() {
-                public void firePropertyChange(SystemTray tray,
-                                               String propertyName,
-                                               Object oldValue,
-                                               Object newValue) {
-                    tray.firePropertyChange(propertyName, oldValue, newValue);
-                }
-            });
+        AWTAccessor.setSystemTrayAccessor(SystemTray::firePropertyChange);
     }
 
     /**
@@ -257,15 +249,16 @@ public void add(TrayIcon trayIcon) throws AWTException {
         if (trayIcon == null) {
             throw new NullPointerException("adding null TrayIcon");
         }
-        TrayIcon[] oldArray = null, newArray = null;
-        Vector<TrayIcon> icons = null;
+        TrayIcon[] oldArray;
+        TrayIcon[] newArray;
+        Vector<TrayIcon> icons;
         synchronized (this) {
             oldArray = systemTray.getTrayIcons();
             @SuppressWarnings("unchecked")
             Vector<TrayIcon> tmp = (Vector<TrayIcon>)AppContext.getAppContext().get(TrayIcon.class);
             icons = tmp;
             if (icons == null) {
-                icons = new Vector<TrayIcon>(3);
+                icons = new Vector<>(3);
                 AppContext.getAppContext().put(TrayIcon.class, icons);
 
             } else if (icons.contains(trayIcon)) {
@@ -305,7 +298,8 @@ public void remove(TrayIcon trayIcon) {
         if (trayIcon == null) {
             return;
         }
-        TrayIcon[] oldArray = null, newArray = null;
+        TrayIcon[] oldArray;
+        TrayIcon[] newArray;
         synchronized (this) {
             oldArray = systemTray.getTrayIcons();
             @SuppressWarnings("unchecked")
@@ -343,7 +337,7 @@ public TrayIcon[] getTrayIcons() {
         @SuppressWarnings("unchecked")
         Vector<TrayIcon> icons = (Vector<TrayIcon>)AppContext.getAppContext().get(TrayIcon.class);
         if (icons != null) {
-            return icons.toArray(new TrayIcon[icons.size()]);
+            return icons.toArray(EMPTY_TRAY_ARRAY);
         }
         return EMPTY_TRAY_ARRAY;
     }
@@ -475,7 +469,7 @@ public synchronized PropertyChangeListener[] getPropertyChangeListeners(String p
     private void firePropertyChange(String propertyName,
                                     Object oldValue, Object newValue)
     {
-        if (oldValue != null && newValue != null && oldValue.equals(newValue)) {
+        if (oldValue != null && oldValue.equals(newValue)) {
             return;
         }
         getCurrentChangeSupport().firePropertyChange(propertyName, oldValue, newValue);