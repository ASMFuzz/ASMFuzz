@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2007, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2007, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -27,208 +27,75 @@
   @bug 4811096
   @summary Tests whether mixing works on Dialogs
   @author anthony.petrov@...: area=awt.mixing
-  @library ../regtesthelpers
-  @build Util
   @run main MixingOnDialog
 */
 
 
-/**
+/*
  * MixingOnDialog.java
  *
  * summary:  Tests whether awt.Button and swing.JButton mix correctly
  */
 
-import java.awt.*;
-import java.awt.event.*;
-import javax.swing.*;
-import test.java.awt.regtesthelpers.Util;
-
-
-
-public class MixingOnDialog
-{
-    static volatile boolean heavyClicked = false;
+import java.awt.AWTException;
+import java.awt.Button;
+import java.awt.Dialog;
+import java.awt.Frame;
+import java.awt.Point;
+import java.awt.Robot;
+import java.awt.event.InputEvent;
+import java.lang.reflect.InvocationTargetException;
+import javax.swing.JButton;
+import javax.swing.SwingUtilities;
+
+public class MixingOnDialog {
     static volatile boolean lightClicked = false;
+    static Dialog d;
+    static volatile Button heavy;
 
-    private static void init()
-    {
+    private static void init() {
         // Create components
-        final Dialog d = new Dialog((Frame)null, "Button-JButton mix test");
-        final Button heavy = new Button("  Heavyweight Button  ");
+        d = new Dialog((Frame)null, "Button-JButton mix test");
+        heavy = new Button("  Heavyweight Button  ");
         final JButton light = new JButton("  LW Button  ");
 
         // Actions for the buttons add appropriate number to the test sequence
-        heavy.addActionListener(new java.awt.event.ActionListener()
-                {
-                    public void actionPerformed(java.awt.event.ActionEvent e) {
-                        heavyClicked = true;
-                    }
-                }
-                );
-
-        light.addActionListener(new java.awt.event.ActionListener()
-                {
-                    public void actionPerformed(java.awt.event.ActionEvent e) {
-                        lightClicked = true;
-                    }
-                }
-                );
+        light.addActionListener(e -> lightClicked = true);
 
         // Overlap the buttons
-        heavy.setBounds(30, 30, 200, 200);
-        light.setBounds(10, 10, 50, 50);
+        heavy.setBounds(230, 230, 200, 200);
+        light.setBounds(210, 210, 50, 50);
 
         // Put the components into the frame
         d.setLayout(null);
         d.add(light);
         d.add(heavy);
-        d.setBounds(50, 50, 400, 400);
+        d.setBounds(250, 250, 400, 400);
         d.setVisible(true);
+    }
 
+    public static void main(String[] args) throws InterruptedException, InvocationTargetException, AWTException {
+        SwingUtilities.invokeAndWait(MixingOnDialog::init);
 
-        Robot robot = Util.createRobot();
-        robot.setAutoDelay(20);
-
-        Util.waitForIdle(robot);
+        Robot robot = new Robot();
+        robot.setAutoDelay(50);
+        robot.waitForIdle();
+        robot.delay(500);
 
         // Move the mouse pointer to the position where both
         //    buttons overlap
         Point heavyLoc = heavy.getLocationOnScreen();
         robot.mouseMove(heavyLoc.x + 5, heavyLoc.y + 5);
 
         // Now perform the click at this point
-        robot.mousePress(InputEvent.BUTTON1_MASK);
-        robot.mouseRelease(InputEvent.BUTTON1_MASK);
-        Util.waitForIdle(robot);
+        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
+        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
+        robot.waitForIdle();
 
-        // If the buttons are correctly mixed, the test sequence
-        // is equal to the check sequence.
-        if (lightClicked == true) {
-            MixingOnDialog.pass();
-        } else {
-            MixingOnDialog.fail("The lightweight component left behind the heavyweight one.");
-        }
-    }//End  init()
+        SwingUtilities.invokeAndWait(() -> d.dispose());
 
-
-
-    /*****************************************************
-     * Standard Test Machinery Section
-     * DO NOT modify anything in this section -- it's a
-     * standard chunk of code which has all of the
-     * synchronisation necessary for the test harness.
-     * By keeping it the same in all tests, it is easier
-     * to read and understand someone else's test, as
-     * well as insuring that all tests behave correctly
-     * with the test harness.
-     * There is a section following this for test-
-     * classes
-     ******************************************************/
-    private static boolean theTestPassed = false;
-    private static boolean testGeneratedInterrupt = false;
-    private static String failureMessage = "";
-
-    private static Thread mainThread = null;
-
-    private static int sleepTime = 300000;
-
-    // Not sure about what happens if multiple of this test are
-    //  instantiated in the same VM.  Being static (and using
-    //  static vars), it aint gonna work.  Not worrying about
-    //  it for now.
-    public static void main( String args[] ) throws InterruptedException
-    {
-        mainThread = Thread.currentThread();
-        try
-        {
-            init();
-        }
-        catch( TestPassedException e )
-        {
-            //The test passed, so just return from main and harness will
-            // interepret this return as a pass
-            return;
+        if (!lightClicked) {
+            throw new RuntimeException("The lightweight component left behind the heavyweight one.");
         }
-        //At this point, neither test pass nor test fail has been
-        // called -- either would have thrown an exception and ended the
-        // test, so we know we have multiple threads.
-
-        //Test involves other threads, so sleep and wait for them to
-        // called pass() or fail()
-        try
-        {
-            Thread.sleep( sleepTime );
-            //Timed out, so fail the test
-            throw new RuntimeException( "Timed out after " + sleepTime/1000 + " seconds" );
-        }
-        catch (InterruptedException e)
-        {
-            //The test harness may have interrupted the test.  If so, rethrow the exception
-            // so that the harness gets it and deals with it.
-            if( ! testGeneratedInterrupt ) throw e;
-
-            //reset flag in case hit this code more than once for some reason (just safety)
-            testGeneratedInterrupt = false;
-
-            if ( theTestPassed == false )
-            {
-                throw new RuntimeException( failureMessage );
-            }
-        }
-
-    }//main
-
-    public static synchronized void setTimeoutTo( int seconds )
-    {
-        sleepTime = seconds * 1000;
-    }
-
-    public static synchronized void pass()
-    {
-        System.out.println( "The test passed." );
-        System.out.println( "The test is over, hit  Ctl-C to stop Java VM" );
-        //first check if this is executing in main thread
-        if ( mainThread == Thread.currentThread() )
-        {
-            //Still in the main thread, so set the flag just for kicks,
-            // and throw a test passed exception which will be caught
-            // and end the test.
-            theTestPassed = true;
-            throw new TestPassedException();
-        }
-        theTestPassed = true;
-        testGeneratedInterrupt = true;
-        mainThread.interrupt();
-    }//pass()
-
-    public static synchronized void fail()
-    {
-        //test writer didn't specify why test failed, so give generic
-        fail( "it just plain failed! :-)" );
     }
-
-    public static synchronized void fail( String whyFailed )
-    {
-        System.out.println( "The test failed: " + whyFailed );
-        System.out.println( "The test is over, hit  Ctl-C to stop Java VM" );
-        //check if this called from main thread
-        if ( mainThread == Thread.currentThread() )
-        {
-            //If main thread, fail now 'cause not sleeping
-            throw new RuntimeException( whyFailed );
-        }
-        theTestPassed = false;
-        testGeneratedInterrupt = true;
-        failureMessage = whyFailed;
-        mainThread.interrupt();
-    }//fail()
-
-}// class MixingOnDialog
-
-//This exception is used to exit from any level of call nesting
-// when it's determined that the test has passed, and immediately
-// end the test.
-class TestPassedException extends RuntimeException
-{
 }