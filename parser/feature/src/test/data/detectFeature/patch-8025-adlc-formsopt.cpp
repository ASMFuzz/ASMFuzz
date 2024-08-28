@@ -635,7 +635,8 @@ void PipeClassForm::output(FILE *fp) {         // Write info to output files
 //==============================Peephole Optimization==========================
 int Peephole::_peephole_counter = 0;
 //------------------------------Peephole---------------------------------------
-Peephole::Peephole() : _match(NULL), _constraint(NULL), _replace(NULL), _next(NULL) {
+Peephole::Peephole() : _predicate(NULL), _match(NULL), _procedure(NULL),
+                       _constraint(NULL), _replace(NULL), _next(NULL) {
   _peephole_number = _peephole_counter++;
 }
 Peephole::~Peephole() {
@@ -650,12 +651,24 @@ void Peephole::append_peephole(Peephole *next_peephole) {
   }
 }
 
+// Add a predicate to this peephole rule
+void Peephole::add_predicate(PeepPredicate* predicate) {
+  assert( _predicate == NULL, "fatal()" );
+  _predicate = predicate;
+}
+
 // Store the components of this peephole rule
 void Peephole::add_match(PeepMatch *match) {
   assert( _match == NULL, "fatal()" );
   _match = match;
 }
 
+// Add a procedure to this peephole rule
+void Peephole::add_procedure(PeepProcedure* procedure) {
+  assert( _procedure == NULL, "fatal()" );
+  _procedure = procedure;
+}
+
 void Peephole::append_constraint(PeepConstraint *next_constraint) {
   if( _constraint == NULL ) {
     _constraint = next_constraint;
@@ -685,13 +698,30 @@ void Peephole::output(FILE *fp) {         // Write info to output files
   if( _next ) _next->output(fp);
 }
 
+//----------------------------PeepPredicate------------------------------------
+PeepPredicate::PeepPredicate(const char* rule) : _rule(rule) {
+}
+PeepPredicate::~PeepPredicate() {
+}
+
+const char* PeepPredicate::rule() const {
+  return _rule;
+}
+
+void PeepPredicate::dump() {
+  output(stderr);
+}
+
+void PeepPredicate::output(FILE* fp) {
+  fprintf(fp, "PeepPredicate\n");
+}
+
 //------------------------------PeepMatch--------------------------------------
 PeepMatch::PeepMatch(char *rule) : _max_position(0), _rule(rule) {
 }
 PeepMatch::~PeepMatch() {
 }
 
-
 // Insert info into the match-rule
 void  PeepMatch::add_instruction(int parent, int position, const char *name,
                                  int input) {
@@ -741,6 +771,24 @@ void PeepMatch::output(FILE *fp) {        // Write info to output files
   fprintf(fp,"PeepMatch:\n");
 }
 
+//----------------------------PeepProcedure------------------------------------
+PeepProcedure::PeepProcedure(const char* name) : _name(name) {
+}
+PeepProcedure::~PeepProcedure() {
+}
+
+const char* PeepProcedure::name() const {
+  return _name;
+}
+
+void PeepProcedure::dump() {
+  output(stderr);
+}
+
+void PeepProcedure::output(FILE* fp) {
+  fprintf(fp, "PeepProcedure\n");
+}
+
 //------------------------------PeepConstraint---------------------------------
 PeepConstraint::PeepConstraint(int left_inst,  char* left_op, char* relation,
                                int right_inst, char* right_op)