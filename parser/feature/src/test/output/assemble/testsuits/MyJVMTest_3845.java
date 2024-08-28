import javax.sql.RowSetEvent;

public class MyJVMTest_3845 {

    static int val = 24376511;

    static int flag = 0;

    boolean isNotified(int val) {
        return flag == val;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3845().isNotified(val));
    }
}
