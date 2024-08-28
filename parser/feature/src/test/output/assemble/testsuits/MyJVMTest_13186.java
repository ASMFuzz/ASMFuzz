public class MyJVMTest_13186 {

    static String a = "l<{l/`Gyky";

    static int ch = 4;

    static int from = 9;

    int indexOfChar(String a, int ch, int from) {
        return a.indexOf(ch, from);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13186().indexOfChar(a, ch, from));
    }
}
