import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.property.Child;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sun.jvm.hotspot.debugger.cdbg.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Condition;

public class Demo {

    private static String camelCaseToUnderscore(String camelCase) {
        StringBuilder builder = new StringBuilder(camelCase.replace('.', '_'));
        for (int i = 1; i < builder.length() - 1; i++) {
            if (isUnderscoreRequired(builder.charAt(i - 1), builder.charAt(i),
                    builder.charAt(i + 1))) {
                builder.insert(i++, '_');
            }
        }

        return builder.toString().toLowerCase();
    }

    private static boolean isUnderscoreRequired(char before, char current, char after) {
        return Character.isLowerCase(before) && Character.isUpperCase(current)
                && Character.isLowerCase(after);
    }

    public static void main(String[] args) {
        String test = camelCaseToUnderscore("testAbcHa");
        System.out.println(test);
    }
}




