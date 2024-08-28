@@ -1802,7 +1802,7 @@ Node* Parse::optimize_cmp_with_klass(Node* c) {
 
 //------------------------------do_one_bytecode--------------------------------
 // Parse this bytecode, and alter the Parsers JVM->Node mapping
-void Parse::do_one_bytecode() {
+void Parse::do_one_bytecode_common() {
   Node *a, *b, *c, *d;          // Handy temps
   BoolTest::mask btest;
   int i;
@@ -2750,16 +2750,4 @@ void Parse::do_one_bytecode() {
     tty->print("\nUnhandled bytecode %s\n", Bytecodes::name(bc()) );
     ShouldNotReachHere();
   }
-
-#ifndef PRODUCT
-  if (C->should_print_igv(1)) {
-    IdealGraphPrinter* printer = C->igv_printer();
-    char buffer[256];
-    jio_snprintf(buffer, sizeof(buffer), "Bytecode %d: %s", bci(), Bytecodes::name(bc()));
-    bool old = printer->traverse_outs();
-    printer->set_traverse_outs(true);
-    printer->print_method(buffer, 4);
-    printer->set_traverse_outs(old);
-  }
-#endif
 }