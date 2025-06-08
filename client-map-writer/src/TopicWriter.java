import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;

public class TopicWriter {
    public static void main(String[] args) {
        HazelcastInstance client = HazelcastClient.newHazelcastClient();
        ITopic<Integer> topic = client.getTopic("numbers-topic");

        for (int i = 1; i <= 100; i++) {
            topic.publish(i);
        }

        System.out.println("Published 100 messages to topic.");
        client.shutdown();
    }
}
