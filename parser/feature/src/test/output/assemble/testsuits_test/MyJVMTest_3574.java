public class MyJVMTest_3574 {

    String helpVMDidBootstrap() {
        return "Test that the VM still managed to start even though we tried to follow reference from a freshly allocated yet uninitialized java.lang.Class object.";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3574().helpVMDidBootstrap());
    }
}
