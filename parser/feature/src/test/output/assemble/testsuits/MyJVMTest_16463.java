public class MyJVMTest_16463 {

    static int stageNum = 8;

    boolean isActionAllowed_6() {
        return (stageNum < 2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16463().isActionAllowed_6());
    }
}
