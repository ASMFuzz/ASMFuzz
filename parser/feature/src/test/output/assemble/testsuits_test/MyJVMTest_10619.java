import java.time.LocalDate;

public class MyJVMTest_10619 {

    LocalDate get() {
        return LocalDate.now();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10619().get());
    }
}
