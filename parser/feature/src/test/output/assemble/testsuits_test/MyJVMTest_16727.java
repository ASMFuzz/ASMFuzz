public class MyJVMTest_16727 {

    static boolean cond = true;

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
        System.out.println(new MyJVMTest_16727().test(cond));
    }
}
