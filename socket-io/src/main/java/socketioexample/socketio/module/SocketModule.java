package socketioexample.socketio.module;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import socketioexample.socketio.entities.Message;
import socketioexample.socketio.services.MessageService;
import socketioexample.socketio.services.SocketService;

@Slf4j
@Component
public class SocketModule {
    private final SocketIOServer server;
    private final SocketService socketService;
    private final MessageService messageService;

    public SocketModule(SocketIOServer server, SocketService socketService, MessageService messageService) {
        this.server = server;
        this.socketService = socketService;
        this.messageService = messageService;
        server.addConnectListener(onConnected());
        server.addDisconnectListener(onDisconnected());
        server.addEventListener("send_message", Message.class, onChatReceived());

    }

    private DataListener<Message> onChatReceived() {
        return (senderClient, data, ackSender) -> {
            log.info(data.toString());
            messageService.saveMessage(data);
            socketService.sendMessage(data.getRoom(), "get_message", senderClient, data.getMessage());
        };
    }

    private ConnectListener onConnected() {
        return (client) -> {
            String room = client.getHandshakeData().getSingleUrlParam("room");
            client.joinRoom(room);
            log.info("Socket ID[{}]  Connected to socket", client.getSessionId().toString());
        };

    }

    private DisconnectListener onDisconnected() {
        return client -> {
            log.info("Client[{}] - Disconnected from socket", client.getSessionId().toString());
        };
    }
}