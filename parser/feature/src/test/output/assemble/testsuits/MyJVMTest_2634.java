public class MyJVMTest_2634 {

    static int stageNum = 6;

    boolean isActionAllowed_3() {
        return (stageNum < 5);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2634().isActionAllowed_3());
    }
}
