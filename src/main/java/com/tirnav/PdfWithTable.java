package com.tirnav;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfWithTable {

	public static void tablePdf() throws IOException, DocumentException {
		String destination = "D:\\TaskRelatedFiles\\Pdf\\addingTable.pdf";
		OutputStream outputStream = new FileOutputStream(new File(destination));
		Document document = new Document();

		PdfWriter.getInstance(document, outputStream);

		document.open();
		float[] pointColumnWidths = { 150F, 150F, 150F };
		PdfPTable table = new PdfPTable(pointColumnWidths); // Create 2 columns in table// Adding cell 1 to the table

		PdfPCell cell1 = new PdfPCell(new Phrase("ID"));
		PdfPCell cell2 = new PdfPCell(new Phrase("Name"));
		PdfPCell cell3 = new PdfPCell(new Phrase("Designation"));

		/* Set Background color */
		cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);

		table.addCell(cell1);
		table.addCell(cell2);
		table.addCell(cell3);
		table.setHeaderRows(1);

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("enter the number of data u want to insert: ");
			int num = sc.nextInt();
			int row = 0;
			do {
				System.out.println("Enter the Id: ");
				String id = sc.next();
				table.addCell(new PdfPCell(new Phrase(id)));
				System.out.println("enter Name: ");
				String name = sc.next();
				table.addCell(new PdfPCell(new Phrase(name)));
				System.out.println("enter the designation: ");
				String designation = sc.next();
				table.addCell(new PdfPCell(new Phrase(designation)));
				row++;
			} while (row != num);
		}
		document.add(table);
		document.close();
		outputStream.close();

//		cell1.add("Name"); // Adding content to the cell
//		table.addCell(cell1); // Adding cell to the table

//		try (Scanner sc = new Scanner(System.in)) {
//			System.out.println("enter the number of data u want to insert: ");
//			int num = sc.nextInt();
//
//			table.addCell(new Cell().add("Id"));
//			table.addCell(new Cell().add("Name"));
//			table.addCell(new Cell().add("Designation"));
//			int row = 0;
//			do {
//				System.out.println("Enter the Id: ");
//				String id = sc.next();
//				table.addCell(new Cell().add(id));
//				System.out.println("enter Name: ");
//				String name = sc.next();
//				table.addCell(new Cell().add(name));
//				System.out.println("enter the designation: ");
//				String designation = sc.next();
//				table.addCell(new Cell().add(designation));
//				cell.setFixedHeight(150);
//				row++;
//			} while (row != num);
//		}
//
////		table.addCell(new Cell().add("2"));
////		table.addCell(new Cell().add("Sugam"));
////		table.addCell(new Cell().add("Developer"));
//
//		document.add(table);
//		document.close();
		System.out.println("Table created successfully..");

	}

}
