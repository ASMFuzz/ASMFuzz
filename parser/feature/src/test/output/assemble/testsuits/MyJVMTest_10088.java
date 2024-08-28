public class MyJVMTest_10088 {

    static int next = 1;

    boolean hasNext() {
        return next <= (1 << 12);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10088().hasNext());
    }
}
