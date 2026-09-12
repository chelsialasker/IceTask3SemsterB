import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class main extends JFrame {
    private ArrayList<String> vertices = new ArrayList<>();
    private JTextArea output;

    public main() {
        setTitle("Graph Algorithms Visualizer");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Graph Algorithms Visualizer");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton addVertexButton = new JButton("Add Vertex");
        JButton showVerticesButton = new JButton("Show Vertices");
        JButton resetButton = new JButton("Reset");

        output = new JTextArea();
        output.setEditable(false);

        addVertexButton.addActionListener(e -> {
            String vertex = JOptionPane.showInputDialog(
                    this,
                    "Enter vertex name:"
            );

            if (vertex != null && !vertex.trim().isEmpty()) {
                vertices.add(vertex);
                output.append("Added vertex: " + vertex + "\n");
            }
        });

        showVerticesButton.addActionListener(e -> {
            output.append("\nVertices:\n");
            for (String vertex : vertices) {
                output.append(vertex + "\n");
            }
        }); // <-- this closing brace + semicolon was missing, which trapped
// everything below inside this lambda

        resetButton.addActionListener(e -> {
            vertices.clear();
            output.setText("");
        });

// Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addVertexButton);
        buttonPanel.add(showVerticesButton);
        buttonPanel.add(resetButton);

// Add everything to window
        add(title, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(output), BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            main window = new main();
            window.setVisible(true);
        });
    }
}

