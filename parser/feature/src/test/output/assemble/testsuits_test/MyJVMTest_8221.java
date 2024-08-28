public class MyJVMTest_8221 {

    static int value = 1;

    int unchecked(int value) {
        return value + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8221().unchecked(value));
    }
}
