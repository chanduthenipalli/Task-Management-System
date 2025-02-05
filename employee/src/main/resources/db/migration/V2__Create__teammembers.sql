-- Create team_members table
CREATE TABLE IF NOT EXISTS team_members (
  id BIGINT NOT NULL AUTO_INCREMENT,
  emp_name VARCHAR(255) NOT NULL,
  department VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;
