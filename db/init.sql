CREATE TABLE cast (
                      cast_id INT PRIMARY KEY,
                      actor_name VARCHAR(255),
                      actor_bio TEXT,
                      birthdate DATE
);

CREATE TABLE movie_cast (
    movie_id INT,
    cast_id INT,
    role VARCHAR(255),
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id),
    FOREIGN KEY (cast_id) REFERENCES cast(cast_id)
);

-- 영화 정보 테이블 (Movies Table)
CREATE TABLE movies (
    movie_id INT PRIMARY KEY,
    title VARCHAR(255),
    release_year YEAR,
    genre VARCHAR(100),
    director VARCHAR(255),
    cast TEXT,
    description TEXT,
    rating DECIMAL(2, 1),
    runtime INT
);

create table movie_cast (
    movie_id INT,

);

-- 사용자 정보 테이블 (Users Table)
CREATE TABLE users (
                       user_id INT PRIMARY KEY,
                       name VARCHAR(255),
                       email VARCHAR(255) UNIQUE,
                       gender CHAR(1),
                       age INT,
                       join_date DATE,
                       preferred_genre VARCHAR(100)
);

-- 사용자 평가 테이블 (Ratings Table)
CREATE TABLE ratings (
                         rating_id INT PRIMARY KEY,
                         user_id INT,
                         movie_id INT,
                         score DECIMAL(2, 1),
                         rating_date DATE,
                         FOREIGN KEY (user_id) REFERENCES users(user_id),
                         FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);

-- 시청 기록 테이블 (Viewing History Table)
CREATE TABLE viewing_history (
                                 history_id INT PRIMARY KEY,
                                 user_id INT,
                                 movie_id INT,
                                 view_date DATE,
                                 view_duration INT,
                                 FOREIGN KEY (user_id) REFERENCES users(user_id),
                                 FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);

-- 영화 메타데이터 테이블 (Movie Metadata Table)
CREATE TABLE movie_metadata (
                                movie_id INT PRIMARY KEY,
                                keywords TEXT,
                                production_country VARCHAR(255),
                                language VARCHAR(100),
                                budget BIGINT,
                                revenue BIGINT,
                                FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);

-- 추천 기록 테이블 (Recommendations Table)
CREATE TABLE recommendations (
                                 recommendation_id INT PRIMARY KEY,
                                 user_id INT,
                                 recommended_movies TEXT,  -- JSON 형식 또는 쉼표로 구분된 문자열
                                 recommendation_date DATE,
                                 FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- 사용자 피드백 테이블 (User Feedback Table)
CREATE TABLE user_feedback (
                               feedback_id INT PRIMARY KEY,
                               user_id INT,
                               movie_id INT,
                               feedback TEXT,
                               feedback_date DATE,
                               FOREIGN KEY (user_id) REFERENCES users(user_id),
                               FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);
