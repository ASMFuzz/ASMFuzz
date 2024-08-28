import javax.sql.RowSetEvent;

public class MyJVMTest_8053 {

    static RowSet eventParam1 = null;

    static RowSetEvent event = new RowSetEvent(eventParam1);

    static int ROW_CHANGED = 2;

    static int flag = 6;

    RowSetEvent rowChanged(RowSetEvent event) {
        flag |= ROW_CHANGED;
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8053().rowChanged(event);
    }
}
