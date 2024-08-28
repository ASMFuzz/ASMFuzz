@@ -702,7 +702,6 @@ UTIL_DEFUN_NAMED([UTIL_ARG_WITH],
   ARG_CHECK_AVAILABLE
 
   # Check if the option should be turned on
-  echo check msg:ARG_CHECKING_MSG:
   AC_MSG_CHECKING(ARG_CHECKING_MSG)
 
   if test x$AVAILABLE = xfalse; then