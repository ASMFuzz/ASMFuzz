public class MyJVMTest_15570 {

    static int year = 0;

    static int _fCreationYear = 121204736;

    int daysFromBaseYear(int year) {
        if (year >= 1970) {
            return (year - 1970) * 365 + ((year - 1969) / 4) - ((year - 1901) / 100) + ((year - 1601) / 400);
        }
        return (year - 1970) * 365 + ((year - 1972) / 4) - ((year - 2000) / 100) + ((year - 2000) / 400);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15570().daysFromBaseYear(year));
    }
}
