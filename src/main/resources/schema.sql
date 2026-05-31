DROP TABLE IF EXISTS recipe_table;

CREATE TABLE recipe_table
(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    url VARCHAR(100),
    PRIMARY KEY(id)
);