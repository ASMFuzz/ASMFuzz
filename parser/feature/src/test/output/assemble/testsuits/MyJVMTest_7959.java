public class MyJVMTest_7959 {

    static boolean b = true;

    static int n = 22;

    void go() throws Exception {
        if (b) {
            System.out.println("if, no else");
        }
        if (b) {
            System.out.println("if branch");
        } else {
            throw new Exception("Wrong branch!?");
        }
        if (!b) {
            throw new Exception("Wrong branch!?");
        } else {
            System.out.println("else branch");
        }
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("caught exception");
        } finally {
            System.out.println("finally");
        }
        synchronized (this) {
            System.out.println("synchronized");
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Loop iteration: " + (i + 1) + "/" + n);
        }
        switch(n) {
            case 0:
                throw new Exception("Wrong branch!?");
            case 1:
                throw new Exception("Wrong branch!?");
            case 2:
                throw new Exception("Wrong branch!?");
            case 3:
                throw new Exception("Wrong branch!?");
            case 22:
                System.out.println("switch case");
                break;
            default:
                throw new Exception("Wrong branch!?");
        }
        switch(n) {
            case 0:
                throw new Exception("Wrong branch!?");
            case 1:
                throw new Exception("Wrong branch!?");
            case 2:
                throw new Exception("Wrong branch!?");
            case 3:
                throw new Exception("Wrong branch!?");
            default:
                System.out.println("switch default");
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7959().go();
    }
}
