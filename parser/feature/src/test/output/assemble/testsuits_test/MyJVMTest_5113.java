public class MyJVMTest_5113 {

    String helpAddToBootpathDuringLiveBadJar() {
        return "Check that AddToBootstrapClassLoaderSearch during Live correctly rejects bad jars. " + "Added as a unit test for J9 VM design ID 450";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5113().helpAddToBootpathDuringLiveBadJar());
    }
}
