public class MyJVMTest_14674 {

    static String threadName = "Txo,epNS#/";

    int getThreadNumber(String threadName) {
        int openQuote = -1;
        int closeQuote = -1;
        openQuote = threadName.indexOf("##");
        closeQuote = threadName.indexOf("##", openQuote + 1);
        if (openQuote > -1 && closeQuote > -1) {
            String threadNo_string = threadName.substring(openQuote + 2, closeQuote);
            int threadNo = Integer.parseInt(threadNo_string);
            return threadNo;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14674().getThreadNumber(threadName));
    }
}
