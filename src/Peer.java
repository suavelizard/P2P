import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Zane on 2014-09-26.
 */
public class Peer {
    private static final int DEFAULT_PORT = 9264;
    private String ip = "";
    private String name;
    private int port = DEFAULT_PORT;
    private List<Peer> peerList;
    private List<SharedFile> fileList;
    private String peerHash;
    private String peerID;

    public String getPeerHash() {
        return peerHash;
    }

    public void setPeerHash(String peerHash) {
        this.peerHash = peerHash;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public List<Peer> getPeerList() {
        return peerList;
    }

    public void setPeerList(List<Peer> peerList) {
        this.peerList = peerList;
    }

    //constuctor
    public Peer(int port, String ip, String name){
        this.peerList = new ArrayList<Peer>();
        this.fileList = new ArrayList<SharedFile>();
        this.setPort(port);
        this.setIp(ip);
        this.setName(name);
        System.out.println("Constructed: " + this.getName() + " at " + this.getIp() + ":" + this.getPort());

        //create socket
        //add self to peer list
        //addPeer(this);
        //System.out.println(this.getName() +"'s peer list: ");
        //for (Peer listPeer: this.getPeerList()){
        //  System.out.println("\t"+listPeer.getName());
        //}
    }
    private String hashPeer(){
        return Integer.toString(this.getName().hashCode() +
                this.getIp().hashCode() + Integer.toString(this.getPort()).hashCode());
    }
    public boolean isPeerInList(Peer peer){

        return this.peerList.contains(peer);
    }
    //add peer to peerlist
    public void addPeer(Peer peer){
        if (!isPeerInList(peer)) {
            this.peerList.add(peer);
            System.out.println("Peer added to list");
        } else {
            System.out.println("Peer is already in list!");
        }
    }
    //remove peer
    public void removePeer(Peer peer){
        this.peerList.remove(peer);
    }

    public void addSharedDirectory(){
        //TODO add method
    }
    public void addSharedFile(SharedFile sf){
        this.fileList.add(sf);
        System.out.println(sf.getFileName() + " added to " + this.name +"'s file list");
    }
    public void respondToAnnounce(){
       //TODO respond to announce
    }
    //MESSAGES
    public void announce() {
        //TODO:
        //broadcast to all clients on network
        //send out IP and port along with hash and name
        //TODO: thread connections
        Thread broadcastThread = new Thread();
        for (int i = 0; i < 255; i++) {
//            ip[3] = (byte)i;
            String localNet = this.ip.substring(0, this.ip.lastIndexOf(".")+1);
            try {
                InetAddress address = InetAddress.getByName(localNet + i );//+ ":" + this.port);
                if (address.isReachable(500)) {
                    System.out.println("can b pinged");
                    //TODO: spawn connection thread
                    //TODO: attempt connection
                    //TODO: copy peerlist
                    //this.peerList = peerListResppnseFromConnection;

                } else if (!address.getHostAddress().equals(address.getHostName())) {
                    System.out.println("Name is......" + address.getHostName() + "\tIP is......." + address.getHostAddress());
                } else {
                    System.out.println("nothing from " +localNet+i);
                }
            } catch (UnknownHostException uhe) {
                uhe.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
    public void copyRouteTable(){
        //TODO: copy route table
    }

    public void leave(){
        //TODO: leave network
    }

    public void findClosestNeighbour(){
        //TODO: find closest neighbour
    }

    //END MESSAGES

    public void printPeerList(){
        System.out.println(this.getName() +"'s peer list: ");
        for (Peer listPeer: this.getPeerList()){
            System.out.println("\t"+listPeer.getName());
        }
    }

    public void printSharedFileList(){
        System.out.println(this.name);
        for(SharedFile sharedfile : this.fileList){
            System.out.println("\t" + sharedfile.getFileName() + "(" + sharedfile.getFileHash() + ")");
        }
    }

    public void sendFileRequestPacket(){
        //TODO: sendfilerequestpacket
    }

    //Get the requested file
    public SharedFile getSharedFileByHash(String fileHash){
        SharedFile sf = null;
        for (SharedFile sharedFile: this.fileList){
            if(sharedFile.equals(fileHash)){
                sf = sharedFile;
            }
        }
        return sf;
    }

}
