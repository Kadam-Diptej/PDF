package com.tirnav;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdf {
	private static String USER_PASSWORD = "123456";
	private static String OWNER_PASSWORD = "123";

	public static void normalPdf() throws DocumentException, MalformedURLException, IOException {
		Document document = new Document();

		PdfWriter pdfWriter = PdfWriter.getInstance(document,
				new FileOutputStream("D:\\TaskRelatedFiles\\Pdf\\PasswordProtectedPdf.pdf"));
		System.out.println("PDF is Created");
		pdfWriter.setEncryption(USER_PASSWORD.getBytes(), OWNER_PASSWORD.getBytes(), PdfWriter.ALLOW_PRINTING,
				PdfWriter.ENCRYPTION_AES_128);
		document.open();
		document.add(new Paragraph(
				"This is my first pdf. Using iText Library. iText is also an open-source Java library that deals with PDFs. It is written in Java and .NET. Using iText, we can create PDF files, dynamically. It is a powerful API that supports the generation of HTML, RTF, and XML documents in addition to generation of PDFs. It provides features like a watermark, generates tables in PDF, fonts, and so on. Although it is free if you want to use it commercially then you will have to pay a nominal fee."));
		document.add(new Paragraph(
				"There are various libraries that can be used to create a PDF file using a Java program. Some of them are:\r\n"
						+ "\r\n" + "Apache PDFBox\r\n" + "iText\r\n" + "PDF Clown\r\n" + "BFO\r\n" + "PJX\r\n"
						+ "PDFjet\r\n" + "jPOD\r\n" + "ICEpdf"));
		document.add(new Paragraph("This is Password protected PDF."));
		Image img = Image.getInstance(URI.create("https://w.wallhaven.cc/full/j8/wallhaven-j81o8p.jpg").toURL());
		img.scaleToFit(300f, 300f);
		document.add(img);

		document.addAuthor("Diptej Kadam");
		document.addCreationDate();
		document.addCreator("Diptej Kadam");
		document.addTitle("Setting Attribute");
		document.addSubject("Setting attributes to the PDF files.");
		document.close();
		pdfWriter.close();

	}

}
