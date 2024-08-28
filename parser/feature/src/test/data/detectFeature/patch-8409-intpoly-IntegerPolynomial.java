@@ -558,7 +558,7 @@ protected boolean isSummand() {
 
         @Override
         public ImmutableElement add(IntegerModuloP genB) {
-
+            assert IntegerPolynomial.this == genB.getField();
             Element b = (Element) genB;
             if (!(isSummand() && b.isSummand())) {
                 throw new ArithmeticException("Not a valid summand");
@@ -596,7 +596,7 @@ protected void copyLow(long[] limbs, long[] out) {
 
         @Override
         public ImmutableElement multiply(IntegerModuloP genB) {
-
+            assert IntegerPolynomial.this == genB.getField();
             Element b = (Element) genB;
 
             long[] newLimbs = new long[limbs.length];
@@ -612,7 +612,7 @@ public ImmutableElement square() {
         }
 
         public void addModPowerTwo(IntegerModuloP arg, byte[] result) {
-
+            assert IntegerPolynomial.this == arg.getField();
             Element other = (Element) arg;
             if (!(isSummand() && other.isSummand())) {
                 throw new ArithmeticException("Not a valid summand");
@@ -642,7 +642,7 @@ public ImmutableElement fixed() {
 
         @Override
         public void conditionalSet(IntegerModuloP b, int set) {
-
+            assert IntegerPolynomial.this == b.getField();
             Element other = (Element) b;
 
             conditionalAssign(set, limbs, other.limbs);
@@ -651,7 +651,7 @@ public void conditionalSet(IntegerModuloP b, int set) {
 
         @Override
         public void conditionalSwapWith(MutableIntegerModuloP b, int swap) {
-
+            assert IntegerPolynomial.this == b.getField();
             MutableElement other = (MutableElement) b;
 
             conditionalSwap(swap, limbs, other.limbs);
@@ -663,6 +663,7 @@ public void conditionalSwapWith(MutableIntegerModuloP b, int swap) {
 
         @Override
         public MutableElement setValue(IntegerModuloP v) {
+            assert IntegerPolynomial.this == v.getField();
             Element other = (Element) v;
 
             System.arraycopy(other.limbs, 0, limbs, 0, other.limbs.length);
@@ -692,6 +693,7 @@ public MutableElement setValue(ByteBuffer buf, int length,
 
         @Override
         public MutableElement setProduct(IntegerModuloP genB) {
+            assert IntegerPolynomial.this == genB.getField();
             Element b = (Element) genB;
             mult(limbs, b.limbs, limbs);
             numAdds = 0;
@@ -708,7 +710,7 @@ public MutableElement setProduct(SmallValue v) {
 
         @Override
         public MutableElement setSum(IntegerModuloP genB) {
-
+            assert IntegerPolynomial.this == genB.getField();
             Element b = (Element) genB;
             if (!(isSummand() && b.isSummand())) {
                 throw new ArithmeticException("Not a valid summand");
@@ -724,7 +726,7 @@ public MutableElement setSum(IntegerModuloP genB) {
 
         @Override
         public MutableElement setDifference(IntegerModuloP genB) {
-
+            assert IntegerPolynomial.this == genB.getField();
             Element b = (Element) genB;
             if (!(isSummand() && b.isSummand())) {
                 throw new ArithmeticException("Not a valid summand");
@@ -747,7 +749,6 @@ public MutableElement setSquare() {
 
         @Override
         public MutableElement setAdditiveInverse() {
-
             for (int i = 0; i < limbs.length; i++) {
                 limbs[i] = -limbs[i];
             }
@@ -756,7 +757,6 @@ public MutableElement setAdditiveInverse() {
 
         @Override
         public MutableElement setReduced() {
-
             reduce(limbs);
             numAdds = 0;
             return this;