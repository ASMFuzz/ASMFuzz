public class MyJVMTest_11185 {

    static Class[] classes = { null, null, null, null, null, null, null, null, null, null };

    static int depth = 0;

    static int tid = 1270770181;

    static String[] classnames = { "java.text.DecimalFormat", "java.text.MessageFormat", "java.util.GregorianCalendar", "java.util.ResourceBundle", "java.text.Collator", "java.util.Date", "java.io.Reader", "java.io.Writer", "java.lang.IllegalAccessException", "java.lang.InstantiationException", "java.lang.ClassNotFoundException", "java.lang.CloneNotSupportedException", "java.lang.InterruptedException", "java.lang.NoSuchFieldException", "java.lang.NoSuchMethodException", "java.lang.RuntimeException", "java.lang.ArithmeticException", "java.lang.ArrayStoreException", "java.lang.ClassCastException", "java.lang.StringIndexOutOfBoundsException", "java.lang.NegativeArraySizeException", "java.lang.IllegalStateException", "java.lang.IllegalArgumentException", "java.lang.NumberFormatException", "java.lang.IllegalThreadStateException", "java.lang.IllegalMonitorStateException", "java.lang.SecurityException", "java.lang.ExceptionInInitializerError" };

    Class[] fillClasses(Class[] classes) {
        for (int i = 0; i < classes.length; i++) {
            try {
                classes[i] = Class.forName(classnames[i]);
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
        }
        return classes;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11185().fillClasses(classes);
    }
}
