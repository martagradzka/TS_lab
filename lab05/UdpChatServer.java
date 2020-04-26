
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;



public class UdpChatServer {
    
    public void main (String [] args) throws IOException{
        
        int port =4444;
        
        DatagramSocket socket= new DatagramSocket (port);
        System.out.println("Serwer UDP działa");
        
        
        byte[] buff = new byte [255];
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        socket.receive(packet);
        String resp = new String(packet.getData(), 0, packet.getLength());
        
        System.out.println(resp);
    }
    class ClientParams{
        private InetAddress address;
        private int port;
    }
    
    }
    
