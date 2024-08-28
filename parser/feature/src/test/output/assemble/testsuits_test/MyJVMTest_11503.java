public class MyJVMTest_11503 {

    static int i = 4;

    static byte[] array = {-82,-114,14,-120,48,-72,-100,113,124,63};

    String getString(int i) {
        return "A" + i + "B";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11503().getString(i));
    }
}
