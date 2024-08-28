public class MyJVMTest_12913 {

    static String traceLine = "[f)OPrl}Z'";

    String getTracePointId(String traceLine) {
        return traceLine.split("\\s+")[2];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12913().getTracePointId(traceLine));
    }
}
