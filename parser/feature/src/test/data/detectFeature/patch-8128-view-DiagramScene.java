@@ -605,17 +605,22 @@ private void smallUpdate(boolean relayout) {
     }
 
     private boolean isVisible(Connection c) {
-        if (getModel().getShowCFG()) {
-            return c.isAlwaysVisible();
-        }
-        FigureWidget w1 = getWidget(c.getFrom().getVertex());
-        FigureWidget w2 = getWidget(c.getTo().getVertex());
-
-        if (w1.isVisible() && w2.isVisible()) {
-            return true;
+        // Generally, a connection is visible if its source and destination
+        // widgets are visible. An exception is Figure connections in the CFG
+        // view, which are never shown.
+        if (getModel().getShowCFG() && c instanceof FigureConnection) {
+            return false;
+        }
+        Widget w1, w2;
+        if (c instanceof BlockConnection) {
+            w1 = getWidget(((Block)c.getFromCluster()).getInputBlock());
+            w2 = getWidget(((Block)c.getToCluster()).getInputBlock());
+        } else {
+            assert (c instanceof FigureConnection);
+            w1 = getWidget(c.getFrom().getVertex());
+            w2 = getWidget(c.getTo().getVertex());
         }
-
-        return false;
+        return w1.isVisible() && w2.isVisible();
     }
 
     private void relayout(Set<Widget> oldVisibleWidgets) {
@@ -697,10 +702,21 @@ private void doCFGLayout(HashSet<Figure> figures, HashSet<Connection> edges) {
                 }
             }
         }
-        // Add connections for CFG edges.
-        edges.addAll(diagram.getBlockConnections());
+        // Add visible connections for CFG edges.
+        for (BlockConnection c : diagram.getBlockConnections()) {
+            if (isVisible(c)) {
+                edges.add(c);
+            }
+        }
         m.setSubManager(new LinearLayoutManager(figureRank));
-        m.setClusters(new HashSet<>(diagram.getBlocks()));
+        Set<Block> visibleBlocks = new HashSet<>();
+        for (Block b : diagram.getBlocks()) {
+            BlockWidget w = getWidget(b.getInputBlock());
+            if (w.isVisible()) {
+                visibleBlocks.add(b);
+            }
+        }
+        m.setClusters(new HashSet<>(visibleBlocks));
         m.doLayout(new LayoutGraph(edges, figures));
     }
 
@@ -795,8 +811,9 @@ private void relayoutWithoutLayout(Set<Widget> oldVisibleWidgets) {
 
         if (getModel().getShowCFG()) {
             for (BlockConnection c : diagram.getBlockConnections()) {
-                SceneAnimator anim = animator;
-                processOutputSlot(lastLineCache, null, Collections.singletonList(c), 0, null, null, offx2, offy2, anim);
+                if (isVisible(c)) {
+                    processOutputSlot(lastLineCache, null, Collections.singletonList(c), 0, null, null, offx2, offy2, animator);
+                }
             }
         }
 
@@ -1211,18 +1228,19 @@ private void updateHiddenNodes(Set<Integer> newHiddenNodes, boolean doRelayout)
                     w.setVisible(false);
                 }
             }
-            visibleBlocks.clear();
-            for (InputBlock b : diagram.getGraph().getBlocks()) {
-                if (!b.isArtificial()) {
-                    visibleBlocks.add(b);
-                }
+            if (getModel().getShowEmptyBlocks()) {
+                // Add remaining blocks.
+                visibleBlocks.addAll(diagram.getGraph().getBlocks());
             }
         }
 
         if (getModel().getShowBlocks() || getModel().getShowCFG()) {
             for (InputBlock b : diagram.getGraph().getBlocks()) {
 
-                boolean visibleAfter = visibleBlocks.contains(b);
+                // A block is visible if it is marked as such, except for
+                // artificial or null blocks in the CFG view.
+                boolean visibleAfter = visibleBlocks.contains(b) &&
+                    !(getModel().getShowCFG() && (b.isArtificial() || b.getNodes().isEmpty()));
 
                 BlockWidget w = getWidget(b);
                 if (visibleAfter) {