package com.wambui.learningspring2.util;



import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public Date createDateFromDateString(String dateString){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        if(StringUtils.hasLength(dateString)){
            try {
                date = format.parse(dateString);
            }catch (ParseException e){
                date = new Date();
            }
        }else {date = new Date();
        }
        return date;
    }
}
