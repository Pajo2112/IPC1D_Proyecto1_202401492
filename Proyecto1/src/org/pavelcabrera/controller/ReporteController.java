package org.pavelcabrera.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;

import org.pavelcabrera.model.Producto;
import org.pavelcabrera.model.Venta;
import org.pavelcabrera.model.Bitacora;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ReporteController {

    private Bitacora bitacora;

    public ReporteController(Bitacora bitacora) {
        this.bitacora = bitacora;
    }
    
    // Método auxiliar para crear carpeta y devolver ruta completa
    private String generarRutaArchivo(String nombre) {
        String folderPath = "reportesPDF";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdir();
        }
        return folderPath + File.separator + nombre;
    }

    // PDF Stock
    public void generarReporteStockPDF(Producto[] productos, int contador) {
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss"));
        String archivo = generarRutaArchivo (fecha + "_Stock.pdf");

        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(archivo));
            doc.open();

            doc.add(new Paragraph("REPORTE DE STOCK"));
            doc.add(new Paragraph("Generado: " + LocalDateTime.now()));
            doc.add(new Paragraph("\n"));

            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(100);
            tabla.addCell("Código");
            tabla.addCell("Marca");
            tabla.addCell("Categoría");
            tabla.addCell("Precio");
            tabla.addCell("Cantidad");

            for (int i = 0; i < contador; i++) {
                tabla.addCell(productos[i].getCodigo());
                tabla.addCell(productos[i].getNombre());
                tabla.addCell(productos[i].getCategoria());
                tabla.addCell(String.valueOf(productos[i].getPrecio()));
                tabla.addCell(String.valueOf(productos[i].getCantidad()));
            }

            doc.add(tabla);
            doc.close();

            System.out.println("📄 Reporte de stock generado: " + archivo);
            bitacora.registrarAccion("Generar reporte stock PDF", true);

        } catch (Exception e) {
            System.out.println("❌ Error al generar reporte stock PDF");
            bitacora.registrarAccion("Generar reporte stock PDF", false);
            e.printStackTrace();
        }
    }

    // PDF Ventas
    public void generarReporteVentasPDF(Venta[] ventas, int contador) {
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss"));
        String archivo = generarRutaArchivo(fecha + "_Ventas.pdf");
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(archivo));
            doc.open();

            doc.add(new Paragraph("REPORTE DE VENTAS"));
            doc.add(new Paragraph("Generado: " + LocalDateTime.now()));
            doc.add(new Paragraph("\n"));

            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            tabla.addCell("Fecha");
            tabla.addCell("Código Producto");
            tabla.addCell("Cantidad");
            tabla.addCell("Total");

            for (int i = 0; i < contador; i++) {
                tabla.addCell(ventas[i].getFechaHora());
                tabla.addCell(ventas[i].getCodigoProducto());
                tabla.addCell(String.valueOf(ventas[i].getCantidad()));
                tabla.addCell(String.valueOf(ventas[i].getTotal()));
            }

            doc.add(tabla);
            doc.close();

            System.out.println("📄 Reporte de ventas generado: " + archivo);
            bitacora.registrarAccion("Generar reporte ventas PDF", true);

        } catch (Exception e) {
            System.out.println("❌ Error al generar reporte ventas PDF");
            bitacora.registrarAccion("Generar reporte ventas PDF", false);
            e.printStackTrace();
        }
    }

    // PDF Bitácora
    public void generarBitacoraPDF() {
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss"));
        String archivo = generarRutaArchivo(fecha + "_Bitacora.pdf");

        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(archivo));
            doc.open();

            doc.add(new Paragraph("BITÁCORA DEL SISTEMA"));
            doc.add(new Paragraph("Generado: " + LocalDateTime.now()));
            doc.add(new Paragraph("\n"));

            PdfPTable tabla = new PdfPTable(1);
            tabla.setWidthPercentage(100);

            for (int i = 0; i < bitacora.getContador(); i++) {
                tabla.addCell(bitacora.getRegistros()[i]);
            }

            doc.add(tabla);
            doc.close();

            System.out.println("📄 Bitácora generada: " + archivo);

        } catch (Exception e) {
            System.out.println("❌ Error al generar bitácora PDF");
            e.printStackTrace();
        }
    }
}

