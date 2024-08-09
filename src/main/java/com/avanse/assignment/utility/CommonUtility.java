package com.avanse.assignment.utility;

import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtility {


    public static void writeDataInResponse(HttpServletResponse response, String jsonString) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
        response.setHeader("Cache-Control", "no-cache");
        bufferedOutputStream.write(jsonString.getBytes("utf8"));
        bufferedOutputStream.flush();
    }

    public static Long getDateFromStrinToLong(String string_date) {
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date d = f.parse(string_date);
            return d.getTime();
        } catch (ParseException e) {
            return new Date().getTime();
        }
    }
}
