package socketioexample.socketio.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import socketioexample.socketio.entities.Message;
import socketioexample.socketio.repository.MessageRepository;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }
}