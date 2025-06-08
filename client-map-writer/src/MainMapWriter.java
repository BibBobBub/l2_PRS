import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class MainMapWriter {
    public static void main(String[] args) {
        HazelcastInstance client = HazelcastClient.newHazelcastClient();
        IMap<Integer, String> map = client.getMap("capitals");

        for (int i = 0; i < 1000; i++) {
            map.put(i, "Value " + i);
        }

        System.out.println("Map filled with 1000 values.");
        client.shutdown();
    }
}
