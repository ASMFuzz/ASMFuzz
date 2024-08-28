public class MyJVMTest_6105 {

    static float i = 0f;

    Float foob(float i) {
        return Float.valueOf(i);
    }

    float simplef(float i) {
        Float ib = foob(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6105().simplef(i));
    }
}
