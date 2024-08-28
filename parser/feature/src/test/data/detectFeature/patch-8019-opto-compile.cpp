@@ -254,6 +254,8 @@ void Compile::print_statistics() {
     PhaseOutput::print_statistics();
     PhasePeephole::print_statistics();
     PhaseIdealLoop::print_statistics();
+    ConnectionGraph::print_statistics();
+    PhaseMacroExpand::print_statistics();
     if (xtty != NULL)  xtty->tail("statistics");
   }
   if (_intrinsic_hist_flags[as_int(vmIntrinsics::_none)] != 0) {