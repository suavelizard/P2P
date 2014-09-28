import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zane on 2014-09-26.
 */
public class Peer {
    private String ip = "";
    private String name;
    private int port;
    private List<Peer> peerList;
    private List<SharedFile> fileList;
    private String peerHash;

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
        this.setPort(port);
        this.setIp(ip);
        this.setName(name);
        System.out.println("Constructed: " + this.getName() + " at " + this.getIp() + ":" + this.getPort());

        //create socket
        //add self to peer list
        addPeer(this);
        System.out.println(this.getName() +"'s peer list: ");
        for (Peer listPeer: this.getPeerList()){
            System.out.println("\t"+listPeer.getName());
        }
    }
    private String hashPeer(){
        return Integer.toString(this.getName().hashCode() +
                this.getIp().hashCode() + Integer.toString(this.getPort()).hashCode());
    }
    public boolean isPeerInList(Peer peer){
        boolean b = false;
        for(Peer listPeer: this.getPeerList()){
            if(listPeer.getPeerHash().equals(peer.getPeerHash())){
                return true;
            }
        }
        return b;
    }
    //add peer to peerlist
    public void addPeer(Peer peer){
        if(!isPeerInList(peer)){
            this.peerList.add(peer);
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
    public void addSharedFile(){
        //TODO add method
    }
    public void announce(){
        //TODO:
        //broadcase to all clients on network
        //send out IP and port along with hash and name
        //log all responses to peerlist

    }
    public void respondToAnnounce(){
        //TODO: send out info

    }
}
