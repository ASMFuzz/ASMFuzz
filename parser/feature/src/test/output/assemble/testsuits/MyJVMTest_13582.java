public class MyJVMTest_13582 {

    static String string = "Akisdr::eG";

    static int IMG_W = 400;

    static int IMG_H = 400;

    static boolean showErrors = false;

    String usage(String string) {
        System.out.println(string);
        System.out.println("Usage: EmptyClipRenderingTest [-show]");
        return string;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13582().usage(string);
    }
}
