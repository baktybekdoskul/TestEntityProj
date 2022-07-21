--liquibase formatted sql
--changeset baktybekdoskul:202207211322
create table document(
    id varchar(250) PRIMARY KEY,
    date timestamp
);

create table dictionary_value(
     id varchar(250) PRIMARY KEY,
     name varchar(250)
);

create table test(
     id varchar(250) PRIMARY KEY,
     name varchar(250)
);

create table test_entity(
    id varchar(250) PRIMARY KEY,
    document_entity_id varchar(250),
    FOREIGN KEY(document_entity_id) references document(id) on DELETE CASCADE,
    dictionary_value_id varchar(250),
    FOREIGN KEY(dictionary_value_id) references dictionary_value(id) on DELETE CASCADE,
    test_id varchar(250),
    FOREIGN KEY(test_id) references test(id) on DELETE CASCADE
);