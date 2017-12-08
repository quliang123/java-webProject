package lambda.lambda1;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 123 on 2017/11/02.
 */

public class l1 {
    public static void main(String[] args) {
        String[] s = {"a", "b"};
        List<String> list = Arrays.asList(s);
        list.forEach((a)->System.out.println(a));

    }
}
