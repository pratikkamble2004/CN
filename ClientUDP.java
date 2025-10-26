import java.io.*;
import java.net.*;

class ClientUDP {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");

        System.out.println("Enter your name:");
        String input = br.readLine();

        byte[] sendData = input.getBytes();
        DatagramPacket dp = new DatagramPacket(sendData, sendData.length, ip, 2100);
        ds.send(dp);

        byte[] recData = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(recData, recData.length);
        ds.receive(dp1);

        String output = new String(dp1.getData(), 0, dp1.getLength());
        System.out.println(output);

        ds.close();
    }
}

