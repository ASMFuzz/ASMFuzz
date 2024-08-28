public class MyJVMTest_5427 {

    static int count = 8;

    static boolean shared = false;

    static char[] value = {Character.MIN_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,'x','[',Character.MIN_VALUE,Character.MAX_VALUE,'p',';',Character.MIN_VALUE};

    int capacity() {
        return value.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5427().capacity());
    }
}
