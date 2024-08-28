@@ -45,7 +45,11 @@
  *
  * @author  Timothy Prinzing
  */
-public class StyleConstants {
+public sealed class StyleConstants
+    permits StyleConstants.CharacterConstants,
+            StyleConstants.ColorConstants,
+            StyleConstants.FontConstants,
+            StyleConstants.ParagraphConstants {
 
     /**
      * Name of elements used to represent components.
@@ -800,7 +804,7 @@ public static void setTabSet(MutableAttributeSet a, TabSet tabs) {
      * attributes that contribute to a paragraph style.  These are
      * aliased by the outer class for general presentation.
      */
-    public static class ParagraphConstants extends StyleConstants
+    public static final class ParagraphConstants extends StyleConstants
         implements AttributeSet.ParagraphAttribute {
 
         private ParagraphConstants(String representation) {
@@ -813,7 +817,7 @@ private ParagraphConstants(String representation) {
      * attributes that contribute to a character style.  These are
      * aliased by the outer class for general presentation.
      */
-    public static class CharacterConstants extends StyleConstants
+    public static final class CharacterConstants extends StyleConstants
         implements AttributeSet.CharacterAttribute {
 
         private CharacterConstants(String representation) {
@@ -826,7 +830,7 @@ private CharacterConstants(String representation) {
      * attributes that contribute to a color.  These are aliased
      * by the outer class for general presentation.
      */
-    public static class ColorConstants extends StyleConstants
+    public static final class ColorConstants extends StyleConstants
         implements AttributeSet.ColorAttribute,  AttributeSet.CharacterAttribute {
 
         private ColorConstants(String representation) {
@@ -839,7 +843,7 @@ private ColorConstants(String representation) {
      * attributes that contribute to a font.  These are aliased
      * by the outer class for general presentation.
      */
-    public static class FontConstants extends StyleConstants
+    public static final class FontConstants extends StyleConstants
         implements AttributeSet.FontAttribute, AttributeSet.CharacterAttribute {
 
         private FontConstants(String representation) {