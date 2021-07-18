package sample;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class TableViewCountryWisePlayerController {
    @FXML
    private TableView tableView;

    ObservableList<Country> List;
    List<PlayerInfo> Players = new ArrayList();
    List<PlayerInfo> SearchList1 = new ArrayList();

    private Main main;
    private String Club_name;

    private boolean init = true;

    private void initializeColumns() {
        TableColumn<Country, String> NameCol = new TableColumn<>("Name");
        NameCol.setMinWidth(60);
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<Country, Integer> CountCol = new TableColumn<>("Number of Players");
        CountCol.setMinWidth(40);
        CountCol.setCellValueFactory(new PropertyValueFactory<>("NumberOfPlayers"));
        tableView.getColumns().addAll(NameCol,CountCol);
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
        TempClub=FileInputOutput.Search_Club(Club_name,Clubs);
        SearchList1=SearchingPlayer.Country_list(TempClub.Players);
        int [] count=SearchingPlayer.Country_PlayerCount(SearchList1,TempClub.Players);
        List=PlayerInfoBeta.getCountryPlayerlsit(SearchList1,count);
        tableView.setEditable(true);
        tableView.setItems(List);
    }

    public void Back(ActionEvent actionEvent)throws Exception {
       main.showMainMenu(Club_name);

    }
    void setMain(Main main) {
        this.main = main;
    }

    public void setClub_name(String club_name) {
        Club_name = club_name;
    }
}
