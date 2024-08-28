import javax.sql.RowSetEvent;

public class MyJVMTest_15723 {

    static int flag = -555186794;

    void resetFlag() {
        flag = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15723().resetFlag();
    }
}
