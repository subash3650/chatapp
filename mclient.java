import java.net.*;
import java.io.*;

public class mclient {

    public static void main(String s[]) throws Exception {
        Socket s1 = null;
        String line = null;
        BufferedReader br = null;
        BufferedReader is = null;
        PrintWriter os = null;
        try {
            s1 = new Socket("localhost", 9999);
            br = new BufferedReader(new InputStreamReader(System.in));  // Reading from console input
            is = new BufferedReader(new InputStreamReader(s1.getInputStream()));  // Reading from server
            os = new PrintWriter(s1.getOutputStream(), true);  // Output stream to server

        } catch (IOException e) {
            System.err.print("IO Exception");

        }
        System.out.println("Enter data to server (enter QUIT to end) :-> " + s1.getRemoteSocketAddress().toString());
        String res = null;
        try {
            line = br.readLine();  // Reading user input
            while (!line.equalsIgnoreCase("QUIT")) {  // Loop until "QUIT" is entered
                os.println(line);  // Send input to server
                os.flush();
                res = is.readLine();  // Read server response
                System.out.println("Server response :-> " + res);
                line = br.readLine();  // Read next user input
            }
            is.close();
            os.close();
            br.close();
            s1.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            System.out.println("Socket read error");
        }
    }
}
