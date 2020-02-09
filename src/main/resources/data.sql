drop table if exists ROLE cascade;

create table ROLE
(
    id   INT IDENTITY PRIMARY KEY,
    name ENUM ('KIEROWCA','KLIENT','FIRMA','ADMIN')
);

insert into ROLE(name)
values ('KIEROWCA'),
       ('KLIENT'),
       ('FIRMA'),
       ('ADMIN');

drop table if exists Samochod cascade;

create TABLE Samochod
(
    id                 INT IDENTITY PRIMARY KEY,
    marka              VARCHAR,
    model              VARCHAR,
    rokprodukcji       VARCHAR,
    przebieg           int,
    numerrejestracyjny VARCHAR,
    typpojazdu         VARCHAR,
    przyczepy          ENUM ( 'WYWROTKA', 'FIRANKA', 'CHŁODNIA', 'CYSTERNA', 'PRZYCZEPA')
);

insert into Samochod(marka, model, rokprodukcji, przebieg, numerrejestracyjny, typpojazdu, przyczepy)
VALUES ('Scania', '560', '1990-05-05', 16123, 'WAW 1', 'TIR', 'WYWROTKA'),
       ('Daf', 'XF', '1995-01-01', 165999, 'WCI 121', 'TIR', 'CHŁODNIA'),
       ('Scania', '340', '1995-02-02', 115999, 'WCI 122', 'TIR', 'CYSTERNA'),
       ('Daf', '115', '1999-01-03', 235999, 'WCI 123', 'TIR', 'FIRANKA'),
       ('Volvo', 'X', '2001-05-06', 155000, 'WCI 124', 'TIR', 'WYWROTKA');

drop table if exists Klient cascade;
create TABLE Klient
(
    id       INT IDENTITY PRIMARY KEY,
    imie     VARCHAR,
    nazwisko VARCHAR,
    pesel    VARCHAR,
    telefon  VARCHAR,
    miasto   VARCHAR,
    ulica    VARCHAR,
    nrdomu   VARCHAR,
    email    VARCHAR,
    haslo    VARCHAR,
    role_id  int
);
insert into Klient(imie, nazwisko, pesel, telefon, miasto, ulica, nrdomu, email, haslo, role_id)
VALUES ('Jan', 'Pierwszy', '71111103034', '100100100', 'Warszawa', 'Ogrodowa', '12/7', 'emailjan@wp.pl', 'klient', 2),
       ('Adam', 'Pierwszy', '64083143313', '100100101', 'Toruń', 'Bursztynowa', '3/9', 'emailadam@wp.pl', 'klient', 2),
       ('Ewa', 'Pierwsza', '64081304943', '100100102', 'Wilkowyje', 'Koła', '125/71', 'emailewa@wp.pl', 'klient', 2),
       ('Krystyna', 'Pierwsza', '85061792383', '100100103', 'Kraków', 'Odyńca', '1/9', 'emailkrystyna@wp.pl', 'klient', 2),
       ('Robert', 'Pierwszy', '46030891258', '100100104', 'Gdańsk', 'Główna', '1', 'emailrobert@wp.pl', 'klient', 2);


drop table if exists Kierowca cascade;
create TABLE Kierowca
(
    id               INT IDENTITY PRIMARY KEY,
    imie             VARCHAR,
    nazwisko         VARCHAR,
    peselnip         VARCHAR,
    telefon          VARCHAR,
    miasto           VARCHAR,
    ulica            VARCHAR,
    nrdomu           VARCHAR,
    datazatrudnienia VARCHAR,
    email            VARCHAR,
    haslo            VARCHAR,
    numerkonta       VARCHAR,
    role_id          int
);
insert into Kierowca(imie, nazwisko, peselnip, telefon, miasto, ulica, nrdomu, datazatrudnienia, email, haslo,
                     numerkonta, role_id)
VALUES ('Justyna','Kierowca','68092283046','200200200','Kraków','Wawelska','65/21','2017-02-05','justyna@o2.pl','kierowca','37967800023356457831088926',1),
       ('Adrianna','Kierowca','79071079569','200200201','Piła','Lipna','61/1','2018-03-05','adrianna@o2.pl','kierowca','75878700003150464268639616',1),
       ('Jan','Kierowca','95120270976','200200202','Rogów','Ciekawa','65','2019-11-01','jan@o2.pl','kierowca','41937010177185009762957155',1),
       ('Artur','Kierowca','86102903278','200200203','Topielec','Kolorowa','5/91','2018-12-31','artur@o2.pl','kierowca','93919800037994935342131611',1),
       ('Tomasz','Kierowca','82030949911','200200204','Lublin','Mroczna','6/1','2017-07-01','tomasz@o2.pl','kierowca','63841310940875473535528807',1),
       ('Olek','Kierowca','90090307435','200200205','Zambrów','Skośna','11','2016-01-17','Olek@o2.pl','kierowca','80878700009538389637429016',1);

drop table if exists Firma cascade;
create TABLE Firma
(
    id                INT IDENTITY PRIMARY KEY,
    nazwafirmy        VARCHAR,
    nip               VARCHAR,
    telefonkontaktowy VARCHAR,
    miasto            VARCHAR,
    ulica             VARCHAR,
    nrdomu            VARCHAR,
    email             VARCHAR,
    haslo             VARCHAR,
    numerkonta        VARCHAR,
    role_id           int
);

insert into Firma(nazwafirmy,nip, telefonkontaktowy, miasto, ulica, nrdomu, email, haslo, numerkonta, role_id)
VALUES ('Transport Pilice','5276396974','300300300','Pilice', 'Warszawska', '16', 'pilice@firma.pl','firma','59113010759875343098345956',3),
       ('Transport Odludzie','1581476034','300300301','Odludzie', 'Polna', '1', 'odludzie@firma.pl','firma','53114011829548145256992672',3),
       ('Transport Mikoszewo','3944923621','300300302','Mikoszewo', 'Oka', '45', 'mikoszewo@firma.pl','firma','18902300064945248739451289',3),
       ('Transport Zakopanem','1097920936','300300303','Zakopanem', 'Polki', '5', 'zakopanem@firma.pl','firma','69124024257403114525577894',3),
       ('Transport Bystre','3787365063','300300304','Bystre', 'Guzowa', '165', 'bystre@firma.pl','firma','98124068720569086993291301',3),
       ('Transport Okawki','3819507308','300300305','Okawki', 'Mini', '290', 'okawki@firma.pl','firma','45955710164674550892065985',3),
       ('Transport Miodowe','4164414488','300300306','Miodowe', 'Werska', '7', 'miodowe@firma.pl','firma','58967200085159627257546726',3);


drop table if exists Koszty cascade;
create TABLE Koszty
(
    id             INT IDENTITY PRIMARY KEY,
    samochod_id    int,
    radzajekosztow ENUM ( 'PALIWO', 'NAPRAWA', 'SERWIS', 'POMOC'),
    kwota          DOUBLE,
    data           VARCHAR,
    notka          VARCHAR,
    firmy_id       int,
    kierowca_id      int
);

insert into Koszty(samochod_id, radzajekosztow, kwota, data, notka, firmy_id, kierowca_id)
VALUES (1,'PALIWO',367.68,'2019-12-12','Paliwo tankowane w Bytomiu',null, 1 ),
       (1,'SERWIS',200,'2019-12-13','Serwis silnika',null, 1 ),
       (1,'NAPRAWA',800,'2019-12-19','Naprawa tylnego koła',null, 1 ),
       (1,'POMOC',150,'2019-12-19','Pęknięte opony na trasie',null, 1 ),
       (1,'PALIWO',367.68,'2019-12-21','Paliwo tankowane w Opolu',null, 1 );



drop table if exists Zlecenie cascade;
create TABLE Zlecenie
(
    id                       INT IDENTITY PRIMARY KEY,
    zlec_firmyEntity_id      int,
    zlec_klientEntity_id     int,
    adreszal                 VARCHAR,
    adresroz                 VARCHAR,
    przyjm_firmyEntity_id    int,
    przyjm_kierowcaEntity_id int,
    oskontakt                VARCHAR,
    ilosckm                  int,
    stawka                   double,
    wartzlec                 double,
    typladunku               varchar,
    specjalny                varchar,
    waga                     int
);

insert into Zlecenie(zlec_firmyEntity_id, zlec_klientEntity_id, adreszal, adresroz, przyjm_firmyEntity_id, przyjm_kierowcaEntity_id, oskontakt, ilosckm, stawka, wartzlec, typladunku, specjalny, waga)
VALUES ( null,1, 'Warszawa ul. Marywislka 44','Kraków, ul. Wioseena 12',null, 1,'Mirek tel. 500500500',350,3.0, 1050,'Palety',null,7000),
       ( 1, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',null, 1,'Mirek tel. 500500500',350,2.8, 980,'Ubrania',null,9000),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',null, 2,'Adam tel. 500500501',200,2.7, 540,'Piach',null,17000),
       ( null,1, 'Lublin, ul. Kwiecista 42', 'Warszawa ul. Marywislka 44',null,2, 'Adam tel. 500500501',200,3.0, 600,'Węgiel',null,17000);