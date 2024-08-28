@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2019, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -433,77 +433,3 @@ void Parse::do_multianewarray() {
   // - Make a fast path for small multi-arrays.  (W/ implicit init. loops.)
   // - Issue CastII against length[*] values, to TypeInt::POS.
 }
-
-// On some architectures, a division cannot be done immediately due to
-// the special case with min_jint / -1. As a result, we need to have
-// special handling for this case
-void Parse::do_divmod_fixup() {
-  Bytecodes::Code bc = this->bc();
-  BasicType bt = (bc == Bytecodes::_idiv || bc == Bytecodes::_irem) ? T_INT : T_LONG;
-  // Operands need to stay in the stack during zero check
-  if (bt == T_INT) {
-    zero_check_int(peek(0));
-  } else {
-    zero_check_long(peek(1));
-  }
-  // Compile-time detection of arithmetic exception
-  if (stopped()) {
-    return;
-  }
-
-  Node* in2 = (bt == T_INT) ? pop() : pop_pair();
-  Node* in1 = (bt == T_INT) ? pop() : pop_pair();
-
-  auto generate_division = [](PhaseGVN& gvn, Node* control, Node* in1, Node* in2,
-                              Bytecodes::Code bc) {
-    switch (bc) {
-      case Bytecodes::_idiv: return gvn.transform(new NoOvfDivINode(control, in1, in2));
-      case Bytecodes::_ldiv: return gvn.transform(new NoOvfDivLNode(control, in1, in2));
-      case Bytecodes::_irem: return gvn.transform(new NoOvfModINode(control, in1, in2));
-      case Bytecodes::_lrem: return gvn.transform(new NoOvfModLNode(control, in1, in2));
-      default:
-        ShouldNotReachHere();
-        return static_cast<Node*>(nullptr);
-    }
-  };
-
-  auto push_result = [](Parse& parser, Node* res, BasicType bt) {
-    if (bt == T_INT) {
-      parser.push(res);
-    } else {
-      parser.push_pair(res);
-    }
-  };
-
-  // No overflow possibility here
-  if ((in1 == in2) ||
-      (bt == T_INT  &&  !TypeInt::MIN->higher_equal(_gvn.type(in1))) ||
-      (bt == T_LONG && !TypeLong::MIN->higher_equal(_gvn.type(in1)))) {
-    Node* res = generate_division(_gvn, control(), in1, in2, bc);
-    push_result(*this, res, bt);
-    return;
-  }
-
-  // The generated graph is equivalent to (in2 == -1) ? -in1 : (in1 / in2)
-  // we need to have a separate branch for in2 == -1 due to the special
-  // case of min_jint / -1
-  Node* cmp = _gvn.transform(CmpNode::make(in2, _gvn.integercon(-1, bt), bt));
-  Node* bol = Bool(cmp, BoolTest::eq);
-  IfNode* iff = create_and_map_if(control(), bol, PROB_UNLIKELY_MAG(3), COUNT_UNKNOWN);
-  Node* iff_true = IfTrue(iff);
-  Node* iff_false = IfFalse(iff);
-  Node* res_fast = (bc == Bytecodes::_idiv || bc == Bytecodes::_ldiv)
-                   ? _gvn.transform(SubNode::make(_gvn.zerocon(bt), in1, bt))
-                   : _gvn.zerocon(bt);
-  Node* res_slow = generate_division(_gvn, iff_false, in1, in2, bc);
-  Node* merge = new RegionNode(3);
-  merge->init_req(1, iff_true);
-  merge->init_req(2, iff_false);
-  record_for_igvn(merge);
-  set_control(_gvn.transform(merge));
-  Node* res = new PhiNode(merge, Type::get_const_basic_type(bt));
-  res->init_req(1, res_fast);
-  res->init_req(2, res_slow);
-  res = _gvn.transform(res);
-  push_result(*this, res, bt);
-}