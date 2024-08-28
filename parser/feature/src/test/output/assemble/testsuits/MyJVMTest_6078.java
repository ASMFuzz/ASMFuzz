public class MyJVMTest_6078 {

    String getSigAlgOID() {
        return "x509cert";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6078().getSigAlgOID());
    }
}
