@@ -202,7 +202,7 @@ List<VisibleMemberTable> getAllSuperinterfaces() {
      * a. The list may or may not contain simple overridden methods.
      * A simple overridden method is one that overrides a super method
      * with no specification changes as indicated by the existence of a
-     * sole {@code @inheritDoc} or devoid of any API comments.
+     * sole {@code {@inheritDoc}} or devoid of any API comments.
      * <p>
      * b.The list may contain (extra) members, inherited by inaccessible
      * super types, primarily package private types. These members are