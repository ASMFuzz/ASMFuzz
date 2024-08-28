@@ -1,5 +1,5 @@
 #
-# Copyright (c) 2011, 2021, Oracle and/or its affiliates. All rights reserved.
+# Copyright (c) 2011, 2022, Oracle and/or its affiliates. All rights reserved.
 # DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 #
 # This code is free software; you can redistribute it and/or modify it
@@ -325,12 +325,12 @@ AC_DEFUN([UTIL_ALIASED_ARG_ENABLE],
 # Creates a command-line option using the --enable-* pattern. Will return a
 # value of 'true' or 'false' in the RESULT variable, depending on whether the
 # option was enabled or not by the user. The option can not be turned on if it
-# is not available, as specified by AVAILABLE and/or AVAILABLE_CHECK.
+# is not available, as specified by AVAILABLE and/or CHECK_AVAILABLE.
 #
 # Arguments:
 #   NAME: The base name of this option (i.e. what follows --enable-). Required.
 #   RESULT: The name of the variable to set to the result. Defaults to
-#     <NAME in uppercase>_RESULT.
+#     <NAME in uppercase>_ENABLED.
 #   DEFAULT: The default value for this option. Can be true, false or auto.
 #     Defaults to true.
 #   AVAILABLE: If true, this option is allowed to be selected. Defaults to true.
@@ -376,7 +376,7 @@ UTIL_DEFUN_NAMED([UTIL_ARG_ENABLE],
   m4_define([ARG_DESC], m4_if(ARG_DESC, , [Enable the ARG_NAME feature], m4_normalize(ARG_DESC)))
 
   # If CHECKING_MSG is not specified, set it to a generic description.
-  m4_define([ARG_CHECKING_MSG], m4_if(ARG_CHECKING_MSG, , [for --enable-ARG_NAME], ARG_CHECKING_MSG))
+  m4_define([ARG_CHECKING_MSG], m4_if(ARG_CHECKING_MSG, , [for --enable-ARG_NAME], m4_normalize(ARG_CHECKING_MSG)))
 
   # If the code blocks are not given, set them to the empty statements to avoid
   # tripping up bash.
@@ -463,3 +463,351 @@ UTIL_DEFUN_NAMED([UTIL_ARG_ENABLE],
   fi
 ])
 
+###############################################################################
+# Helper functions for ARG_WITH, to validate different types of argument
+
+# Dispatcher to call the correct UTIL_CHECK_TYPE_* function depending on the ARG_TYPE
+AC_DEFUN([UTIL_CHECK_TYPE],
+[
+  UTIL_CHECK_TYPE_$1($2)
+])
+
+AC_DEFUN([UTIL_CHECK_TYPE_string],
+[
+  # All strings always passes
+])
+
+AC_DEFUN([UTIL_CHECK_TYPE_integer],
+[
+  # Check that the argument is an integer
+  # Additional [] needed to keep m4 from mangling shell constructs.
+  [ if [[ ! "$1" =~ ^[0-9]+$ ]] ; then ]
+    FAILURE="Not an integer: $1"
+  fi
+])
+
+AC_DEFUN([UTIL_CHECK_TYPE_file],
+[
+  # Check that the argument is an existing file
+  if test ! -f "$1" ; then
+    FAILURE="File $1 does not exist or is not readable"
+  fi
+])
+
+AC_DEFUN([UTIL_CHECK_TYPE_directory],
+[
+  # Check that the argument is an existing directory
+  if test ! -d "$1" ; then
+    FAILURE="Directory $1 does not exist or is not readable"
+  fi
+
+  if test "[x]ARG_CHECK_FOR_FILES" != x; then
+    for file in ARG_CHECK_FOR_FILES; do
+      found_files=$($ECHO $(ls $1/$file 2> /dev/null))
+      if test "x$found_files" = x; then
+        FAILURE="Directory $1 does not contain $file"
+        break
+      elif ! test -e "$found_files"; then
+        FAILURE="Directory $1 contains multiple $file: $found_files"
+        break
+      fi
+    done
+  fi
+])
+
+AC_DEFUN([UTIL_CHECK_TYPE_literal],
+[
+  # Check if it contains a space between non-space characters
+  # Additional [] needed to keep m4 from mangling shell constructs.
+  [ if [[ "$1" =~ [^' ']' '+[^' '] ]] ; then ]
+    FAILURE="Multiple words: $1"
+  fi
+
+  # Check that the selected variants are valid
+  UTIL_GET_NON_MATCHING_VALUES(invalid_value, $1, \
+      ARG_VALID_VALUES)
+  if test "x$invalid_value" != x; then
+    FAILURE="Invalid value: $invalid_value. Valid values are: ARG_VALID_VALUES"
+  fi
+])
+
+AC_DEFUN([UTIL_CHECK_TYPE_multivalue],
+[
+  # We accept either space or comma as separator, but use space internally
+  values=`$ECHO $1 | $SED -e 's/,/ /g'`
+
+  # Check that the selected variants are valid
+  UTIL_GET_NON_MATCHING_VALUES(invalid_value, $values, \
+      ARG_VALID_VALUES)
+  if test "x$invalid_value" != x; then
+    FAILURE="Invalid value(s): $invalid_value. Valid values are: ARG_VALID_VALUES"
+  fi
+
+  # Update to version without comma
+  ARG_RESULT=$($ECHO $values)
+])
+
+AC_DEFUN([UTIL_CHECK_TYPE_features],
+[
+  # We accept either space or comma as separator, but use space internally
+  feature_list=`$ECHO $1 | $SED -e 's/,/ /g'`
+  features_enabled=`$ECHO $feature_list | \
+    $AWK '{ for (i=1; i<=NF; i++) if (!match($i, /^-.*/)) printf("%s ", $i) }'`
+  features_disabled=`$ECHO $feature_list | \
+    $AWK '{ for (i=1; i<=NF; i++) if (match($i, /^-.*/)) printf("%s ", substr($i, 2))}'`
+
+  # Check that the selected features are valid
+  UTIL_GET_NON_MATCHING_VALUES(invalid_features, $features_enabled \
+        $features_disabled, ARG_VALID_VALUES)
+  if test "x$invalid_features" != x; then
+    FAILURE="Invalid feature(s): $invalid_features. Valid values are: ARG_VALID_VALUES"
+  fi
+
+  # Update to version without comma
+  ARG_RESULT=$($ECHO $feature_list)
+])
+
+###############################################################################
+# Creates a command-line option using the --with-* pattern. Will return a
+# string in the RESULT variable with the option provided by the user, or the
+# empty string if the --with-* option was not given. The option can not be given
+# if it is not available, as specified by AVAILABLE and/or CHECK_AVAILABLE.
+#
+# Arguments:
+#   NAME: The base name of this option (i.e. what follows --with-). Required.
+#   TYPE: The type of the value. Can be one of "string", "integer", "file",
+#     "directory", "literal", "multivalue" or "features". Required.
+#   DEFAULT: The default value for this option. Can be any valid string.
+#     Required.
+#   OPTIONAL: If this feature can be disabled. Defaults to false. If true,
+#     the feature can be disabled using --without-FOO, --with-FOO=no, or
+#     --with-FOO=. Check the ENABLED_RESULT variable for the enabled/disabled
+#     state.
+#   RESULT: The name of the variable to set to the result. Defaults to
+#     <NAME in uppercase>. Set to empty if ENABLED_RESULT is false.
+#   ENABLED_DEFAULT: If the value is enabled by default. Defaults to false. Only
+#     relevant if OPTIONAL is true.
+#   ENABLED_RESULT: The name of the variable to set to the enabled/disabled
+#     result state. Defaults to <NAME in uppercase>_ENABLED.
+#   AVAILABLE: If true, this option is allowed to be selected. Defaults to true.
+#   DESC: A description of this option. Defaults to a generic and unhelpful
+#     string.
+#   DEFAULT_DESC: A message describing the default value, for the help. Defaults
+#     to the literal value of DEFAULT, or "<none>" if DEFAULT is empty.
+#   CHECKING_MSG: The message to present to user when checking this option.
+#     Defaults to a generic message.
+#   CHECK_AVAILABLE: An optional code block to execute to determine if the
+#     option should be available. Must set AVAILABLE to 'false' if not.
+#   VALID_VALUES: A list of literals that are the allowed values. Only valid if
+#     TYPE is "literal", "multivalue" or "features".
+#   CHECK_VALUE: An optional code block to execute to determine if the value
+#     is correct. Must set FAILURE to a non-empty string if not. This string
+#     will be displayed. The value is given in $RESULT.
+#   CHECK_FOR_FILES: A list of files to verify the presence for. Only valid if
+#     TYPE is "directory". Paths are relative the directory given as value.
+#     Wildcards are accepted. Exactly one matching file must be found, for each
+#     listed file, or FAILURE is set.
+#   IF_AUTO: An optional code block to execute if the value is "auto", either by
+#     default or given by the command line. Must set RESULT to the calculated
+#     value.
+#   IF_GIVEN:  An optional code block to execute if the option was given on the
+#     command line (regardless of the value).
+#   IF_NOT_GIVEN:  An optional code block to execute if the option was not given
+#     on the command line (regardless of the value).
+#
+UTIL_DEFUN_NAMED([UTIL_ARG_WITH],
+    [*NAME *TYPE *DEFAULT OPTIONAL RESULT ENABLED_DEFAULT ENABLED_RESULT
+    AVAILABLE DESC DEFAULT_DESC CHECKING_MSG CHECK_AVAILABLE VALID_VALUES
+    CHECK_VALUE CHECK_FOR_FILES IF_AUTO IF_GIVEN IF_NOT_GIVEN], [$@],
+[
+  ##########################
+  # Part 1: Set up m4 macros
+  ##########################
+
+  # If ENABLED_DEFAULT is not specified, set it to 'false'.
+  m4_define([ARG_ENABLED_DEFAULT], m4_if(ARG_ENABLED_DEFAULT, , false, ARG_ENABLED_DEFAULT))
+
+  # If AVAILABLE is not specified, set it to 'true'.
+  m4_define([ARG_AVAILABLE], m4_if(ARG_AVAILABLE, , true, ARG_AVAILABLE))
+
+  # If OPTIONAL is not specified, set it to 'false'.
+  m4_define([ARG_OPTIONAL], m4_if(ARG_OPTIONAL, , false, ARG_OPTIONAL))
+
+  # If DEFAULT_DESC is not specified, calculate it from DEFAULT.
+  m4_define([ARG_DEFAULT_DESC], m4_if(ARG_DEFAULT_DESC, , m4_if(ARG_DEFAULT, , <none>, ARG_DEFAULT), ARG_DEFAULT_DESC))
+
+  # If RESULT is not specified, set it to 'ARG_NAME'.
+  m4_define([ARG_RESULT], m4_if(ARG_RESULT, , m4_translit(ARG_NAME, [a-z-], [A-Z_]), ARG_RESULT))
+
+  # If ENABLED_RESULT is not specified, set it to 'ARG_NAME[_ENABLED]'.
+  m4_define([ARG_ENABLED_RESULT], m4_if(ARG_ENABLED_RESULT, , m4_translit(ARG_NAME, [a-z-], [A-Z_])[_ENABLED], ARG_ENABLED_RESULT))
+
+  # Construct shell variable names for the option
+  m4_define(ARG_OPTION, [with_]m4_translit(ARG_NAME, [-], [_]))
+  m4_define(ARG_GIVEN, m4_translit(ARG_NAME, [a-z-], [A-Z_])[_GIVEN])
+
+  # If DESC is not specified, set it to a generic description.
+  m4_define([ARG_DESC], m4_if(ARG_DESC, , [Give a value for the ARG_NAME feature], m4_normalize(ARG_DESC)))
+
+  # If CHECKING_MSG is not specified, set it to a generic description.
+  m4_define([ARG_CHECKING_MSG], m4_if(ARG_CHECKING_MSG, , [for --with-ARG_NAME], m4_normalize(ARG_CHECKING_MSG)))
+
+  m4_define([ARG_HAS_AUTO_BLOCK], m4_if(ARG_IF_AUTO, , false, true))
+
+  # If the code blocks are not given, set them to the empty statements to avoid
+  # tripping up bash.
+  m4_define([ARG_CHECK_AVAILABLE], m4_if(ARG_CHECK_AVAILABLE, , :, ARG_CHECK_AVAILABLE))
+  m4_define([ARG_CHECK_VALUE], m4_if(ARG_CHECK_VALUE, , :, ARG_CHECK_VALUE))
+  m4_define([ARG_CHECK_FOR_FILES], m4_if(ARG_CHECK_FOR_FILES, , :, ARG_CHECK_FOR_FILES))
+  m4_define([ARG_IF_AUTO], m4_if(ARG_IF_AUTO, , :, ARG_IF_AUTO))
+  m4_define([ARG_IF_GIVEN], m4_if(ARG_IF_GIVEN, , :, ARG_IF_GIVEN))
+  m4_define([ARG_IF_NOT_GIVEN], m4_if(ARG_IF_NOT_GIVEN, , :, ARG_IF_NOT_GIVEN))
+
+  ##########################
+  # Part 2: Set up autoconf shell code
+  ##########################
+
+  # Check that OPTIONAL has a valid value
+  if test "[x]ARG_OPTIONAL" != xtrue && test "[x]ARG_OPTIONAL" != xfalse ; then
+    AC_MSG_ERROR([Internal error: Argument OPTIONAL to [UTIL_ARG_WITH] can only be true or false, was: 'ARG_OPTIONAL'])
+  fi
+
+  # Check that ENABLED_DEFAULT has a valid value
+  if test "[x]ARG_ENABLED_DEFAULT" != xtrue && test "[x]ARG_ENABLED_DEFAULT" != xfalse ; then
+    AC_MSG_ERROR([Internal error: Argument ENABLED_DEFAULT to [UTIL_ARG_WITH] can only be true or false, was: 'ARG_ENABLED_DEFAULT'])
+  fi
+
+  # Check that AVAILABLE has a valid value
+  if test "[x]ARG_AVAILABLE" != xtrue && test "[x]ARG_AVAILABLE" != xfalse; then
+    AC_MSG_ERROR([Internal error: Argument AVAILABLE to [UTIL_ARG_WITH] can only be true or false, was: 'ARG_AVAILABLE'])
+  fi
+
+  # Check that TYPE has a valid value
+  # Need to assign since we can't expand ARG TYPE inside the m4 quoted if statement
+  TEST_TYPE="ARG_TYPE"
+  # Additional [] needed to keep m4 from mangling shell constructs.
+  [ if [[ ! "$TEST_TYPE" =~ ^(string|integer|file|directory|literal|multivalue|features)$ ]] ; then ]
+    AC_MSG_ERROR([Internal error: Argument TYPE to [UTIL_ARG_WITH] must be a valid type, was: 'ARG_TYPE'])
+  fi
+
+  AC_ARG_WITH(ARG_NAME, AS_HELP_STRING([--with-]ARG_NAME,
+      [ARG_DESC [ARG_DEFAULT_DESC]]), [ARG_GIVEN=true], [ARG_GIVEN=false])
+
+  # Check if the option is available
+  AVAILABLE=ARG_AVAILABLE
+  # Run the available check block (if any), which can overwrite AVAILABLE.
+  ARG_CHECK_AVAILABLE
+
+  # Check if the option should be turned on
+  echo check msg:ARG_CHECKING_MSG:
+  AC_MSG_CHECKING(ARG_CHECKING_MSG)
+
+  if test x$AVAILABLE = xfalse; then
+    ARG_RESULT="$ARG_OPTION"
+    ARG_ENABLED_RESULT=false
+    REASON="not available"
+  else
+    if test x$ARG_GIVEN = xfalse; then
+      ARG_RESULT="ARG_DEFAULT"
+      if test "[x]ARG_OPTIONAL" = xtrue; then
+        ARG_ENABLED_RESULT=ARG_ENABLED_DEFAULT
+      else
+        ARG_ENABLED_RESULT=true
+      fi
+      REASON="default"
+
+    else # ARG_GIVEN is true
+      # Special treatment of "yes" and "no" for "--with-ARG" and "--without-ARG"
+      if test "x$ARG_OPTION" = xyes || test "x$ARG_OPTION" = xno || test "x$ARG_OPTION" = x ; then
+        if test "[x]ARG_OPTIONAL" = xfalse; then
+          if test "x$ARG_OPTION" = x; then
+            # If not optional, the empty string is a valid value
+            ARG_RESULT=""
+            ARG_ENABLED_RESULT=true
+            REASON="from command line"
+          else
+            AC_MSG_RESULT([invalid])
+            AC_MSG_ERROR([Option [--with-]ARG_NAME must have a specified value])
+          fi
+        else
+          if test "x$ARG_OPTION" = xyes; then
+            ARG_RESULT="ARG_DEFAULT"
+            ARG_ENABLED_RESULT=true
+            REASON="default as enabled from command line"
+          else
+            # For optional values, both --without-FOO and --with-FOO= disables
+            ARG_RESULT=""
+            ARG_ENABLED_RESULT=false
+            REASON="from command line"
+          fi
+        fi
+      else
+        # The most common case -- the user gives a value for the option.
+        ARG_RESULT="$ARG_OPTION"
+        ARG_ENABLED_RESULT=true
+        REASON="from command line"
+      fi
+    fi
+  fi
+
+  if test "x$ARG_ENABLED_RESULT" = xfalse; then
+    if test "x$REASON" = "xnot available"; then
+      AC_MSG_RESULT([<invalid>, $REASON])
+      if test "x$ARG_RESULT" != "x" && test "x$ARG_RESULT" != "xno" ; then
+        AC_MSG_WARN([Option [--with-]ARG_NAME is not available for this configuration])
+      fi
+    else
+      AC_MSG_RESULT([<disabled>, $REASON])
+    fi
+    ARG_RESULT=""
+  else
+    if test [x]ARG_HAS_AUTO_BLOCK = xtrue && test "x$ARG_RESULT" = xauto; then
+      # Execute "auto" payload
+      ARG_IF_AUTO
+
+      ARG_RESULT="$RESULT"
+      REASON="$REASON (calculated from 'auto')"
+    fi
+
+    if test "x$ARG_RESULT" = x; then
+      AC_MSG_RESULT([<none>, $REASON])
+    else
+      AC_MSG_RESULT([$ARG_RESULT, $REASON])
+    fi
+  fi
+
+  # Verify value
+  # First use our dispatcher to verify that type requirements are satisfied
+  UTIL_CHECK_TYPE(ARG_TYPE, $ARG_RESULT)
+
+  if test "x$FAILURE" = x; then
+    # Execute custom verification payload, if present
+    RESULT="$ARG_RESULT"
+
+    ARG_CHECK_VALUE
+
+    ARG_RESULT="$RESULT"
+  fi
+
+  if test "x$FAILURE" != x; then
+    AC_MSG_NOTICE([Invalid value for [--with-]ARG_NAME: "$ARG_RESULT"])
+    AC_MSG_NOTICE([$FAILURE])
+    AC_MSG_ERROR([Cannot continue])
+  fi
+
+  # Execute result payloads, if present
+  if test x$ARG_GIVEN = xtrue; then
+    ARG_IF_GIVEN
+  else
+    ARG_IF_NOT_GIVEN
+  fi
+])
+
+###############################################################################
+# Helper functions for CHECK_VALUE in ARG_WITH.
+AC_DEFUN([UTIL_CHECK_STRING_NON_EMPTY],
+[
+  if test "x$RESULT" = "x"; then
+    FAILURE="Value cannot be empty"
+  fi
+])