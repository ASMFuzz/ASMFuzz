import javax.naming.ldap.Rdn;

public class MyJVMTest_3882 {

    static Object[] values = { 3, 2, 0, 406330019, -1856481619, 0, 7, 2, 0, 701241025 };

    Object[] printEscapedVal(Object[] values) {
        String escVal;
        for (int i = 0; i < values.length; i++) {
            escVal = Rdn.escapeValue(values[i]);
            System.out.println("Orig val: " + values[i] + "       Escaped val: " + escVal);
        }
        return values;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3882().printEscapedVal(values);
    }
}
