public class MyJVMTest_15033 {

    static int i = 4;

    char charAt(int i) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15033().charAt(i));
    }
}
