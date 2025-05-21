package utp.edu.pe.bfc.models.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum EstadoPedido {
    WAITING ("Esperando"),
    IN_PROGRESS ("En Proceso"),
    READY ("Listo"),
    DELIVERED ("Entregado"),
    CANCELLED ("Cancelado");

    private final String displayName;
    EstadoPedido(String displayName) { this.displayName = displayName;}
    public String getDisplayName() { return displayName; }
    public static List<EstadoPedido> getEstados() {
        return new ArrayList<>(Arrays.asList(EstadoPedido.values()));
    }
}