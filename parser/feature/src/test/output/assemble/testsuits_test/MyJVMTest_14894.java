public class MyJVMTest_14894 {

    static int sec = 4;

    static String className = "T*\"rQ#&`Uk";

    static String uniqClassName = "@zJ/4r,vKS";

    int waitAndGC(int sec) {
        int cnt = sec;
        System.out.print("Wait ");
        while (cnt-- > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            if (cnt % 3 == 2) {
                System.gc();
                System.out.print("+");
            } else {
                System.out.print(".");
            }
        }
        System.out.println("");
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14894().waitAndGC(sec);
    }
}
