public class MyJVMTest_18048 {

    static String[] target = { "]mfK[/.ZJl", "h]Ro1-4#b|", "1.WD@(}Q&q", "A'=IE@--&6", "b\"6.w2L\"ED", "R\"Rt9wOi %", "U]'\"HLR2-b", "HrF#6v7n{%", "f8ZQbH0ZF'", "`k*[}-Cjm," };

    static String contextVersion = "u{tu/aK}go";

    static String[] enabledProtocols = {"ybAIuty3]O","SuXz`D@EGU","8\"0_<mJXH.","87C 6FJIA0","Ca(QQSEw*`",";?=j8asMfM",",ct;@IvoG7","-v:QoB325Z","IU^]Ml}{`j","dF|c8{^ew@"};

    boolean checkCipherSuites(String[] target) {
        boolean success = true;
        if (target.length == 0) {
            System.out.println("\t\t\t*** Error: No cipher suites");
            success = false;
        }
        System.out.println("\t\t\t--> Cipher check passed!!");
        return success;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18048().checkCipherSuites(target));
    }
}
