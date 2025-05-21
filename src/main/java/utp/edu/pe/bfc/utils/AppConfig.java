package utp.edu.pe.bfc.utils;

import java.util.ResourceBundle;

public class AppConfig {
    static ResourceBundle rb = ResourceBundle.getBundle("config");

    public static String getDatasource() {
        return rb.getString("cnxString");
    }

    public static String getErrorLogDir(){
        return rb.getString("errorLog");
    }
}
