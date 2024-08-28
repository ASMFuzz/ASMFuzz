public class MyJVMTest_6952 {

    static int stageNum = 3;

    boolean isActionAllowed_6() {
        return (stageNum < 2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6952().isActionAllowed_6());
    }
}
