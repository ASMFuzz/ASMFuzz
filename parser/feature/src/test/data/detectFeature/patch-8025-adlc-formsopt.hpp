@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -47,9 +47,6 @@ class ExpandRule;
 class RewriteRule;
 class ConstructRule;
 class FormatRule;
-class Peephole;
-class PeepMatch;
-class PeepConstraint;
 class EncClass;
 class Interface;
 class RegInterface;
@@ -67,7 +64,10 @@ class ResourceForm;
 class PipeClassForm;
 class PipeClassOperandForm;
 class PipeClassResourceForm;
+class Peephole;
+class PeepPredicate;
 class PeepMatch;
+class PeepProcedure;
 class PeepConstraint;
 class PeepReplace;
 class MatchList;
@@ -526,7 +526,9 @@ class Peephole : public Form {
 private:
   static int      _peephole_counter;// Incremented by each peephole rule parsed
   int             _peephole_number;// Remember my order in architecture description
+  PeepPredicate  *_predicate;      // Predicate to apply peep rule
   PeepMatch      *_match;          // Instruction pattern to match
+  PeepProcedure  *_procedure;      // The detailed procedure to perform the rule
   PeepConstraint *_constraint;     // List of additional constraints
   PeepReplace    *_replace;        // Instruction pattern to substitute in
 
@@ -541,13 +543,17 @@ class Peephole : public Form {
   void append_peephole(Peephole *next_peephole);
 
   // Store the components of this peephole rule
+  void add_predicate(PeepPredicate *only_one_predicate);
   void add_match(PeepMatch *only_one_match);
+  void add_procedure(PeepProcedure *only_one_procedure);
   void append_constraint(PeepConstraint *next_constraint);
   void add_replace(PeepReplace *only_one_replacement);
 
   // Access the components of this peephole rule
   int             peephole_number() { return _peephole_number; }
+  PeepPredicate  *predicate()   { return _predicate; }
   PeepMatch      *match()       { return _match; }
+  PeepProcedure  *procedure()   { return _procedure; }
   PeepConstraint *constraints() { return _constraint; }
   PeepReplace    *replacement() { return _replace; }
   Peephole       *next()        { return _next; }
@@ -556,6 +562,19 @@ class Peephole : public Form {
   void output(FILE *fp);           // Write info to output files
 };
 
+class PeepPredicate : public Form {
+private:
+  const char* _rule;
+public:
+  // Public Methods
+  PeepPredicate(const char* rule);
+  ~PeepPredicate();
+
+  const char* rule() const;
+
+  void dump();
+  void output(FILE* fp);
+};
 
 class PeepMatch : public Form {
 private:
@@ -588,6 +607,19 @@ class PeepMatch : public Form {
   void output(FILE *fp);
 };
 
+class PeepProcedure : public Form {
+private:
+  const char* _name;
+public:
+  // Public Methods
+  PeepProcedure(const char* name);
+  ~PeepProcedure();
+
+  const char* name() const;
+
+  void dump();
+  void output(FILE* fp);
+};
 
 class PeepConstraint : public Form {
 private: