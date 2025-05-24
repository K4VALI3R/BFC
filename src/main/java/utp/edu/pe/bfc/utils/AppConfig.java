package utp.edu.pe.bfc.utils;

import java.util.ResourceBundle;

public class AppConfig {
    static ResourceBundle rb = ResourceBundle.getBundle("config");

    public static String getDatasource() {
        return rb.getString("cnxString");
    }

    public static String getErrorLogDir() {
        return rb.getString("errorLog");
    }

    public static String getImageDir() {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().contains("windows")) {
            return "D:\\universidad\\diseño web\\Proyecto final web\\BFC" + rb.getString("windowsImage");
        }else{
            return rb.getString("linuxImage");
        }
    }
}