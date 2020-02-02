alter table hibernate.workshops
    drop constraint workshops_secondary_instructor_id_fkey;

alter table hibernate.workshops
    drop column secondary_instructor_id;

alter table hibernate.workshops
    add column co_teachers VARCHAR;