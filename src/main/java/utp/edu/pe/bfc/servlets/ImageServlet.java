package utp.edu.pe.bfc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utp.edu.pe.bfc.utils.AppConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "image", urlPatterns = {"/image"})
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strImg = req.getParameter("img");

        String imagePath = "D:\\universidad\\diseño web\\Proyecto final web\\BFC" + strImg;
        File imageFile = new File(imagePath);
        int length = (int) imageFile.length();

        resp.setContentType("image/jpg");
        resp.setHeader("Content-Disposition", "inline");
        resp.setHeader("Cache-Control", "public, max-age=88584");
        resp.setDateHeader("Expires", System.currentTimeMillis() + 88584);
        resp.setContentLength(length);

        FileInputStream fileInputStream = new FileInputStream(imageFile);
        OutputStream outputStream = resp.getOutputStream();

        byte[] buffer = new byte[length];
        int bytesRead;

        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        fileInputStream.close();
        outputStream.close();

    }
}