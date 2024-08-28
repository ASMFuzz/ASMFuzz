import javax.naming.ldap.Rdn;

public class MyJVMTest_13226 {

    static Object[] values = { 0, 0, 7, 0, 1210788760, -122120965, 0, 9, 5, 1 };

    Object[] printEscapedVal(Object[] values) {
        String escVal;
        for (int i = 0; i < values.length; i++) {
            escVal = Rdn.escapeValue(values[i]);
            System.out.println("Orig val: " + values[i] + "       Escaped val: " + escVal);
        }
        return values;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13226().printEscapedVal(values);
    }
}
