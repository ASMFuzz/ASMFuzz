public class MyJVMTest_5452 {

    static String traceLine = "!T$L&Ax)>L";

    String getTracePointDetail(String traceLine) {
        return traceLine.split("\\s+", 5)[4].trim();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5452().getTracePointDetail(traceLine));
    }
}
