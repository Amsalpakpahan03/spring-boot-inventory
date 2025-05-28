package com.inventory.data.Service;

import com.inventory.data.Model.ItemNota;
import com.inventory.data.Model.Nota;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfGeneratorService {

    public ByteArrayInputStream generateNotaPdf(Nota nota) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Judul
            Font fontHeader = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph title = new Paragraph("Nota Pembelian", fontHeader);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Tanggal: " + nota.getTanggal()));

            // Tabel
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{4, 2, 3});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Nama Barang", headFont));
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Jumlah", headFont));
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Harga Total", headFont));
            table.addCell(hcell);

            for (ItemNota item : nota.getItems()) {
                table.addCell(item.getNamaBarang());
                table.addCell(String.valueOf(item.getJumlah()));
                table.addCell("Rp" + item.getHargaTotal());
            }

            document.add(table);
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Total Bayar: Rp" + nota.getTotalHarga()));

            document.close();
        } catch (DocumentException e) {
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
