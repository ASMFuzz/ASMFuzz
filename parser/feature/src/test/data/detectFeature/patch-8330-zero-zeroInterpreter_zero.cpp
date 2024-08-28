@@ -619,6 +619,8 @@ int ZeroInterpreter::getter_entry(Method* method, intptr_t UNUSED, TRAPS) {
       stack->alloc(wordSize);
       topOfStack = stack->sp();
       break;
+    default:
+      ;
   }
 
   // Read the field to stack(0)