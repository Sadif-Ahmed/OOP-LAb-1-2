package sample;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class TableViewClubCountryNameController {
    @FXML
    private TableView tableView;

    ObservableList<PlayerInfoBeta> List;
    List<PlayerInfo> Players = new ArrayList();
    private Main main;
    private String Club_Name;
    private String Country_Name;


    private boolean init = true;

    private void initializeColumns() {
        TableColumn<PlayerInfoBeta, String> NameCol = new TableColumn<>("Name");
        NameCol.setMinWidth(60);
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<PlayerInfoBeta, String> CountryCol = new TableColumn<>("Country");
        CountryCol.setMinWidth(40);
        CountryCol.setCellValueFactory(new PropertyValueFactory<>("Country"));

        TableColumn<PlayerInfoBeta, Integer> AgeCol = new TableColumn<>("Age");
        AgeCol.setMinWidth(20);
        AgeCol.setCellValueFactory(new PropertyValueFactory<>("Age"));

        TableColumn<PlayerInfoBeta, Double> HeightCol = new TableColumn<>("Height");
        HeightCol.setMinWidth(20);
        HeightCol.setCellValueFactory(new PropertyValueFactory<>("Height"));
        TableColumn<PlayerInfoBeta, String> ClubCol = new TableColumn<>("Club");
        ClubCol.setMinWidth(60);
        ClubCol.setCellValueFactory(new PropertyValueFactory<>("Club"));
        TableColumn<PlayerInfoBeta, String> PositionCol = new TableColumn<>("Position");
        PositionCol.setMinWidth(60);
        PositionCol.setCellValueFactory(new PropertyValueFactory<>("Position"));
        TableColumn<PlayerInfoBeta, Integer> NumberCol = new TableColumn<>("Number");
        NumberCol.setMinWidth(20);
        NumberCol.setCellValueFactory(new PropertyValueFactory<>("Number"));
        TableColumn<PlayerInfoBeta, Double> SalaryCol = new TableColumn<>("Salary");
        SalaryCol.setMinWidth(40);
        SalaryCol.setCellValueFactory(new PropertyValueFactory<>("Salary"));

        tableView.getColumns().addAll(NameCol,CountryCol,AgeCol,HeightCol,ClubCol,PositionCol,NumberCol,SalaryCol);
    }
    public void load() throws Exception{
        if (init) {
            initializeColumns();
            init = false;
        }
        List<Club> Clubs;
        Club TempClub;
        List<PlayerInfo> Search_list = new ArrayList();
        Players=FileInputOutput.readFromFile();
        Search_list=FileInputOutput.Club_list(Players);
        Clubs=FileInputOutput.Club_List_update(Search_list);
        FileInputOutput.Add_to_Clublist(Clubs,Players);
        TempClub=FileInputOutput.Search_Club(Club_Name,Clubs);
        List = PlayerInfoBeta.getObservablePlayerlsit(SearchingPlayer.Search_by_Club_and_Country(Country_Name,Club_Name,TempClub.Players));
        tableView.setEditable(true);
        tableView.setItems(List);
    }

    public void Back(ActionEvent actionEvent)throws Exception {
       main.showMainMenu(Club_Name);

    }
    void setMain(Main main) {
        this.main = main;
    }
    public void setClub_Name(String club_Name) {
        Club_Name = club_Name;
    }

    public void setCountry_Name(String country_Name) {
        Country_Name = country_Name;
    }
}