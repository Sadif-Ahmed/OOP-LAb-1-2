package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class PositionInput {
    @FXML
    public TextField Position;
    private String position;
    private Main main;
    private String Club_name;
    public void Submit(ActionEvent actionEvent) throws Exception {
        position= Position.getText();

        if (position.equalsIgnoreCase("Forward")||position.equalsIgnoreCase("Midfielder")||position.equalsIgnoreCase("Goalkeeper")||position.equalsIgnoreCase("Defender"))
        {
             main.ShowPositionNameSearchResult(position,Club_name);
        }
        else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Position Input Window");
            a.setContentText("Wrong Position");
            a.showAndWait();
        }

    }

    public void Reset(ActionEvent actionEvent) {
        Position.setText("");
    }

    public void Back(ActionEvent actionEvent)throws Exception {
       main.showMainMenu(Club_name);
    }
    void setMain(Main main) {
        this.main = main;
    }
    public String getPosition()
    {
        return position;
    }
    public void setClub_name(String club_name) {
        Club_name = club_name;
    }


}
