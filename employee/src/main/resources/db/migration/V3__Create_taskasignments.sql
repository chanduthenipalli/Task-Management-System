
-- Create logs_status table
---- CREATE TABLE IF NOT EXISTS logs_status (
--  id BIGINT NOT NULL AUTO_INCREMENT,
--  task_id BIGINT NOT NULL,
--  emp_id BIGINT NOT NULL,
--  status VARCHAR(255) NOT NULL,
--  timestamp TIMESTAMP NOT NULL,
--  PRIMARY KEY (id),
--  KEY fk_task (task_id),
--  KEY fk_team_member (emp_id),
--  CONSTRAINT fk_task FOREIGN KEY (task_id) REFERENCES tasks (id),
--  CONSTRAINT fk_team_member FOREIGN KEY (emp_id) REFERENCES team_members (id)
--) ENGINE=InnoDB;