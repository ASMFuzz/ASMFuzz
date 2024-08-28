@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -406,12 +406,12 @@ public void addRowSet(RowSet[] rowset,
      * Returns a Collection of the <code>RowSet</code> object instances
      * currently residing with the instance of the <code>JoinRowSet</code>
      * object instance. This should return the 'n' number of RowSet contained
-     * within the JOIN and maintain any updates that have occoured while in
+     * within the JOIN and maintain any updates that have occurred while in
      * this union.
      *
      * @return A <code>Collection</code> of the added <code>RowSet</code>
      * object instances
-     * @throws SQLException if an error occours generating a collection
+     * @throws SQLException if an error occurs generating a collection
      * of the originating RowSets contained within the JOIN.
      */
     @SuppressWarnings("rawtypes")
@@ -424,7 +424,7 @@ public Collection getRowSets() throws SQLException {
      * with the <code>JoinRowSet</code> object instance.
      *
      * @return a string array of the RowSet names
-     * @throws SQLException if an error occours retrieving the RowSet names
+     * @throws SQLException if an error occurs retrieving the RowSet names
      * @see CachedRowSet#setTableName
      */
     public String[] getRowSetNames() throws SQLException {
@@ -633,10 +633,10 @@ private void initJOIN(CachedRowSet rowset) throws SQLException {
                 // Now we have two rowsets crsInternal and cRowset which need
                 // to be INNER JOIN'ED to form a new rowset
                 // Compare table1.MatchColumn1.value1 == { table2.MatchColumn2.value1
-                //                              ... upto table2.MatchColumn2.valueN }
+                //                              ... up to table2.MatchColumn2.valueN }
                 //     ...
                 // Compare table1.MatchColumn1.valueM == { table2.MatchColumn2.value1
-                //                              ... upto table2.MatchColumn2.valueN }
+                //                              ... up to table2.MatchColumn2.valueN }
                 //
                 // Assuming first rowset has M rows and second N rows.
 
@@ -682,7 +682,7 @@ private void initJOIN(CachedRowSet rowset) throws SQLException {
                              if (match) {
 
                                 int p;
-                                int colc = 0;   // reset this variable everytime you loop
+                                int colc = 0;   // reset this variable every time you loop
                                 // re create a JoinRowSet in crsTemp object
                                 crsTemp.moveToInsertRow();
 
@@ -863,8 +863,8 @@ private void initJOIN(CachedRowSet rowset) throws SQLException {
      * strings description of <code>JOIN</code> or provide a textual description to assist
      * applications using a <code>JoinRowSet</code>.
      *
-     * @return whereClause a textual or SQL descripition of the logical
-     * <code>WHERE</code> cluase used in the <code>JoinRowSet</code> instance
+     * @return whereClause a textual or SQL description of the logical
+     * <code>WHERE</code> clause used in the <code>JoinRowSet</code> instance
      * @throws SQLException if an error occurs in generating a representation
      * of the <code>WHERE</code> clause.
      */
@@ -1769,7 +1769,7 @@ public Object getObject(String columnName) throws SQLException {
     /**
      * Retrieves the value of the designated column in this
      * <code>JoinRowSetImpl</code> object as an <code>Object</code> in
-     * the Java programming lanugage, using the given
+     * the Java programming language, using the given
      * <code>java.util.Map</code> object to custom map the value if
      * appropriate.
      *
@@ -2185,7 +2185,7 @@ public boolean rowUpdated() throws SQLException {
      * <code>false</code> will always be returned if it does not detect updates.
      *
      * @return <code>true</code> if the column updated
-     *          <code>false</code> otherwse
+     *          <code>false</code> otherwise
      * @throws SQLException if the cursor is on the insert row or not
      *          on a valid row
      * @see DatabaseMetaData#updatesAreDetected
@@ -3428,7 +3428,7 @@ public Statement getStatement() throws SQLException {
     /**
      * Retrieves the value of the designated column in this
      * <code>JoinRowSetImpl</code> object as a <code>Ref</code> object
-     * in the Java programming lanugage.
+     * in the Java programming language.
      *
      * @param columnIndex the first column is <code>1</code>, the second
      *        is <code>2</code>, and so on; must be <code>1</code> or larger
@@ -3446,7 +3446,7 @@ public Ref getRef(int columnIndex) throws SQLException {
     /**
      * Retrieves the value of the designated column in this
      * <code>JoinRowSetImpl</code> object as a <code>Blob</code> object
-     * in the Java programming lanugage.
+     * in the Java programming language.
      *
      * @param columnIndex the first column is <code>1</code>, the second
      *        is <code>2</code>, and so on; must be <code>1</code> or larger
@@ -3464,7 +3464,7 @@ public Blob getBlob(int columnIndex) throws SQLException {
     /**
      * Retrieves the value of the designated column in this
      * <code>JoinRowSetImpl</code> object as a <code>Clob</code> object
-     * in the Java programming lanugage.
+     * in the Java programming language.
      *
      * @param columnIndex the first column is <code>1</code>, the second
      *        is <code>2</code>, and so on; must be <code>1</code> or larger
@@ -3482,7 +3482,7 @@ public Clob getClob(int columnIndex) throws SQLException {
     /**
      * Retrieves the value of the designated column in this
      * <code>JoinRowSetImpl</code> object as an <code>Array</code> object
-     * in the Java programming lanugage.
+     * in the Java programming language.
      *
      * @param columnIndex the first column is <code>1</code>, the second
      *        is <code>2</code>, and so on; must be <code>1</code> or larger
@@ -3503,7 +3503,7 @@ public Array getArray(int columnIndex) throws SQLException {
     /**
      * Retrieves the value of the designated column in this
      * <code>JoinRowSetImpl</code> object as a <code>Ref</code> object
-     * in the Java programming lanugage.
+     * in the Java programming language.
      *
      * @param columnName a <code>String</code> object that must match the
      *        SQL name of a column in this rowset, ignoring case
@@ -3520,7 +3520,7 @@ public Ref getRef(String columnName) throws SQLException {
     /**
      * Retrieves the value of the designated column in this
      * <code>JoinRowSetImpl</code> object as a <code>Blob</code> object
-     * in the Java programming lanugage.
+     * in the Java programming language.
      *
      * @param columnName a <code>String</code> object that must match the
      *        SQL name of a column in this rowset, ignoring case
@@ -3538,7 +3538,7 @@ public Blob getBlob(String columnName) throws SQLException {
     /**
      * Retrieves the value of the designated column in this
      * <code>JoinRowSetImpl</code> object as a <code>Clob</code> object
-     * in the Java programming lanugage.
+     * in the Java programming language.
      *
      * @param columnName a <code>String</code> object that must match the
      *        SQL name of a column in this rowset, ignoring case
@@ -3556,7 +3556,7 @@ public Clob getClob(String columnName) throws SQLException {
     /**
      * Retrieves the value of the designated column in this
      * <code>JoinRowSetImpl</code> object as an <code>Array</code> object
-     * in the Java programming lanugage.
+     * in the Java programming language.
      *
      * @param columnName a <code>String</code> object that must match the
      *        SQL name of a column in this rowset, ignoring case
@@ -3712,7 +3712,7 @@ public java.sql.Timestamp getTimestamp(String columnName, Calendar cal) throws S
     * with the given <code>RowSetMetaData</code> object.
     *
     * @param md a <code>RowSetMetaData</code> object instance containing
-    *            metadata about the columsn in the rowset
+    *            metadata about the columns in the rowset
     * @throws SQLException if invalid meta data is supplied to the
     *            rowset
     */
@@ -4050,7 +4050,7 @@ public void execute() throws SQLException {
      *           connection to the datasource
      * @throws SQLException if an invalid <code>Connection</code> is supplied
      *           or an error occurs in establishing the connection to the
-     *           data soure
+     *           data source
      * @see java.sql.Connection
      */
     public void execute(Connection conn) throws SQLException {
@@ -4226,7 +4226,7 @@ public void removeRowSetListener(RowSetListener listener) {
 
     /**
      * Converts this <code>JoinRowSetImpl</code> object to a collection
-     * of tables. The sample implementation utilitizes the <code>TreeMap</code>
+     * of tables. The sample implementation utilizes the <code>TreeMap</code>
      * collection type.
      * This class guarantees that the map will be in ascending key order,
      * sorted according to the natural order for the key's class.
@@ -4246,7 +4246,7 @@ public Collection<?> toCollection() throws SQLException {
     /**
      * Returns the specified column of this <code>JoinRowSetImpl</code> object
      * as a <code>Collection</code> object.  This method makes a copy of the
-     * column's data and utilitizes the <code>Vector</code> to establish the
+     * column's data and utilizes the <code>Vector</code> to establish the
      * collection. The <code>Vector</code> class implements a growable array
      * objects allowing the individual components to be accessed using an
      * an integer index similar to that of an array.
@@ -4268,7 +4268,7 @@ public Collection<?> toCollection(int column) throws SQLException {
     /**
      * Returns the specified column of this <code>JoinRowSetImpl</code> object
      * as a <code>Collection</code> object.  This method makes a copy of the
-     * column's data and utilitizes the <code>Vector</code> to establish the
+     * column's data and utilizes the <code>Vector</code> to establish the
      * collection. The <code>Vector</code> class implements a growable array
      * objects allowing the individual components to be accessed using an
      * an integer index similar to that of an array.