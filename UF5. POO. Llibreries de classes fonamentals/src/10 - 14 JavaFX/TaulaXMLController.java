package edu.fje.daw2dam2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * FXML Controller class
 *
 * @author sergi grau
 * @version 1.0 15/01/2015
 */
public class TaulaXMLController implements Initializable {

	@FXML
	private TableView<Stock> taula;

	@FXML
	private Button boto;

	@FXML
	protected void carregar(ActionEvent event) {
		ObservableList<Stock> dades = taula.getItems();
		carregarXML(dades);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	private void carregarXML(ObservableList<Stock> dades) {
		try {
			File stocks = new File(TaulaXMLController.class.getResource(
					"stocks.xml").toURI());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stocks);
			doc.getDocumentElement().normalize();

			NodeList nodes = doc.getElementsByTagName("stock");

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					dades.add(new Stock(
							obtenirContingut("simbol", element),
							Integer.parseInt(obtenirContingut("preu", element)),
							Integer.parseInt(obtenirContingut("quantitat",
									element))));

				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static String obtenirContingut(String etiqueta, Element element) {
		NodeList nodes = element.getElementsByTagName(etiqueta).item(0)
				.getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}
}
