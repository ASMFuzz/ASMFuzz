@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,18 +25,30 @@
 
 package com.sun.java.swing.plaf.windows;
 
-import java.awt.*;
-import javax.swing.*;
-import javax.swing.border.*;
-import javax.swing.plaf.*;
-import javax.swing.plaf.basic.*;
-import javax.swing.table.*;
+import java.awt.Component;
+import java.awt.Dimension;
+import java.awt.Graphics;
+import java.awt.Insets;
+
+import javax.swing.Icon;
+import javax.swing.JComponent;
+import javax.swing.JTable;
+import javax.swing.SortOrder;
+import javax.swing.UIManager;
+import javax.swing.border.Border;
+import javax.swing.border.EmptyBorder;
+import javax.swing.plaf.ComponentUI;
+import javax.swing.plaf.UIResource;
+import javax.swing.plaf.basic.BasicTableHeaderUI;
+import javax.swing.table.TableCellRenderer;
+import javax.swing.table.TableColumn;
 
-import static com.sun.java.swing.plaf.windows.TMSchema.*;
-import static com.sun.java.swing.plaf.windows.XPStyle.*;
-import sun.swing.table.*;
 import sun.swing.SwingUtilities2;
+import sun.swing.table.DefaultTableCellHeaderRenderer;
 
+import static com.sun.java.swing.plaf.windows.TMSchema.Part;
+import static com.sun.java.swing.plaf.windows.TMSchema.State;
+import static com.sun.java.swing.plaf.windows.XPStyle.Skin;
 
 public class WindowsTableHeaderUI extends BasicTableHeaderUI {
     private TableCellRenderer originalHeaderRenderer;
@@ -89,6 +101,9 @@ public Component getTableCellRendererComponent(JTable table, Object value,
             this.isSelected = isSelected;
             this.hasFocus = hasFocus;
             this.column = column;
+            if (table != null) {
+                header = table.getTableHeader();
+            }
             this.hasRollover = (column == getRolloverColumn());
             if (skin == null) {
                 XPStyle xp = XPStyle.getXP();