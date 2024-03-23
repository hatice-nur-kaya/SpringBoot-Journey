package socketioexample.socketio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import socketioexample.socketio.entities.Message;

public interface MessageRepository extends MongoRepository<Message, String> {
}