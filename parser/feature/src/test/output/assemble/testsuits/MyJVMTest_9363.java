public class MyJVMTest_9363 {

    static String in = ":f0|V?XfZ/";

    int getInt(String in) {
        if (in.equals("processingComplete"))
            return 0;
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9363().getInt(in));
    }
}
