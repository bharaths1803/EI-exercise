public class CommunicationAdapter {
    private CommunicationProtocol protocol;

    public CommunicationAdapter(CommunicationProtocol protocol) {
        this.protocol = protocol;
    }

    public void connect() {
        protocol.connect();
    }

    public void send(String message) {
        protocol.send(message);
    }

    public void disconnect() {
        protocol.disconnect();
    }
}
