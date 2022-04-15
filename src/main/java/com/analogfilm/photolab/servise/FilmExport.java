package com.analogfilm.photolab.servise;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.analogfilm.photolab.models.Film;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;


public class FilmExport {
    private List<Film> listFilms;

    public FilmExport(List<Film> listFilms) {
        this.listFilms = listFilms;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);

        cell.setPhrase(new Phrase("Film name", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Develop technology", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Scan machine", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Price", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Format", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (Film film : listFilms) {
            table.addCell(film.getName_film());
            table.addCell(film.getTech_name().getTech_name());
            table.addCell(film.getScan_machine().getScan_machine());
            table.addCell(String.valueOf(film.getFilm_prise()));
            table.addCell(film.getFormat_type());
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLACK);

        Paragraph p = new Paragraph("List of Films", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);
        writeTableHeader(table);
        writeTableData(table);
        document.add(table);
        document.close();
    }
}
