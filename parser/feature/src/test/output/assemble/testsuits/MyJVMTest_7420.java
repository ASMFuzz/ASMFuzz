public class MyJVMTest_7420 {

    static int expected = 7;

    static String label = "Dk)n\\S DOa";

    static int x = 2;

    static Object o = 0;

    static String s = "~HQnMKdGx{";

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
        new MyJVMTest_7420().check(expected, label);
    }
}
