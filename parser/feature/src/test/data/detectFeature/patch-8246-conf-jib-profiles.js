@@ -244,7 +244,7 @@ var getJibProfilesCommon = function (input, data) {
         "linux-aarch64", "linux-arm32", "linux-ppc64le", "linux-s390x"
     ];
 
-    // These are the base setttings for all the main build profiles.
+    // These are the base settings for all the main build profiles.
     common.main_profile_base = {
         dependencies: ["boot_jdk", "gnumake", "jtreg", "jib", "autoconf", "jmh", "jcov"],
         default_make_targets: ["product-bundles", "test-bundles", "static-libs-bundles"],
@@ -620,7 +620,7 @@ var getJibProfilesProfiles = function (input, common, data) {
     });
 
     // Define a profile with precompiled headers disabled. This is just used for
-    // verfication of this build configuration.
+    // verification of this build configuration.
     var noPchProfiles = {
         "linux-x64-debug-nopch": {
             target_os: "linux",
@@ -1022,10 +1022,10 @@ var getJibProfilesProfiles = function (input, common, data) {
     // get src.full as a dependency, and define the work_dir (where make gets
     // run) to be in the src.full install path. By running in the install path,
     // the same cached installation of the full src can be reused for multiple
-    // test tasks. Care must however be taken not to polute that work dir by
+    // test tasks. Care must however be taken not to pollute that work dir by
     // setting the appropriate make variables to control output directories.
     //
-    // Use the existance of the top level README.md as indication of if this is
+    // Use the existence of the top level README.md as indication of if this is
     // the full source or just src.conf.
     if (!new java.io.File(__DIR__, "../../README.md").exists()) {
         var runTestPrebuiltSrcFullExtra = {