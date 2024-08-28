public class MyJVMTest_3532 {

    static String s = "tT9gmGyg$z";

    static int i = 3;

    String getString(String s, int i) {
        String current = s + String.valueOf(i);
        System.nanoTime();
        return current;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3532().getString(s, i));
    }
}
