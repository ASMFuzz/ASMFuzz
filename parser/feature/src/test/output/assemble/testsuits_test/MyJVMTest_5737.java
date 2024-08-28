public class MyJVMTest_5737 {

    static int i = 0;

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

    int m1(int i) {
        try {
            return 0;
        } finally {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5737().m1(i));
    }
}
