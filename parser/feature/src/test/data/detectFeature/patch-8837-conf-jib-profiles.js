@@ -837,7 +837,7 @@ var getJibProfilesProfiles = function (input, common, data) {
         [ "", common.open_suffix ].forEach(function (suffix) {
             var cmpBaselineName = name + suffix + "-cmp-baseline";
             profiles[cmpBaselineName] = clone(profiles[name + suffix]);
-            // Only compare the images target. This should pressumably be expanded
+            // Only compare the images target. This should presumably be expanded
             // to include more build targets when possible.
             profiles[cmpBaselineName].default_make_targets = [ "images", "test-image" ];
             if (name == "linux-x64") {