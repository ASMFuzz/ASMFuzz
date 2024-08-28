public class MyJVMTest_13977 {

    static int x = -32251471;

    static String color = "d#X:<t&6$K";

    int setColor(final int x) {
        this.color = Integer.toString(x);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13977().setColor(x);
    }
}
