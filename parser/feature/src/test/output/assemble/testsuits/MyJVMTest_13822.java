public class MyJVMTest_13822 {

    static int x = 2;

    static int y = 0;

    static int rgb = 0;

    int filterRGB(int x, int y, int rgb) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13822().filterRGB(x, y, rgb));
    }
}
