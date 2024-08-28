@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2010, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2010, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -21,17 +21,28 @@
  * questions.
  */
 
+import com.sun.swingset3.demos.ResourceManager;
+import org.jemmy2ext.JemmyExt;
 import org.jtregext.GuiTestListener;
 import com.sun.swingset3.demos.scrollpane.ScrollPaneDemo;
 import static com.sun.swingset3.demos.scrollpane.ScrollPaneDemo.DEMO_TITLE;
 import static org.testng.AssertJUnit.*;
+
+import javax.swing.ImageIcon;
+import javax.swing.JLabel;
 import javax.swing.UIManager;
+
+import org.netbeans.jemmy.operators.ContainerOperator;
+import org.netbeans.jemmy.operators.JLabelOperator;
+import org.netbeans.jemmy.util.Dumper;
 import org.testng.annotations.Test;
 import org.netbeans.jemmy.ClassReference;
 import org.netbeans.jemmy.operators.JFrameOperator;
 import org.netbeans.jemmy.operators.JScrollPaneOperator;
 import org.testng.annotations.Listeners;
 
+import java.awt.MediaTracker;
+
 /*
  * @test
  * @key headful
@@ -46,18 +57,24 @@
  * @build org.jemmy2ext.JemmyExt
  * @build com.sun.swingset3.demos.scrollpane.ScrollPaneDemo
  * @run testng/timeout=600 ScrollPaneDemoTest
+
  */
 @Listeners(GuiTestListener.class)
 public class ScrollPaneDemoTest {
 
+    public static final String IMAGE_DESCRIPTION =
+            new ResourceManager(ScrollPaneDemo.class).getString("ScrollPaneDemo.crayons");
+
     @Test(dataProvider = "availableLookAndFeels", dataProviderClass = TestHelpers.class)
     public void test(String lookAndFeel) throws Exception {
         UIManager.setLookAndFeel(lookAndFeel);
 
         new ClassReference(ScrollPaneDemo.class.getName()).startApplication();
 
         JFrameOperator frame = new JFrameOperator(DEMO_TITLE);
-        JScrollPaneOperator jspo = new JScrollPaneOperator(frame);
+        ContainerOperator<ScrollPaneDemo> scrollPaneDemo =
+                new ContainerOperator<>(frame, c -> c instanceof ScrollPaneDemo);
+        JScrollPaneOperator jspo = new JScrollPaneOperator(scrollPaneDemo);
 
         // Set initial scrollbar positions
         int initialVerticalValue = jspo.getVerticalScrollBar().getValue();
@@ -66,6 +83,17 @@ public void test(String lookAndFeel) throws Exception {
         System.out.println("Initial Vertical Value = " + jspo.getVerticalScrollBar().getValue());
         System.out.println("Initial HoriZontal Value = " + jspo.getHorizontalScrollBar().getValue());
 
+        JLabelOperator imageLabel = new JLabelOperator(scrollPaneDemo, c ->
+            c instanceof JLabel label && label.getIcon() instanceof ImageIcon imageIcon &&
+                    imageIcon.getDescription().equals(IMAGE_DESCRIPTION));
+        imageLabel.waitState(c -> ((ImageIcon)((JLabel)c).getIcon()).getImageLoadStatus() == MediaTracker.COMPLETE);
+
+        //this additional instrumentation is related to JDK-8225013
+        //after the image has been completely loaded, the UI is supposed to be functional
+        //screenshot and dump are created to capture the state of the UI, should the test fail again
+        JemmyExt.save(JemmyExt.capture(), "after-image-load");
+        Dumper.dumpAll("after-image-load-" + JemmyExt.lafShortName() + "xml");
+
         // Check scroll to Bottom
         {
             jspo.scrollToBottom();