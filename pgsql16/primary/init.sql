CREATE USER replicator WITH REPLICATION ENCRYPTED PASSWORD 'replicator';
SELECT * FROM pg_create_physical_replication_slot('replication_slot_replica1');
SELECT * FROM pg_create_physical_replication_slot('replication_slot_replica2');
