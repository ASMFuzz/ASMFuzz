public class MyJVMTest_17667 {

    static int i = 4;

    int m1(int i) {
        try {
            return 0;
        } finally {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17667().m1(i));
    }
}
