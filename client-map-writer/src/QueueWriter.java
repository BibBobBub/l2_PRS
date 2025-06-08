import com.hazelcast.client.HazelcastClient;
import com.hazelcast.collection.IQueue;
import com.hazelcast.core.HazelcastInstance;

public class QueueWriter {
    public static void main(String[] args) throws Exception {
        HazelcastInstance client = HazelcastClient.newHazelcastClient();
        IQueue<Integer> queue = client.getQueue("bounded-queue");

        for (int i = 1; i <= 100; i++) {
            queue.put(i);
            System.out.println("Put: " + i);
        }

        client.shutdown();
    }
}
