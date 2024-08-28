import java.util.Arrays;

public class MyJVMTest_3499 {

    String[] getClassNames() {
        return new String[] { "p.NestedExamples", "p.NestedExamples.MemberClass1", "p.NestedExamples.MemberClass2", "p.NestedExamples.Win$$AtVegas" };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3499().getClassNames()));
    }
}
