public class MyJVMTest_10842 {

    static String in = ",LYgFm*YTc";

    static String text = "qg\"6}{'2-!";

    String normalize(String in) {
        return in.replace(System.getProperty("line.separator"), "\n");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10842().normalize(in));
    }
}
