public class MyJVMTest_15382 {

    String helpVerboseGCSubscription_2multiple() {
        return "Check verbose GC subscriber functionality with multiple subscribers. " + "Added as a unit test for Jazz Design 43965 / LIR 15727";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15382().helpVerboseGCSubscription_2multiple());
    }
}
