
CREATE TABLE public.PERSISTENT_LOGIN (
                series VARCHAR(64) NOT NULL,
                username VARCHAR(64) NOT NULL,
                token VARCHAR(64) NOT NULL,
                last_used TIMESTAMP NOT NULL,
                CONSTRAINT persistent_login_pk PRIMARY KEY (series)
);


CREATE TABLE public.APP_ROLE (
                ROLE_ID BIGINT NOT NULL,
                ROLE_NAME VARCHAR(30) NOT NULL,
                CONSTRAINT app_role_pk PRIMARY KEY (ROLE_ID)
);


CREATE TABLE public.APP_USER (
                USER_ID BIGINT NOT NULL,
                USER_NAME VARCHAR(36) NOT NULL,
                ADRESSE_MAIL VARCHAR(120) NOT NULL,
                ENCRYTED_PASSWORD VARCHAR(128) NOT NULL,
                ENABLED INTEGER NOT NULL,
                CONSTRAINT app_user_pk PRIMARY KEY (USER_ID)
);


CREATE TABLE public.USER_ROLE (
                ID BIGINT NOT NULL,
                USER_ID BIGINT NOT NULL,
                ROLE_ID BIGINT NOT NULL,
                CONSTRAINT user_role_pk PRIMARY KEY (ID)
);


CREATE SEQUENCE public.commentaire_idcom_seq;

CREATE TABLE public.Commentaire (
                idCom INTEGER NOT NULL DEFAULT nextval('public.commentaire_idcom_seq'),
                USER_ID BIGINT NOT NULL,
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

ALTER TABLE public.USER_ROLE ADD CONSTRAINT app_role_user_role_fk
FOREIGN KEY (ROLE_ID)
REFERENCES public.APP_ROLE (ROLE_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Commentaire ADD CONSTRAINT app_user_commentaire_fk
FOREIGN KEY (USER_ID)
REFERENCES public.APP_USER (USER_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.USER_ROLE ADD CONSTRAINT app_user_user_role_fk
FOREIGN KEY (USER_ID)
REFERENCES public.APP_USER (USER_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Bar ADD CONSTRAINT biere_bar_fk
FOREIGN KEY (idBiere)
REFERENCES public.Biere (idBiere)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
