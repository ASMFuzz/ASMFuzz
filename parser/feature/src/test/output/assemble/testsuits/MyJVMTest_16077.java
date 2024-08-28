public class MyJVMTest_16077 {

    static OutOfMemoryError error = new OutOfMemoryError();

    static String whoAmI = "F%`MeK>jnc";

    static int maxClassesToLoad = -449537814;

    static ShrinkGrowTest.Foo foo = null;

    boolean isMetaspaceError(OutOfMemoryError error) {
        String message = error.getMessage();
        return message != null && (message.contains("Metaspace") || message.contains("Compressed class space"));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16077().isMetaspaceError(error));
    }
}
