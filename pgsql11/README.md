1. [main] apt-get update
2. [main] apt-get install -y vim
3. [main] echo "host replication replication_user 0.0.0.0/0 trust" >> /var/lib/postgresql/data/pg_hba.conf
4. [main] CREATE ROLE replication_user LOGIN REPLICATION PASSWORD 'postgres';
5. [main] restart postgres
6. [sub] rm -rf /var/lib/postgresql/data/\*
7. [sub] pg_basebackup -h pgsql11a -U replication_user -D /var/lib/postgresql/data/ --wal-method=stream --checkpoint=fast --write-recovery-conf --progress --verbose --create-slot --slot=pgstandby1

pg_basebackup: initiating base backup, waiting for checkpoint to complete
pg_basebackup: checkpoint completed
pg_basebackup: write-ahead log start point: 0/2000028 on timeline 1
pg_basebackup: starting background WAL receiver
pg_basebackup: created replication slot "pgstandby1"
23731/23731 kB (100%), 1/1 tablespace
pg_basebackup: write-ahead log end point: 0/2000130
pg_basebackup: waiting for background process to finish streaming ...
pg_basebackup: base backup completed

8. [sub] start postgres
