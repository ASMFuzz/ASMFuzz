@@ -1583,6 +1583,7 @@ class Node_List : public Node_Array {
   void remove( uint i ) { Node_Array::remove(i); _cnt--; }
   void push( Node *b ) { map(_cnt++,b); }
   void yank( Node *n );         // Find and remove
+  void replace( Node *o, Node *n );               // Replace o with n
   Node *pop() { return _nodes[--_cnt]; }
   void clear() { _cnt = 0; Node_Array::clear(); } // retain storage
   void copy(const Node_List& from) {