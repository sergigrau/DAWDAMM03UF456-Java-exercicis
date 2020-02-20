package edu.fje.daw2dam2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Classe que mostra diversos content panes activats per un menú de navegacio
 * Els continguts es generen dinàmicament
 *
 * @author sergi grau
 * @version 1.0 15/01/2015
 */
public class DiversosPanells extends Application {

	private static final LinkContingut[] linkAContingut = {
			new LinkContingut(
					"Partis1",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
					"http://icons.iconarchive.com/icons/archigraphs/tea-party/128/Sugar-Cubes-icon.png"),
			new LinkContingut(
					"Partis2",
					"Vestibulum a dui et massa laoreet vehicula.",
					"http://icons.iconarchive.com/icons/archigraphs/tea-party/128/Tea-Cake-icon.png"),
			new LinkContingut("Partis3", "Donec sed euismod risus.",
					"http://icons.iconarchive.com/icons/archigraphs/tea-party/128/Tea-Cup-icon.png"),
			new LinkContingut("Partis4",
					"Duis semper porttitor leo ac posuere.",
					"http://icons.iconarchive.com/icons/archigraphs/tea-party/128/Tea-Pot-icon.png") };

	private final StackPane contingut = new StackPane();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		contingut.setPrefWidth(200);
		HBox.setHgrow(contingut, Priority.ALWAYS);

		stage.setTitle("Selecciona un pastis");
		stage.setScene(new Scene(crearLayout()));
		stage.show();
	}

	private Pane crearLayout() {
		HBox hb = new HBox();
		hb.setSpacing(100);
		hb.getStylesheets().add(
				DiversosPanells.class.getResource("diversos-panells.css")
						.toExternalForm());
		hb.getChildren().addAll(crearMenuNavegacio(),contingut);
		return hb;
	}

	private VBox crearMenuNavegacio() {
		VBox nav = new VBox();
		nav.setMinWidth(100);
		nav.getStyleClass().add("navbar");
		for (int i = 0; i < linkAContingut.length; i++) {
			Hyperlink link = crearLink(linkAContingut[i].textLink,
					crearNodeDeContingut(linkAContingut[i]));
			nav.getChildren().add(link);
			if (i == 0) {
				link.fire();
			}
		}

		return nav;
	}

	private Node crearNodeDeContingut(LinkContingut linkContingut) {
		VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setStyle("node-contingut");
		vb.getChildren().add(new ImageView(linkContingut.imatge));
		Label lb = new Label(linkContingut.textContingut);
		lb.setWrapText(true);
		vb.getChildren().add(lb);

		return vb;
	}

	private Hyperlink crearLink(final String textLink, final Node nodeContingut) {
		
		Hyperlink hb = new Hyperlink(textLink);
		hb.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent t) {
						contingut.getChildren().setAll(nodeContingut);
					}
				});
		
		return hb;
	}

	/**
	 * Classe interna que encapsula la informació que es mostra assiciada a un
	 * link
	 */
	static class LinkContingut {

		final String textLink, textContingut;
		final Image imatge;

		public LinkContingut(String linkText, String contentText,
				String ubicacioImatge) {
			this.textLink = linkText;
			this.textContingut = contentText;
			this.imatge = new Image(ubicacioImatge);
		}
	}
}
