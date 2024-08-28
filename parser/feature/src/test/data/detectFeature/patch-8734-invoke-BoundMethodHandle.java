@@ -113,6 +113,7 @@ BoundMethodHandle rebind() {
         if (!tooComplex()) {
             return this;
         }
+        this.prepare();
         return makeReinvoker(this);
     }
 