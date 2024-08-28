public class MyJVMTest_4239 {

    static int i = 1185869038;

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
        System.out.println(new MyJVMTest_4239().m2(i));
    }
}
