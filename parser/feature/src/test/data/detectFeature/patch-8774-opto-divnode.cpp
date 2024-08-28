@@ -1466,27 +1466,3 @@ Node* UDivModLNode::match( const ProjNode *proj, const Matcher *match ) {
   }
   return new MachProjNode(this, proj->_con, rm, ideal_reg);
 }
-
-//------------------------------make------------------------------------------
-NoOvfDivModINode* NoOvfDivModINode::make(Node* div_or_mod) {
-  Node* n = div_or_mod;
-  assert(n->Opcode() == Op_NoOvfDivI || n->Opcode() == Op_NoOvfModI,
-         "only div or mod input pattern accepted");
-
-  NoOvfDivModINode* divmod = new NoOvfDivModINode(n->in(0), n->in(1), n->in(2));
-  Node*        dproj  = new ProjNode(divmod, DivModNode::div_proj_num);
-  Node*        mproj  = new ProjNode(divmod, DivModNode::mod_proj_num);
-  return divmod;
-}
-
-//------------------------------make------------------------------------------
-NoOvfDivModLNode* NoOvfDivModLNode::make(Node* div_or_mod) {
-  Node* n = div_or_mod;
-  assert(n->Opcode() == Op_NoOvfDivL || n->Opcode() == Op_NoOvfModL,
-         "only div or mod input pattern accepted");
-
-  NoOvfDivModLNode* divmod = new NoOvfDivModLNode(n->in(0), n->in(1), n->in(2));
-  Node*        dproj  = new ProjNode(divmod, DivModNode::div_proj_num);
-  Node*        mproj  = new ProjNode(divmod, DivModNode::mod_proj_num);
-  return divmod;
-}