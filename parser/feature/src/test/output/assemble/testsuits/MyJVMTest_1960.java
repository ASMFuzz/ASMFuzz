import java.security.Principal;

public class MyJVMTest_1960 {

    static String username = "J}x3U=@i{I";

    static char[] password = {'0','K',Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,'0','7',Character.MAX_VALUE,'J','Q'};

    static String myUsername = "Q<hA.oQA.T";

    static char[] myPassword = {'-','0',Character.MIN_VALUE,Character.MIN_VALUE,'W','0',Character.MIN_VALUE,'0',Character.MAX_VALUE,'0'};

    static String header = "3?rxW.mZ0Q";

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
        new MyJVMTest_1960().printDebugInfo();
    }
}
