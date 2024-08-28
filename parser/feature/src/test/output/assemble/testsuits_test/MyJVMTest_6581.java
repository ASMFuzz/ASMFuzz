public class MyJVMTest_6581 {

    static String errorParam1 = "[_K9Oy+jak";

    static OutOfMemoryError error = new OutOfMemoryError(errorParam1);

    static String whoAmI = "Au78v Cg6Q";

    static int maxClassesToLoad = 6;

    static ShrinkGrowTest.Foo foo = null;

    boolean isMetaspaceError(OutOfMemoryError error) {
        String message = error.getMessage();
        return message != null && (message.contains("Metaspace") || message.contains("Compressed class space"));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6581().isMetaspaceError(error));
    }
}
