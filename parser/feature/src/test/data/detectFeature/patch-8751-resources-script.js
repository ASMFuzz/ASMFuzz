@@ -137,14 +137,14 @@ document.addEventListener("DOMContentLoaded", function(e) {
     window.addEventListener("hashchange", function(e) {
         history.replaceState(contentDiv.scrollTop, document.title);
     });
+    var timeoutId;
     contentDiv.addEventListener("scroll", function(e) {
-        var timeoutID;
-        if (!timeoutID) {
-            timeoutID = setTimeout(function() {
-                history.replaceState(contentDiv.scrollTop, document.title);
-                timeoutID = null;
-            }, 100);
+        if (timeoutId) {
+            clearTimeout(timeoutId);
         }
+        timeoutId = setTimeout(function() {
+            history.replaceState(contentDiv.scrollTop, document.title);
+        }, 100);
     });
     if (!location.hash) {
         history.replaceState(contentDiv.scrollTop, document.title);