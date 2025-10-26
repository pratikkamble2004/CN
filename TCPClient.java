import java.net.*;
import java.io.*;

class TCPClient{
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 1024);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream ps = new PrintStream(s.getOutputStream());

        System.out.println("Please Enter Number 1:");
        int a = Integer.parseInt(br.readLine());

        System.out.println("Please Enter Number 2:");
        int b = Integer.parseInt(br.readLine());

        System.out.println("Please Enter The Operation to Be Performed");
        System.out.println("1.Addition  2.Subtraction  3.Multiplication  4.Division  5.Modulo  0.Exit");
        int ch = Integer.parseInt(br.readLine());

        ps.println(ch);
        ps.println(a);
        ps.println(b);

        BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        int c = Integer.parseInt(br1.readLine());
        System.out.println("Answer: " + c);

        s.close();
    }
}
