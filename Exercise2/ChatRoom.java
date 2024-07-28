import java.util.*;

public class ChatRoom {
    private static ChatRoom instance;
    private final Map<String, List<Client>> chatRooms;
    private final Map<String, List<String>> chatMessages;
    private final Map<String, Set<String>> activeUsers;

    private ChatRoom() {
        chatRooms = new HashMap<>();
        chatMessages = new HashMap<>();
        activeUsers = new HashMap<>();
    }

    public static synchronized ChatRoom getInstance() {
        if (instance == null) {
            instance = new ChatRoom();
        }
        return instance;
    }

    public void createRoom(String roomId) {
        chatRooms.putIfAbsent(roomId, new ArrayList<>());
        chatMessages.putIfAbsent(roomId, new ArrayList<>());
        activeUsers.putIfAbsent(roomId, new HashSet<>());
    }

    public void joinRoom(String roomId, String username) {
        createRoom(roomId);
        activeUsers.get(roomId).add(username);
        notifyUsers(roomId, username + " has joined the chat.");
    }

    public void leaveRoom(String roomId, String username) {
        if (activeUsers.containsKey(roomId)) {
            activeUsers.get(roomId).remove(username);
            notifyUsers(roomId, username + " has left the chat.");
        }
    }

    public void sendMessage(String roomId, String username, String message) {
        String formattedMessage = username + ": " + message;
        chatMessages.get(roomId).add(formattedMessage);
        notifyUsers(roomId, formattedMessage);
    }

    public List<String> getMessages(String roomId) {
        return chatMessages.getOrDefault(roomId, new ArrayList<>());
    }

    public Set<String> getActiveUsers(String roomId) {
        return activeUsers.getOrDefault(roomId, new HashSet<>());
    }

    private void notifyUsers(String roomId, String message) {
        if (chatRooms.containsKey(roomId)) {
            chatRooms.get(roomId).forEach(client -> client.update(message));
        }
    }

    public void register(String roomId, Client client) {
        chatRooms.get(roomId).add(client);
    }

    public void unregister(String roomId, Client client) {
        chatRooms.get(roomId).remove(client);
    }
}
