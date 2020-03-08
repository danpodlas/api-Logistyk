drop table if exists ROLE cascade;

create table ROLE
(
    id   INT IDENTITY PRIMARY KEY,
    name VARCHAR
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
    przyczepy          VARCHAR
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
VALUES ('Jan', 'Pierwszy', '71111103034', '100100100', 'Warszawa', 'Ogrodowa', '12/7', 'k', 'k', 2),
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
    datazatrudnienia date,
    email            VARCHAR,
    haslo            VARCHAR,
    numerkonta       VARCHAR,
    role_id          int,
    samochodid       int
);
insert into Kierowca(imie, nazwisko, peselnip, telefon, miasto, ulica, nrdomu, datazatrudnienia, email, haslo, numerkonta, role_id, samochodid)
VALUES ('Justyna','Kierowca','68092283046','200200200','Kraków','Wawelska','65/21','2017-02-05','k','k','37967800023356457831088926',1,3),
       ('Adrianna','Kierowca','79071079569','200200201','Piła','Lipna','61/1','2018-03-05','adrianna@o2.pl','kierowca','75878700003150464268639616',1,1),
       ('Jan','Kierowca','95120270976','200200202','Rogów','Ciekawa','65','2019-11-01','jan@o2.pl','kierowca','41937010177185009762957155',1,1),
       ('Artur','Kierowca','86102903278','200200203','Topielec','Kolorowa','5/91','2018-12-31','artur@o2.pl','kierowca','93919800037994935342131611',1,4),
       ('Tomasz','Kierowca','82030949911','200200204','Lublin','Mroczna','6/1','2017-07-01','tomasz@o2.pl','kierowca','63841310940875473535528807',1,5),
       ('Olek','Kierowca','90090307435','200200205','Zambrów','Skośna','11','2016-01-17','Olek@o2.pl','kierowca','80878700009538389637429016',1,null);

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
    roleid            int,
    samochodid        int
);

insert into Firma(nazwafirmy,nip, telefonkontaktowy, miasto, ulica, nrdomu, email, haslo, numerkonta, roleid, samochodid)
VALUES ('Transport Pilice','5276396974','300300300','Pilice', 'Warszawska', '16', 'f','f','59113010759875343098345956',3,1),
       ('Transport Odludzie','1581476034','300300301','Odludzie', 'Polna', '1', 'odludzie@firma.pl','firma','53114011829548145256992672',3,4),
       ('Transport Mikoszewo','3944923621','300300302','Mikoszewo', 'Oka', '45', 'mikoszewo@firma.pl','firma','18902300064945248739451289',3,3),
       ('Transport Zakopanem','1097920936','300300303','Zakopanem', 'Polki', '5', 'zakopanem@firma.pl','firma','69124024257403114525577894',3,2),
       ('Transport Bystre','3787365063','300300304','Bystre', 'Guzowa', '165', 'bystre@firma.pl','firma','98124068720569086993291301',3,1),
       ('Transport Okawki','3819507308','300300305','Okawki', 'Mini', '290', 'okawki@firma.pl','firma','45955710164674550892065985',3,null),
       ('Transport Miodowe','4164414488','300300306','Miodowe', 'Werska', '7', 'miodowe@firma.pl','firma','58967200085159627257546726',3,null);


drop table if exists Koszty cascade;
create TABLE Koszty
(
    id             INT IDENTITY PRIMARY KEY,
    radzajekosztow VARCHAR,
    kwota          DOUBLE,
    data           DATE,
    notka          VARCHAR,
    firmy_id       int,
    kierowca_id    int
);

insert into Koszty(radzajekosztow, kwota, data, notka, firmy_id, kierowca_id)
VALUES ('PALIWO', 367.68, '2019-12-12', 'Paliwo tankowane w Bytomiu', null, 1),
       ('SERWIS', 200, '2019-12-13', 'Serwis silnika', null, 1),
       ('NAPRAWA', 800, '2019-12-19', 'Naprawa tylnego koła', null, 1),
       ('POMOC', 150, '2019-12-19', 'Pęknięte opony na trasie', null, 1),
       ('PALIWO', 367.68, '2019-12-21', 'Paliwo tankowane w Opolu', null, 1),

       ('Naprawa', 200, '2019-01-01', 'Serwis silnika', 1, null),
       ('Paliwo', 500, '2019-01-20', 'Naprawa tylnego koła', 1, null),
       ('Opłaty', 150, '2019-02-05', 'Przejazd', 1, null),
       ('Paliwo', 800, '2019-02-20', null, 1, null),
       ('Opłaty', 50, '2019-03-05', 'Przejazd', 1, null),
       ('Paliwo', 300, '2019-03-20', null, 1, null),
       ('Opłaty', 100, '2019-04-05', 'Przejazd', 1, null),
       ('Paliwo', 500, '2019-04-20', null, 1, null),
       ('Opłaty', 150, '2019-05-05', 'Przejazd', 1, null),
       ('Paliwo', 800, '2019-05-20', null, 1, null),
       ('Opłaty', 350, '2019-06-05', 'Przejazd', 1, null),
       ('Paliwo', 600, '2019-06-20', null, 1, null),
       ('Opłaty', 150, '2019-07-05', 'Przejazd', 1, null),
       ('Paliwo', 550, '2019-07-20', null, 1, null),
       ('Opłaty', 50, '2019-08-05', 'Przejazd', 1, null),
       ('Paliwo', 300, '2019-08-20', null, 1, null),
       ('Opłaty', 100, '2019-09-05', 'Przejazd', 1, null),
       ('Paliwo', 500, '2019-09-20', null, 1, null),
       ('Opłaty', 150, '2019-10-05', 'Przejazd', 1, null),
       ('Paliwo', 800, '2019-10-20', null, 1, null),
       ('Opłaty', 350, '2019-11-05', 'Przejazd', 1, null),
       ('Paliwo', 600, '2019-11-20', null, 1, null),
       ('Opłaty', 150, '2019-12-05', 'Przejazd', 1, null),
       ('Paliwo', 550, '2019-12-20', null, 1, null),
       ('Paliwo', 500, '2020-01-20', 'Naprawa tylnego koła', 1, null),
       ('Opłaty', 150, '2020-02-05', 'Przejazd', 1, null),
       ('Paliwo', 800, '2020-02-20', null, 1, null);



drop table if exists Zlecenie cascade;
create TABLE Zlecenie
(
    id              INT IDENTITY PRIMARY KEY,
    zlec_firma_id   int,
    klient_id       int,
    adreszal        VARCHAR,
    adresroz        VARCHAR,
    przyjm_firma_id int,
    kierowca_id     int,
    oskontakt       VARCHAR,
    ilosckm         int,
    stawka          double,
    wartzlec        double,
    typladunku      varchar,
    specjalny       varchar,
    waga            int,
    datautworzenia  date,
    dataprzyjecia   date,
    datazakonczenia date,
    status          varchar
);

insert into Zlecenie(zlec_firma_id, klient_id, adreszal, adresroz, przyjm_firma_id, kierowca_id, oskontakt, ilosckm, stawka, wartzlec, typladunku, specjalny, waga, datautworzenia, dataprzyjecia, datazakonczenia,status)
VALUES ( null,1, 'Warszawa ul. Marywislka 44','Kraków, ul. Wioseena 12',1, 1,'Mirek tel. 500500500',350,3.0, 1050,'Palety',null,7000, '2020-01-03', '2020-01-03','2020-01-04','Zakończone'),
       ( 1, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',null, 1,'Mirek tel. 500500500',350,2.8, 980,'Ubrania',null,9000, '2020-01-04', '2020-01-05',null,'W realizacji'),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',1, 2,'Adam tel. 500500501',200,2.7, 540,'Piach',null,17000, '2020-01-07', '2020-01-08', '2020-01-10','Zakończone'),
       ( null,1, 'Lublin, ul. Kwiecista 42', 'Warszawa ul. Marywislka 44',null,null, 'Adam tel. 500500501',200,3.0, 600,'Węgiel',null,17000, '2020-01-09',null, null,'Nowe'),

       ( 2, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',1, null,'Mirek tel. 500500500',350,2, 700,'Ubrania',null,9000, '2019-01-04', '2019-01-04','2019-01-05','Zakończone'),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',1, 2,'Adam tel. 500500501',200,2.7, 540,'Piach',null,17000, '2019-01-07', '2019-01-07', '2019-01-08','Zakończone'),


       ( 2, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',1, null,'Mirek tel. 500500500',350,2, 800,'Ubrania',null,9000, '2019-01-04', '2019-01-04','2019-01-05','Zakończone'),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',1, 2,'Adam tel. 500500501',200,2.7, 552,'Piach',null,17000, '2019-01-07', '2019-01-07', '2019-01-08','Zakończone'),

       ( 2, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',1, null,'Mirek tel. 500500500',350,2, 965,'Ubrania',null,9000, '2019-02-04', '2019-02-04','2019-02-05','Zakończone'),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',1, 2,'Adam tel. 500500501',200,2.7, 572,'Piach',null,17000, '2019-02-07', '2019-02-07', '2019-02-08','Zakończone'),

       ( 2, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',1, null,'Mirek tel. 500500500',350,2, 123,'Ubrania',null,9000, '2019-03-04', '2019-03-04','2019-03-05','Zakończone'),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',1, 2,'Adam tel. 500500501',200,2.7, 471,'Piach',null,17000, '2019-03-07', '2019-03-07', '2019-03-08','Zakończone'),

       ( 2, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',1, null,'Mirek tel. 500500500',350,2, 852,'Ubrania',null,9000, '2019-04-04', '2019-04-04','2019-04-05','Zakończone'),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',1, 2,'Adam tel. 500500501',200,2.7, 963,'Piach',null,17000, '2019-04-07', '2019-04-07', '2019-04-08','Zakończone'),

       ( 2, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',1, null,'Mirek tel. 500500500',350,2, 143,'Ubrania',null,9000, '2019-05-04', '2019-05-04','2019-05-05','Zakończone'),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',1, 2,'Adam tel. 500500501',200,2.7, 852,'Piach',null,17000, '2019-05-07', '2019-05-07', '2019-05-08','Zakończone'),

       ( 2, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',1, null,'Mirek tel. 500500500',350,2, 437,'Ubrania',null,9000, '2019-06-04', '2019-06-04','2019-07-05','Zakończone'),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',1, 2,'Adam tel. 500500501',200,2.7, 821,'Piach',null,17000, '2019-06-07', '2019-06-07', '2019-07-08','Zakończone'),

       ( 2, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',1, null,'Mirek tel. 500500500',350,2, 934,'Ubrania',null,9000, '2019-08-04', '2019-08-04','2019-08-05','Zakończone'),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',1, 2,'Adam tel. 500500501',200,2.7, 540,'Piach',null,17000, '2019-08-07', '2019-08-07', '2019-08-08','Zakończone'),

       ( 2, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',1, null,'Mirek tel. 500500500',350,2, 741,'Ubrania',null,9000, '2019-09-04', '2019-09-04','2019-09-05','Zakończone'),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',1, 2,'Adam tel. 500500501',200,2.7, 258,'Piach',null,17000, '2019-09-07', '2019-09-07', '2019-09-08','Zakończone'),

       ( 2, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',1, null,'Mirek tel. 500500500',350,2, 700,'Ubrania',null,9000, '2019-10-04', '2019-10-04','2019-10-05','Zakończone'),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',1, 2,'Adam tel. 500500501',200,2.7, 369,'Piach',null,17000, '2019-10-07', '2019-10-07', '2019-10-08','Zakończone'),

       ( 2, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',1, null,'Mirek tel. 500500500',350,2, 951,'Ubrania',null,9000, '2019-11-04', '2019-11-04','2019-11-05','Zakończone'),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',1, 2,'Adam tel. 500500501',200,2.7, 753,'Piach',null,17000, '2019-11-07', '2019-11-07', '2019-11-08','Zakończone'),

       ( 2, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',1, null,'Mirek tel. 500500500',350,2, 357,'Ubrania',null,9000, '2019-12-04', '2019-12-04','2019-12-05','Zakończone'),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',1, 2,'Adam tel. 500500501',200,2.7, 456,'Piach',null,17000, '2019-12-07', '2019-12-07', '2019-12-08','Zakończone'),

       ( 2, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',1, null,'Mirek tel. 500500500',350,2, 789,'Ubrania',null,9000, '2020-01-04', '2020-01-04','2020-01-05','Zakończone'),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',1, 2,'Adam tel. 500500501',200,2.7, 540,'Piach',null,17000, '2020-01-07', '2020-01-07', '2020-01-08','Zakończone'),

       ( 2, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',1, null,'Mirek tel. 500500500',350,2, 700,'Ubrania',null,9000, '2020-02-04', '2020-02-04','2020-02-05','Zakończone'),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',1, 2,'Adam tel. 500500501',200,2.7, 495,'Piach',null,17000, '2020-02-07', '2020-02-07', '2020-02-08','Zakończone'),

       ( 2, null, 'Kraków, ul. Wioseena 12','Warszawa ul. Marywislka 44',1, null,'Mirek tel. 500500500',350,2, 665,'Ubrania',null,9000, '2020-03-04', '2020-03-04','2020-03-05','Zakończone'),
       ( null,1, 'Warszawa ul. Marywislka 44','Lublin, ul. Kwiecista 42',1, 2,'Adam tel. 500500501',200,2.7, 552,'Piach',null,17000, '2020-03-07', '2020-03-07', '2020-03-08','Zakończone');

