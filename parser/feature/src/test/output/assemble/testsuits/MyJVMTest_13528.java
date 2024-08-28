public class MyJVMTest_13528 {

    static String s = "!Gf8NRJeC[";

    String wahoo(String s) {
        return "wahoo " + s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13528().wahoo(s));
    }
}
