import javax.sql.RowSetEvent;

public class MyJVMTest_9728 {

    static RowSet eventParam1 = null;

    static RowSetEvent event = new RowSetEvent(eventParam1);

    static int CURSOR_MOVED = 4;

    static int flag = 0;

    RowSetEvent cursorMoved(RowSetEvent event) {
        flag |= CURSOR_MOVED;
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9728().cursorMoved(event);
    }
}
