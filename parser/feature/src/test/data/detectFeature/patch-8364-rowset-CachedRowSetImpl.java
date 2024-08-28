@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -397,7 +397,7 @@ public SyncProvider run() throws SyncFactoryException {
         onInsertRow = false;
         insertRow = null;
 
-        // set the warninings
+        // set the warnings
         sqlwarn = new SQLWarning();
         rowsetWarning = new RowSetWarning();
 
@@ -446,7 +446,7 @@ public SyncProvider run() throws SyncFactoryException {
      * optimistic provider <code>com.sun.rowset.providers.RIOptimisticProvider</code>.
      * <p>
      * In addition, the following properties can be associated with the
-     * provider to assist in determining the choice of the synchronizaton
+     * provider to assist in determining the choice of the synchronization
      * provider such as:
      * <ul>
      * <li><code>ROWSET_SYNC_PROVIDER</code> - the property specifying the
@@ -459,7 +459,7 @@ public SyncProvider run() throws SyncFactoryException {
      * software vendor.
      * </ul>
      * More specific detailes are available in the <code>SyncFactory</code>
-     * and <code>SyncProvider</code> specificiations later in this document.
+     * and <code>SyncProvider</code> specifications later in this document.
      * <p>
      * @param env a <code>Hashtable</code> object with a list of desired
      *        synchronization providers
@@ -967,8 +967,8 @@ public void acceptChanges(Connection con) throws SyncProviderException{
      * Before returning, this method moves the cursor before the first row
      * and sends a <code>rowSetChanged</code> event to all registered
      * listeners.
-     * @throws SQLException if an error is occurs rolling back the RowSet
-     *           state to the definied original value.
+     * @throws SQLException if an error occurs rolling back the RowSet
+     *           state to the defined original value.
      * @see javax.sql.RowSetListener#rowSetChanged
      */
     public void restoreOriginal() throws SQLException {
@@ -1108,7 +1108,7 @@ public void undoUpdate() throws SQLException {
     /**
      * Returns a new <code>RowSet</code> object backed by the same data as
      * that of this <code>CachedRowSetImpl</code> object and sharing a set of cursors
-     * with it. This allows cursors to interate over a shared set of rows, providing
+     * with it. This allows cursors to iterate over a shared set of rows, providing
      * multiple views of the underlying data.
      *
      * @return a <code>RowSet</code> object that is a copy of this <code>CachedRowSetImpl</code>
@@ -1285,7 +1285,7 @@ public CachedRowSet createCopyNoConstraints() throws SQLException {
 
     /**
      * Converts this <code>CachedRowSetImpl</code> object to a collection
-     * of tables. The sample implementation utilitizes the <code>TreeMap</code>
+     * of tables. The sample implementation utilizes the <code>TreeMap</code>
      * collection type.
      * This class guarantees that the map will be in ascending key order,
      * sorted according to the natural order for the key's class.
@@ -1312,7 +1312,7 @@ public Collection<?> toCollection() throws SQLException {
     /**
      * Returns the specified column of this <code>CachedRowSetImpl</code> object
      * as a <code>Collection</code> object.  This method makes a copy of the
-     * column's data and utilitizes the <code>Vector</code> to establish the
+     * column's data and utilizes the <code>Vector</code> to establish the
      * collection. The <code>Vector</code> class implements a growable array
      * objects allowing the individual components to be accessed using an
      * an integer index similar to that of an array.
@@ -1348,7 +1348,7 @@ public Collection<?> toCollection(int column) throws SQLException {
     /**
      * Returns the specified column of this <code>CachedRowSetImpl</code> object
      * as a <code>Collection</code> object.  This method makes a copy of the
-     * column's data and utilitizes the <code>Vector</code> to establish the
+     * column's data and utilizes the <code>Vector</code> to establish the
      * collection. The <code>Vector</code> class implements a growable array
      * objects allowing the individual components to be accessed using an
      * an integer index similar to that of an array.
@@ -1734,7 +1734,7 @@ public String getString(int columnIndex) throws SQLException {
      * @param columnIndex the first column is <code>1</code>, the second
      *        is <code>2</code>, and so on; must be <code>1</code> or larger
      *        and equal to or less than the number of columns in the rowset
-     * @return the column value as a <code>boolean</code> in the Java progamming language;
+     * @return the column value as a <code>boolean</code> in the Java programming language;
      *        if the value is SQL <code>NULL</code>, the result is <code>false</code>
      * @throws SQLException if (1) the given column index is out of bounds,
      *            (2) the cursor is not on one of this rowset's rows or its
@@ -2438,7 +2438,7 @@ public java.io.InputStream getUnicodeStream(int columnIndex) throws SQLException
      * (2) the cursor is not on one of this rowset's rows or its
      * insert row, or (3) the designated column does not store an
      * SQL <code>BINARY, VARBINARY</code> or <code><b>LONGVARBINARY</b></code>
-     * The bold type indicates the SQL type that this method is recommened
+     * The bold type indicates the SQL type that this method is recommended
      * to retrieve.
      * @see #getBinaryStream(String)
      */
@@ -2818,7 +2818,7 @@ public java.io.InputStream getUnicodeStream(String columnName) throws SQLExcepti
      * (2) the cursor is not on one of this rowset's rows or its
      * insert row, or (3) the designated column does not store an
      * SQL <code>BINARY, VARBINARY</code> or <code><b>LONGVARBINARY</b></code>
-     * The bold type indicates the SQL type that this method is recommened
+     * The bold type indicates the SQL type that this method is recommended
      * to retrieve.
      * @see #getBinaryStream(int)
      *
@@ -3516,7 +3516,7 @@ public boolean absolute( int row ) throws SQLException {
             throw new SQLException(resBundle.handleGetObject("cachedrowsetimpl.absolute").toString());
         }
 
-        if (row > 0) { // we are moving foward
+        if (row > 0) { // we are moving forward
             if (row > numRows) {
                 // fell off the end
                 afterLast();
@@ -3872,7 +3872,7 @@ public boolean rowDeleted() throws SQLException {
     }
 
     /**
-     * Indicates whether the given SQL data type is a numberic type.
+     * Indicates whether the given SQL data type is a numeric type.
      *
      * @param type one of the constants from <code>java.sql.Types</code>
      * @return <code>true</code> if the given type is <code>NUMERIC</code>,'
@@ -5985,7 +5985,7 @@ public Clob getClob(String colName) throws SQLException {
     /**
      * Retrieves the value of the designated column in this
      * <code>CachedRowSetImpl</code> object as an <code>Array</code> object
-     * in the Java programming langugage.
+     * in the Java programming language.
      *
      * @param colName a <code>String</code> object that must match the
      *        SQL name of a column in this rowset, ignoring case
@@ -6269,7 +6269,7 @@ public Connection getConnection() throws SQLException{
      * with the given <code>RowSetMetaData</code> object.
      *
      * @param md a <code>RowSetMetaData</code> object instance containing
-     *            metadata about the columsn in the rowset
+     *            metadata about the columns in the rowset
      * @throws SQLException if invalid meta data is supplied to the
      *            rowset
      */
@@ -6385,7 +6385,7 @@ private void makeRowOriginal(Row row) {
     /**
      * Marks all rows in this rowset as being original rows. Any updates
      * made to the rows become the original values for the rowset.
-     * Calls to the method <code>setOriginal</code> connot be reversed.
+     * Calls to the method <code>setOriginal</code> cannot be reversed.
      *
      * @throws SQLException if an error occurs
      */
@@ -6804,7 +6804,7 @@ public java.net.URL getURL(String columnName) throws SQLException {
      * object is returned. Subsequent <code>CachedRowSetImpl</code> warnings will
      * be chained to this <code>SQLWarning</code>. All <code>RowSetWarnings</code>
      * warnings are generated in the disconnected environment and remain a
-     * seperate warning chain to that provided by the <code>getWarnings</code>
+     * separate warning chain to that provided by the <code>getWarnings</code>
      * method.
      *
      * <P>The warning chain is automatically cleared each time a new
@@ -6864,7 +6864,7 @@ private String buildTableName(String command) throws SQLException {
                 int idxWhere = tabName.toLowerCase().indexOf("where");
 
                 /**
-                  * Adding the addtional check for conditions following the table name.
+                  * Adding the additional check for conditions following the table name.
                   * If a condition is found truncate it.
                   **/
 
@@ -7240,7 +7240,7 @@ public void rowSetPopulated(RowSetEvent event, int numRows) throws SQLException
      *
      * @param data the <code>ResultSet</code> object containing the data
      *             to be read into this <code>CachedRowSetImpl</code> object
-     * @param start the integer specifing the position in the
+     * @param start the integer specifying the position in the
      *        <code>ResultSet</code> object to popultate the
      *        <code>CachedRowSetImpl</code> object.
      * @throws SQLException if an error occurs; or the max row setting is
@@ -7421,7 +7421,7 @@ public boolean nextPage() throws SQLException {
 
     /**
      * This is the setter function for setting the size of the page, which specifies
-     * how many rows have to be retrived at a time.
+     * how many rows have to be retrieved at a time.
      *
      * @param size which is the page size
      * @throws SQLException if size is less than zero or greater than max rows.
@@ -7526,7 +7526,7 @@ public boolean absolutePage(int page) throws SQLException{
         int counter;
 
         if( page <= 0 ){
-            throw new SQLException("Absolute positoin is invalid");
+            throw new SQLException("Absolute position is invalid");
         }
         counter = 0;
 
@@ -7551,7 +7551,7 @@ else if(counter == page){
 
     /**
      * Goes to the page number passed as the parameter  from the current page.
-     * The parameter can take postive or negative value accordingly.
+     * The parameter can take positive or negative value accordingly.
      * @param page , the page loaded on a call to this function
      * @return true if the page exists false otherwise
      * @throws SQLException if an error occurs
@@ -7629,7 +7629,7 @@ public boolean firstPage() throws SQLException {
     */
 
     /**
-     * Retrives the last page of data as specified by the page size.
+     * Retrieves the last page of data as specified by the page size.
      * @return boolean value tur if present on the last page, false otherwise
      * @throws SQLException if called before populate or if an error occurs.
      */