@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,8 +25,6 @@
  * @test
  * @summary Testing external editor.
  * @bug 8143955 8080843 8163816 8143006 8169828 8171130 8162989 8210808
- * @comment musl/Alpine has problems executing some shell scripts, see 8285987
- * @requires !vm.musl
  * @modules jdk.jshell/jdk.internal.jshell.tool
  * @build ReplToolTesting CustomEditor EditorTestBase
  * @run testng ExternalEditorTest