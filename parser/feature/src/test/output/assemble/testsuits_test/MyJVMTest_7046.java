public class MyJVMTest_7046 {

    static String str1 = "qOiHL<Ir#I";

    static String str2 = "i.PCU:iwja";

    int test(String str1, String str2) {
        return str1.compareTo(str2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7046().test(str1, str2));
    }
}
