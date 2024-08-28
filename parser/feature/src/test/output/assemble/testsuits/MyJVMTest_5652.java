public class MyJVMTest_5652 {

    static int field = 0;

    void test2() {
        for (int i = 5; i > -10; i--) {
            switch(i) {
                case 0:
                case 4:
                case 10:
                case 20:
                case 30:
                case 40:
                case 50:
                case 100:
                    field = 42;
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5652().test2();
    }
}
