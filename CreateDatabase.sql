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
-- Name: blogpost; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE blogpost (
    id integer NOT NULL,
    title character varying(255),
    created date NOT NULL,
    content text,
    summary text,
    author integer NOT NULL
);


ALTER TABLE blogpost OWNER TO postgres;

--
-- Name: bloguser; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE bloguser (
    id integer NOT NULL,
    username character varying(64),
    password character varying(128),
    friendlyname character varying(128),
    isadmin bit(1)
);


ALTER TABLE bloguser OWNER TO postgres;

--
-- Name: seq_blogpost; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE seq_blogpost
    START WITH 3
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE seq_blogpost OWNER TO postgres;

--
-- Data for Name: blogpost; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY blogpost (id, title, created, content, summary, author) FROM stdin;
1	Dependency injection with ASP.NET 5	2015-07-26	With ASP.NET 5 finally comes integrated dependency injection. This is something other frameworks like Spring MVC had for years, but better late than never I guess.	With ASP.NET 5 finally comes integrated dependency injection. This is something other frameworks like Spring MVC had for years, but better late than never I guess.	1
2	Getting started with ASP.NET 5	2015-07-26	ASP.NET 5 is the new portable web framework from Microsoft which actually runs on OS X and Linux.	ASP.NET 5 is the new portable web framework from Microsoft which actually runs on OS X and Linux.	1
3	Java 8 lamba's are fun	2015-07-26	Compared to C# and Scala, Java is a very verbose language.\r\n\r\nWith Java 8 lambda's we can finally trim down our code a bit.	Compared to C# and Scala, Java is a very verbose language.\r\n\r\nWith Java 8 lambda's we can finally trim down our code a bit.	1
4	What I like about Google Go	2015-07-26	Google Go is a new programming language that sits somewhere between C and C++, but with strong type inference and good support for concurrent programming.	Google Go is a new programming language that sits somewhere between C and C++, but with strong type inference and good support for concurrent programming.	1
5	Installing Ubuntu on an Intel NUC 2820	2015-07-26	Installing Ubuntu on an Intel NUC 2820 should be a breeze, as long as you stay away from the BIOS.\r\n\r\nReally. A simple tweak like setting the OS choice to Windows 7 instead of Windows 8 will give you a lot of headaches. The machine won't shut down properly et cetera.	Installing Ubuntu on an Intel NUC 2820 should be a breeze, as long as you stay away from the BIOS.\r\n\r\nReally. A simple tweak like setting the OS choice to Windows 7 instead of Windows 8 will give you a lot of headaches. The machine won't shut down properly et cetera.	1
\.


--
-- Data for Name: bloguser; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY bloguser (id, username, password, friendlyname, isadmin) FROM stdin;
1	marc	1234	Marc	1
2	pietje	1234	Pietje	0
\.


--
-- Name: seq_blogpost; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('seq_blogpost', 5, true);


--
-- Name: pk_blogpost_id; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY blogpost
    ADD CONSTRAINT pk_blogpost_id PRIMARY KEY (id);


--
-- Name: pk_bloguser; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bloguser
    ADD CONSTRAINT pk_bloguser PRIMARY KEY (id);


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

