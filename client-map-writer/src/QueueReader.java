import com.hazelcast.client.HazelcastClient;
import com.hazelcast.collection.IQueue;
import com.hazelcast.core.HazelcastInstance;

public class QueueReader {
    public static void main(String[] args) throws Exception {
        HazelcastInstance client = HazelcastClient.newHazelcastClient();
        IQueue<Integer> queue = client.getQueue("bounded-queue");

        while (true) {
            Integer item = queue.take();
            System.out.println("Read: " + item);
        }
    }
}
