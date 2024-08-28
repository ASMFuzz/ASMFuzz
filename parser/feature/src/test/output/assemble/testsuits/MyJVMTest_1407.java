import java.time.LocalDate;

public class MyJVMTest_1407 {

    LocalDate get() {
        return LocalDate.now();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1407().get());
    }
}
