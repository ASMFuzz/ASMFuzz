public class MyJVMTest_8291 {

    static float i = 0f;

    Float foob(float i) {
        return Float.valueOf(i);
    }

    void dummy() {
    }

    float simplef_deop(float i) {
        Float ib = foob(i);
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8291().simplef_deop(i));
    }
}
