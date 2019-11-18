package com.hx5847.onlinebookstore.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by JiChao on 2019/3/29.
 */
public class ExcelUtil {

    public static void downloadExcel(HttpServletRequest request, HttpServletResponse response, String title, Workbook workbook) {
        try(OutputStream outputStream = response.getOutputStream()) {
            // 设置下载头
            String userAgent = request.getHeader("User-Agent");
            //判断浏览器类型
            boolean isMSIE = userAgent != null && (userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("like Gecko") > -1);
            if (isMSIE) {
                title = URLEncoder.encode(title, "UTF8");
            } else {
                title = new String(title.getBytes("UTF-8"), "ISO-8859-1");
            }
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment;filename=" + title + ".xlsx");
            // 写入文件
            workbook.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
