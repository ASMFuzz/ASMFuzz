public class MyJVMTest_2171 {

    static int index = 3;

    static int count = 5;

    static boolean shared = false;

    static char[] value = {'W','P','t',Character.MAX_VALUE,Character.MIN_VALUE,'W',Character.MAX_VALUE,'0',Character.MAX_VALUE,'4'};

    char charAt(int index) {
        try {
            if (index < count)
                return value[index];
        } catch (IndexOutOfBoundsException e) {
        }
        throw new IndexOutOfBoundsException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2171().charAt(index));
    }
}
