public class MyJVMTest_7204 {

    static boolean cond = false;

    String test(boolean cond) {
        final String s;
        try {
            if (cond) {
                try {
                    s = "";
                    return s;
                } finally {
                }
            } else {
                s = "";
            }
            return s;
        } finally {
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7204().test(cond));
    }
}
