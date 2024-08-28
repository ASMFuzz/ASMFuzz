import javax.sql.RowSetEvent;

public class MyJVMTest_6248 {

    static int flag = 0;

    void resetFlag() {
        flag = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6248().resetFlag();
    }
}
