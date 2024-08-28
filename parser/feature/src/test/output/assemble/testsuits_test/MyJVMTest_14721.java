public class MyJVMTest_14721 {

    void \ud801\udc01() {
        new java.io.File(this.getClass().getName() + ".class").deleteOnExit();
        System.out.println("success");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14721().\ud801\udc01();
    }
}
