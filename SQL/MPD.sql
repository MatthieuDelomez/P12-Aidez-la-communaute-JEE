
CREATE TABLE public.Administrateur (
                pseudo VARCHAR(255) NOT NULL,
                nom VARCHAR(255) NOT NULL,
                prenom VARCHAR(255) NOT NULL,
                motPasse VARCHAR(255) NOT NULL,
                adresseMail VARCHAR(255) NOT NULL,
                CONSTRAINT administrateur_pk PRIMARY KEY (pseudo)
);


CREATE SEQUENCE public.biere_idbiere_seq;

CREATE TABLE public.Biere (
                idBiere INTEGER NOT NULL DEFAULT nextval('public.biere_idbiere_seq'),
                nom VARCHAR(255) NOT NULL,
                variete VARCHAR(255) NOT NULL,
                region VARCHAR(255) NOT NULL,
                degres REAL NOT NULL,
                CONSTRAINT biere_pk PRIMARY KEY (idBiere)
);


ALTER SEQUENCE public.biere_idbiere_seq OWNED BY public.Biere.idBiere;

CREATE SEQUENCE public.bar_idbar_seq;

CREATE TABLE public.Bar (
                idBar INTEGER NOT NULL DEFAULT nextval('public.bar_idbar_seq'),
                idBiere INTEGER NOT NULL,
                nom VARCHAR(255) NOT NULL,
                adresse VARCHAR(255) NOT NULL,
                codePostal VARCHAR NOT NULL,
                ville VARCHAR(255) NOT NULL,
                description VARCHAR(255) NOT NULL,
                note REAL NOT NULL,
                CONSTRAINT bar_pk PRIMARY KEY (idBar)
);


ALTER SEQUENCE public.bar_idbar_seq OWNED BY public.Bar.idBar;

CREATE TABLE public.Utilisateur (
                pseudo VARCHAR(255) NOT NULL,
                nom VARCHAR(255) NOT NULL,
                prenom VARCHAR(255) NOT NULL,
                motPasse VARCHAR(255) NOT NULL,
                adresseMail VARCHAR(255) NOT NULL,
                CONSTRAINT utilisateur_pk PRIMARY KEY (pseudo)
);


CREATE SEQUENCE public.commentaire_idcom_seq;

CREATE TABLE public.Commentaire (
                idCom INTEGER NOT NULL DEFAULT nextval('public.commentaire_idcom_seq'),
                titre VARCHAR(50) NOT NULL,
                pseudo VARCHAR(255) NOT NULL,
                description VARCHAR(255) NOT NULL,
                CONSTRAINT commentaire_pk PRIMARY KEY (idCom)
);


ALTER SEQUENCE public.commentaire_idcom_seq OWNED BY public.Commentaire.idCom;

ALTER TABLE public.Bar ADD CONSTRAINT biere_bar_fk
FOREIGN KEY (idBiere)
REFERENCES public.Biere (idBiere)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Commentaire ADD CONSTRAINT utilisateur_commentaire_fk
FOREIGN KEY (pseudo)
REFERENCES public.Utilisateur (pseudo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
