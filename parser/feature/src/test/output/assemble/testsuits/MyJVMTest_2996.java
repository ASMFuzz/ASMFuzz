public class MyJVMTest_2996 {

    static int stageNum = 4;

    boolean isActionAllowed_5() {
        return (stageNum < 2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2996().isActionAllowed_5());
    }
}
