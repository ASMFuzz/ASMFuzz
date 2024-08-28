public class MyJVMTest_2269 {

    Object run() throws Exception {
        java.io.FileInputStream fis = new java.io.FileInputStream("/testFile");
        return fis;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2269().run());
    }
}
