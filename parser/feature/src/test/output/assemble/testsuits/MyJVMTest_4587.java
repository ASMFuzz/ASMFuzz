public class MyJVMTest_4587 {

    static int x = 0;

    static String color = "9<z^<SUN/H";

    int setColor(final int x) {
        this.color = Integer.toString(x);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4587().setColor(x);
    }
}
