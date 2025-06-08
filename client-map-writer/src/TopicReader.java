import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import com.hazelcast.topic.Message;
import com.hazelcast.topic.MessageListener;

public class TopicReader {
    public static void main(String[] args) {
        HazelcastInstance client = HazelcastClient.newHazelcastClient();
        ITopic<Integer> topic = client.getTopic("numbers-topic");

        topic.addMessageListener((Message<Integer> message) ->
            System.out.println("Received: " + message.getMessageObject())
        );
    }
}
