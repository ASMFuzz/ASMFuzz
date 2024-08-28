public class MyJVMTest_10483 {

    String helpOutOfMemoryObject() {
        return "Tests whether the VM calls back with a Resource Exhausted event (with JVMTI_RESOURCE_EXHAUSTED_OOM_ERROR flag set)";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10483().helpOutOfMemoryObject());
    }
}
