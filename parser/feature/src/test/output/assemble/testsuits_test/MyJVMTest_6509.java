public class MyJVMTest_6509 {

    static boolean x = true;

    static String w = "~*Nga~Vj!M";

    String inspect(final boolean x, final String w) {
        return w + ": boolean";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6509().inspect(x, w));
    }
}
