public class MyJVMTest_3922 {

    String helpGetHeapFreeTotalMemory() {
        return "Tests calling the getHeapFree/TotalMemory through the JVMTI extensions";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3922().helpGetHeapFreeTotalMemory());
    }
}
