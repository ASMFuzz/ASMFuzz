public class MyJVMTest_12907 {

    String helpAddToClasspathDuringLiveBadJar() {
        return "Check that AddToSystemClassLoaderSearch during Live correctly rejects bad jars. " + "Added as a unit test for J9 VM design ID 450";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12907().helpAddToClasspathDuringLiveBadJar());
    }
}
