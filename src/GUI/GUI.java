package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Zane on 2014-10-07.
 */
public class GUI extends JFrame {
    private JTextArea text = new JTextArea();



    // Class constructor
    public GUI( String titleText ) {
        super( titleText );
        setJMenuBar( buildMenuBar() );
        text.setEditable( false );
        Container cp = getContentPane();
        cp.add( new JScrollPane( text ),
                BorderLayout.CENTER );
        setBounds(600,400, 600, 400 );
        setVisible( true );
    }
    public JMenuBar buildMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu( "File" );
        JMenuItem exitItem = new JMenuItem( "Exit" );
        JMenuItem fileNewFeer = new JMenuItem( "Add Shared File" );

        JMenu peerMenu = new JMenu("Peer");
        JMenuItem peerNewPeer = new JMenuItem("Add Peer");

        JMenu editMenu = new JMenu( "Edit" );
        JMenuItem editSettings = new JMenuItem( "Settings" );



        fileMenu.setMnemonic( KeyEvent.VK_F );
        exitItem.setMnemonic( KeyEvent.VK_X );

        menuBar.add( fileMenu );
        menuBar.add( editMenu );
        menuBar.add(peerMenu);
        peerMenu.add(peerNewPeer);
        //fileMenu.add(fileNewPeer);
        fileMenu.add(exitItem);
        editMenu.add(editSettings);


        return menuBar;
    }
}
