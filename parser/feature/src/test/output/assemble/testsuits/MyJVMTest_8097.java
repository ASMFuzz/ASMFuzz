public class MyJVMTest_8097 {

    static int i = 9;

    int m1(int i) {
        try {
            return 0;
        } finally {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8097().m1(i));
    }
}
