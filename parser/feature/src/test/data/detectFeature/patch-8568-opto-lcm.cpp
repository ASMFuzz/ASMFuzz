@@ -489,9 +489,11 @@ void PhaseCFG::implicit_null_check(Block* block, Node *proj, Node *val, int allo
 
 //------------------------------select-----------------------------------------
 // Select a nice fellow from the worklist to schedule next. If there is only one
-// choice, then use it. CreateEx nodes must start their blocks and are selected
-// eagerly. After them, projections take top priority for correctness. Next
-// after projections are constants and CheckCastPP nodes. There are a number of
+// choice, then use it. CreateEx nodes that are initially ready must start their
+// blocks and are given the highest priority, by being placed at the beginning
+// of the worklist. Next after initially-ready CreateEx nodes are projections,
+// which must follow their parents, and CreateEx nodes with local input
+// dependencies. Next are constants and CheckCastPP nodes. There are a number of
 // other special cases, for instructions that consume condition codes, et al.
 // These are chosen immediately. Some instructions are required to immediately
 // precede the last instruction in the block, and these are taken last. Of the
@@ -529,27 +531,21 @@ Node* PhaseCFG::select(
     Node *n = worklist[i];      // Get Node on worklist
 
     int iop = n->is_Mach() ? n->as_Mach()->ideal_Opcode() : 0;
-    if (iop == Op_CreateEx) {
-      // CreateEx must start the block (after Phi and Parm nodes which are
-      // pre-scheduled): select it right away.
+    if (iop == Op_CreateEx || n->is_Proj()) {
+      // CreateEx nodes that are initially ready must start the block (after Phi
+      // and Parm nodes which are pre-scheduled) and get top priority. This is
+      // currently enforced by placing them at the beginning of the initial
+      // worklist and selecting them eagerly here. After these, projections and
+      // other CreateEx nodes are selected with equal priority.
       worklist.map(i,worklist.pop());
       return n;
     }
 
-    uint n_choice = 2;
-    if (n->is_Proj()) {
-      // Projections should follow their parents.
-      n_choice = 5;
-    } else if (n->Opcode() == Op_Con || iop == Op_CheckCastPP) {
+    if (n->Opcode() == Op_Con || iop == Op_CheckCastPP) {
       // Constants and CheckCastPP nodes have higher priority than the rest of
-      // the nodes tested below.
-      n_choice = 4;
-    }
-
-    if (n_choice >= 4 && choice < n_choice) {
-      // n is a constant, a projection, or a CheckCastPP node: record as current
-      // winner, but keep looking for higher-priority nodes in the worklist.
-      choice  = n_choice;
+      // the nodes tested below. Record as current winner, but keep looking for
+      // higher-priority nodes in the worklist.
+      choice  = 4;
       // Latency and score are only used to break ties among low-priority nodes.
       latency = 0;
       score   = 0;
@@ -575,6 +571,8 @@ Node* PhaseCFG::select(
       }
     }
 
+    uint n_choice = 2;
+
     // See if this instruction is consumed by a branch. If so, then (as the
     // branch is the last instruction in the basic block) force it to the
     // end of the basic block
@@ -1078,6 +1076,10 @@ bool PhaseCFG::schedule_local(Block* block, GrowableArray<int>& ready_cnt, Vecto
         // of the phi to be scheduled first. The select() method breaks
         // ties in scheduling by worklist order.
         delay.push(m);
+      } else if (m->is_Mach() && m->as_Mach()->ideal_Opcode() == Op_CreateEx) {
+        // Place CreateEx nodes that are initially ready at the beginning of the
+        // worklist so they are selected first and scheduled at the block start.
+        worklist.insert(0, m);
       } else {
         worklist.push(m);         // Then on to worklist!
       }