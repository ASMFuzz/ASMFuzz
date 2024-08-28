public class MyJVMTest_5359 {

    int test0() {
        int res = 0;
        for (int i = 10; i < 50; ++i) {
            switch(i * 5) {
                case 15:
                case 25:
                case 40:
                case 101:
                    return 42;
                case 45:
                case 51:
                case 60:
                    res++;
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5359().test0());
    }
}
