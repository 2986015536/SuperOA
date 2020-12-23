package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.JsonResult;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class JsonUtil {
    public static void writeJsonInfo (int code, Object info, HttpServletResponse response) {
        JsonResult jsonResult = new JsonResult(code, info);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(jsonResult);
            PrintWriter writer = response.getWriter();
            writer.write(s);
            writer.flush();//刷新缓存
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
