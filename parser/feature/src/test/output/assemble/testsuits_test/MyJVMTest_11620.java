public class MyJVMTest_11620 {

    void test6() {
        int local;
        for (int i = 25; i > 0; i -= 5) {
            switch(i + 10) {
                case 30:
                case 40:
                case 50:
                case 60:
                case 70:
                case 80:
                case 300:
                    local = 42;
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11620().test6();
    }
}
