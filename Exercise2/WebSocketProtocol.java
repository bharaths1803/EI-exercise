import java.net.URI;
import java.net.URISyntaxException;
import javax.websocket.*;

@ClientEndpoint
public class WebSocketProtocol implements CommunicationProtocol {
    private Session session;
    private static final String URI = "ws://example.com/websocket";

    @Override
    public void connect() {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, new URI(URI));
            System.out.println("Connected via WebSocket");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(String message) {
        if (session != null) {
            session.getAsyncRemote().sendText(message);
            System.out.println("WebSocket message sent: " + message);
        }
    }

    @Override
    public void disconnect() {
        if (session != null) {
            try {
                session.close();
                System.out.println("Disconnected from WebSocket");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        this.session = null;
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
