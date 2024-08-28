public class MyJVMTest_12891 {

    static String args = "7N;i'-@<&q";

    String agentmain(String args) {
        throw new RuntimeException("Something bad happened - Bye!");
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12891().agentmain(args);
    }
}
