package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SalaryRangeInput {
    @FXML
    public TextField Minimum_Salary;
    @FXML
    public TextField Maximum_Salary;
    private double Min_Salary;
    private double Max_Salary;
    private String Club_name;
    private Main main;

    public void Submit(ActionEvent actionEvent) throws Exception{
        Min_Salary=Double.parseDouble(Minimum_Salary.getText());
        Max_Salary=Double.parseDouble(Maximum_Salary.getText());
        main.ShowSalaryRangeNameSearchResult(Min_Salary,Max_Salary,Club_name);
    }

    public void Reset(ActionEvent actionEvent) {
        Minimum_Salary.setText("");
        Maximum_Salary.setText("");
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
