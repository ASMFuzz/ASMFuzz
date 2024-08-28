@@ -91,8 +91,6 @@ public String toString() {
     private Map<InputNode, Node> inputNodeToNode;
     private Vector<InputBlock> blocks;
     private Map<InputBlock, InputBlock> dominatorMap;
-    private Map<InputBlock, Integer> blockIndex;
-    private InputBlock[][] commonDominator;
     private static final Comparator<InputEdge> edgeComparator = new Comparator<InputEdge>() {
 
         @Override
@@ -230,14 +228,6 @@ public void buildBlocks() {
                 block.addNode(n.inputNode.getId());
             }
         }
-
-        // Compute block index map for dominator computation.
-        int z = 0;
-        blockIndex = new HashMap<>(blocks.size());
-        for (InputBlock b : blocks) {
-            blockIndex.put(b, z);
-            z++;
-        }
     }
 
     private String getBlockName(InputNode n) {
@@ -276,7 +266,6 @@ public Collection<InputBlock> schedule(InputGraph graph) {
             connectOrphansAndWidows();
             buildBlocks();
             buildDominators();
-            buildCommonDominators();
             scheduleLatest();
 
             InputBlock noBlock = null;
@@ -439,7 +428,7 @@ private void scheduleLatest() {
                                 if (block == null) {
                                     block = s.block;
                                 } else {
-                                    block = commonDominator[this.blockIndex.get(block)][blockIndex.get(s.block)];
+                                    block = getCommonDominator(block, s.block);
                                 }
                             }
                         }
@@ -505,18 +494,7 @@ private void markWithBlock(Node n, InputBlock b, Set<Node> reachable) {
         }
     }
 
-    public void buildCommonDominators() {
-        commonDominator = new InputBlock[this.blocks.size()][this.blocks.size()];
-        for (int i = 0; i < blocks.size(); i++) {
-            for (int j = 0; j < blocks.size(); j++) {
-                commonDominator[i][j] = getCommonDominator(i, j);
-            }
-        }
-    }
-
-    public InputBlock getCommonDominator(int a, int b) {
-        InputBlock ba = blocks.get(a);
-        InputBlock bb = blocks.get(b);
+    public InputBlock getCommonDominator(InputBlock ba, InputBlock bb) {
         if (ba == bb) {
             return ba;
         }