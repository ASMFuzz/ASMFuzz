public class MyJVMTest_14855 {

    static int count = 2;

    static boolean shared = true;

    static char[] value = {'z','q','5','0','0',Character.MAX_VALUE,'0','$','-','0'};

    int capacity() {
        return value.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14855().capacity());
    }
}
