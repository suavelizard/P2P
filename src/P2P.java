import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Zane on 2014-09-26.
 */
public class P2P {
    public static void main(String[] args){
        //start gui thread
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                gui();
//            }
//        });
        //create peer
        Random rand = new Random();
        SharedFile sf = new SharedFile("C:\\Users\\Zane\\Documents\\IdeaProjects\\P2P\\src","fb.jpg");
//        List<Peer> peers = new ArrayList<Peer>();
//        for(int i = 0; i < 5; i++){
//            peers.add(new Peer(9264,"127.0.0.1",Integer.toString(rand.nextInt(Integer.MAX_VALUE))));
//        }

        Peer peer1 = new Peer(9264,"127.0.0.1","peer1");
        Peer peer2 = new Peer(9264,"127.0.0.1","peer2");
        Peer peer3 = new Peer(9264,"127.0.0.1","peer3");

        peer1.addPeer(peer2);
        peer1.addPeer(peer3);

        peer1.addSharedFile(sf);

        System.out.println("=================================");
        peer1.printPeerList();
        peer1.printSharedFileList();



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
