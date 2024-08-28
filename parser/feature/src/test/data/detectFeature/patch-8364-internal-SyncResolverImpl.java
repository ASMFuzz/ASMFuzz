@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2004, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2004, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -302,7 +302,7 @@ public void setResolvedValue(int index, Object obj) throws SQLException {
      *        values of a particular row after they have been resolved by
      *        the user to synchronize back to datasource.
      * @throws SQLException if synchronization does not happen properly
-     *         maybe beacuse {@code Connection} has timed out.
+     *         maybe because {@code Connection} has timed out.
      **/
      private void writeData(CachedRowSet row) throws SQLException {
         crw.updateResolvedConflictToDB(row, crw.getReader().connect((RowSetInternal)crsSync));
@@ -661,8 +661,8 @@ public void acceptChanges(Connection con) throws SyncProviderException{
      * Before returning, this method moves the cursor before the first row
      * and sends a {@code rowSetChanged} event to all registered
      * listeners.
-     * @throws SQLException if an error is occurs rolling back the RowSet
-     *           state to the definied original value.
+     * @throws SQLException if an error occurs rolling back the RowSet
+     *           state to the defined original value.
      * @see javax.sql.RowSetListener#rowSetChanged
      */
     public void restoreOriginal() throws SQLException {
@@ -742,7 +742,7 @@ public void undoUpdate() throws SQLException {
     /**
      * Returns a new {@code RowSet} object backed by the same data as
      * that of this {@code CachedRowSetImpl} object and sharing a set of cursors
-     * with it. This allows cursors to interate over a shared set of rows, providing
+     * with it. This allows cursors to iterate over a shared set of rows, providing
      * multiple views of the underlying data.
      *
      * @return a {@code RowSet} object that is a copy of this {@code CachedRowSetImpl}
@@ -851,7 +851,7 @@ public CachedRowSet createCopyNoConstraints() throws SQLException {
 
     /**
      * Converts this {@code CachedRowSetImpl} object to a collection
-     * of tables. The sample implementation utilitizes the {@code TreeMap}
+     * of tables. The sample implementation utilizes the {@code TreeMap}
      * collection type.
      * This class guarantees that the map will be in ascending key order,
      * sorted according to the natural order for the key's class.
@@ -872,7 +872,7 @@ public Collection toCollection() throws SQLException {
     /**
      * Returns the specified column of this {@code CachedRowSetImpl} object
      * as a {@code Collection} object.  This method makes a copy of the
-     * column's data and utilitizes the {@code Vector} to establish the
+     * column's data and utilizes the {@code Vector} to establish the
      * collection. The {@code Vector} class implements a growable array
      * objects allowing the individual components to be accessed using an
      * an integer index similar to that of an array.
@@ -895,7 +895,7 @@ public Collection toCollection(int column) throws SQLException {
     /**
      * Returns the specified column of this {@code CachedRowSetImpl} object
      * as a {@code Collection} object.  This method makes a copy of the
-     * column's data and utilitizes the {@code Vector} to establish the
+     * column's data and utilizes the {@code Vector} to establish the
      * collection. The {@code Vector} class implements a growable array
      * objects allowing the individual components to be accessed using an
      * an integer index similar to that of an array.
@@ -1124,7 +1124,7 @@ public String getString(int columnIndex) throws SQLException {
      * @param columnIndex the first column is {@code 1}, the second
      *        is {@code 2}, and so on; must be {@code 1} or larger
      *        and equal to or less than the number of columns in the rowset
-     * @return the column value as a {@code boolean} in the Java progamming language;
+     * @return the column value as a {@code boolean} in the Java programming language;
      *        if the value is SQL {@code NULL}, the result is {@code false}
      * @throws SQLException if (1) the given column index is out of bounds,
      *            (2) the cursor is not on one of this rowset's rows or its
@@ -1467,7 +1467,7 @@ public java.io.InputStream getUnicodeStream(int columnIndex) throws SQLException
      * (2) the cursor is not on one of this rowset's rows or its
      * insert row, or (3) the designated column does not store an
      * SQL {@code BINARY, VARBINARY} or <b>{@code LONGVARBINARY}</b>.
-     * The bold type indicates the SQL type that this method is recommened
+     * The bold type indicates the SQL type that this method is recommended
      * to retrieve.
      * @see #getBinaryStream(String)
      */
@@ -1829,7 +1829,7 @@ public java.io.InputStream getUnicodeStream(String columnName) throws SQLExcepti
      *         (2) the cursor is not on one of this rowset's rows or its
      *         insert row, or (3) the designated column does not store an
      *         SQL {@code BINARY, VARBINARY} or <b>{@code LONGVARBINARY}</b>
-     *         The bold type indicates the SQL type that this method is recommened
+     *         The bold type indicates the SQL type that this method is recommended
      *         to retrieve.
      * @see #getBinaryStream(int)
      *
@@ -3938,7 +3938,7 @@ public Clob getClob(String colName) throws SQLException {
     /**
      * Retrieves the value of the designated column in this
      * {@code CachedRowSetImpl} object as an {@code Array} object
-     * in the Java programming langugage.
+     * in the Java programming language.
      *
      * @param colName a {@code String} object that must match the
      *        SQL name of a column in this rowset, ignoring case
@@ -4113,7 +4113,7 @@ public Connection getConnection() throws SQLException{
      * with the given {@code RowSetMetaData} object.
      *
      * @param md a {@code RowSetMetaData} object instance containing
-     *            metadata about the columsn in the rowset
+     *            metadata about the columns in the rowset
      * @throws SQLException if invalid meta data is supplied to the
      *            rowset
      */
@@ -4168,7 +4168,7 @@ public void setOriginalRow() throws SQLException {
     /**
      * Marks all rows in this rowset as being original rows. Any updates
      * made to the rows become the original values for the rowset.
-     * Calls to the method {@code setOriginal} connot be reversed.
+     * Calls to the method {@code setOriginal} cannot be reversed.
      *
      * @throws SQLException if an error occurs
      */
@@ -4491,7 +4491,7 @@ public java.net.URL getURL(String columnName) throws SQLException {
      * object is returned. Subsequent {@code CachedRowSetImpl} warnings will
      * be chained to this {@code SQLWarning}. All {@code RowSetWarnings}
      * warnings are generated in the disconnected environment and remain a
-     * seperate warning chain to that provided by the {@code getWarnings}
+     * separate warning chain to that provided by the {@code getWarnings}
      * method.
      *
      * <P>The warning chain is automatically cleared each time a new
@@ -4760,7 +4760,7 @@ public void rowSetPopulated(RowSetEvent event, int numRows) throws SQLException
      *
      * @param data the {@code ResultSet} object containing the data
      *             to be read into this {@code CachedRowSetImpl} object
-     * @param start the integer specifing the position in the
+     * @param start the integer specifying the position in the
      *        {@code ResultSet} object to popultate the
      *        {@code CachedRowSetImpl} object.
      * @throws SQLException if an error occurs; or the max row setting is
@@ -4786,7 +4786,7 @@ public boolean nextPage() throws SQLException {
 
     /**
      * This is the setter function for setting the size of the page, which specifies
-     * how many rows have to be retrived at a time.
+     * how many rows have to be retrieved at a time.
      *
      * @param size which is the page size
      * @throws SQLException if size is less than zero or greater than max rows.