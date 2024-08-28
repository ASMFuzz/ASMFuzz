public class MyJVMTest_6865 {

    static String s = "hDRdmTXW4W";

    static Integer args = 5;

    int f(String s, Integer... args) {
        return 3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6865().f(s, args));
    }
}
