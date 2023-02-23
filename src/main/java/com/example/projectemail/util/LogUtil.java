package com.example.projectemail.util;

import com.example.projectemail.service.EmailService;
import org.apache.log4j.Logger;

public class LogUtil {

    private LogUtil() { }

    public static Logger getLogger(Class<EmailService> object) {
        return Logger.getLogger(String.valueOf(object.getClass()));
    }

}
