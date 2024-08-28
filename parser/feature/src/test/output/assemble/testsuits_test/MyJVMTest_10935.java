import javax.sql.RowSetEvent;

public class MyJVMTest_10935 {

    static RowSet eventParam1 = null;

    static RowSetEvent event = new RowSetEvent(eventParam1);

    static int ROWSET_CHANGED = 1;

    static int flag = 7;

    RowSetEvent rowSetChanged(RowSetEvent event) {
        flag |= ROWSET_CHANGED;
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10935().rowSetChanged(event);
    }
}
