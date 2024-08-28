@@ -1,4 +1,3 @@
-
 /*
  * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
@@ -209,10 +208,17 @@ class DumpTimeSharedClassTable: public DumpTimeSharedClassTableBaseType
     }
   }
 
-  // Overrides ResourceHashtable<>::iterate(ITER*)
-  template<class ITER> void iterate(ITER* iter) const;
+  template<class ITER> void iterate_all_live_classes(ITER* iter) const;
+  template<typename Function> void iterate_all_live_classes(Function function) const;
+
 private:
-  template<class ITER> class IterationHelper;
+  // It's unsafe to iterate on classes whose loader is dead.
+  // Declare these private and don't implement them. This forces users of
+  // DumpTimeSharedClassTable to use the iterate_all_live_classes() methods
+  // instead.
+  template<class ITER> void iterate(ITER* iter) const;
+  template<typename Function> void iterate(Function function) const;
+  template<typename Function> void iterate_all(Function function) const;
 };
 
 #endif // SHARED_CDS_DUMPTIMESHAREDCLASSINFO_HPP