public class MyJVMTest_3578 {

    static String traceLine = "HgNw>Jj^b#";

    String getTracePointId(String traceLine) {
        return traceLine.split("\\s+")[2];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3578().getTracePointId(traceLine));
    }
}
