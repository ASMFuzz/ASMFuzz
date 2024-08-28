public class MyJVMTest_212 {

    static String in = "BB><B~Y[o=";

    int getInt(String in) {
        if (in.equals("processingComplete"))
            return 0;
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_212().getInt(in));
    }
}
