package com.analogfilm.photolab.servise;

import com.analogfilm.photolab.models.Film;
import com.analogfilm.photolab.models.Order;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class UserOrderExport {
    private List<Order> listOrders;

    public UserOrderExport(List<Order> listOrders) {
        this.listOrders = listOrders;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(13);

        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);

        cell.setPhrase(new Phrase("ID order", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("User", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Employee name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Film name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Film price", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Scan machine", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Price scan", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Develop technology", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Price develop", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Order in progress", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Need develop", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Need scan", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Result order cost", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (Order order : listOrders) {
            table.addCell(String.valueOf(order.getId()));
            table.addCell(order.getUsername().getUsername());
            table.addCell(order.getEmployee_name().getUsername());
            table.addCell(order.getName_film().getName_film());
            table.addCell(String.valueOf(order.getName_film().getFilm_prise()));
            table.addCell(order.getName_film().getScan_machine().getScan_machine());
            table.addCell(String.valueOf(order.getName_film().getScan_machine().getPrise()));
            table.addCell(order.getName_film().getTech_name().getTech_name());
            table.addCell(String.valueOf(order.getName_film().getTech_name().getPrice()));
            table.addCell(String.valueOf(order.isIn_progress()));
            table.addCell(String.valueOf(order.isNeed_develop()));
            table.addCell(String.valueOf(order.isNeed_scan()));
            table.addCell(String.valueOf(order.getOrder_cost()));
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A3.rotate());
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLACK);

        Paragraph p = new Paragraph("List of Orders", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(13);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {5.5f, 4.5f, 6.0f, 5.5f, 4.7f, 5.5f, 4.0f, 7.0f, 5.5f, 5.0f, 4.7f, 4.5f, 5.0f});
        table.setSpacingBefore(10);
        writeTableHeader(table);
        writeTableData(table);
        document.add(table);
        document.close();
    }
}
