package src.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import src.Obj.Game;
import src.Utils.HandleFillColorNode;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    // Var Fxml
    @FXML
    private AnchorPane anchorPane;
    // Var
    private int SIZE;
    private Game game;
    private List<List<Button>> lNode;
    private List<Button> lNummber;
    public static Button buttonNodeClickedAfter;

    // Init
    public void initialize(Game game) {
        // Init
        this.game = game;
        this.SIZE = game.getSize();
        lNode = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            lNode.add(new ArrayList<Button>());
        }
        lNummber = new ArrayList<Button>();
        // Add Node
        addNodeToList();
        // Add Nummber
        addNummberToList();
    }

    // Add Node
    private void addNodeToList() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                String idNode = "#node_" + i +"_" + j;
                Button node = (Button) anchorPane.lookup(idNode);
                lNode.get(i).add(j, node);

                // Gắn giá trị của game cho node
                node.setText(String.valueOf(game.getListNodeGame()[i][j].getValue()));

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
        System.out.println(idNode);
        HandleFillColorNode.handleFillColorNode(node, row, col, lNode, SIZE);
    }

    // Handle Click Number
    private void handleClickNumber(MouseEvent e) {
        Button number = (Button) e.getSource();
        String idNumber = number.getId();
        System.out.println(idNumber);
    }

}
