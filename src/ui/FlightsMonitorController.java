package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Flight;
import model.FlightsMonitor;

public class FlightsMonitorController implements Initializable{
    @FXML
    private TextField searchText;
    @FXML
    private TextField flightsNumberText;
    @FXML
    private TitledPane sortT;
    @FXML
    private RadioButton airLineSort;
    @FXML
    private RadioButton boardSort;
    @FXML
    private RadioButton dateSort;
    @FXML
    private RadioButton desSort;
    @FXML
    private RadioButton flightSort;
    @FXML
    private RadioButton timeSort;
    @FXML
    private TitledPane searchT;
    @FXML
    private RadioButton airLineSearch;
    @FXML
    private RadioButton boardSearch;
    @FXML
    private RadioButton dateSearch;
    @FXML
    private RadioButton desSearch;
    @FXML
    private RadioButton flightSearch;
    @FXML
    private RadioButton timeSearch;
    @FXML
    private TableView<Flight> flightsTable;
    @FXML
    private TableColumn<Flight, String> airlineT;
    @FXML
    private TableColumn<Flight, Integer> boardT;	
    @FXML
    private TableColumn<Flight, String> dateT;
    @FXML
    private TableColumn<Flight, String> desT;
    @FXML
    private TableColumn<Flight, Integer> flightT;
    @FXML
    private TableColumn<Flight, String> timeT;
    private FlightsMonitor fm;
    private ObservableList<Flight> flights;
    @FXML
    void generateFlights(ActionEvent event) throws NumberFormatException, IOException {
    	flightsTable.setItems(fm.generateFlights(Integer.parseInt(flightsNumberText.getText())));
    }
    @FXML
    void searchBy(ActionEvent event) {

    }

    @FXML
    void sortBy(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		flights = FXCollections.observableArrayList();
		fm = new FlightsMonitor(flights);
		airlineT.setCellValueFactory(new PropertyValueFactory<Flight, String>("airLine"));
		boardT.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("boardingGate"));
		dateT.setCellValueFactory(new PropertyValueFactory<Flight, String>("date"));
		desT.setCellValueFactory(new PropertyValueFactory<Flight, String>("destination"));
		flightT.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("flightNumber"));
		timeT.setCellValueFactory(new PropertyValueFactory<Flight, String>("time"));
	}

}

