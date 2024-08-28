public class MyJVMTest_11694 {

    static javax.swing.JComponent obj = null;

    static java.beans.PropertyChangeListener listener = new java.beans.PropertyChangeListener() {

        public void propertyChange(java.beans.PropertyChangeEvent ev) {
        }

        public void xwait(javax.swing.JComponent obj) {
            obj.removePropertyChangeListener(listener);
        }
    };

    javax.swing.JComponent xwait(javax.swing.JComponent obj) {
        obj.removePropertyChangeListener(listener);
        return obj;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11694().xwait(obj);
    }
}
