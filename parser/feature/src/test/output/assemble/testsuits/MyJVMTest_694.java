public class MyJVMTest_694 {

    static int field = 0;

    void test3() {
        for (int i = 5; i > -20; i -= 5) {
            switch(i) {
                case 0:
                case 10:
                case 20:
                case 30:
                case 40:
                case 50:
                case 60:
                case 100:
                    field = 42;
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_694().test3();
    }
}
