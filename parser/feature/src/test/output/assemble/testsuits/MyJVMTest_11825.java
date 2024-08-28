public class MyJVMTest_11825 {

    void test() {
        final int b;
        b = 10;
        class Local1 {

            public String toString() {
                return "" + b;
            }
        }
        class Local2 {

            void test() {
                final int b;
                b = 20;
                class DeepLocal extends Local1 {

                    public String toString() {
                        return "" + b;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11825().toString());
    }
}
