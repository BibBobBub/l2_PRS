import hazelcast
import time

client = hazelcast.HazelcastClient()
topic = client.get_topic("test-topic")

for i in range(1, 101):
    topic.publish(i)
    time.sleep(0.005)

print("✅ Опубліковано 100 повідомлень.")
client.shutdown()
