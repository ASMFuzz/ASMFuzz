import javax.sql.RowSetEvent;

public class MyJVMTest_562 {

    static RowSet eventParam1 = null;

    static RowSetEvent event = new RowSetEvent(eventParam1);

    static int CURSOR_MOVED = 4;

    static int flag = -989402530;

    RowSetEvent cursorMoved(RowSetEvent event) {
        flag |= CURSOR_MOVED;
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_562().cursorMoved(event);
    }
}
