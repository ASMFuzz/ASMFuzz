import java.util.*;
import java.util.Locale.*;
import static java.util.Locale.FilteringMode.*;
import static java.util.Locale.LanguageRange.*;

public class MyJVMTest_11844 {

    static List<LanguageRange> priorityList = new ArrayList<LanguageRange>();

    String showPriorityList(List<LanguageRange> priorityList) {
        StringBuilder sb = new StringBuilder();
        Iterator<LanguageRange> itr = priorityList.iterator();
        LanguageRange lr;
        if (itr.hasNext()) {
            lr = itr.next();
            sb.append(lr.getRange());
            sb.append(";q=");
            sb.append(lr.getWeight());
        }
        while (itr.hasNext()) {
            sb.append(", ");
            lr = itr.next();
            sb.append(lr.getRange());
            sb.append(";q=");
            sb.append(lr.getWeight());
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11844().showPriorityList(priorityList));
    }
}
