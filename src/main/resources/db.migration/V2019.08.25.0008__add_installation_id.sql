ALTER TABLE users ADD COLUMN installation_id VARCHAR;
ALTER TABLE users ADD CONSTRAINT unique_installation_id UNIQUE(installation_id);