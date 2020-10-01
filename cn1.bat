start cns.bat
consul kv put usuario postgres
consul kv put password admin
consul kv put driver org.postgresql.Driver
consul kv put cadena jdbc:postgresql://localhost:5432/ejemplo