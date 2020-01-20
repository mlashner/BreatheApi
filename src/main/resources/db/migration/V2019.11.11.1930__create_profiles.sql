create sequence profile_seq start 1 increment 1;

create table hibernate.profiles (
    id INTEGER,
    user_id INTEGER,
    profile_picture_url VARCHAR,
    background_image_url VARCHAR,
    description VARCHAR,

    primary key(id),
    foreign key(user_id) references users (id)
)

