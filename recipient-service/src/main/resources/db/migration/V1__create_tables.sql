CREATE TABLE recipient (
    id BIGINT PRIMARY KEY,
    creator_id UUID,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    organization VARCHAR(50),
    contact_data jsonb,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
