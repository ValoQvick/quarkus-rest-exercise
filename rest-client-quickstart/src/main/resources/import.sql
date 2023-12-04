create TABLE countries (
    id BIGINT auto_increment,
    name JSON,
    region VARCHAR(255),
    population BIGINT,
    flag VARCHAR(255)
)