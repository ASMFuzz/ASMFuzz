@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -603,9 +603,9 @@ private boolean updateOriginalRow(CachedRowSet crs)
                 // reset boolNull if it had been set
                 boolNull = true;
 
-                /** This addtional checking has been added when the current value
+                /** This additional checking has been added when the current value
                  *  in the DB is null, but the DB had a different value when the
-                 *  data was actaully fetched into the CachedRowSet.
+                 *  data was actually fetched into the CachedRowSet.
                  **/
 
                 if(rsval == null && orig != null) {
@@ -638,7 +638,7 @@ else if(rsval != null && (!rsval.equals(orig)))
                      objVal = rsval;
                 } else if (  (orig == null || curr == null) ) {
 
-                        /** Adding the additonal condition of checking for "flag"
+                        /** Adding the additional condition of checking for "flag"
                          *  boolean variable, which would otherwise result in
                          *  building a invalid query, as the comma would not be
                          *  added to the query string.
@@ -1171,7 +1171,7 @@ private void initSQLStatements(CachedRowSet caller) throws SQLException {
         deleteCmd = "DELETE FROM " + buildTableName(dbmd, catalog, schema, table);
 
         /*
-         * set the key desriptors that will be
+         * set the key descriptors that will be
          * needed to construct where clauses.
          */
         buildKeyDesc(caller);