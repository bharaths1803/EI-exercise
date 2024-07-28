public class ChatClient implements Client {
    private String username;

    public ChatClient(String username) {
        this.username = username;
    }

    @Override
    public void update(String message) {
        System.out.println(message);
    }

    public String getUsername() {
        return username;
    }
}
