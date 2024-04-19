package src.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class Gam9x9Controller {
    // Var Fxml
    @FXML
    private AnchorPane anchorPane;
    // Var
    public final int SIZE = 9;
    private List<Button> lNode;
    private List<Button> lNummber;

    // Init
    @FXML
    public void initialize() {
        // Init
        lNode = new ArrayList<Button>();
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
                String idNode = "#node_" + i + j;
                Button node = (Button) anchorPane.lookup(idNode);
                lNode.add(node);
                node.addEventHandler(MouseEvent.MOUSE_CLICKED, this::handleClickNode);
            }
        }
    }

    // Add Nummber
    private void addNummberToList() {
        for (int i = 1; i <= SIZE; i++) {
            String idNumber = "#number_" + i;
            Button number = (Button) anchorPane.lookup(idNumber);
            lNummber.add(number);
            number.addEventHandler(MouseEvent.MOUSE_CLICKED, this::handleClickNumber);
        }
    }

    // Handle Click Node
    private void handleClickNode(MouseEvent e) {
        Button node = (Button) e.getSource();
        String idNode = node.getId();
        System.out.println(idNode);
    }

    // Handle Click Number
    private void handleClickNumber(MouseEvent e) {
        Button number = (Button) e.getSource();
        String idNumber = number.getId();
        System.out.println(idNumber);
    }

}
