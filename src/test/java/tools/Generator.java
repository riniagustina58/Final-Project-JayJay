package tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Generator {

    public static  String getUniqueVal(){
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyHHmmssSSS");
        return sdf.format(new Date());
    }
}
