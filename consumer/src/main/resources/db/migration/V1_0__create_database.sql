CREATE SCHEMA IF NOT EXISTS `demo`;

-- GRANT will create users if they do not already exist
GRANT ALL ON `demo`.* TO 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL ON `demo`.* TO 'admin'@'%' IDENTIFIED BY 'admin';