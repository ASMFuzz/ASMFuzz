public class MyJVMTest_16117 {

    static int i = 0;

    Object get(int i) {
        throw new Error("Invalid field index " + i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16117().get(i));
    }
}
