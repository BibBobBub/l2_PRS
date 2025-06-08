import hazelcast

client = hazelcast.HazelcastClient()

distributed_map = client.get_map("test-map").blocking()

for i in range(1000):
    distributed_map.put(i, f"value {i}")

print("✅ Вставлено 1000 значень у distributed map.")

client.shutdown()
