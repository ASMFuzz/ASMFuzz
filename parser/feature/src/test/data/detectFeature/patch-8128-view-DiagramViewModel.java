@@ -62,6 +62,7 @@ public class DiagramViewModel extends RangeSliderModel implements ChangedListene
     private boolean showBlocks;
     private boolean showCFG;
     private boolean showNodeHull;
+    private boolean showEmptyBlocks;
     private boolean hideDuplicates;
     private ChangedListener<FilterChain> filterChainChangedListener = new ChangedListener<FilterChain>() {
 
@@ -166,6 +167,15 @@ public void setShowNodeHull(boolean b) {
         viewPropertiesChangedEvent.fire();
     }
 
+    public boolean getShowEmptyBlocks() {
+        return showEmptyBlocks;
+    }
+
+    public void setShowEmptyBlocks(boolean b) {
+        showEmptyBlocks = b;
+        viewPropertiesChangedEvent.fire();
+    }
+
     public boolean getHideDuplicates() {
         return hideDuplicates;
     }
@@ -194,6 +204,7 @@ public DiagramViewModel(Group g, FilterChain filterChain, FilterChain sequenceFi
         this.showBlocks = Settings.get().getInt(Settings.DEFAULT_VIEW, Settings.DEFAULT_VIEW_DEFAULT) == Settings.DefaultView.CLUSTERED_SEA_OF_NODES;
         this.showCFG = Settings.get().getInt(Settings.DEFAULT_VIEW, Settings.DEFAULT_VIEW_DEFAULT) == Settings.DefaultView.CONTROL_FLOW_GRAPH;
         this.showNodeHull = true;
+        this.showEmptyBlocks = true;
         this.group = g;
         filterGraphs();
         assert filterChain != null;