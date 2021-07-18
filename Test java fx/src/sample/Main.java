package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        showLoginPage();
    }

    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        // Loading the controller
        LoginController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public void showMainMenu(String Clubname) throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Main_Menu.fxml"));
        Parent root = loader.load();

        // Loading the controller
        MainMenu controller = loader.getController();
        controller.setClub_name(Clubname);
        controller.Club.setText(Clubname);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Main");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }


    public void ShowNameInput(String Clubname) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Name_Input.fxml"));
        Parent root = loader.load();

        // Loading the controller
       NameInput controller = loader.getController();
       controller.setClub_name(Clubname);
        controller.setMain(this);
        stage.setTitle("Name Input");
        stage.setScene(new Scene(root, 600, 400));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowClubCountryInput(String Clubname) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Club_Country_input.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ClubCountryInput controller = loader.getController();
        controller.setClub_name(Clubname);
        controller.setMain(this);
        stage.setTitle("Club and Country Input");
        stage.setScene(new Scene(root, 600, 400));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowPositionInput(String Clubname) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Position_Input.fxml"));
        Parent root = loader.load();

        // Loading the controller
       PositionInput controller = loader.getController();
       controller.setClub_name(Clubname);
        controller.setMain(this);
        stage.setTitle("Position Input");
        stage.setScene(new Scene(root, 600, 400));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowSalaryRangeInput(String Clubname) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Salary_Range_Input.fxml"));
        Parent root = loader.load();

        // Loading the controller
        SalaryRangeInput controller = loader.getController();
        controller.setClub_name(Clubname);
        controller.setMain(this);
        stage.setTitle("Salary Range Input");
        stage.setScene(new Scene(root, 600, 400));
        stage.setResizable(false);
        stage.show();
    }


    public void ShowPlayerNameSearchResult(String name,String Clubname) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableViewPlayerName.fxml"));
        Parent root = loader.load();

        TableViewPlayerNameController controller = loader.getController();
        controller.setName(name);
        controller.setClub_name(Clubname);
        controller.load();
        controller.setMain(this);
        stage.setTitle("Table View");
        stage.setScene(new Scene(root, 700, 300));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowClubCountryNameSearchResult(String Country_name,String Club_name) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableViewClubCountryname.fxml"));
        Parent root = loader.load();

        TableViewClubCountryNameController controller = loader.getController();
        controller.setCountry_Name(Country_name);
        controller.setClub_Name(Club_name);
        controller.load();
        controller.setMain(this);
        stage.setTitle("Table View");
        stage.setScene(new Scene(root, 700, 700));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowPositionNameSearchResult(String position_name,String Clubname) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableViewPositionName.fxml"));
        Parent root = loader.load();

       TableViewPositionNameController controller = loader.getController();
        controller.setPosition_Name(position_name);
        controller.setClub_name(Clubname);
        controller.load();
        controller.setMain(this);
        stage.setTitle("Table View");
        stage.setScene(new Scene(root, 700, 300));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowSalaryRangeNameSearchResult(double min_range,double max_range,String Clubname) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableViewSalaryRangeName.fxml"));
        Parent root = loader.load();

        TableViewSalaryRangeNameController controller = loader.getController();
        controller.setMin_Range(min_range);
        controller.setMax_Range(max_range);
        controller.setClub_name(Clubname);
        controller.load();
        controller.setMain(this);
        stage.setTitle("Table View");
        stage.setScene(new Scene(root, 700, 300));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowCountryWisePlayerCountSearchResult(String Clubname) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableViewCountryWisePlayer.fxml"));
        Parent root = loader.load();

        TableViewCountryWisePlayerController controller = loader.getController();
        controller.setClub_name(Clubname);
        controller.load();
        controller.setMain(this);
        stage.setTitle("Table View");
        stage.setScene(new Scene(root, 700, 300));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowClubMaxSalarySearchResult(String Club_name) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableViewClubMaxSalary.fxml"));
        Parent root = loader.load();

        TableViewClubMaxSalaryController controller = loader.getController();
        controller.setClub_Name(Club_name);
        controller.load();
        controller.setMain(this);
        stage.setTitle("Table View");
        stage.setScene(new Scene(root, 700, 300));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowClubMaxAgeSearchResult(String Club_name) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableViewClubMaxAge.fxml"));
        Parent root = loader.load();

        TableViewClubMaxAgeController controller = loader.getController();
        controller.setClub_Name(Club_name);
        controller.load();
        controller.setMain(this);
        stage.setTitle("Table View");
        stage.setScene(new Scene(root, 700, 300));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowClubMaxHeightSearchResult(String Club_name) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableViewClubMaxHeight.fxml"));
        Parent root = loader.load();

        TableViewClubMaxHeightController controller = loader.getController();
        controller.setClub_Name(Club_name);
        controller.load();
        controller.setMain(this);
        stage.setTitle("Table View");
        stage.setScene(new Scene(root, 700, 300));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowClubTotalSalary(String Club_name) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TotalClubSalaryOutput.fxml"));
        Parent root = loader.load();

        TotalClubSalaryOutput controller = loader.getController();
        controller.setClub_Name(Club_name);
        controller.work();
        controller.setMain(this);
        stage.setTitle("Total Salary");
        stage.setScene(new Scene(root, 600, 400));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowGratitude() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Thank_You.fxml"));
        Parent root = loader.load();
        ThankYou controller = loader.getController();
        controller.setMain(this);
        stage.setTitle("Gratitude");
        stage.setScene(new Scene(root, 600, 400));
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        // This will launch the JavaFX application
        launch(args);
    }
}
