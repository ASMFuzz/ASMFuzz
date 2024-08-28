@@ -166,6 +166,12 @@ void f() {}
 
         group((Function<Object, Integer>) x -> x instanceof Integer i ? i : -1,
               (Function<Object, Integer>) x -> x instanceof Integer i ? i : -1);
+
+        group((Function<Object, Integer>) x -> x instanceof R(var i1, var i2) ? i1 : -1,
+              (Function<Object, Integer>) x -> x instanceof R(var i1, var i2) ? i1 : -1 );
+
+        group((Function<Object, Integer>) x -> x instanceof R(Integer i1, int i2) ? i2 : -1,
+              (Function<Object, Integer>) x -> x instanceof R(Integer i1, int i2) ? i2 : -1 );
     }
 
     void f() {}
@@ -174,4 +180,6 @@ void g() {}
 
     int i;
     int j;
+
+    record R(Integer i1, int i2) {}
 }