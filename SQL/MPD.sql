
CREATE TABLE public.App_User (
                username VARCHAR(36) NOT NULL,
                adresse_mail VARCHAR(120) NOT NULL,
                password VARCHAR(128) NOT NULL,
                nom VARCHAR(30) NOT NULL,
                prenom VARCHAR(30) NOT NULL,
                enabled BOOLEAN NOT NULL,
                CONSTRAINT app_user_pk PRIMARY KEY (username)
);


CREATE SEQUENCE public.user_roles_id_seq;

CREATE TABLE public.user_roles (
                roleid BIGINT NOT NULL DEFAULT nextval('public.user_roles_id_seq'),
                role VARCHAR(45) NOT NULL,
                username VARCHAR(36) NOT NULL,
                CONSTRAINT user_roles_pk PRIMARY KEY (roleid)
);


ALTER SEQUENCE public.user_roles_id_seq OWNED BY public.user_roles.roleid;

CREATE SEQUENCE public.commentaire_idcom_seq;

CREATE TABLE public.Commentaire (
                idCom INTEGER NOT NULL DEFAULT nextval('public.commentaire_idcom_seq'),
                username VARCHAR(36) NOT NULL,
                titre VARCHAR(50) NOT NULL,
                description VARCHAR(255) NOT NULL,
                CONSTRAINT commentaire_pk PRIMARY KEY (idCom)
);


ALTER SEQUENCE public.commentaire_idcom_seq OWNED BY public.Commentaire.idCom;

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

ALTER TABLE public.Commentaire ADD CONSTRAINT app_user_commentaire_fk
FOREIGN KEY (username)
REFERENCES public.App_User (username)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.user_roles ADD CONSTRAINT app_user_user_roles_fk
FOREIGN KEY (username)
REFERENCES public.App_User (username)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Bar ADD CONSTRAINT biere_bar_fk
FOREIGN KEY (idBiere)
REFERENCES public.Biere (idBiere)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
