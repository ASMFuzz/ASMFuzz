public class MyJVMTest_15269 {

    static int endingRow = 682224494;

    static int mask = -1674071779;

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
        new MyJVMTest_15269().loop(endingRow, mask);
    }
}
