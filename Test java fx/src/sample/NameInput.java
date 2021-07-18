package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NameInput {
    @FXML
    public Button Back;
    private Main main;
    private String name;
    private String Club_name;
@FXML
    public Button Name_Submit;
@FXML
    public Button Reset_Button;
@FXML
    public TextField Name;
@FXML
    public void Submit(ActionEvent actionEvent)throws Exception {
        name= Name.getText();
        main.ShowPlayerNameSearchResult(name,Club_name);
    }

    public void Reset(ActionEvent actionEvent) {
    Name.setText("");
    }

    public void Back(ActionEvent actionEvent) throws Exception{
   main.showMainMenu(Club_name);
    }

    public String getName() {
        return name;
    }

    void setMain(Main main) {
        this.main = main;
    }
    public void setClub_name(String club_name) {
        Club_name = club_name;
    }
}
