@@ -166,20 +166,23 @@ class Options {
   friend class Compile;
   friend class VMStructs;
  private:
-  const bool _subsume_loads;         // Load can be matched as part of a larger op.
-  const bool _do_escape_analysis;    // Do escape analysis.
+  const bool _subsume_loads;                 // Load can be matched as part of a larger op.
+  const bool _do_escape_analysis;            // Do escape analysis.
   const bool _do_iterative_escape_analysis;  // Do iterative escape analysis.
-  const bool _eliminate_boxing;      // Do boxing elimination.
-  const bool _do_locks_coarsening;   // Do locks coarsening
-  const bool _install_code;          // Install the code that was compiled
+  const bool _split_phi_bases;               // Split Phi nodes that merge object bases
+  const bool _eliminate_boxing;              // Do boxing elimination.
+  const bool _do_locks_coarsening;           // Do locks coarsening
+  const bool _install_code;                  // Install the code that was compiled
  public:
   Options(bool subsume_loads, bool do_escape_analysis,
           bool do_iterative_escape_analysis,
+          bool split_phi_bases,
           bool eliminate_boxing, bool do_locks_coarsening,
           bool install_code) :
           _subsume_loads(subsume_loads),
           _do_escape_analysis(do_escape_analysis),
           _do_iterative_escape_analysis(do_iterative_escape_analysis),
+          _split_phi_bases(split_phi_bases),
           _eliminate_boxing(eliminate_boxing),
           _do_locks_coarsening(do_locks_coarsening),
           _install_code(install_code) {
@@ -190,6 +193,7 @@ class Options {
        /* subsume_loads = */ true,
        /* do_escape_analysis = */ false,
        /* do_iterative_escape_analysis = */ false,
+       /* split_phi_bases = */ false,
        /* eliminate_boxing = */ false,
        /* do_lock_coarsening = */ false,
        /* install_code = */ true
@@ -352,6 +356,8 @@ class Compile : public Phase {
   GrowableArray<Node*>  _for_post_loop_igvn;    // List of nodes for IGVN after loop opts are over
   GrowableArray<Node_List*> _coarsened_locks;   // List of coarsened Lock and Unlock nodes
   ConnectionGraph*      _congraph;
+  uint                  _unique_base_id;        // Used to create a sequence of IDs for bases when splitting Phi
+
 #ifndef PRODUCT
   IdealGraphPrinter*    _igv_printer;
   static IdealGraphPrinter* _debug_file_printer;
@@ -537,6 +543,7 @@ class Compile : public Phase {
   bool              subsume_loads() const       { return _options._subsume_loads; }
   /** Do escape analysis. */
   bool              do_escape_analysis() const  { return _options._do_escape_analysis; }
+  bool              split_phi_bases() const     { return _options._split_phi_bases; }
   bool              do_iterative_escape_analysis() const  { return _options._do_iterative_escape_analysis; }
   /** Do boxing elimination. */
   bool              eliminate_boxing() const    { return _options._eliminate_boxing; }
@@ -770,6 +777,7 @@ class Compile : public Phase {
   // Node management
   uint         unique() const              { return _unique; }
   uint         next_unique()               { return _unique++; }
+  uint         next_unique_base_id()       { return _unique_base_id++; }
   void         set_unique(uint i)          { _unique = i; }
   static int   debug_idx()                 { return debug_only(_debug_idx)+0; }
   static void  set_debug_idx(int i)        { debug_only(_debug_idx = i); }