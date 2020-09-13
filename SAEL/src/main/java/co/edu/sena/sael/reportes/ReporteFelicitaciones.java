/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.reportes;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

/**
 *
 * @author Fabian Andres
 */
public class ReporteFelicitaciones extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        Connection conn = null;
        try {
            String rutaReporte = this.getServletContext().getRealPath("/reportes")
                    + File.separator + "cartaFelicitacionHombre.jrxml";
            System.out.println("Ruta completa: " + rutaReporte);
            //se abre el reporte
            InputStream inputStream = new FileInputStream(rutaReporte);
            if (inputStream == null) {
                throw new ClassNotFoundException("Archivo jasper no se encontro");
            }

            String documentoAprendiz = request.getParameter("documentoAprendiz");
            System.out.println("documentoAprendiz: " + documentoAprendiz);

            //parametros del reporte
            Map params = new HashMap();
            params.put("documentoAprendiz", documentoAprendiz);
//            params.put("imagenParametro",this.getClass().getResourceAsStream("estudiante.png"));

            //se abre la cx
            Context initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("jdbc/gepadBD");
            conn = ds.getConnection();
            //se llena el reporte
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params, conn);

            JRPdfExporter pdfExporter = new JRPdfExporter();
            pdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            ByteArrayOutputStream pdfReportStream = new ByteArrayOutputStream();
            pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfReportStream));
            pdfExporter.exportReport();

            response.setContentType("application/pdf");
            response.setHeader("content-Length", String.valueOf(pdfReportStream.size()));
            response.setHeader("Content-disposition", "attachment; filename=reporteFelicitaciones.pdf");

            OutputStream responseOutputStream = response.getOutputStream();
            responseOutputStream.write(pdfReportStream.toByteArray());
            responseOutputStream.close();
            pdfReportStream.close();
        } catch (IOException | ClassNotFoundException | SQLException | NamingException | JRException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
