package com.avanse.assignment.utility;

import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedOutputStream;
import java.io.IOException;

public class CommonUtility {
    public static void writeDataInResponse(HttpServletResponse response, String jsonString) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
        response.setHeader("Cache-Control", "no-cache");
        bufferedOutputStream.write(jsonString.getBytes("utf8"));
        bufferedOutputStream.flush();
    }
}
