package Assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SocialNetworkGraphApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SocialNetworkGraphApp().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Social Network Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GraphCanvas canvas = new GraphCanvas();
        frame.add(canvas, BorderLayout.CENTER);
        
        Toolbar toolbar = new Toolbar(canvas);
        frame.add(toolbar, BorderLayout.NORTH);

        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}

class GraphCanvas extends JPanel {
    // Define data structures to hold user data, nodes, and edges
    // You'll need classes to represent User, Node, and Edge
    
    // Implement methods to add, delete, and search users, nodes, and edges
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Implement code to draw nodes and edges based on user data
    }
}

class Toolbar extends JPanel {
    private JButton addNodeButton;
    private JButton addEdgeButton;
    private JButton selectModeButton;
    private JTextField searchField;
    private JButton searchButton;

    private GraphCanvas canvas;

    public Toolbar(GraphCanvas canvas) {
        this.canvas = canvas;

        addNodeButton = new JButton("Add Node");
        addEdgeButton = new JButton("Add Edge");
        selectModeButton = new JButton("Select Mode");
        searchField = new JTextField(15);
        searchButton = new JButton("Search");

        add(addNodeButton);
        add(addEdgeButton);
        add(selectModeButton);
        add(searchField);
        add(searchButton);

        // Implement action listeners for buttons
        addNodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle adding a new node
            }
        });
        
        // Implement action listeners for other buttons
    }
}
