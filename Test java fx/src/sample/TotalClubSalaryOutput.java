package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class TotalClubSalaryOutput {
    @FXML
    public Label TotalSalary;
    private String Club_Name;
    private Main main;
    List<PlayerInfo> Players = new ArrayList();

    public void setClub_Name(String club_Name) {
        Club_Name = club_Name;
    }

    public void Back(ActionEvent actionEvent) throws Exception{
        main.showMainMenu(Club_Name);

    }
    void work() throws Exception
    {
        Players=FileInputOutput.readFromFile();
        double salary=ClubSearch.Yearly_Club_Salary(Club_Name,Players);
        TotalSalary.setText(String.format("%.0f",salary));
    }
    void setMain(Main main) {

        this.main = main;
    }
}
