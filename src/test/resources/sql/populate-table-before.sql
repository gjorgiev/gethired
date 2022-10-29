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

-- skills
INSERT INTO skills (id, description, name) VALUES (1, 'Being able to code in Java', 'Java')
INSERT INTO skills (id, description, name) VALUES (2, 'Being able to code in Python', 'Python')
INSERT INTO skills (id, description, name) VALUES (3, 'Being able to code in Scala', 'Scala')

-- users
INSERT INTO users (id, name, location_id) VALUES (1, 'John', 1)
INSERT INTO users (id, name, location_id) VALUES (2, 'Alice', 2)
INSERT INTO users (id, name, location_id) VALUES (3, 'Brian', 3)

-- searches
INSERT INTO searches (id, keywords, remote, location_id, user_id) VALUES (1, 'Java', true, 1, 1)
INSERT INTO searches (id, keywords, remote, location_id, user_id) VALUES (2, 'Python', false, 2, 2)
INSERT INTO searches (id, keywords, remote, location_id, user_id) VALUES (3, 'Scala', true, 3, 3)

-- jobs_skills
INSERT INTO jobs_skills (job_id, skill_id) VALUES (1,1)
INSERT INTO jobs_skills (job_id, skill_id) VALUES (2,2)
INSERT INTO jobs_skills (job_id, skill_id) VALUES (3,3)

-- users_skills
INSERT INTO users_skills (user_id, skill_id) VALUES (1,1)
INSERT INTO users_skills (user_id, skill_id) VALUES (2,2)
INSERT INTO users_skills (user_id, skill_id) VALUES (3,3)

-- searches_jobs
INSERT INTO searches_jobs (search_id, job_id) VALUES (1,1)
INSERT INTO searches_jobs (search_id, job_id) VALUES (2,2)
INSERT INTO searches_jobs (search_id, job_id) VALUES (3,3)