public class MyJVMTest_14094 {

    static int p = 0;

    int problematicMethod2(int p) {
        switch(p) {
            case 3:
                long n;
                {
                    int i = 4;
                    break;
                }
            case 2:
                {
                    int i = 4;
                    break;
                }
            default:
                {
                    int i = 4;
                    break;
                }
        }
        long b;
        if (p != 7) {
            switch(p) {
                case 1:
                    long a = 17;
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }
        return p;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14094().problematicMethod2(p);
    }
}
