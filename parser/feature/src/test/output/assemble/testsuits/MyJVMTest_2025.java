public class MyJVMTest_2025 {

    void callingMethod(final String parameter) {
        String t = "12345";
        final String local_var = t;
        BaseClass enum_ = new BaseClass() {

            public void x() {
                int i = parameter.length() + local_var.length();
                if (i != 13)
                    throw new Error();
            }
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2025().x();
    }
}
