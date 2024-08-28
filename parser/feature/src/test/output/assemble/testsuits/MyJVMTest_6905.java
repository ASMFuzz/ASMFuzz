public class MyJVMTest_6905 {

    static float v = 0f;

    Object save() {
        return new Float(v);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6905().save());
    }
}
