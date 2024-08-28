@@ -384,7 +384,7 @@ AC_DEFUN([PLATFORM_EXTRACT_TARGET_AND_BUILD],
   fi
 ])
 
-# Check if a reduced build (32-bit on 64-bit platforms) is requested, and modify behaviour
+# Check if a reduced build (32-bit on 64-bit platforms) is requested, and modify behavior
 # accordingly. Must be done after setting up build and target system, but before
 # doing anything else with these values.
 AC_DEFUN([PLATFORM_SETUP_TARGET_CPU_BITS],