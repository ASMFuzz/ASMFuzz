public class MyJVMTest_3557 {

    static String args = "hC|7:lD2g&";

    String agentmain(String args) {
        throw new RuntimeException("Something bad happened - Bye!");
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3557().agentmain(args);
    }
}
