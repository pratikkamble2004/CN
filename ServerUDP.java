import java.io.*;
import java.net.*;

class ServerUDP {
    public static void main(String args[]) throws IOException {
        DatagramSocket ss = new DatagramSocket(2100);
        System.out.println("UDP Server listening on port 2100...");
        byte[] sendData = new byte[1024];
        byte[] recData = new byte[1024];

        while (true) {
            DatagramPacket dp = new DatagramPacket(recData, recData.length);
            ss.receive(dp);
            String input = new String(dp.getData(), 0, dp.getLength()).trim();
            if (input.equalsIgnoreCase("end")) break;

            InetAddress ip = dp.getAddress();
            int port = dp.getPort();
            System.out.println("Received input: " + input);

            String output = "Hello " + input;
            sendData = output.getBytes();
            DatagramPacket dp1 = new DatagramPacket(sendData, sendData.length, ip, port);
            ss.send(dp1);
        }

        ss.close();
        System.out.println("UDP Server closed.");
    }
}

