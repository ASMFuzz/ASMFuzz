public class MyJVMTest_11423 {

    static int index = 0;

    static int count = -1678507740;

    static boolean shared = false;

    static char[] value = {Character.MAX_VALUE,'V','0',Character.MIN_VALUE,Character.MAX_VALUE,'0',Character.MAX_VALUE,'0','J','0'};

    char charAt(int index) {
        try {
            if (index < count)
                return value[index];
        } catch (IndexOutOfBoundsException e) {
        }
        throw new IndexOutOfBoundsException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11423().charAt(index));
    }
}
