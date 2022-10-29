-- companies
INSERT INTO companies (id, name) VALUES (11, 'Microsoft')
INSERT INTO companies (id, name) VALUES (12, 'Apple')
INSERT INTO companies (id, name) VALUES (13, 'Google')

-- jobs
INSERT INTO jobs (id, title, company_id, remote) VALUES (11, 'Java Developer', 11, true)
INSERT INTO jobs (id, title, company_id, remote) VALUES (12, 'Python Developer', 12, false)
INSERT INTO jobs (id, title, company_id, remote) VALUES (13, 'Scala Developer', 13, false)

-- locations
INSERT INTO locations (id, city, country) VALUES (11, 'Los Angeles', 'USA')
INSERT INTO locations (id, city, country) VALUES (12, 'Berlin', 'Germany')
INSERT INTO locations (id, city, country) VALUES (13, 'London', 'United Kingdom')

-- skills
INSERT INTO skills (id, description, name) VALUES (11, 'Being able to code in Java', 'Java')
INSERT INTO skills (id, description, name) VALUES (12, 'Being able to code in Python', 'Python')
INSERT INTO skills (id, description, name) VALUES (13, 'Being able to code in Scala', 'Scala')

-- users
INSERT INTO users (id, name, location_id) VALUES (11, 'John', 11)
INSERT INTO users (id, name, location_id) VALUES (12, 'Alice', 12)
INSERT INTO users (id, name, location_id) VALUES (13, 'Brian', 13)

-- searches
INSERT INTO searches (id, keywords, remote, location_id, user_id) VALUES (11, 'Java', true, 11, 11)
INSERT INTO searches (id, keywords, remote, location_id, user_id) VALUES (12, 'Python', false, 12, 12)
INSERT INTO searches (id, keywords, remote, location_id, user_id) VALUES (13, 'Scala', true, 13, 13)

-- jobs_skills
INSERT INTO jobs_skills (job_id, skill_id) VALUES (11,11)
INSERT INTO jobs_skills (job_id, skill_id) VALUES (12,12)
INSERT INTO jobs_skills (job_id, skill_id) VALUES (13,13)

-- users_skills
INSERT INTO users_skills (user_id, skill_id) VALUES (11,11)
INSERT INTO users_skills (user_id, skill_id) VALUES (12,12)
INSERT INTO users_skills (user_id, skill_id) VALUES (13,13)

-- searches_jobs
INSERT INTO searches_jobs (search_id, job_id) VALUES (11,11)
INSERT INTO searches_jobs (search_id, job_id) VALUES (12,12)
INSERT INTO searches_jobs (search_id, job_id) VALUES (13,13)