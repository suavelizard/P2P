import javax.swing.*;
import java.util.Random;

/**
 * Created by Zane on 2014-09-26.
 */
public class P2P {
    public static void main(String[] args){
        //start gui thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                gui();
            }
        });
        //create peer
        Random rand = new Random();

        Peer peer = new Peer(9264,"127.0.0.1",Integer.toString(rand.nextInt(Integer.MAX_VALUE)));

    }
    public static void gui(){
        JLabel bulletin = new JLabel("Hello, world!", JLabel.CENTER);

        JFrame frame = new JFrame("Bulletin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(bulletin); // adds to CENTER
        frame.setSize(200, 150);
        frame.setVisible(true);
    }
}
