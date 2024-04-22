package src.Controller.Game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import src.Model.NodeGame;
import src.Model.Validate;
import src.Obj.Game;
import src.Obj.User;
import src.Obj.UserGame;
import src.Utils.HandleFillColorNode;
import src.Utils.IdToLocation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    // Var Fxml
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField health;

    // Var
    private int SIZE;
    private UserGame userGame;
    private Game game;
    private User user;
    private Validate validate;
    private List<List<Button>> lNode;
    private List<Button> lNummber;
    public static Button buttonNodeClickedAfter;

    // Init
    public void initialize(User user, Game game) {
        // Init
        this.game = game;
        this.user = user;

        validate = new Validate(game);

        this.SIZE = game.getSize();
        lNode = new ArrayList<>();

        // Set health
        health.setText(String.valueOf(game.getError()));

        for (int i = 0; i < SIZE; i++) {
            lNode.add(new ArrayList<Button>());
        }
        lNummber = new ArrayList<Button>();
        // Add Node
        addNodeToList();
        // Add Nummber
        addNummberToList();
    }

    // Game Check
    public void gameCheck() {
        if (game.getEmpty() <= 0) {
            // Check Win
            System.out.println("Win");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.exit(0);
        }
        if (game.getError() < 0) {
            // Check Lose
            System.out.println("Lose");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.exit(0);
        }
    }

    // Add Node
    private void addNodeToList() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                String idNode = "#node_" + i +"_" + j;
                Button node = (Button) anchorPane.lookup(idNode);
                lNode.get(i).add(j, node);

                // Gắn giá trị của game cho node
                if (game.getListNodeGame()[i][j].getValue() != 0) {
                    node.setText(String.valueOf(game.getListNodeGame()[i][j].getValue()));
                } else {
                    node.setText("");
                }


                final int row = i;
                final int col = j;
                node.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        e -> {
                            handleClickNode(e, row, col);
                        }
                );
            }
        }
    }

    // Add Nummber
    private void addNummberToList() {
        for (int i = 1; i <= SIZE; i++) {
            String idNumber = "#number_" + i;
            Button number = (Button) anchorPane.lookup(idNumber);
            lNummber.add(number);
            number.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                handleClickNumber(e);
            });
        }
    }

    // Handle Click Node
    private void handleClickNode(MouseEvent e, int row, int col) {
        Button node = (Button) e.getSource();
        String idNode = node.getId();
        HandleFillColorNode.handleFillColorNode(node, row, col, lNode, SIZE);
    }

    // Handle Click Number
    private void handleClickNumber(MouseEvent e) {
        Button number = (Button) e.getSource();
        int n = Integer.parseInt(number.getText());
        if (buttonNodeClickedAfter != null && buttonNodeClickedAfter.getText() == "") {
            if (validate.ValidateSafe(new NodeGame(
                    IdToLocation.getIdRow(buttonNodeClickedAfter.getId()),
                    IdToLocation.getIdCol(buttonNodeClickedAfter.getId()),
                    n)
            )) {
                buttonNodeClickedAfter.setText(String.valueOf(n));
                game.setEmpty(game.getEmpty() - 1);
            } else {
                game.setError(game.getError() - 1);
                health.setText(String.valueOf(game.getError()));
            }
            HandleFillColorNode.disableFillColorNode(buttonNodeClickedAfter,
                    IdToLocation.getIdRow(buttonNodeClickedAfter.getId()),
                    IdToLocation.getIdCol(buttonNodeClickedAfter.getId()), lNode, SIZE);
            gameCheck();
        }
    }

    // Handle Click Menu
    public void handleClickMenu(MouseEvent event) { // todo viết
        try {
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/View/Home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
