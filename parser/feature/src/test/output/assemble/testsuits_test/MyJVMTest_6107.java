public class MyJVMTest_6107 {

    String helpClassInstanceTraversal() {
        return "Check the IterateOverHeap API for correct traversal of instances of java/lang/Class. " + "Added as a unit test for CMVC 111022";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6107().helpClassInstanceTraversal());
    }
}
