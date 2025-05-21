package utp.edu.pe.bfc.models.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Categoria {
    BURGERS ("Hamburguesa"),
    BOXES ("Cajas"),
    DRINKS ("Bebidas"),
    EXTRAS ("Extras");

    private final String displayName;
    Categoria(String displayName) { this.displayName = displayName;}
    public String getDisplayName() { return displayName; }
    public static List<Categoria> getCategorias() {
        return new ArrayList<>(Arrays.asList(Categoria.values()));
    }
}