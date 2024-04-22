package src.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import src.DataGame.Handle.HandleData;
import src.DataGame.Handle.HandleDataSql;


import java.io.IOException;

public class PlayNewController implements Initializable {
    // Var fxml
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private AnchorPane formCreatUser;
    @FXML
    private TextField nameNewUser;
    // Var
    private boolean isCreatUser = false;
    private HandleData handleData;

    // init
    @Override
    public void initialize(java.net.URL url, java.util.ResourceBundle resourceBundle) {
        formCreatUser.setVisible(false);
        handleData = new HandleDataSql();
    }

    // gotoLevel
    public void gotoLevel(ActionEvent event) {
        String name = nameNewUser.getText();
        if (name != null && !name.equals("")) {
            handleData.addUsers(name);
            helpGotoUsers();
        } else {
            nameNewUser.setPromptText("Vui lòng nhập !!!");
        }
    }

    // back
    public void back(MouseEvent event) throws Exception {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/src/View/Home.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
    }

    // gotoUsers
    public void gotoUsers(MouseEvent event) {
        helpGotoUsers();
    }

    // creatUser
    public void creatUser(MouseEvent event) {
        if (isCreatUser) {
            formCreatUser.setVisible(false);
        } else {
            formCreatUser.setVisible(true);
        }
        isCreatUser = !isCreatUser;
    }

    // Help gotoUsers
    private void helpGotoUsers()  {
        try {
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/src/View/User/Users.fxml"));
            Parent parent = loader.load();
            Scene scene = new Scene(parent);

            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
