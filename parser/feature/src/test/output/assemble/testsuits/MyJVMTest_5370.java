public class MyJVMTest_5370 {

    void myStaticMethod() {
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5370().myStaticMethod();
    }
}
