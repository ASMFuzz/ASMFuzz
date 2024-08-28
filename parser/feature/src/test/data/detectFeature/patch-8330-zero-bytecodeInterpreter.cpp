@@ -2994,6 +2994,8 @@ void BytecodeInterpreter::run(interpreterState istate) {
         SET_STACK_OBJECT(ts->earlyret_oop(), 0);
         MORE_STACK(1);
         break;
+      default:
+        ShouldNotReachHere();
     }
 
     ts->clr_earlyret_value();