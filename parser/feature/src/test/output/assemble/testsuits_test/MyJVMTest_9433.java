public class MyJVMTest_9433 {

    static int SCOPE_ID_E1000G0 = 2;

    int getScopeId() {
        return SCOPE_ID_E1000G0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9433().getScopeId());
    }
}
