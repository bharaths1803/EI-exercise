import java.util.Scanner;

public class ChatApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChatRoom chatRoom = ChatRoom.getInstance();

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        ChatClient client = new ChatClient(username);

        System.out.print("Enter room ID to join or create: ");
        String roomId = scanner.nextLine();
        chatRoom.joinRoom(roomId, username);
        chatRoom.register(roomId, client);

        System.out.println("Welcome to the chat room! Type 'exit' to leave.");
        while (true) {
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("exit")) {
                chatRoom.leaveRoom(roomId, username);
                chatRoom.unregister(roomId, client);
                break;
            } else {
                chatRoom.sendMessage(roomId, username, message);
            }
        }
        scanner.close();
    }
}
