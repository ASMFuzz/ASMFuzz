public class MyJVMTest_14012 {

    void test4() {
        int local = 0;
        for (int i = 5; i > -20; i -= 5) {
            switch(i) {
                case 0:
                case 10:
                case 20:
                case 30:
                case 40:
                case 50:
                case 100:
                    local = 42;
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14012().test4();
    }
}
