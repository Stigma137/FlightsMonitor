package ui;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Flight;
import model.FlightsMonitor;

public class FlightsMonitorController implements Initializable{

    @FXML
    private Button backButton;
    @FXML
    private Button forwardButton;
    @FXML
    private TextField searchText;
    @FXML
    private TextField flightsNumberText;
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
    private RadioButton datetimeSort;
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
    @FXML
    private ToggleGroup  sortGroup;
    @FXML
    private ToggleGroup  searchGroup;
    
    private FlightsMonitor fm;
    private final static int ITEMS_PER_PAGE = 23;
    private int currentPage;
    private ObservableList<Flight> flights;
    
    /* Event that allows to generate a determinate number of flights.
     * @param an ActionEvent that represents the generate button.
     */
    @FXML
    void generateFlights(ActionEvent event) throws NumberFormatException, IOException {
    	fm.generateFlights(Integer.parseInt(flightsNumberText.getText()));
    	flights = fm.getFlights();
    	setupPage();
    }
    /* Event that allows to search a flight in the flights list by a determinate criterion.
     * @param an ActionEvent that represents the search button.
     */
    @FXML
    void searchBy(ActionEvent event) {
    	String option = (String) (searchGroup.getSelectedToggle().getUserData());
    	Pane root = new Pane();
		Label result = new Label();
		result.relocate(5, 25);
		root.getChildren().addAll(result);
		Scene scene = new Scene(root, 850, 60);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("SEARCHING RESULT");
		stage.show();
    	switch(option) {
    	case "airsearch":
    		result.setText(fm.search("airsearch", searchText.getText()).toString());
    		break;
    	case "boardsearch":
    		result.setText(fm.search("boardsearch", searchText.getText()).toString());
    		break;
    	case "datesearch":
    		result.setText(fm.search("datesearch", searchText.getText()).toString());
    		break;
    	case "destinationsearch":
    		result.setText(fm.search("destinationsearch", searchText.getText()).toString());
    		break;
    	case "flightsearch":
    		result.setText(fm.search("flightsearch", searchText.getText()).toString());
    		break;
    	case "timesearch":
    		result.setText(fm.search("timesearch", searchText.getText()).toString());
    		break;
    		
    	}
    }
    /* Event that allows to sort the flights list by a determinate criterion.
     * @param an ActionEvent that represents the sort button.
     */
    @FXML
    void sortBy(ActionEvent event) {
    	String option = (String) sortGroup.getSelectedToggle().getUserData();
    	fm.sort(option);
    	switch(option) {
    	case "airlinesort":
    		fm.sort("airlinesort");
    		setupPage();
    		break;
    	case "boardsort":
    		fm.sort("boardsort");
    		setupPage();
    		break;
    	case "datesort":
    		fm.sort("datesort");
    		setupPage();
    		break;
    	case "dessort":
    		fm.sort("dessort");
    		setupPage();
    		break;
    	case "flightsort":
    		fm.sort("flightsort");
    		setupPage();
    		break;
    	case "timesort":
    		fm.sort("timesort");
    		setupPage();
    		break;
    	case "datetimesort":
    		fm.sort("datetimesort");
    		setupPage();
    		break;
    		
    	}
    }
    /* Method that allows to switch the page back.
     * @param an ActionEvent that represents the back button.
     */
    @FXML
    void turnPageBack(ActionEvent event) {
    	currentPage -= 1;
    	setupPage();
    }
    /* Method that allows to switch the page forward.
     * @param an ActionEvent that represents the forward button.
     */
    @FXML
    void turnPageForward(ActionEvent event) {
    	currentPage += 1;
    	setupPage();
    }
    /* Method that allows to distribute the list in sub lists per page.
     */
    public void setupPage() {
    	int fromIndex = currentPage * ITEMS_PER_PAGE;
    	int toIndex = Math.min( fromIndex + ITEMS_PER_PAGE, flights.size());
    	ObservableList<Flight> subFlights = FXCollections.observableArrayList(flights.subList(fromIndex, toIndex));
    	flightsTable.setItems(subFlights);
    	if(toIndex < flights.size()) {
    		forwardButton.setDisable(false);
    	} else {
    		forwardButton.setDisable(true);
    	} if (fromIndex != 0) {
    		backButton.setDisable(false);
    	} else {
    		backButton.setDisable(true);
    	}
    }
    /*
     * (non-Javadoc)
     * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
     */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		currentPage = 0;
		flights = FXCollections.observableArrayList();
		fm = new FlightsMonitor(flights);
		airlineT.setCellValueFactory(new PropertyValueFactory<Flight, String>("airLine"));
		boardT.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("boardingGate"));
		dateT.setCellValueFactory(new PropertyValueFactory<Flight, String>("date"));
		desT.setCellValueFactory(new PropertyValueFactory<Flight, String>("destination"));
		flightT.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("flightNumber"));
		timeT.setCellValueFactory(new PropertyValueFactory<Flight, String>("time"));
		
		airLineSearch.setUserData("airsearch");
		boardSearch.setUserData("boardsearch");
		dateSearch.setUserData("datesearch");
		desSearch.setUserData("destinationsearch");
		flightSearch.setUserData("flightsearch");
		timeSearch.setUserData("timesearch");
		
		airLineSort.setUserData("airlinesort");
		boardSort.setUserData("boardsort");
		dateSort.setUserData("datesort");
		datetimeSort.setUserData("datetimesort");
		desSort.setUserData("dessort");
		flightSort.setUserData("flightsort");
		timeSort.setUserData("timesort");
	}

}

