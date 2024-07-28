public interface CommunicationProtocol {
    void connect();
    void send(String message);
    void disconnect();
}
