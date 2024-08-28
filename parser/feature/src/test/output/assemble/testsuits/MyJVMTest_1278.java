public class MyJVMTest_1278 {

    static int field = 66549341;

    String method(int field) {
        String s = field % 2 == 0 ? (field == 0 ? "false" : "true" + field) : "false" + field;
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1278().method(field));
    }
}
