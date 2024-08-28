public class MyJVMTest_13478 {

    static int SCOPE_ID_LO0 = 1;

    int getScopeId() {
        return SCOPE_ID_LO0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13478().getScopeId());
    }
}
