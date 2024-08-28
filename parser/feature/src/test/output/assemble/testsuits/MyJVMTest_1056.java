public class MyJVMTest_1056 {

    static Bar x = null;

    static int i = 7;

    static String s = "zD{N6JPs<D";

    static int effects = 0;

    Bar iBar(Bar x) {
        effects++;
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1056().iBar(x));
    }
}
