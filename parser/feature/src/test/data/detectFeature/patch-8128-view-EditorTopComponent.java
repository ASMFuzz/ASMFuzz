@@ -99,6 +99,7 @@ public final class EditorTopComponent extends TopComponent implements PropertyCh
     private OverviewAction overviewAction;
     private HideDuplicatesAction hideDuplicatesAction;
     private PredSuccAction predSuccAction;
+    private ShowEmptyBlocksAction showEmptyBlocksAction;
     private SelectionModeAction selectionModeAction;
     private PanModeAction panModeAction;
     private boolean notFirstTime;
@@ -279,6 +280,13 @@ public void changed(DiagramViewModel source) {
         toolBar.add(button);
         predSuccAction.addPropertyChangeListener(this);
 
+        showEmptyBlocksAction = new ShowEmptyBlocksAction();
+        button = new JToggleButton(showEmptyBlocksAction);
+        button.setSelected(true);
+        button.setEnabled(Settings.get().getInt(Settings.DEFAULT_VIEW, Settings.DEFAULT_VIEW_DEFAULT) == Settings.DefaultView.CONTROL_FLOW_GRAPH);
+        toolBar.add(button);
+        showEmptyBlocksAction.addPropertyChangeListener(this);
+
         hideDuplicatesAction = new HideDuplicatesAction();
         hideDuplicatesButton = new JToggleButton(hideDuplicatesAction);
         hideDuplicatesButton.setSelected(false);
@@ -546,6 +554,9 @@ public void propertyChange(PropertyChangeEvent evt) {
         if (evt.getSource() == this.predSuccAction) {
             boolean b = (Boolean) predSuccAction.getValue(PredSuccAction.STATE);
             this.getModel().setShowNodeHull(b);
+        } else if (evt.getSource() == this.showEmptyBlocksAction) {
+            boolean b = (Boolean) showEmptyBlocksAction.getValue(ShowEmptyBlocksAction.STATE);
+            this.getModel().setShowEmptyBlocks(b);
         } else if (evt.getSource() == this.overviewAction) {
             boolean b = (Boolean) overviewAction.getValue(OverviewAction.STATE);
             if (b) {
@@ -556,12 +567,15 @@ public void propertyChange(PropertyChangeEvent evt) {
         } else if (evt.getSource() == this.seaLayoutAction) {
             boolean b = seaLayoutAction.isSelected();
             this.getModel().setShowSea(b);
+            this.showEmptyBlocksAction.setEnabled(false);
         } else if (evt.getSource() == this.blockLayoutAction) {
             boolean b = blockLayoutAction.isSelected();
             this.getModel().setShowBlocks(b);
+            this.showEmptyBlocksAction.setEnabled(false);
         } else if (evt.getSource() == this.cfgLayoutAction) {
             boolean b = cfgLayoutAction.isSelected();
             this.getModel().setShowCFG(b);
+            this.showEmptyBlocksAction.setEnabled(true);
         } else if (evt.getSource() == this.hideDuplicatesAction) {
             boolean b = (Boolean) hideDuplicatesAction.getValue(HideDuplicatesAction.STATE);
             this.getModel().setHideDuplicates(b);