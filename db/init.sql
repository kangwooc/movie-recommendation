CREATE TABLE cast_member (
    cast_member_id INT PRIMARY KEY,
    name VARCHAR(255),
    bio TEXT,
    birthdate DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

create table genres(
    genre_id INT PRIMARY KEY,
    name VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 영화 정보 테이블 (Movies Table)
CREATE TABLE movies (
    movie_id INT PRIMARY KEY,
    title VARCHAR(255),
    release_date DATE,
    runtime INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE genres_movies (
    movie_id INT,
    genre_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id),
    FOREIGN KEY (genre_id) REFERENCES genres(genre_id)
);

create table role (
    role_id INT PRIMARY KEY,
    role_name VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE movie_cast_member (
    movie_id INT,
    cast_member_id INT,
    role_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id),
    FOREIGN KEY (cast_member_id) REFERENCES cast_member(cast_member_id),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);


-- 사용자 정보 테이블 (Users Table)
CREATE Type gender_type AS ENUM ('M', 'F');

CREATE TABLE users (
                       user_id INT PRIMARY KEY,
                       name VARCHAR(255),
                       email VARCHAR(255) UNIQUE,
                       gender gender_type,
                       age INT,
                       join_date DATE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE users_genre (
    user_id INT,
    genre_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (genre_id) REFERENCES genres(genre_id)
);

-- 사용자 평가 테이블 (Ratings Table)
CREATE TABLE ratings (
                         rating_id INT PRIMARY KEY,
                         user_id INT,
                         movie_id INT,
                         score DECIMAL(2, 1),
                         description TEXT,
                         rating_date DATE,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
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
                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
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
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);

-- 추천 기록 테이블 (Recommendations Table)
CREATE TABLE recommendations (
                                 recommendation_id INT PRIMARY KEY,
                                 user_id INT,
                                 recommended_movies TEXT,  -- JSON 형식 또는 쉼표로 구분된 문자열
                                 recommendation_date DATE,
                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- 사용자 피드백 테이블 (User Feedback Table)
CREATE TABLE user_feedback (
                               feedback_id INT PRIMARY KEY,
                               user_id INT,
                               movie_id INT,
                               feedback TEXT,
                               feedback_date DATE,
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               FOREIGN KEY (user_id) REFERENCES users(user_id),
                               FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);

CREATE FUNCTION update_updated_at_user_task()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = now();
RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TRIGGER update_users_updated_at
    BEFORE UPDATE
    ON
        users
    FOR EACH ROW
    EXECUTE PROCEDURE update_updated_at_user_task();


CREATE TRIGGER update_cast_member_updated_at
    BEFORE UPDATE
    ON
        cast_member
    FOR EACH ROW
    EXECUTE PROCEDURE update_updated_at_user_task();

CREATE TRIGGER update_genres_updated_at
    BEFORE UPDATE
    ON
        genres
    FOR EACH ROW
    EXECUTE PROCEDURE update_updated_at_user_task();

CREATE TRIGGER update_movies_updated_at
    BEFORE UPDATE
    ON
        movies
    FOR EACH ROW
    EXECUTE PROCEDURE update_updated_at_user_task();

CREATE TRIGGER update_movie_cast_member_updated_at
    BEFORE UPDATE
    ON
        movie_cast_member
    FOR EACH ROW
    EXECUTE PROCEDURE update_updated_at_user_task();

CREATE TRIGGER update_role_updated_at
    BEFORE UPDATE
    ON
        role
    FOR EACH ROW
    EXECUTE PROCEDURE update_updated_at_user_task();

CREATE TRIGGER update_movie_metadata_updated_at
    BEFORE UPDATE
    ON
        movie_metadata
    FOR EACH ROW
    EXECUTE PROCEDURE update_updated_at_user_task();

CREATE TRIGGER update_user_feedback_updated_at
    BEFORE UPDATE
    ON
        user_feedback
    FOR EACH ROW
    EXECUTE PROCEDURE update_updated_at_user_task();

CREATE TRIGGER update_recommendations_updated_at
    BEFORE UPDATE
    ON
        recommendations
    FOR EACH ROW
    EXECUTE PROCEDURE update_updated_at_user_task();
