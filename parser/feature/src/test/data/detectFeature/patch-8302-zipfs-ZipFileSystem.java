@@ -3309,7 +3309,7 @@ public byte[] comment() {
         public Optional<Set<PosixFilePermission>> storedPermissions() {
             Set<PosixFilePermission> perms = null;
             if (posixPerms != -1) {
-                perms = new HashSet<>(PosixFilePermission.values().length);
+                perms = HashSet.newHashSet(PosixFilePermission.values().length);
                 for (PosixFilePermission perm : PosixFilePermission.values()) {
                     if ((posixPerms & ZipUtils.permToFlag(perm)) != 0) {
                         perms.add(perm);