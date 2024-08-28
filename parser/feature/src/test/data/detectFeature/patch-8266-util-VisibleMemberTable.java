@@ -463,7 +463,8 @@ void computeVisibleMembers(LocalMemberTable lmt, Kind kind) {
     }
 
     private boolean mustDocument(Element e) {
-        return !utils.hasHiddenTag(e) && utils.shouldDocument(e);
+        // these checks are ordered in a particular way to avoid parsing unless absolutely necessary
+        return utils.shouldDocument(e) && !utils.hasHiddenTag(e);
     }
 
     private boolean allowInheritedMembers(Element e, Kind kind, LocalMemberTable lmt) {