@@ -393,8 +393,8 @@ var getJibProfilesCommon = function (input, data) {
         };
     };
 
-    common.boot_jdk_version = "17";
-    common.boot_jdk_build_number = "35";
+    common.boot_jdk_version = "18";
+    common.boot_jdk_build_number = "36";
     common.boot_jdk_home = input.get("boot_jdk", "install_path") + "/jdk-"
         + common.boot_jdk_version
         + (input.build_os == "macosx" ? ".jdk/Contents/Home" : "");