public class MyJVMTest_1749 {

    static int i = 2;

    Object getStatic(int i) {
        throw new Error("Invalid static field index " + i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1749().getStatic(i));
    }
}
