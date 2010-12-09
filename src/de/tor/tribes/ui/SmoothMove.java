/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tor.tribes.ui;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.swing.*;
import javax.swing.event.*;

/** @author John B. Matthews; distribution per GPL. */
public class SmoothMove extends JPanel
    implements ActionListener, ChangeListener {

    private static final int WIDE = 640;
    private static final int HIGH = 640;
    private static final int RADIUS = 35;
    private ControlPanel control;
    private int radius = RADIUS;
    private Kind kind = Kind.Circular;
    private JComboBox kindBox = new JComboBox();
    private List<Node> nodes = new ArrayList<Node>();
    private List<Node> selected = new ArrayList<Node>();
    private List<Edge> edges = new ArrayList<Edge>();
    private Point mousePt = new Point(WIDE / 2, HIGH / 2);
    private Rectangle mouseRect = new Rectangle();
    private boolean selecting = false;

    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame f = new JFrame("GraphPanel");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                SmoothMove gp = new SmoothMove();
                f.add(gp.control, BorderLayout.NORTH);
                f.add(new JScrollPane(gp), BorderLayout.CENTER);
                f.getRootPane().setDefaultButton(gp.control.newButton);
                f.pack();
                f.setVisible(true);
            }
        });
    }

    SmoothMove() {
        this.setPreferredSize(new Dimension(WIDE, HIGH));
        this.control = new ControlPanel();
        this.addMouseListener(new MouseHandler());
        this.addMouseMotionListener(new MouseMotionHandler());
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(new Color(0x00f0f0f0));
        g.fillRect(0, 0, getWidth(), getHeight());
        for (Edge e : edges) {
            e.draw(g);
        }
        for (Node n : nodes) {
            n.draw(g);
        }
        if (selecting) {
            g.setColor(Color.darkGray);
            g.drawRect(mouseRect.x, mouseRect.y,
                mouseRect.width, mouseRect.height);
        }
    }

    public void actionPerformed(ActionEvent e) {
        Color color = control.colorIcon.getColor();
        String cmd = e.getActionCommand();
        if ("Clear".equals(cmd)) {
            nodes.clear();
            edges.clear();
        } else if ("Color".equals(cmd)) {
            color = JColorChooser.showDialog(
                this, "Choose a color", color);
            if (color != null) {
                Node.updateColor(nodes, color);
                control.colorIcon.setColor(color);
                control.repaint();
            }
        } else if ("Connect".equals(cmd)) {
            Node.getSelected(nodes, selected);
            if (selected.size() > 1) {
                for (int i = 0; i < selected.size() - 1; ++i) {
                    Node n1 = selected.get(i);
                    Node n2 = selected.get(i + 1);
                    edges.add(new Edge(n1, n2));
                }
            }
        } else if ("Delete".equals(cmd)) {
            deleteSelected();
        } else if ("Kind".equals((cmd))) {
            kind = (Kind) kindBox.getSelectedItem();
            Node.updateKind(nodes, kind);
        } else if ("New".equals(cmd)) {
            Node.selectNone(nodes);
            Point p = mousePt.getLocation();
            Node n = new Node(p, radius, color, kind);
            n.setSelected(true);
            nodes.add(n);
        } else {
            for (Kind k : Kind.values()) {
                if (k.toString().equals(cmd)) {
                    kindBox.setSelectedItem(k);
                }
            }
        }
        this.repaint();
    }

    private void deleteSelected() {
        ListIterator<Node> iter = nodes.listIterator();
        while (iter.hasNext()) {
            Node n = iter.next();
            if (n.isSelected()) {
                deleteEdges(n);
                iter.remove();
            }
        }
    }

    private void deleteEdges(Node n) {
        ListIterator<Edge> iter = edges.listIterator();
        while (iter.hasNext()) {
            Edge e = iter.next();
            if (e.n1 == n || e.n2 == n) {
                iter.remove();
            }
        }
    }

    public void stateChanged(ChangeEvent e) {
        JSpinner s = (JSpinner) e.getSource();
        radius = (Integer) s.getValue();
        Node.updateRadius(nodes, radius);
        this.repaint();
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseReleased(MouseEvent e) {
            selecting = false;
            mouseRect.setBounds(0, 0, 0, 0);
            if (e.isPopupTrigger()) {
                showPopup(e);
            }
            e.getComponent().repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            mousePt = e.getPoint();
            if (e.isShiftDown()) {
                Node.selectToggle(nodes, mousePt);
            } else if (e.isPopupTrigger()) {
                Node.selectOne(nodes, mousePt);
                showPopup(e);
            } else if (Node.selectOne(nodes, mousePt)) {
                selecting = false;
            } else {
                Node.selectNone(nodes);
                selecting = true;
            }
            e.getComponent().repaint();
        }

        private void showPopup(MouseEvent e) {
            control.popup.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    private class MouseMotionHandler extends MouseMotionAdapter {

        Point delta = new Point();

        @Override
        public void mouseDragged(MouseEvent e) {
            if (selecting) {
                mouseRect.setBounds(
                    Math.min(mousePt.x, e.getX()),
                    Math.min(mousePt.y, e.getY()),
                    Math.abs(mousePt.x - e.getX()),
                    Math.abs(mousePt.y - e.getY()));
                Node.selectRect(nodes, mouseRect);
            } else {
                delta.setLocation(
                    e.getX() - mousePt.x,
                    e.getY() - mousePt.y);
                Node.updatePosition(nodes, delta);
                mousePt = e.getPoint();
            }
            e.getComponent().repaint();
        }
    }

    private class ControlPanel extends JPanel {

        private JButton newButton = new JButton("New");
        private ColorIcon colorIcon = new ColorIcon(Color.blue);
        private JPopupMenu popup = new JPopupMenu();

        ControlPanel() {
            this.setLayout(new FlowLayout(FlowLayout.LEFT));
            this.setBackground(Color.lightGray);
            newButton.addActionListener(SmoothMove.this);
            this.add(newButton);
            JButton clearButton = new JButton("Clear");
            clearButton.addActionListener(SmoothMove.this);
            this.add(clearButton);
            for (Kind k : Kind.values()) {
                kindBox.addItem(k);
            }
            kindBox.setActionCommand("Kind");
            kindBox.addActionListener(SmoothMove.this);
            this.add(kindBox);
            JButton colorButton = new JButton("Color");
            colorButton.addActionListener(SmoothMove.this);
            this.add(colorButton);
            this.add(new JLabel(colorIcon));
            JSpinner js = new JSpinner();
            js.setModel(new SpinnerNumberModel(RADIUS, 5, 100, 5));
            js.addChangeListener(SmoothMove.this);
            this.add(new JLabel("Size:"));
            this.add(js);

            JMenuItem menuItem = new JMenuItem("New");
            menuItem.addActionListener(SmoothMove.this);
            popup.add(menuItem);
            menuItem = new JMenuItem("Color");
            menuItem.addActionListener(SmoothMove.this);
            popup.add(menuItem);
            menuItem = new JMenuItem("Connect");
            menuItem.addActionListener(SmoothMove.this);
            popup.add(menuItem);
            menuItem = new JMenuItem("Delete");
            menuItem.addActionListener(SmoothMove.this);
            popup.add(menuItem);
            JMenu subMenu = new JMenu("Kind");
            for (Kind k : Kind.values()) {
                menuItem = new JMenuItem(k.toString());
                menuItem.addActionListener(SmoothMove.this);
                subMenu.add(menuItem);
            }
            popup.add(subMenu);
        }
    }

    /** The kinds of node in a graph. */
    private enum Kind {

        Circular, Rounded, Square
    }

    /** An Edge is a pair of Nodes. */
    private static class Edge {

        private Node n1;
        private Node n2;

        public Edge(Node n1, Node n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

        public void draw(Graphics g) {
            Point p1 = n1.getLocation();
            Point p2 = n2.getLocation();
            g.setColor(Color.darkGray);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    /** A Node represents a node in a graph. */
    private static class Node {

        private Point p;
        private int r;
        private Color color;
        private Kind kind;
        private boolean selected = false;
        private Rectangle b = new Rectangle();

        /** Construct a new node. */
        public Node(Point p, int r, Color color, Kind kind) {
            this.p = p;
            this.r = r;
            this.color = color;
            this.kind = kind;
            setBoundary(b);
        }

        /** Calculate this node's rectangular boundary. */
        private void setBoundary(Rectangle b) {
            b.setBounds(p.x - r, p.y - r, 2 * r, 2 * r);
        }

        /** Draw this node. */
        public void draw(Graphics g) {
            g.setColor(this.color);
            if (this.kind == Kind.Circular) {
                g.fillOval(b.x, b.y, b.width, b.height);
            } else if (this.kind == Kind.Rounded) {
                g.fillRoundRect(b.x, b.y, b.width, b.height, r, r);
            } else if (this.kind == Kind.Square) {
                g.fillRect(b.x, b.y, b.width, b.height);
            }
            if (selected) {
                g.setColor(Color.darkGray);
                g.drawRect(b.x, b.y, b.width, b.height);
            }
        }

        /** Return this node's location. */
        public Point getLocation() {
            return p;
        }

        /** Return true if this node contains p. */
        public boolean contains(Point p) {
            return b.contains(p);
        }

        /** Return true if this node is selected. */
        public boolean isSelected() {
            return selected;
        }

        /** Mark this node as slected. */
        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        /** Collected all the selected nodes in list. */
        public static void getSelected(List<Node> list, List<Node> selected) {
            selected.clear();
            for (Node n : list) {
                if (n.isSelected()) {
                    selected.add(n);
                }
            }
        }

        /** Select no nodes. */
        public static void selectNone(List<Node> list) {
            for (Node n : list) {
                n.setSelected(false);
            }
        }

        /** Select a single node; return true if not already selected. */
        public static boolean selectOne(List<Node> list, Point p) {
            for (Node n : list) {
                if (n.contains(p)) {
                    if (!n.isSelected()) {
                        Node.selectNone(list);
                        n.setSelected(true);
                    }
                    return true;
                }
            }
            return false;
        }

        /** Select each node in r. */
        public static void selectRect(List<Node> list, Rectangle r) {
            for (Node n : list) {
                n.setSelected(r.contains(n.p));
            }
        }

        /** Toggle selected state of each node containing p. */
        public static void selectToggle(List<Node> list, Point p) {
            for (Node n : list) {
                if (n.contains(p)) {
                    n.setSelected(!n.isSelected());
                }
            }
        }

        /** Update each node's position by d (delta). */
        public static void updatePosition(List<Node> list, Point d) {
            for (Node n : list) {
                if (n.isSelected()) {
                    n.p.x += d.x;
                    n.p.y += d.y;
                    n.setBoundary(n.b);
                }
            }
        }

        /** Update each node's radius r. */
        public static void updateRadius(List<Node> list, int r) {
            for (Node n : list) {
                if (n.isSelected()) {
                    n.r = r;
                    n.setBoundary(n.b);
                }
            }
        }

        /** Update each node's color. */
        public static void updateColor(List<Node> list, Color color) {
            for (Node n : list) {
                if (n.isSelected()) {
                    n.color = color;
                }
            }
        }

        /** Update each node's kind. */
        public static void updateKind(List<Node> list, Kind kind) {
            for (Node n : list) {
                if (n.isSelected()) {
                    n.kind = kind;
                }
            }
        }
    }

    private static class ColorIcon implements Icon {

        private static final int WIDE = 20;
        private static final int HIGH = 20;
        private Color color;

        public ColorIcon(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(color);
            g.fillRect(x, y, WIDE, HIGH);
        }

        public int getIconWidth() {
            return WIDE;
        }

        public int getIconHeight() {
            return HIGH;
        }
    }
}