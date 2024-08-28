public class MyJVMTest_16952 {

    static int expected = 1499197691;

    static String label = "qO?&Iqwzq\"";

    static int x = 1;

    static Object o = 2;

    static String s = "CT/izn*07G";

    int check(int expected, String label) {
        if (x != expected) {
            StringBuilder sb = new StringBuilder();
            sb.append(label);
            sb.append(": ");
            sb.append("Expected = ");
            sb.append(expected);
            sb.append("actual = ");
            sb.append(x);
            throw new IllegalStateException(sb.toString());
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16952().check(expected, label);
    }
}
