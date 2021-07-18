package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainMenu {
    public Label Club;
    private Main main;
    @FXML
    private String Club_name;
    void setMain(Main main) {
        this.main = main;
    }

    public void setClub_name(String club_name) {
        Club_name = club_name;
    }
    public void Player_name(ActionEvent actionEvent) throws Exception {
        main.ShowNameInput(Club_name);
    }
    public void Club_Country(ActionEvent actionEvent) throws Exception{
        main.ShowClubCountryInput(Club_name);
    }

    public void Position(ActionEvent actionEvent) throws Exception{
        main.ShowPositionInput(Club_name);
    }

    public void salary_range(ActionEvent actionEvent) throws Exception{
        main.ShowSalaryRangeInput(Club_name);
    }

    public void country_player_count(ActionEvent actionEvent) throws Exception{
        main.ShowCountryWisePlayerCountSearchResult(Club_name);
    }

    public void max_salary(ActionEvent actionEvent) throws Exception{
        main.ShowClubMaxSalarySearchResult(Club_name);
    }

    public void max_age(ActionEvent actionEvent) throws Exception{
        main.ShowClubMaxAgeSearchResult(Club_name);
    }

    public void max_height(ActionEvent actionEvent) throws Exception{
        main.ShowClubMaxHeightSearchResult(Club_name);
    }

    public void total_salary(ActionEvent actionEvent) throws Exception{
        main.ShowClubTotalSalary(Club_name);
    }
    public void buy(ActionEvent actionEvent) {
    }

    public void sell(ActionEvent actionEvent) {
    }
    public void Save_Exit(ActionEvent actionEvent)throws Exception {
        main.ShowGratitude();
    }

}
