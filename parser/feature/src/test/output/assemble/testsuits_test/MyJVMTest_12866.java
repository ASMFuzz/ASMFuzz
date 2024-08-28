public class MyJVMTest_12866 {

    static String s = "_o+#)V$YS(";

    static int i = 7;

    String getString(String s, int i) {
        String current = s + String.valueOf(i);
        System.nanoTime();
        return current;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12866().getString(s, i));
    }
}
