package converttype.converttypes;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by 123 on 2017/08/28.
 */

public class typeconvert implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        SimpleDateFormat sdf = getDateFormat(source);
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private SimpleDateFormat getDateFormat(String source) {
        SimpleDateFormat sdf = null;

        if (Pattern.matches("\\d{4}-\\d{2}-\\d{2}", source)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }
        if (Pattern.matches("\\d{4}/\\d{2}/\\d{2}", source)) {
            sdf = new SimpleDateFormat("yyyy/MM/dd");
        }
        if(Pattern.matches("\\d{4}\\d{2}\\d{2}", source)) {
            sdf = new SimpleDateFormat("yyyyMMdd");
        }
        return sdf;
    }

}
