public class MyJVMTest_15536 {

    String getSigAlgOID() {
        return "x509cert";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15536().getSigAlgOID());
    }
}
