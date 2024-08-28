import java.security.Principal;

public class MyJVMTest_11198 {

    static String username = "^EuX>=Ta{!";

    static char[] password = {'0',Character.MAX_VALUE,'0','0','0','0','I','0',Character.MIN_VALUE,Character.MAX_VALUE};

    static String myUsername = "SX[</0_caT";

    static char[] myPassword = {Character.MAX_VALUE,Character.MIN_VALUE,'Z',Character.MIN_VALUE,Character.MAX_VALUE,Character.MAX_VALUE,Character.MAX_VALUE,'0',Character.MIN_VALUE,Character.MAX_VALUE};

    static String header = "q/1fs=oAc2";

    void printDebugInfo() {
        System.out.println("\t\t" + header + " correct user name: " + myUsername);
        System.out.println("\t\t" + header + " user entered user name: " + username);
        System.out.print("\t\t" + header + " correct password: ");
        for (char c : myPassword) {
            System.out.print(c);
        }
        System.out.println();
        System.out.print("\t\t" + header + " user entered password: ");
        for (char c : password) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11198().printDebugInfo();
    }
}
