public class MyJVMTest_11618 {

    static byte b = 127;

    int f() {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11618().f());
    }
}
