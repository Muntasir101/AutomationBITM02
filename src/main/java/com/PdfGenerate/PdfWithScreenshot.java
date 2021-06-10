package com.PdfGenerate;

import com.Base.TestBase;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfWithScreenshot extends TestBase {
    public static void main(String[] args) throws DocumentException, IOException {
        firefoxLaunch();
        openTestSite("https://demo.opencart.com/");
        pageLoadWait(10);
        createPdf();
        closeBrowser();
    }
    public static void createPdf() throws IOException, DocumentException {
        //take screenshot and save as byte[]
        byte [] input=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

        Document document=new Document();

        String output=System.getProperty("user.dir")+"//src//main//pdf//MyPdf.pdf";

        FileOutputStream fs=new FileOutputStream(output);

        PdfWriter writer=PdfWriter.getInstance(document,fs);

        //Open the pdf for writing
        writer.open();
        document.open();

        //Process add image
        Image img= Image.getInstance(input);

        //Set size of image
        img.scaleToFit(PageSize.A4.getWidth()/2,PageSize.A4.getHeight()/2);

        //Add image to PDF
        document.add(img);
        document.add(new Paragraph(" "));

        //close files and save
        document.close();
        writer.close();
    }
}
