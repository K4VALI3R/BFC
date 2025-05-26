package utp.edu.pe.bfc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "image", urlPatterns = {"/image"})
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Llama a doPost para centralizar la lógica
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strImg = req.getParameter("img");
        if(strImg == null || strImg.isEmpty()){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parámetro img requerido");
            return;
        }

        // Opción recomendada: obtener la ruta real de la carpeta /images del proyecto
        String imagePath = getServletContext().getRealPath("/images/" + strImg);
        File imageFile = new File(imagePath);

        // Verificamos que el archivo realmente exista
        if(!imageFile.exists()){
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Imagen no encontrada");
            return;
        }

        int length = (int) imageFile.length();

        // Configurar el Content-Type de acuerdo a la extensión de la imagen
        if(strImg.toLowerCase().endsWith(".png")){
            resp.setContentType("image/png");
        } else if(strImg.toLowerCase().endsWith(".jpg") || strImg.toLowerCase().endsWith(".jpeg")){
            resp.setContentType("image/jpeg");
        } else {
            resp.setContentType("application/octet-stream");
        }

        resp.setHeader("Content-Disposition", "inline");
        resp.setHeader("Cache-Control", "public, max-age=88584");
        resp.setDateHeader("Expires", System.currentTimeMillis() + 88584);
        resp.setContentLength(length);

        try (FileInputStream fileInputStream = new FileInputStream(imageFile);
             OutputStream outputStream = resp.getOutputStream()) {

            byte[] buffer = new byte[1024]; // Buffer de lectura fijo
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}