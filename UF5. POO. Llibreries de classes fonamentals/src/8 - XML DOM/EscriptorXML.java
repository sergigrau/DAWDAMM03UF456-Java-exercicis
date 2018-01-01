package edu.fje.dam2daw2;

import java.io.File;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Classe que converteix una taula dispersió en un fitxer XML
 * 
 * @author sergi grau
 * @version 1.0 06.01.2013
 */
public class EscriptorXML {

	public static void desarXML(Hashtable taulaDispersio) {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			Element elementArrel = doc.createElement("LlistaCompra");
			doc.appendChild(elementArrel);

			Attr attr = doc.createAttribute("total");
			attr.setValue("1");
			elementArrel.setAttributeNode(attr);

			// rootElement.setAttribute("id", "1");

			Enumeration e = taulaDispersio.keys();
			while (e.hasMoreElements()) {
				String it = (String) e.nextElement();

				Element producte = doc.createElement("Producte");
				elementArrel.appendChild(producte);

				Element item = doc.createElement("item");
				item.appendChild(doc.createTextNode(it));
				producte.appendChild(item);

				Element q = doc.createElement("quantitat");
				q.appendChild(doc.createTextNode(taulaDispersio.get(it)
						.toString()));
				producte.appendChild(q);

			}

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("sortida.xml"));

			transformer.transform(source, result);

			System.out.println("desat");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}