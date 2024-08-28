@@ -340,7 +340,7 @@ AC_DEFUN([FLAGS_SETUP_TOOLCHAIN_CONTROL],
     # Check if @file is supported by gcc
     if test "x$TOOLCHAIN_TYPE" = xgcc; then
       AC_MSG_CHECKING([if @file is supported by gcc])
-      # Extra emtpy "" to prevent ECHO from interpreting '--version' as argument
+      # Extra empty "" to prevent ECHO from interpreting '--version' as argument
       $ECHO "" "--version" > command.file
       if $CXX @command.file 2>&AS_MESSAGE_LOG_FD >&AS_MESSAGE_LOG_FD; then
         AC_MSG_RESULT(yes)