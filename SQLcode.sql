CREATE DATABASE IF NOT EXISTS FilmLab;

CREATE TABLE IF NOT EXISTS FilmLab.User (username VARCHAR(255) UNIQUE NOT NULL,
                                        password varchar(255),
                                        role varchar(20),
                                        PRIMARY KEY (username));

CREATE TABLE IF NOT EXISTS FilmLab.Technology (tech_name VARCHAR(255),
                                                price DOUBLE,
                                                time_to_process INT,
                                                PRIMARY KEY (tech_name));

CREATE TABLE IF NOT EXISTS FilmLab.Scan (scan_machine VARCHAR(255),
                                        megapixels DOUBLE,
                                        prise DOUBLE,
                                        PRIMARY KEY (scan_machine));


CREATE TABLE IF NOT EXISTS FilmLab.Film (name_film VARCHAR(255),
                                        tech_name VARCHAR(255),
                                        scan_machine VARCHAR(255),
                                        film_prise DOUBLE,
                                        format_type VARCHAR(20),
                                        PRIMARY KEY (name_film),
                                        FOREIGN KEY (tech_name) REFERENCES FilmLab.Technology(tech_name) ON DELETE CASCADE ON UPDATE CASCADE,
                                        FOREIGN KEY (scan_machine) REFERENCES FilmLab.Scan(scan_machine) ON DELETE CASCADE ON UPDATE CASCADE
                                        );

CREATE TABLE IF NOT EXISTS FilmLab.Order (id MEDIUMINT AUTO_INCREMENT NOT NULL,
                                         username VARCHAR(255),
                                         employee_name VARCHAR(255),
                                         name_film VARCHAR(255),
                                         in_progress BOOL,
                                         need_develop BOOL,
                                         need_scan BOOL,
                                         order_cost DOUBLE,
                                         PRIMARY KEY (id),
                                         FOREIGN KEY (username) REFERENCES FilmLab.User(username) ON DELETE CASCADE ON UPDATE CASCADE,
                                         FOREIGN KEY (employee_name) REFERENCES FilmLab.User(username) ON DELETE CASCADE ON UPDATE CASCADE,
                                         FOREIGN KEY (name_film) REFERENCES FilmLab.Film(name_film) ON DELETE CASCADE ON UPDATE CASCADE
                                         );
