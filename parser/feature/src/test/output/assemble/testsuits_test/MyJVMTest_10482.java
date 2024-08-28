public class MyJVMTest_10482 {

    static int field = 5;

    String method(int field) {
        String s = field % 2 == 0 ? (field == 0 ? "false" : "true" + field) : "false" + field;
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10482().method(field));
    }
}
