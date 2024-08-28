@@ -450,7 +450,7 @@ var getJibProfilesProfiles = function (input, common, data) {
             target_os: "macosx",
             target_cpu: "aarch64",
             dependencies: ["devkit", "gtest", "pandoc"],
-            configure_args: concat(common.configure_args_64bit, "--with-zlib=system",
+            configure_args: concat(common.configure_args_64bit,
                 "--with-macosx-version-max=11.00.00"),
         },
 