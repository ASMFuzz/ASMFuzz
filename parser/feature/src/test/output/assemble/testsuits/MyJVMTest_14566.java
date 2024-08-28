public class MyJVMTest_14566 {

    static int value = 0;

    int unchecked(int value) {
        return value - 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14566().unchecked(value));
    }
}
