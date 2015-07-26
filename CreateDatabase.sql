--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2015-07-26 11:51:03 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

DROP DATABASE "SimpleBlog";
--
-- TOC entry 2212 (class 1262 OID 16456)
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
-- TOC entry 2213 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 173 (class 3079 OID 12018)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2215 (class 0 OID 0)
-- Dependencies: 173
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
-- TOC entry 172 (class 1259 OID 16477)
-- Name: seq_blogpost; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE seq_blogpost
    START WITH 3
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_blogpost OWNER TO postgres;

--
-- TOC entry 2205 (class 0 OID 16457)
-- Dependencies: 170
-- Data for Name: blogpost; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO blogpost VALUES (5, 'Installing Ubuntu on an Intel NUC 2820', '2015-07-26 11:38:20.226', 'Installing Ubuntu on an Intel NUC 2820 should be a breeze, as long as you stay away from the BIOS.

Really. A simple tweak like setting the OS choice to Windows 7 instead of Windows 8 will give you a lot of headaches. The machine won''t shut down properly et cetera.', 'Installing Ubuntu on an Intel NUC 2820 should be a breeze, as long as you stay away from the BIOS.

Really. A simple tweak like setting the OS choice to Windows 7 instead of Windows 8 will give you a lot of headaches. The machine won''t shut down properly et cetera.');
INSERT INTO blogpost VALUES (3, 'Java 8 lamba''s are fun', '2015-07-26 11:39:49.084', 'Compared to C# and Scala, Java is a very verbose language.

With Java 8 lambda''s we can finally trim down our code a bit.', 'Compared to C# and Scala, Java is a very verbose language.

With Java 8 lambda''s we can finally trim down our code a bit.');
INSERT INTO blogpost VALUES (4, 'What I like about Google Go', '2015-07-26 11:41:16.568', 'Google Go is a new programming language that sits somewhere between C and C++, but with strong type inference and good support for concurrent programming.', 'Google Go is a new programming language that sits somewhere between C and C++, but with strong type inference and good support for concurrent programming.');
INSERT INTO blogpost VALUES (2, 'Getting started with ASP.NET 5', '2015-07-26 11:42:07.915', 'ASP.NET 5 is the new portable web framework from Microsoft which actually runs on OS X and Linux.', 'ASP.NET 5 is the new portable web framework from Microsoft which actually runs on OS X and Linux.');
INSERT INTO blogpost VALUES (1, 'Dependency injection with ASP.NET 5', '2015-07-26 11:43:35.748', 'With ASP.NET 5 finally comes integrated dependency injection. This is something other frameworks like Spring MVC had for years, but better late than never I guess.', 'With ASP.NET 5 finally comes integrated dependency injection. This is something other frameworks like Spring MVC had for years, but better late than never I guess.');


--
-- TOC entry 2206 (class 0 OID 16472)
-- Dependencies: 171
-- Data for Name: bloguser; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO bloguser VALUES (1, 'marc', '1234', 'Marc', B'1');
INSERT INTO bloguser VALUES (2, 'pietje', '1234', 'Pietje', B'0');


--
-- TOC entry 2216 (class 0 OID 0)
-- Dependencies: 172
-- Name: seq_blogpost; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('seq_blogpost', 5, true);


--
-- TOC entry 2095 (class 2606 OID 16461)
-- Name: pk_blogpost_id; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY blogpost
    ADD CONSTRAINT pk_blogpost_id PRIMARY KEY (id);


--
-- TOC entry 2097 (class 2606 OID 16476)
-- Name: pk_bloguser; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bloguser
    ADD CONSTRAINT pk_bloguser PRIMARY KEY (id);


--
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-07-26 11:51:04 CEST

--
-- PostgreSQL database dump complete
--

