@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -63,6 +63,7 @@
 import java.util.Set;
 import java.util.stream.Collectors;
 import java.util.stream.Stream;
+import java.util.zip.ZipException;
 
 import javax.lang.model.SourceVersion;
 import javax.tools.FileObject;
@@ -560,7 +561,11 @@ public ArchiveContainer(Path archivePath) throws IOException, ProviderNotFoundEx
                 Map<String,String> env = Collections.singletonMap("multi-release", multiReleaseValue);
                 FileSystemProvider jarFSProvider = fsInfo.getJarFSProvider();
                 Assert.checkNonNull(jarFSProvider, "should have been caught before!");
-                this.fileSystem = jarFSProvider.newFileSystem(archivePath, env);
+                try {
+                    this.fileSystem = jarFSProvider.newFileSystem(archivePath, env);
+                } catch (ZipException ze) {
+                    throw new IOException("ZipException opening \"" + archivePath + "\": " + ze.getMessage(), ze);
+                }
             } else {
                 this.fileSystem = FileSystems.newFileSystem(archivePath, (ClassLoader)null);
             }