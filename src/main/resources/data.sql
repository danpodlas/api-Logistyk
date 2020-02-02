drop table if exists ROLE cascade;
drop table if exists SamochodEntity cascade;

create table ROLE
(
    id   INT IDENTITY PRIMARY KEY,
    name ENUM ('KIEROWCA','KLIENT','FIRMA')
);

create TABLE SamochodEntity
(
    id                 INT IDENTITY PRIMARY KEY,
    marka              VARCHAR(250),
    model              VARCHAR(250),
    rokprodukcji       DATE,
    przebieg           int,
    numerrejestracyjny VARCHAR(250),
    typpojazdu         VARCHAR(250),
    przyczepy ENUM ( 'WYWROTKA', 'FIRANKA', 'CHŁODNIA', 'CYSTERNA', 'PRZYCZEPA')
);

insert into SamochodEntity(marka, model, rokprodukcji, przebieg, numerrejestracyjny, typpojazdu, przyczepy)
VALUES ('Scania','560', '1990-05-05', 16123,'WAW 1','TIR','WYWROTKA');