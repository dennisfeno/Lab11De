package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.bar.model.Gruppo;
import it.polito.tdp.bar.model.Simulator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class BarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleSimula(ActionEvent event) {

    		Simulator sim = new Simulator() ;
			
			int time = 0 ; 
			
			for(int i=0; i<2000; i++) {
				Gruppo g = new Gruppo() ;
				sim.addGruppo(g, time) ;
				
				time += (int)(1+Math.random()*10); // intervallo tra uno e l'altro di 10 minuti...
			}
	
			sim.run(); 

			txtResult.appendText(String.format("Totali: %d\nSoddisfatti Tavolo: %d\nSoddisfatti Bancone: %d\nInsoddisfatti: %d\n\n", 
					sim.getNumero_totale_clienti(),
					sim.getNumero_clienti_soddisfatti_tavolo(),
					sim.getNumero_clienti_soddisfatti_bancone(),
					sim.getNumero_clienti_insoddisfatti()));
			
    }

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";

    }
}
