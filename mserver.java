import java.net.*;
import java.io.*;

public class mserver {

    public static void main(String s[]) throws Exception {
        Socket sa = null;
        ServerSocket ss2 = null;
        System.out.println("Host starts accepting response ");
        try {
            ss2 = new ServerSocket(9999);
            while (true) {
                try {
                    sa = ss2.accept();
                    System.out.println("Connection established by " + sa.getInetAddress());
                    ServerThread st = new ServerThread(sa);
                    st.start();
                } catch (Exception e) {
                    System.out.println("Connection error");
                }
            }
        } catch (IOException e) {
            System.out.println("Server error");
        } finally {
            if (ss2 != null && !ss2.isClosed()) {
                try {
                    ss2.close();
                    System.out.println("ServerSocket closed");
                } catch (IOException e) {
                    System.out.println("Error closing ServerSocket");
                }
            }
        }
    }
}

class ServerThread extends Thread {
    String line = null;
    BufferedReader is = null;
    PrintWriter od = null;
    Socket s1 = null;

    public ServerThread(Socket s) {
        s1 = s;
    }

    public void run() {
        try {
            is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            od = new PrintWriter(s1.getOutputStream(), true);

            line = is.readLine();

            while (!line.equals("QUIT")) {
                od.println(line);
                od.flush();

                System.out.println("Response to client: " + line);
                line = is.readLine();
            }

            is.close();
            od.close();
            s1.close();

        } catch (IOException ie) {
            System.out.println("Socket close error");
        }
    }
}
