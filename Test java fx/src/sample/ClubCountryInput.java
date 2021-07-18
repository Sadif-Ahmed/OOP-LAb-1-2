package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ClubCountryInput {
    @FXML
    public TextField Country_Name;
    private Main main;
    private String Country_name;
    private String Club_name;
    public void Reset(ActionEvent actionEvent) {
        Country_Name.setText("");

    }

    public void Back(ActionEvent actionEvent)throws Exception {
       main.showMainMenu(Club_name);

    }

    public void Submit(ActionEvent actionEvent)throws Exception {
        Country_name= Country_Name.getText();
        main.ShowClubCountryNameSearchResult(Country_name,Club_name);
    }
    void setMain(Main main) {
        this.main = main;
    }

    public String getClub_name() {
        return Club_name;
    }
    public String getCountry_name() {
        return Country_name;
    }
    public void setClub_name(String club_name) {
        Club_name = club_name;
    }
}
