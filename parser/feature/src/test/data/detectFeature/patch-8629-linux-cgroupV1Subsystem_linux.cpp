@@ -32,6 +32,7 @@
 #include "runtime/os.hpp"
 #include "utilities/globalDefinitions.hpp"
 
+
 /*
  * Set directory to subsystem specific files based
  * on the contents of the mountinfo and cgroup files.
@@ -59,7 +60,7 @@ void CgroupV1Controller::set_subsystem_path(char *cgroup_path) {
         _path = os::strdup(buf);
       } else {
         char *p = strstr(cgroup_path, _root);
-        if (p != NULL && p == _root) {
+        if (p != NULL && p == cgroup_path) {
           if (strlen(cgroup_path) > strlen(_root)) {
             int buflen;
             strncpy(buf, _mount_point, MAXPATHLEN);
@@ -72,12 +73,40 @@ void CgroupV1Controller::set_subsystem_path(char *cgroup_path) {
             buf[MAXPATHLEN-1] = '\0';
             _path = os::strdup(buf);
           }
+        } else {
+          // Find the longest common prefix as namespaces are hierarchical.
+          // If there are no matches between the root and the cgroup path,
+          // the controller's mount point will be used, which is a reasonable
+          // fallback.
+          stringStream ss;
+          ss.print_raw(_mount_point);
+          const char* root_p = _root;
+          const char* cgroup_p = cgroup_path;
+          int last_slash = find_last_slash_pos(root_p, cgroup_p);
+          assert(last_slash >= 0, "not an absolute path?");
+          ss.print_raw(_root, last_slash);
+          _path = os::strdup(ss.base());
         }
       }
     }
   }
 }
 
+// Return last index of '/' in s1 and s2 up to which point paths
+// are the same in s1 and s2. -1 otherwise. For example
+// returns 4 for s1 = "/cat/dog" and s2 = "/cat/cow".
+int CgroupV1Controller::find_last_slash_pos(const char* s1, const char* s2) {
+  int last_matching_slash_pos = -1;
+  for (int i = 0; *s1 == *s2 && *s1 != 0; i++) {
+    if (*s1 == '/') {
+      last_matching_slash_pos = i;
+    }
+    s1++; s2++;
+  }
+  return last_matching_slash_pos;
+}
+
+
 /* uses_mem_hierarchy
  *
  * Return whether or not hierarchical cgroup accounting is being