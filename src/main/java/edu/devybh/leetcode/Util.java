package edu.devybh.leetcode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {
    public static void log(String log) {
        String forPrint = "";

        // trace
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        String caller = stackTraceElements[1].getClassName();
        caller = caller.substring(caller.lastIndexOf(".") + 1);
        forPrint = "[" + caller.substring(caller.lastIndexOf(".") + 1) + "]";

        // data to string
        forPrint += " " +log;

        // print
        System.out.println(forPrint);

    }

    public static void log(String title, Object obj) {
        String forPrint = "";

        // trace
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        String caller = stackTraceElements[1].getClassName();
        caller = caller.substring(caller.lastIndexOf(".") + 1);
        forPrint = "[" + caller.substring(caller.lastIndexOf(".") + 1) + "]";

        // title
        forPrint += " " + title + "\n";

        // data to string
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            forPrint += " " + objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // print
        System.out.println(forPrint);
    }
}
