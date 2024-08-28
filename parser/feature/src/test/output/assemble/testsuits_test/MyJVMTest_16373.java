public class MyJVMTest_16373 {

    static String s = "d{LEz7>!.L";

    static Integer args = 0;

    int f(String s, Integer... args) {
        return 3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16373().f(s, args));
    }
}
