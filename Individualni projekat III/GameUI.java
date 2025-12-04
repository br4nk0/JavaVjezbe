package vjezbeXII;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class GameUI extends JFrame {
    private JTextField nameField = new JTextField(20);
    private JTextField healthField = new JTextField(4);
    private JTextField xField = new JTextField(4);
    private JTextField yField = new JTextField(4);
    private JRadioButton rectBtn = new JRadioButton("Rectangle (32x32)", true);
    private JRadioButton circleBtn = new JRadioButton("Circle (r=16)");
    private JButton runBtn = new JButton("Pokreni igru");
    private JTextArea outputArea = new JTextArea(20, 50);

    public GameUI() {
        super("Simple Game UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel input = new JPanel();
        input.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4,4,4,4);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0; input.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1; input.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; input.add(new JLabel("Health (0-100):"), gbc);
        gbc.gridx = 1; input.add(healthField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; input.add(new JLabel("X:"), gbc);
        gbc.gridx = 1; input.add(xField, gbc);
        gbc.gridx = 2; input.add(new JLabel("Y:"), gbc);
        gbc.gridx = 3; input.add(yField, gbc);

        ButtonGroup group = new ButtonGroup();
        group.add(rectBtn); group.add(circleBtn);
        gbc.gridx = 0; gbc.gridy = 3; input.add(rectBtn, gbc);
        gbc.gridx = 1; input.add(circleBtn, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; input.add(runBtn, gbc);

        add(input, BorderLayout.NORTH);

        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        runBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRun();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void onRun() {
        try {
            String name = nameField.getText();
            int health = Integer.parseInt(healthField.getText().trim());
            int x = Integer.parseInt(xField.getText().trim());
            int y = Integer.parseInt(yField.getText().trim());

            Collidable collider;
            if (rectBtn.isSelected()) {
                collider = new RectangleCollider(x, y, 32, 32);
            } else {
                collider = new CircleCollider(x, y, 16);
            }

            Player player = new Player(name, x, y, collider, health);
            Game game = new Game(player);

            // let user pick CSV file
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Select enemies CSV file");
            int res = chooser.showOpenDialog(this);
            if (res != JFileChooser.APPROVE_OPTION) return;
            String path = chooser.getSelectedFile().getAbsolutePath();

            List<Enemy> loaded = Game.loadEnemiesFromCSV(path);
            for (Enemy en : loaded) game.addEnemy(en);

            game.resolveCollisions();

            StringBuilder sb = new StringBuilder();
            sb.append("Player status:\n");
            sb.append(game.getPlayer().toString()).append('\n');
            sb.append("\nEnemies:\n");
            for (Enemy en : game.getEnemies()) {
                sb.append(en.toString()).append('\n');
            }
            sb.append("\nSudar sa igracem:\n");
            for (Enemy en : game.collidingWithPlayer()) {
                sb.append(en.toString()).append('\n');
            }
            sb.append("\nEvent log:\n");
            for (String log : game.getLog()) {
                sb.append(log).append('\n');
            }

            outputArea.setText(sb.toString());

            if (game.getPlayer().getHealth() <= 0) {
                JOptionPane.showMessageDialog(this, "Player porazen!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            } else if (game.collidingWithPlayer().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nema sudara sa enemies: ", "Victory", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Unesi normalan broj za health i poziciju.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to load CSV: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}