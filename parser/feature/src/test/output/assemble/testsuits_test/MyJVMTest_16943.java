public class MyJVMTest_16943 {

    static int i = 0;

    static int length = 3;

    char charAt(int i) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16943().charAt(i));
    }
}
