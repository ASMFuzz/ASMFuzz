public class MyJVMTest_8474 {

    void m() {
        class Local1 {
        }
        class Local2 extends Local1 {
        }
        Local2.class.getTypeParameters();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8474().m();
    }
}
