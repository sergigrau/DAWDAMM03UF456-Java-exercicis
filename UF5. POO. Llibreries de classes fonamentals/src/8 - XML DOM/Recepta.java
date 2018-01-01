package edu.fje.dam2daw2;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Hashtable;

/**
 * Classe que escriu un document XML a partir dels diferents tipus d'ingredients
 * d'una recepta continguda en un altre document XML. També ha de mostrar el
 * nombre d'unitats de cadascun d'ells.
 *
 * @author sergi grau
 * @version 2.0 22.12.2014
 */
public class Recepta {

	public static void main(String argv[]) {

		Hashtable<String, Float> ingredients = new Hashtable<String, Float>();
		Document doc = null;

		try {

			File fXmlFile = new File("recepta.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("element Arrel:"
					+ doc.getDocumentElement().getNodeName());
			NodeList llistaDeNodes = doc.getElementsByTagName("Ingredient");
			System.out.println("-----------------------");

			for (int temp = 0; temp < llistaDeNodes.getLength(); temp++) {

				Node node = llistaDeNodes.item(temp);
				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) node;

					String item = obtenirContingut("Item", element);
					float nombre = 0;
					if (ingredients.get(item) != null){
						nombre = ingredients.get(item);
					}
					ingredients.put(
							item,
							nombre
									+ Float.parseFloat(obtenirContingut("Quantitat",
											element)));

					// HashTreetoNode.appendHashToNode(ingredients, item, nNode,
					// doc);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(ingredients.toString());
		EscriptorXML.desarXML(ingredients);
	}

	private static String obtenirContingut(String etiqueta, Element element) {
		NodeList nlList = element.getElementsByTagName(etiqueta).item(0)
				.getChildNodes();

		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();
	}
}