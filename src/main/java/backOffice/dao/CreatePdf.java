package backOffice.dao;

import java.io.IOException;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;



public class CreatePdf {

    public static  void creePdf(String name,double price,int id) throws IOException {

        try (PDDocument doc = new PDDocument()) {

            PDPage myPage = new PDPage();
            doc.addPage(myPage);
            
            try (PDPageContentStream cont = new PDPageContentStream(doc, myPage)) {

                cont.beginText();
                
                cont.setFont(PDType1Font.TIMES_ROMAN, 14);
				
				  cont.setLeading(14.5f); cont.newLineAtOffset(25, 700);
				  
				  String line1 = "recu de M. " + name; cont.showText(line1);
				  
				  cont.newLine(); cont.newLine();
				  
				  String line2 = "numéro de commande " + id; cont.showText(line2);
				  
				  cont.newLine(); cont.newLine();
				  
				  String line3 ="Le "+(java.time.LocalDate.now()).toString();
				  cont.showText(line3);
				  
				  cont.newLine(); cont.newLine();
				  
				  String
				  line4="je soussigne(e) que je reçois tous les produits que j'ai commandés pour un prix total de "
				  + price+" Dh"; cont.showText(line4);
				  
				  cont.newLine(); cont.newLine();
				  
				  cont.newLine(); cont.newLine();
				  
				  String line5="Signature " + "  ......."; cont.showText(line5);
				  
				  
				  cont.endText();
				 
            }
            String userDirectory ="C:\\Users\\pc\\eclipse-workspace\\versionFinal\\src\\main\\webapp\\frontOffice\\pdf\\"+ id+".pdf";
            doc.save(userDirectory);
            //C:\\Users\\admin\\Desktop\\Sample2.pdf
        }
        
        
    }
    
    public static void main(String[] args) 
    {
    	try {
			CreatePdf.creePdf("mouad benthami", 0, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
  
}