public class MyJVMTest_3773 {

    static String s1 = "y\\E6gHv7eB";

    static String s2 = "|SSX5YHDkf";

    String concatStrings(String s1, String s2) {
        return s1 + s2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3773().concatStrings(s1, s2));
    }
}
