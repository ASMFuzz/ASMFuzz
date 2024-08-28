public class MyJVMTest_5472 {

    static String prev = "MK=9@X >{q";

    String foo(String prev) {
        return prev + "Here ";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5472().foo(prev));
    }
}
