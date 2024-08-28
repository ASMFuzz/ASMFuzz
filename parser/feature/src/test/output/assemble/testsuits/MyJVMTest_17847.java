public class MyJVMTest_17847 {

    static String errorMessage = "not completed";

    static String whoAmI = "K([wYKZD]?";

    static int maxClassesToLoad = 2;

    static ShrinkGrowTest.Foo foo = null;

    boolean isPassed() {
        return errorMessage == null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17847().isPassed());
    }
}
