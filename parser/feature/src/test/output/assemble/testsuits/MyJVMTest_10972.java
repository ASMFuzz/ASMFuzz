public class MyJVMTest_10972 {

    static int i = 0;

    Object getStatic(int i) {
        throw new Error("Invalid static field index " + i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10972().getStatic(i));
    }
}
