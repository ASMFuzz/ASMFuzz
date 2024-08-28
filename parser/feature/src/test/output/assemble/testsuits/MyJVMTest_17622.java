import javax.sql.RowSetEvent;

public class MyJVMTest_17622 {

    static RowSet eventParam1 = null;

    static RowSetEvent event = new RowSetEvent(eventParam1);

    static int ROW_CHANGED = 2;

    static int flag = 0;

    RowSetEvent rowChanged(RowSetEvent event) {
        flag |= ROW_CHANGED;
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17622().rowChanged(event);
    }
}
