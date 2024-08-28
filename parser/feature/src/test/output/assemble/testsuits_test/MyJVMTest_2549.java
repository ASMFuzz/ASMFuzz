public class MyJVMTest_2549 {

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
        System.out.println(new MyJVMTest_2549().toString());
    }
}
