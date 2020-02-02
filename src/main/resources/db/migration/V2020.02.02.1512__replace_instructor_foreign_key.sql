alter table hibernate.workshops
    drop constraint workshops_primary_instructor_id_fkey;

alter table hibernate.workshops
    add constraint workshops_primary_instructor_id_fkey foreign key (primary_instructor_id) references teachers(id);