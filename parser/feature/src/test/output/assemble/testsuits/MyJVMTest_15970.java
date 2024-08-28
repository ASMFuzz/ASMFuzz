public class MyJVMTest_15970 {

    static int stageNum = 6;

    boolean isActionAllowed_8() {
        return (stageNum < 2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15970().isActionAllowed_8());
    }
}
