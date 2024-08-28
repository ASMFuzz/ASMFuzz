public class MyJVMTest_11445 {

    static int i = 460083021;

    String statementBroken(int i) {
        String res;
        switch(i) {
            case 0:
                {
                    res = "NULL-A";
                }
            case 1:
                {
                    res = "NULL-A";
                    break;
                }
            case 2:
                {
                    res = "NULL-A";
                    break;
                }
            default:
                {
                    res = "NULL-A";
                    break;
                }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11445().statementBroken(i);
    }
}
