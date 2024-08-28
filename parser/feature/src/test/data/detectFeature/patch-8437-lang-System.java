@@ -732,6 +732,9 @@ public static native void arraycopy(Object src,  int  srcPos,
      *     <td>Java Runtime Environment specification version, whose value is
      *     the {@linkplain Runtime.Version#feature feature} element of the
      *     {@linkplain Runtime#version() runtime version}</td></tr>
+     * <tr><th scope="row">{@systemProperty java.specification.maintenance.version}</th>
+     *     <td>Java Runtime Environment specification maintenance version,
+     *     may be interpreted as a positive integer <em>(optional, see below)</em></td></tr>
      * <tr><th scope="row">{@systemProperty java.specification.vendor}</th>
      *     <td>Java Runtime Environment specification  vendor</td></tr>
      * <tr><th scope="row">{@systemProperty java.specification.name}</th>
@@ -779,6 +782,16 @@ public static native void arraycopy(Object src,  int  srcPos,
      * </tbody>
      * </table>
      * <p>
+     * The {@code java.specification.maintenance.version} property is
+     * defined if the specification implemented by this runtime at the
+     * time of its construction had undergone a <a
+     * href="https://jcp.org/en/procedures/jcp2#3.6.4">maintenance
+     * release</a>. When defined, its value identifies that
+     * maintenance release. To indicate the first maintenance release
+     * this property will have the value {@code "1"}, to indicate the
+     * second maintenance release this property will have the value
+     * {@code "2"}, and so on.
+     * <p>
      * Multiple paths in a system property value are separated by the path
      * separator character of the platform.
      * <p>