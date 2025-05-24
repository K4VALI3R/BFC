package utp.edu.pe.bfc.models.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Estado {
    ACTIVE ("Activo"),
    INACTIVE ("Inactivo");

    private final String displayName;
    Estado(String displayName) { this.displayName = displayName;}
    public String getDisplayName() { return displayName; }
    public static List<Estado> getEstados() {
        return new ArrayList<>(Arrays.asList(Estado.values()));
    }
}