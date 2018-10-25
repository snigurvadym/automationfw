package web.test.com.core;

import org.apache.log4j.Logger;

public class Log extends Logger {

    protected Log(String name) {
        super(name);
    }

    private static String getCallerClass() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement:stackTraceElements) {
            if (!stackTraceElement.getClassName().equals(Log.class.getName())
                    &&stackTraceElement.getClassName().contains("java.lang.Thread")) {
               return stackTraceElement.getClassName();
            }
        }
        return null;
    }

    public static void info(String message) {
        Log.getLogger(getCallerClass()).info(message);
    }

    public static void error(String message) {
        Log.getLogger(getCallerClass()).error(message);
    }

}
