@@ -27,15 +27,22 @@
 import com.sun.hotspot.igv.data.*;
 import com.sun.hotspot.igv.data.services.Scheduler;
 import com.sun.hotspot.igv.difference.Difference;
-import com.sun.hotspot.igv.filter.CustomFilter;
+import com.sun.hotspot.igv.filter.ColorFilter;
 import com.sun.hotspot.igv.filter.FilterChain;
 import com.sun.hotspot.igv.graph.Diagram;
 import com.sun.hotspot.igv.graph.Figure;
+import com.sun.hotspot.igv.graph.MatcherSelector;
 import com.sun.hotspot.igv.settings.Settings;
 import com.sun.hotspot.igv.util.RangeSliderModel;
 import java.awt.Color;
-import java.util.*;
 import org.openide.util.Lookup;
+import java.util.Arrays;
+import java.util.ArrayList;
+import java.util.Collection;
+import java.util.HashSet;
+import java.util.Iterator;
+import java.util.List;
+import java.util.Set;
 
 /**
  *
@@ -431,6 +438,10 @@ public void selectGraph(InputGraph g) {
         setPositions(index, index);
     }
 
+    private static ColorFilter.ColorRule stateColorRule(String state, Color color) {
+        return new ColorFilter.ColorRule(new MatcherSelector(new Properties.RegexpPropertyMatcher("state", state)), color);
+    }
+
     public Diagram getDiagramToView() {
 
         if (diagram == null) {
@@ -447,11 +458,11 @@ public Diagram getDiagramToView() {
                                             Settings.get().get(Settings.NODE_TINY_TEXT, Settings.NODE_TINY_TEXT_DEFAULT));
             getFilterChain().apply(diagram, getSequenceFilterChain());
             if (getFirstPosition() != getSecondPosition()) {
-                CustomFilter f = new CustomFilter(
-                        "difference", "colorize('state', 'same', white);"
-                        + "colorize('state', 'changed', orange);"
-                        + "colorize('state', 'new', green);"
-                        + "colorize('state', 'deleted', red);");
+                ColorFilter f = new ColorFilter("");
+                f.addRule(stateColorRule("same",    Color.white));
+                f.addRule(stateColorRule("changed", Color.orange));
+                f.addRule(stateColorRule("new",     Color.green));
+                f.addRule(stateColorRule("deleted", Color.red));
                 f.apply(diagram);
            }
         }