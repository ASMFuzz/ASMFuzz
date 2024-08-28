@@ -105,27 +105,49 @@ function indexFilesLoaded() {
         && memberSearchIndex
         && tagSearchIndex;
 }
-
+// Copy the contents of the local snippet to the clipboard
 function copySnippet(button) {
+    copyToClipboard(button.nextElementSibling.innerText);
+    switchCopyLabel(button.firstElementChild, button.parentElement);
+}
+// Copy the link to the adjacent header to the clipboard
+function copyUrl(button) {
+    var id;
+    var header = button.parentElement;
+    if (header.hasAttribute("id")) {
+        id = header.getAttribute("id");
+    } else if (header.parentElement.tagName === 'SECTION' && header.parentElement.hasAttribute("id")) {
+        id = header.parentElement.getAttribute("id");
+    } else if (header.firstElementChild && header.firstElementChild.tagName === "A"
+                                        && header.firstElementChild.hasAttribute("id")) {
+        id = header.firstElementChild.getAttribute("id");
+    }
+    var url = document.location.href;
+    if (url.indexOf("#") > -1) {
+        url = url.substring(0, url.indexOf("#"));
+    }
+    copyToClipboard(url + "#" + id);
+    switchCopyLabel(button.lastElementChild, button.parentElement);
+}
+function copyToClipboard(content) {
     var textarea = document.createElement("textarea");
     textarea.style.height = 0;
     document.body.appendChild(textarea);
-    textarea.value = button.nextElementSibling.innerText;
+    textarea.value = content;
     textarea.select();
     document.execCommand("copy");
     document.body.removeChild(textarea);
-    var span = button.firstElementChild;
+}
+function switchCopyLabel(span, parent) {
     var copied = span.getAttribute("data-copied");
     if (span.innerHTML !== copied) {
         var initialLabel = span.innerHTML;
         span.innerHTML = copied;
-        var parent = button.parentElement;
         parent.onmouseleave = parent.ontouchend = function() {
             span.innerHTML = initialLabel;
         };
     }
 }
-
 // Workaround for scroll position not being included in browser history (8249133)
 document.addEventListener("DOMContentLoaded", function(e) {
     var contentDiv = document.querySelector("div.flex-content");