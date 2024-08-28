public class MyJVMTest_7673 {

    static int p = 8;

    int problematicMethod(int p) {
        switch(p) {
            case 3:
                long n;
                while (true) {
                    if (false) {
                        break;
                    }
                }
                break;
            case 2:
                loop: while (true) {
                    while (true) {
                        int i = 4;
                        if (p != 16) {
                            return;
                        }
                        break loop;
                    }
                }
                break;
            default:
                while (true) {
                    if (false) {
                        break;
                    }
                }
                break;
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
        new MyJVMTest_7673().problematicMethod(p);
    }
}
