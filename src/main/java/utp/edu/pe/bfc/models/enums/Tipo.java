package utp.edu.pe.bfc.models.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Tipo {
    MANAGER ("Gerente"),
    WORKER ("Trabajador"),;

    private final String displayName;
    Tipo(String displayName) { this.displayName = displayName;}
    public String getDisplayName() { return displayName; }
    public static List<Tipo> getTipos() {
        return new ArrayList<>(Arrays.asList(Tipo.values()));
    }
}