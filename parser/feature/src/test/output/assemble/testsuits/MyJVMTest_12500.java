import java.util.Comparator;

public class MyJVMTest_12500 {

    static Object o1 = 0;

    static Object o2 = 1441132532;

    Comparator m() {
        return new Comparator() {

            @Override
            public boolean equals(Object o) {
                return true;
            }

            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12500().compare(o1, o2));
    }
}
