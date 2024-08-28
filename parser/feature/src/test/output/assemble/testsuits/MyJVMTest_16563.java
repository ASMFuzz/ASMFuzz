public class MyJVMTest_16563 {

    static String str1 = "p.+lbmY+&2";

    static String str2 = "!v>11;WfYX";

    int test(String str1, String str2) {
        return str1.compareTo(str2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16563().test(str1, str2));
    }
}
