import javax.sql.RowSetEvent;

public class MyJVMTest_13187 {

    static int val = -737544782;

    static int flag = 8;

    boolean isNotified(int val) {
        return flag == val;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13187().isNotified(val));
    }
}
