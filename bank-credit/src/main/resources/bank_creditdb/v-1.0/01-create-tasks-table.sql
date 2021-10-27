CREATE TABLE tasks (
    id INT AUTO_INCREMENT,
    person_id INT,
    name VARCHAR(255),
    PRIMARY KEY  (id),
    FOREIGN KEY (person_id)
        REFERENCES persons (id)
)

GO

