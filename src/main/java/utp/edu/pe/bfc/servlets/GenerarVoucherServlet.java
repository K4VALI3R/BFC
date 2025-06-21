package utp.edu.pe.bfc.servlets;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utp.edu.pe.bfc.models.Pedido;
import utp.edu.pe.bfc.models.PedidoDetalle;

import java.io.IOException;
import java.util.List;

@WebServlet("/generarVoucher")
public class GenerarVoucherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Obtener los datos desde la sesión (deben estar guardados antes en otra parte)
        Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
        List<PedidoDetalle> detalles = (List<PedidoDetalle>) request.getSession().getAttribute("detalles");

        if (pedido == null || detalles == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        // Configurar la respuesta como PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=voucher.pdf");

        // Crear documento PDF
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        // Encabezado
        document.add(new Paragraph("Comprobante de Pedido", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
        document.add(new Paragraph("Cliente: " + pedido.getCliente().getNombreCompleto()));
        document.add(new Paragraph("Fecha: " + pedido.getFecha()));
        document.add(new Paragraph("Dirección: " + pedido.getDireccion()));
        document.add(new Paragraph("Estado: " + pedido.getEstado()));
        document.add(new Paragraph(" ")); // espacio

        // Tabla con los detalles
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.addCell("Tipo");
        table.addCell("Nombre");
        table.addCell("Cantidad");
        table.addCell("Subtotal");

        for (PedidoDetalle det : detalles) {
            String tipo = det.getProducto() != null ? "Producto" : "Combo";
            String nombre = det.getProducto() != null ? det.getProducto().getNombre() : det.getCombo().getNombre();
            table.addCell(tipo);
            table.addCell(nombre);
            table.addCell(String.valueOf(det.getCantidad()));
            table.addCell("S/ " + det.getSubtotal());
        }

        document.add(table);

        // Total
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Total: S/ " + pedido.getMonto(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));

        document.close();
    }
}
