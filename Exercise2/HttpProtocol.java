import java.net.HttpURLConnection;
import java.net.URL;

public class HttpProtocol implements CommunicationProtocol {
    private HttpURLConnection connection;

    @Override
    public void connect() {
        try {
            URL url = new URL("http://example.com");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            System.out.println("Connected via HTTP");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(String message) {
        try {
            connection.setDoOutput(true);
            connection.getOutputStream().write(message.getBytes());
            connection.getOutputStream().flush();
            System.out.println("HTTP message sent: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        if (connection != null) {
            connection.disconnect();
            System.out.println("Disconnected from HTTP");
        }
    }
}
