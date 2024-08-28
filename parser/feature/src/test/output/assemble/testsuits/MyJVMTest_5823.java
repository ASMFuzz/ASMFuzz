public class MyJVMTest_5823 {

    static int endingRow = 1;

    static int mask = 0;

    boolean next(int rows) {
        return rows < 12;
    }

    int loop(int endingRow, int mask) throws Exception {
        int rows = 1;
        boolean next = true;
        while (rows <= endingRow && next) {
            rows++;
            if (rows == mask)
                System.out.println("Rows=" + rows + ", end=" + endingRow + ", next=" + next);
            next = next(rows);
        }
        if (next)
            throw new Exception("Ended on rows(no rs): " + rows);
        return rows;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5823().loop(endingRow, mask);
    }
}
