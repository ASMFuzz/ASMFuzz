@@ -474,6 +474,11 @@ class InstanceKlass: public Klass {
   bool has_nest_member(JavaThread* current, InstanceKlass* k) const;
 
 public:
+  // Call this only if you know that the nest host has been initialized.
+  InstanceKlass* nest_host_not_null() {
+    assert(_nest_host != NULL, "must be");
+    return _nest_host;
+  }
   // Used to construct informative IllegalAccessError messages at a higher level,
   // if there was an issue resolving or validating the nest host.
   // Returns NULL if there was no error.