public class MyJVMTest_14881 {

    static String traceLine = "2PpIfko*IG";

    String getTracePointDetail(String traceLine) {
        return traceLine.split("\\s+", 5)[4].trim();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14881().getTracePointDetail(traceLine));
    }
}
