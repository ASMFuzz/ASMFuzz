public class MyJVMTest_3683 {

    void test5() {
        int local;
        for (int i = 25; i > 0; i -= 5) {
            switch(i) {
                case 20:
                case 30:
                case 40:
                case 50:
                case 60:
                case 70:
                case 300:
                    local = 42;
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3683().test5();
    }
}
