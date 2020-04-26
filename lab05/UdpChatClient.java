
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UdpChatClient {
   
    public static void main (String [] args) throws IOException{
        InetAddress address = InetAddress.getByName("localhost");//adres odbiorcy
        
        int port =4444;
        
        BufferedReader keyboard = new BufferedReader (new InputStreamReader(System.in));
        
        DatagramSocket socket = new DatagramSocket();
        //new UdpMsgReceiver(socket).start();
        
        while (true){
            String fromKeyboard =keyboard.readLine();
            
            if (fromKeyboard.equals("exit"))break;
        
            byte [] buf = fromKeyboard.getBytes();
        
        DatagramPacket packet= new DatagramPacket(buf, buf.length, address, port);
        socket.send(packet);
        
    }
    
}
   
class UdpMsgReceiver extends Thread {
    private DatagramSocket socket;
    
    public UdpMsgReceiver(DatagramSocket socket){
        this.socket = socket;
    }
    
    @Override
    public void run(){
        
        while (true) {
            
            byte[] buff = new byte [255];
            DatagramPacket packet= new DatagramPacket (buff, buff.length);
            try{
                socket.receive(packet);
            }catch (IOException e){
                e.printStackTrace();
                
                break;
            }
            
            String resp = new String (packet.getData(), 0, packet.getLength());
            System.out.println(resp);
            
            if ("exit".equals(resp)) break;
            
            }
            
        }
    }
    
}
