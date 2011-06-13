/*
 * DSWorkbenchSplashScreen.java
 *
 * Created on 30. Juni 2008, 14:12
 */
package de.tor.tribes.ui;

import de.tor.tribes.ui.views.DSWorkbenchSettingsDialog;
import de.tor.tribes.io.DataHolder;
import de.tor.tribes.util.GlobalOptions;
import org.apache.log4j.Logger;
import de.tor.tribes.io.DataHolderListener;
import de.tor.tribes.php.DatabaseInterface;
import de.tor.tribes.types.UserProfile;
import de.tor.tribes.ui.renderer.ProfileTreeNodeRenderer;
import de.tor.tribes.util.Constants;
import de.tor.tribes.util.JOptionPaneHelper;
import de.tor.tribes.util.PluginManager;
import de.tor.tribes.util.ProfileManager;
import java.awt.AWTEvent;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import org.apache.log4j.Level;
import org.apache.log4j.RollingFileAppender;

/**
 * @author  Jejkal
 */
public class DSWorkbenchSplashScreen extends javax.swing.JFrame implements DataHolderListener {

    private static Logger logger = Logger.getLogger("Launcher");
    private final DSWorkbenchSplashScreen self = this;
    private final SplashRepaintThread t;
    private static DSWorkbenchSplashScreen SINGLETON = null;

    public static synchronized DSWorkbenchSplashScreen getSingleton() {
        if (SINGLETON == null) {
            SINGLETON = new DSWorkbenchSplashScreen();
        }
        return SINGLETON;
    }

    /** Creates new form DSWorkbenchSplashScreen */
    DSWorkbenchSplashScreen() {
        initComponents();
        jLabel1.setIcon(new ImageIcon("./graphics/splash.gif"));
        setTitle("DS Workbench " + Constants.VERSION + Constants.VERSION_ADDITION);
        new Timer("StartupTimer", true).schedule(new HideSplashTask(), 1000);
        jProfileDialog.getContentPane().setBackground(Constants.DS_BACK_LIGHT);
        jProfileDialog.pack();
        jProfileDialog.setLocationRelativeTo(this);
        jProfileDialog.getContentPane().setBackground(Constants.DS_BACK);
        t = new SplashRepaintThread();
        t.start();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProfileDialog = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();
        jStatusOutput = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jProfileDialog.setTitle("Profile");
        jProfileDialog.setModal(true);
        jProfileDialog.setUndecorated(true);

        jScrollPane2.setViewportView(jTree1);

        jButton1.setBackground(new java.awt.Color(239, 235, 223));
        jButton1.setText("Profil auswählen");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireSelectAccountEvent(evt);
            }
        });

        javax.swing.GroupLayout jProfileDialogLayout = new javax.swing.GroupLayout(jProfileDialog.getContentPane());
        jProfileDialog.getContentPane().setLayout(jProfileDialogLayout);
        jProfileDialogLayout.setHorizontalGroup(
            jProfileDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jProfileDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jProfileDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jProfileDialogLayout.setVerticalGroup(
            jProfileDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jProfileDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jStatusOutput.setFont(new java.awt.Font("Comic Sans MS", 0, 14));
        jStatusOutput.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jStatusOutput.setText("Lade Einstellungen...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jStatusOutput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jStatusOutput)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fireSelectAccountEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireSelectAccountEvent
        Object[] path = jTree1.getSelectionPath().getPath();
        UserProfile profile = null;
        try {
            profile = (UserProfile) ((DefaultMutableTreeNode) path[2]).getUserObject();
        } catch (Exception e) {
        }
        if (profile == null) {
            JOptionPaneHelper.showWarningBox(jProfileDialog, "Bitte eine Profil auswählen.", "Bitte wählen");
            return;
        } else {
            String server = profile.getServerId();
            GlobalOptions.setSelectedServer(server);
            GlobalOptions.setSelectedProfile(profile);
            GlobalOptions.addProperty("default.server", server);
            GlobalOptions.addProperty("selected.profile", Long.toString(profile.getProfileId()));
            GlobalOptions.addProperty("player." + server, Long.toString(profile.getProfileId()));
            jProfileDialog.setVisible(false);
        }
    }//GEN-LAST:event_fireSelectAccountEvent

    protected boolean hideSplash() {
        try {
            if (!new File(".").canWrite()) {
                JOptionPaneHelper.showErrorBox(self, "Fehler bei der Initialisierung.\nDas DS Workbench Verzeichnis ist für deinen Systembenutzer nicht beschreibbar.\nBitte installiere DS Workbench z.B. in dein Benutzerverzeichnis.", "Fehler");
                return false;
            }
            File f = new File("./servers");
            if (!f.exists() && !f.mkdir()) {
                JOptionPaneHelper.showErrorBox(self, "Fehler bei der Initialisierung.\nDas Serververzeichnis konnte nicht erstellt werden.", "Fehler");
                return false;
            }
            //load properties, cursors, skins, world decoration
            GlobalOptions.initialize();
            DataHolder.getSingleton().addDataHolderListener(this);
            DataHolder.getSingleton().addDataHolderListener(DSWorkbenchSettingsDialog.getSingleton());
            ProfileManager.getSingleton().loadProfiles();
        } catch (Exception e) {
            logger.error("Failed to initialize global options", e);
            JOptionPaneHelper.showErrorBox(self, "Fehler bei der Initialisierung.\nMöglicherweise ist deine DS Workbench Installation defekt.", "Fehler");
            return false;
        }

        try {
            //open profile selection
            if (ProfileManager.getSingleton().getProfiles().length == 0) {
                //no profile found...this is handles by the settings validation
            } else if (ProfileManager.getSingleton().getProfiles().length == 1) {
                //only one single profile was found, use it
                UserProfile profile = ProfileManager.getSingleton().getProfiles()[0];
                String server = profile.getServerId();
                GlobalOptions.setSelectedServer(server);
                GlobalOptions.setSelectedProfile(profile);
                GlobalOptions.addProperty("default.server", server);
                GlobalOptions.addProperty("selected.profile", Long.toString(profile.getProfileId()));
            } else {
                File f = new File("./servers");
                List<String> servers = new LinkedList<String>();
                for (File server : f.listFiles()) {
                    servers.add(server.getName());
                }
                //sort server names
                Collections.sort(servers, new Comparator<String>() {

                    @Override
                    public int compare(String o1, String o2) {
                        if (o1.length() < o2.length()) {
                            return -1;
                        } else if (o1.length() > o2.length()) {
                            return 1;
                        }
                        return o1.compareTo(o2);
                    }
                });
                List<Object> path = new LinkedList<Object>();
                DefaultMutableTreeNode root = new DefaultMutableTreeNode("Profile");
                long selectedProfile = -1;
                try {
                    selectedProfile = Long.parseLong(GlobalOptions.getProperty("selected.profile"));
                } catch (Exception e) {
                }
                path.add(root);
                for (String server : servers) {
                    DefaultMutableTreeNode serverNode = new DefaultMutableTreeNode(server);
                    boolean profileAdded = false;
                    for (UserProfile profile : ProfileManager.getSingleton().getProfiles(server)) {
                        DefaultMutableTreeNode profileNode = new DefaultMutableTreeNode(profile);
                        if (profile.getProfileId() == selectedProfile) {
                            path.add(serverNode);
                            path.add(profileNode);
                        }
                        serverNode.add(profileNode);
                        profileAdded = true;
                    }
                    if (profileAdded) {
                        root.add(serverNode);
                    }
                }

                jTree1.setModel(new DefaultTreeModel(root));
                jTree1.setSelectionPath(new TreePath(path.toArray()));
                jTree1.scrollPathToVisible(new TreePath(path.toArray()));
                jTree1.setCellRenderer(new ProfileTreeNodeRenderer());
                jProfileDialog.setVisible(true);
            }

            //check settings
            if (!DSWorkbenchSettingsDialog.getSingleton().checkSettings()) {
                logger.info("Reading user settings returned error(s)");
                DSWorkbenchSettingsDialog.getSingleton().setVisible(true);
            }
        } catch (Exception e) {
            logger.warn("Failed to open profile manager", e);
        }

        // <editor-fold defaultstate="collapsed" desc=" Check for data updates ">
        boolean checkForUpdates = false;
        try {
            checkForUpdates = Boolean.parseBoolean(GlobalOptions.getProperty("check.updates.on.startup"));
        } catch (Exception e) {
            checkForUpdates = false;
        }
        if (checkForUpdates && !GlobalOptions.isOfflineMode()) {
            String selectedServer = GlobalOptions.getProperty("default.server");
            String name = GlobalOptions.getProperty("account.name");
            String password = GlobalOptions.getProperty("account.password");
            if (DatabaseInterface.checkUser(name, password) != DatabaseInterface.ID_SUCCESS) {
                JOptionPaneHelper.showErrorBox(this, "Die Accountvalidierung ist fehlgeschlagen.\n" + "Bitte überprüfe deine Account- und Netzwerkeinstellungen und versuches es erneut.",
                        "Fehler");
                checkForUpdates = false;
            } else {
                long serverDataVersion = DatabaseInterface.getServerDataVersion(selectedServer);
                long userDataVersion = DatabaseInterface.getUserDataVersion(name, selectedServer);
                logger.debug("User data version is " + userDataVersion);
                logger.debug("Server data version is " + serverDataVersion);
                if (userDataVersion == serverDataVersion) {
                    logger.debug("Skip downloading updates");
                    checkForUpdates = false;
                }
            }
        }

        try {
            if (!DataHolder.getSingleton().loadData(checkForUpdates)) {
                throw new Exception("loadData() returned 'false'. See log for more details.");
            }
        } catch (Exception e) {
            logger.error("Failed to load server data", e);
            return false;
        }
        // </editor-fold>

        try {
            logger.debug("Checking for plugin updates");
            PluginManager.getSingleton().checkForUpdates();

            logger.debug("Initializing application window");
            DSWorkbenchMainFrame.getSingleton().init();
            /* logger.debug("Initializing search frame");
            DSWorkbenchSearchFrame.getSingleton();*/

            logger.info("Showing application window");
            DSWorkbenchMainFrame.getSingleton().setVisible(true);
            t.stopRunning();
            setVisible(false);
            boolean informOnUpdate = true;

            try {
                String val = GlobalOptions.getProperty("inform.on.updates");
                if (val != null) {
                    informOnUpdate = Boolean.parseBoolean(val);
                }
            } catch (Exception e) {
                //value not found, inform by default
            }
            if (informOnUpdate) {
                //check version
                double version = DatabaseInterface.getCurrentVersion();

                if (version > 0 && version > Constants.VERSION) {
                    NotifierFrame.doNotification("Eine neue Version (" + version + ") von DS Workbench ist verfügbar.\n" + "Klicke auf das Update Icon um \'http://www.dsworkbench.de\' im Browser zu öffnen.", NotifierFrame.NOTIFY_UPDATE);
                }
            }
            return true;
        } catch (Throwable th) {
            logger.fatal("Fatal error while running DS Workbench", th);
            JOptionPaneHelper.showErrorBox(self, "Ein schwerwiegender Fehler ist aufgetreten.\nMöglicherweise ist deine DS Workbench Installation defekt. Bitte kontaktiere den Entwickler.", "Fehler");
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Locale.setDefault(Locale.GERMAN);

        //add global ESC listener
       /* Toolkit.getDefaultToolkit().getSystemEventQueue().push(
                new EventQueue() {

                    protected void dispatchEvent(AWTEvent event) {
                        if (event instanceof KeyEvent) {
                            KeyEvent keyEvent = (KeyEvent) event;

                            if ((keyEvent.getID() == KeyEvent.KEY_PRESSED)
                                    && ((keyEvent).getKeyCode() == KeyEvent.VK_ESCAPE)) {
                                try {
                                    JFrame source = (JFrame) keyEvent.getSource();
                                    if (source != DSWorkbenchMainFrame.getSingleton()) {
                                        source.setVisible(false);
                                    }
                                } catch (Exception e) {
                                    try {
                                        JDialog source = (JDialog) keyEvent.getSource();
                                        source.setVisible(false);
                                    } catch (Exception inner) {
                                    }
                                }
                            }

                        }
                        super.dispatchEvent(event);
                    }
                });*/
        try {
          //  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
              UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }

       /* Font f = new Font("SansSerif", Font.PLAIN, 11);

        UIManager.put("Label.font", f);
        UIManager.put("TextField.font", f);
        UIManager.put("ComboBox.font", f);
        UIManager.put("EditorPane.font", f);
        UIManager.put("TextArea.font", f);
        UIManager.put("List.font", f);
        UIManager.put("Button.font", f);
        UIManager.put("ToggleButton.font", f);
        UIManager.put("CheckBox.font", f);
        UIManager.put("CheckBoxMenuItem.font", f);
        UIManager.put("Menu.font", f);
        UIManager.put("MenuItem.font", f);
        UIManager.put("OptionPane.font", f);
        UIManager.put("Panel.font", f);
        UIManager.put("PasswordField.font", f);
        UIManager.put("PopupMenu.font", f);
        UIManager.put("ProgressBar.font", f);
        UIManager.put("RadioButton.font", f);
        UIManager.put("ToggleButton.font", f);
        UIManager.put("ScrollPane.font", f);
        UIManager.put("Table.font", f);
        UIManager.put("TableHeader.font", f);
        UIManager.put("TextField.font", f);
        UIManager.put("TextPane.font", f);
        UIManager.put("ToolTip.font", f);
        UIManager.put("Tree.font", f);
        UIManager.put("Viewport.font", f);


        //UIManager.put("Panel.background", Constants.DS_BACK);
        UIManager.put("Label.background", Constants.DS_BACK);
        UIManager.put("Panel.background", Constants.DS_BACK);
        UIManager.put("MenuBar.background", Constants.DS_BACK);
        UIManager.put("ScrollPane.background", Constants.DS_BACK);
        UIManager.put("Button.background", Constants.DS_BACK_LIGHT);
        UIManager.put("ToggleButton.background", Constants.DS_BACK_LIGHT);
        UIManager.put("TabbedPane.background", Constants.DS_BACK);
        UIManager.put("SplitPane.background", Constants.DS_BACK);
        UIManager.put("Separator.background", Constants.DS_BACK);
        UIManager.put("Menu.background", Constants.DS_BACK);
        UIManager.put("OptionPane.background", Constants.DS_BACK);
        UIManager.put("ToolBar.background", Constants.DS_BACK);
*/
        //error mode
        int mode = -1;
        if (args != null) {
            for (String arg : args) {
                if (arg.equals("-d") || arg.equals("--debug")) {
                    //debug mode
                    mode = 1;
                } else if (arg.equals("-i") || arg.equals("--info")) {
                    //info mode
                    mode = 0;
                }
            }
        }

        RollingFileAppender a = new org.apache.log4j.RollingFileAppender();
        a.setLayout(new org.apache.log4j.PatternLayout("%d - %-5p - %-20c (%C [%L]) - %m%n"));
        try {
            a.setFile("./log/dsworkbench.log", true, true, 1024);
            switch (mode) {
                case 0: {
                    Logger.getRootLogger().setLevel(Level.INFO);
                    break;
                }
                case 1: {
                    Logger.getRootLogger().setLevel(Level.DEBUG);

                    break;
                }
                default: {
                    Logger.getRootLogger().setLevel(Level.ERROR);
                    break;
                }
            }


            Logger.getRootLogger().addAppender(a);
            Logger.getLogger("de.tor").addAppender(a);
            Logger.getLogger("dswb").addAppender(a);
        } catch (IOException ioe) {
        }

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                DSWorkbenchSplashScreen.getSingleton().setLocationRelativeTo(null);
                DSWorkbenchSplashScreen.getSingleton().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JDialog jProfileDialog;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jStatusOutput;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void fireDataHolderEvent(String pText) {
        jStatusOutput.setText(pText);
    }

    public void updateStatus() {
        jStatusOutput.repaint();
    }

    @Override
    public void fireDataLoadedEvent(boolean pSuccess) {
        if (pSuccess) {
            jStatusOutput.setText("Daten geladen");
        } else {
            jStatusOutput.setText("Download fehlgeschlagen");
        }
    }
}

class HideSplashTask extends TimerTask {

    public HideSplashTask() {
    }

    public void run() {
        if (!DSWorkbenchSplashScreen.getSingleton().hideSplash()) {
            System.exit(1);
        }
    }
}

class SplashRepaintThread extends Thread {

    private boolean running = true;

    public SplashRepaintThread() {
        setDaemon(true);
    }

    public void run() {
        while (running) {
            DSWorkbenchSplashScreen.getSingleton().updateStatus();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ie) {
            }
        }
    }

    public void stopRunning() {
        running = false;
    }
}
