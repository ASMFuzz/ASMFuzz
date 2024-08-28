public class MyJVMTest_13605 {

    static int i = -1256583117;

    @SuppressWarnings("finally")
    static int x = new Finally2() {

        int m1(int i) {
            try {
                return 0;
            } finally {
                throw new IllegalArgumentException();
            }
        }
    }.m1(0);

    int m2(int i) {
        try {
            return 0;
        } finally {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13605().m2(i));
    }
}
