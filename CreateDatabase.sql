--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2015-07-25 12:57:28 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

DROP DATABASE "SimpleBlog";
--
-- TOC entry 2209 (class 1262 OID 16456)
-- Name: SimpleBlog; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "SimpleBlog" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'C' LC_CTYPE = 'C';


ALTER DATABASE "SimpleBlog" OWNER TO postgres;

\connect "SimpleBlog"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 5 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 172 (class 3079 OID 12018)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 172
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 170 (class 1259 OID 16457)
-- Name: blogpost; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE blogpost (
    id integer NOT NULL,
    title character varying(255),
    created timestamp without time zone,
    content text,
    summary text
);


ALTER TABLE public.blogpost OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 16472)
-- Name: bloguser; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE bloguser (
    id integer NOT NULL,
    username character varying(64),
    password character varying(128),
    friendlyname character varying(128),
    isadmin bit(1)
);


ALTER TABLE public.bloguser OWNER TO postgres;

--
-- TOC entry 2203 (class 0 OID 16457)
-- Dependencies: 170
-- Data for Name: blogpost; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO blogpost VALUES (2, 'Dit is nog een test', '2015-07-11 15:35:00', 'En hier komt ook een verhaaltje', 'Samenvatting 2');
INSERT INTO blogpost VALUES (1, 'Dit is een test', '2015-07-11 14:45:00', 'Een verhaal-----------Dit is de tijd om een leuk verhaal te schrijven.En dit is nog een paragraaf.Hier komt een puntenlijstje:1. Pizza2. Patat3. ChipsWat volgt er nu?----------------Nog wat meer geblaat.En C# code:```public class Person{	public int ID { get; set; }	public string Name { get; set; }		public Person()	{		this.ID = 1;		this.Name = "Pietje";	}}```', 'Samenvatting 1');


--
-- TOC entry 2204 (class 0 OID 16472)
-- Dependencies: 171
-- Data for Name: bloguser; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO bloguser VALUES (1, 'marc', '1234', 'Marc', B'1');
INSERT INTO bloguser VALUES (2, 'pietje', '1234', 'Pietje', B'0');


--
-- TOC entry 2093 (class 2606 OID 16461)
-- Name: pk_blogpost_id; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY blogpost
    ADD CONSTRAINT pk_blogpost_id PRIMARY KEY (id);


--
-- TOC entry 2095 (class 2606 OID 16476)
-- Name: pk_bloguser; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bloguser
    ADD CONSTRAINT pk_bloguser PRIMARY KEY (id);


--
-- TOC entry 2211 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-07-25 12:57:28 CEST

--
-- PostgreSQL database dump complete
--

