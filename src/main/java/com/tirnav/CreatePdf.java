package com.tirnav;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.DocumentException;

public class CreatePdf {

	public static void main(String[] args) throws MalformedURLException, DocumentException, IOException {
		GeneratePdf.normalPdf();
		PdfWithTable.tablePdf();
	}

}
