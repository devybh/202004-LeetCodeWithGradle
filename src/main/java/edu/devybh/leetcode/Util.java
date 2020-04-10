package edu.devybh.leetcode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {
    public static void log(String log) {
        String forPrint = log + " (" + getStackTraceText() + ")\n";
        System.out.println(forPrint);
    }

    public static void log(String title, Object obj) {
        String forPrint = "[" + title + "]";
        forPrint += "\n  trace: " + getStackTraceText();
        forPrint += "\n  type: " + obj.getClass().getTypeName();
        // data to string
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            forPrint += "\n  value: " + objectMapper.writeValueAsString(obj) + "\n";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // print
        System.out.println(forPrint);
    }

    private static String getStackTraceText() {
        // stackTrace
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        // make stackTrace title
        String className = stackTraceElements[2].getClassName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String methodName = stackTraceElements[2].getMethodName();
        String lineNumber = String.valueOf(stackTraceElements[2].getLineNumber());
        // for Print
        return className + "." + methodName + "():" + lineNumber;
    }
}
