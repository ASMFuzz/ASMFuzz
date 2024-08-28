public class MyJVMTest_7602 {

    String helpGarbageCollectionCycleEvent() {
        return "Generates garbage until a cycle event has been sent to JVMTI, or until we give up";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7602().helpGarbageCollectionCycleEvent());
    }
}
