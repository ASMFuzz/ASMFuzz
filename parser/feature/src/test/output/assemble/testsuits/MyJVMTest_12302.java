public class MyJVMTest_12302 {

    static int stageNum = 7;

    boolean isActionAllowed_5() {
        return (stageNum < 2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12302().isActionAllowed_5());
    }
}
