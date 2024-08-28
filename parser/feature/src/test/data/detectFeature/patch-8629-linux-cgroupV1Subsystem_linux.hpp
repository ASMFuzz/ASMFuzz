@@ -49,6 +49,8 @@ class CgroupV1Controller: public CgroupController {
 
     virtual void set_subsystem_path(char *cgroup_path);
     char *subsystem_path() { return _path; }
+  private:
+    int find_last_slash_pos(const char* s1, const char* s2);
 };
 
 class CgroupV1MemoryController: public CgroupV1Controller {