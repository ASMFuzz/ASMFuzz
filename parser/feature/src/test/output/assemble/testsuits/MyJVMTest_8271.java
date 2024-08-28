public class MyJVMTest_8271 {

    static String errorMessage = "not completed";

    static String whoAmI = "9,KyW:a7|!";

    static int maxClassesToLoad = -1298683610;

    static ShrinkGrowTest.Foo foo = null;

    boolean isPassed() {
        return errorMessage == null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8271().isPassed());
    }
}
