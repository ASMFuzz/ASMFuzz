public class MyJVMTest_1035 {

    static int stageNum = 0;

    boolean isActionAllowed_7() {
        return (stageNum < 2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1035().isActionAllowed_7());
    }
}
