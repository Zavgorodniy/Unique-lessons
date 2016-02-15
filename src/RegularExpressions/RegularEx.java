package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx {

    public static void check(String ex) {

        String regex = "^(19|20)\\d\\d-((0[1-9]|1[012])-(0[1-9]|[12]\\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)[T]" +
                "([0-1]\\d|2[0-3])(:[0-5]\\d){2}[+]" +
                "([0-1]\\d|2[0-3])(\\.[0-5]\\d)$";

        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(ex);

        System.out.print(m.matches());
    }
}
