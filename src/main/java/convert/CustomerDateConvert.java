package convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerDateConvert implements Converter<String, Date> {

    private SimpleDateFormat[] sdfs = new SimpleDateFormat[]{
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyyMMdd"),
            new SimpleDateFormat("yyyy年MM月dd日")
    };

    @Override
    public Date convert(String s) {

        if (s == null || s.isEmpty()) {
            return null;
        }

        for (SimpleDateFormat sdf : sdfs) {
            try {
                return sdf.parse(s);
            } catch (ParseException e) {
//                把字符串儿变成一个date
                e.printStackTrace();
                continue;
            }
        }
        return null;
    }
}
