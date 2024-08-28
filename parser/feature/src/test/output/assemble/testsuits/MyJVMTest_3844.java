public class MyJVMTest_3844 {

    static String a = "P;.Sfha JV";

    static int ch = 6;

    static int from = 0;

    int indexOfChar(String a, int ch, int from) {
        return a.indexOf(ch, from);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3844().indexOfChar(a, ch, from));
    }
}
