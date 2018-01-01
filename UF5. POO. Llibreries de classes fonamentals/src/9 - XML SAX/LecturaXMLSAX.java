package edu.fje.dam2daw2;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Classe que llegeix un document mitjançant JAXP i SAX
 *
 * @author sergi grau
 * @version 1.0 11/02/2014
 */
public class LecturaXMLSAX {

    public static void main(String argv[]) {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            File stocks = new File("stocks.xml");
            /**
             * Classe Interna que gestiona els esdeveniments
             */
            DefaultHandler handler = new DefaultHandler() {

                boolean bSimbol = false;
                boolean bPreu = false;
                boolean bQuantitat = false;

                @Override
                public void startElement(String uri, String nomLocal, String nomElement,
                        Attributes atributs) throws SAXException {

                    System.out.println("Inici d'element :" + nomElement);

                    if (nomElement.equalsIgnoreCase("simbol")) {
                        bSimbol = true;
                    }

                    if (nomElement.equalsIgnoreCase("preu")) {
                        bPreu = true;
                    }

                    if (nomElement.equalsIgnoreCase("quantitat")) {
                        bQuantitat = true;
                    }
                }

                @Override
                public void endElement(String uri, String localName,
                        String nomElement) throws SAXException {

                    System.out.println("Final d'element :" + nomElement);

                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {

                    if (bSimbol) {
                        System.out.println("Simbol: " + new String(ch, start, length));
                        bSimbol = false;
                    }
                    if (bPreu) {
                        System.out.println("Preu: " + new String(ch, start, length));
                        bPreu = false;
                    }
                    if (bQuantitat) {
                        System.out.println("Quantitat: " + new String(ch, start, length));
                        bQuantitat = false;
                    }
                }

            };

            saxParser.parse(stocks, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
