--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: comunidad; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE comunidad WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'C' LC_CTYPE = 'C';


ALTER DATABASE comunidad OWNER TO postgres;

\connect comunidad

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: comunidad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE comunidad (
    id character varying(255) NOT NULL,
    nombre character varying(255) NOT NULL,
    poblacion character varying(255) NOT NULL
);


ALTER TABLE public.comunidad OWNER TO postgres;

--
-- Name: departamento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE departamento (
    id character varying(255) NOT NULL,
    tipo_vivienda character varying(255) NOT NULL,
    numero_dormitorios integer NOT NULL
);


ALTER TABLE public.departamento OWNER TO postgres;

--
-- Name: garaje; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE garaje (
    id character varying(255) NOT NULL,
    tipo character varying(255) NOT NULL,
    con_deposito boolean NOT NULL
);


ALTER TABLE public.garaje OWNER TO postgres;

--
-- Name: gasto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE gasto (
    id character varying(255) NOT NULL,
    descripcion character varying(255) NOT NULL,
    importe double precision NOT NULL,
    id_zona character varying(255) NOT NULL
);


ALTER TABLE public.gasto OWNER TO postgres;

--
-- Name: local_comercial; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE local_comercial (
    id character varying(255) NOT NULL,
    nombre character varying(255) NOT NULL,
    actividad character varying(255) NOT NULL
);


ALTER TABLE public.local_comercial OWNER TO postgres;

--
-- Name: propiedad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE propiedad (
    tipo character varying(255) NOT NULL,
    id character varying(255) NOT NULL,
    metros_cuadrados double precision NOT NULL,
    id_propietario character varying(255) NOT NULL,
    porcentaje_reparto character varying(255) NOT NULL
);


ALTER TABLE public.propiedad OWNER TO postgres;

--
-- Name: propietario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE propietario (
    id character varying(255) NOT NULL,
    nombre character varying(255) NOT NULL,
    poblacion character varying(255) NOT NULL,
    email character varying(255) NOT NULL
);


ALTER TABLE public.propietario OWNER TO postgres;

--
-- Name: zona_reparto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE zona_reparto (
    id character varying(255) NOT NULL,
    nombre character varying(255) NOT NULL,
    tipo_reparto character varying(255) NOT NULL
);


ALTER TABLE public.zona_reparto OWNER TO postgres;

--
-- Data for Name: comunidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY comunidad (id, nombre, poblacion) FROM stdin;
01	Trebol	Temporal
\.


--
-- Data for Name: departamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY departamento (id, tipo_vivienda, numero_dormitorios) FROM stdin;
1-A	VH	2
1-B	VH	3
1-C	VNH	3
2-A	VH	4
2-B	VH	4
2-C	VNH	4
\.


--
-- Data for Name: garaje; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY garaje (id, tipo, con_deposito) FROM stdin;
P01	A	f
P02	A	f
P03	A	t
P04	A	t
P05	A	t
P06	C	f
P07	C	f
P08	C	f
P09	C	f
P10	C	f
\.


--
-- Data for Name: gasto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY gasto (id, descripcion, importe, id_zona) FROM stdin;
L001	Luz Escalera	56	E
L002	Luz Garaje	36	G
A001	Agua Escalera	30	E
A002	Agua Zona Comu	130	C
AS01	Seguro Escalera	600	E
S002	Seguro Garaje	300	G
S003	Seguro Piscina	150	C
LI01	Limpieza Escalera	1200	E
LI02	Limpieza Zona Comun	600	C
REIX	Rejas Jardin	1500	C
JARD	Jardinero	1500	C
ANTE	Antena Comunitaria	700	C
OB01	Obras Escalera	3000	E
\.


--
-- Data for Name: local_comercial; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY local_comercial (id, nombre, actividad) FROM stdin;
0-A	Banco Mundial	Banca
0-B	Hercules	Seguros
0-C	Caprabo	Alimentacion
\.


--
-- Data for Name: propiedad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY propiedad (tipo, id, metros_cuadrados, id_propietario, porcentaje_reparto) FROM stdin;
L	0-A	80	04	E-8
L	0-B	90	05	E-9
L	0-C	90	06	E-9
D	1-A	90	07	E-9,C-12
D	1-B	100	08	E-10,C-14
D	1-C	100	09	E-10,C-14
D	2-A	150	01	E-15,C-20
D	2-B	150	02	E-15,C-20
D	2-C	150	03	E-15,C-20
G	P01	12	14	G-10
G	P02	12	15	G-10
G	P03	15	01	G-10
G	P04	15	02	G-10
G	P05	15	03	G-10
G	P06	15	04	G-10
G	P07	15	10	G-10
G	P08	15	11	G-10
G	P09	15	12	G-10
G	P10	15	13	G-10
\.


--
-- Data for Name: propietario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY propietario (id, nombre, poblacion, email) FROM stdin;
01	Jorge Salas	Sopocachi (La Paz)	jsalas@dominio.com
02	Jaime Rodriguez	Sacaba (Cochabamba)	jrodriguez@dominio.com
03	Nestor Crespo	Temporal (Cochabamba)	ncrespo@dominio.com
04	Maria Gutierrez	Temporal (Cochabamba)	mgutierrez@dominio.com
05	Miguel Palacios	Temporal (Cochabamba)	mpalacios@dominio.com
06	Nuria Mas	Temporal (Cochabamba)	nmas@dominio.com
07	Ricardo Torres	Temporal (Cochabamba)	rtorres@dominio.com
08	Tomas Asensio	Temporal (Cochabamba)	tasensio@dominio.com
09	Enrique Alos	Temporal (Cochabamba)	ealos@dominio.com
10	Pedro Navarra	Temporal (Cochabamba)	pnavarra@dominio.com
11	Sergio Briban	Temporal (Cochabamba)	sbriban@dominio.com
12	Carlos Escudero	Temporal (Cochabamba)	cescudero@dominio.com
13	Ruben Palencia	Temporal (Cochabamba)	rpalencia@dominio.com
14	Paula Cabos	Temporal (Cochabamba)	pcabos@dominio.com
15	Juan Tenorio	Temporal (Cochabamba)	jtenorio@dominio.com
\.


--
-- Data for Name: zona_reparto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY zona_reparto (id, nombre, tipo_reparto) FROM stdin;
E	Escalera	P
G	Garaje	I
C	Zona Comun	P
\.


--
-- Name: comunidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY comunidad
    ADD CONSTRAINT comunidad_pkey PRIMARY KEY (id);


--
-- Name: departamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY departamento
    ADD CONSTRAINT departamento_pkey PRIMARY KEY (id);


--
-- Name: garaje_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY garaje
    ADD CONSTRAINT garaje_pkey PRIMARY KEY (id);


--
-- Name: gasto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY gasto
    ADD CONSTRAINT gasto_pkey PRIMARY KEY (id);


--
-- Name: local_comercial_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY local_comercial
    ADD CONSTRAINT local_comercial_pkey PRIMARY KEY (id);


--
-- Name: propiedad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY propiedad
    ADD CONSTRAINT propiedad_pkey PRIMARY KEY (id);


--
-- Name: propietario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY propietario
    ADD CONSTRAINT propietario_pkey PRIMARY KEY (id);


--
-- Name: zona_reparto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY zona_reparto
    ADD CONSTRAINT zona_reparto_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

