public class MyJVMTest_8452 {

    static int next = 1;

    Integer next() {
        try {
            return new Integer(next);
        } finally {
            next <<= 1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8452().next());
    }
}
