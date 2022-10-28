-- companies
INSERT INTO companies (id, name) VALUES (1, 'Microsoft')
INSERT INTO companies (id, name) VALUES (2, 'Apple')
INSERT INTO companies (id, name) VALUES (3, 'Google')

-- jobs
INSERT INTO jobs (id, title, company_id, remote) VALUES (1, 'Java Developer', 1, true)
INSERT INTO jobs (id, title, company_id, remote) VALUES (2, 'Python Developer', 2, false)
INSERT INTO jobs (id, title, company_id, remote) VALUES (3, 'Scala Developer', 3, false)

-- locations
INSERT INTO locations (id, city, country) VALUES (1, 'Los Angeles', 'USA')
INSERT INTO locations (id, city, country) VALUES (2, 'Berlin', 'Germany')
INSERT INTO locations (id, city, country) VALUES (3, 'London', 'United Kingdom')