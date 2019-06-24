--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3 (Ubuntu 11.3-1.pgdg18.04+1)
-- Dumped by pg_dump version 11.3 (Ubuntu 11.3-1.pgdg18.04+1)

-- Started on 2019-06-24 00:21:19 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE oussystem;
--
-- TOC entry 2951 (class 1262 OID 16384)
-- Name: oussystem; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE oussystem WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'pt_BR.UTF-8' LC_CTYPE = 'pt_BR.UTF-8';


ALTER DATABASE oussystem OWNER TO postgres;

\connect oussystem

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 198 (class 1259 OID 16395)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    id integer NOT NULL,
    bairro text,
    cidade text,
    endereco text,
    estado text,
    nome text,
    numero text,
    telefone1 text,
    telefone2 text
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16385)
-- Name: funcionario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.funcionario (
    id integer NOT NULL,
    cargo text,
    contato text,
    email text,
    nome text,
    senha text,
    sobrenome text
);


ALTER TABLE public.funcionario OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16393)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16424)
-- Name: os; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.os (
    id integer NOT NULL,
    aparelho character varying(255),
    cor_aparelho character varying(255),
    descricao_defeito character varying(255),
    itens_inclusos character varying(255),
    marca character varying(255),
    modelo character varying(255),
    servico character varying(255),
    status character varying(255),
    valor double precision,
    cliente_id integer
);


ALTER TABLE public.os OWNER TO postgres;

--
-- TOC entry 2944 (class 0 OID 16395)
-- Dependencies: 198
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cliente (id, bairro, cidade, endereco, estado, nome, numero, telefone1, telefone2) VALUES (8, 'São Vicente', 'Crateús', 'Rua Marechal Hermes', 'CE', 'Agatha B', '116 A', '88988888888', '88999999999');
INSERT INTO public.cliente (id, bairro, cidade, endereco, estado, nome, numero, telefone1, telefone2) VALUES (7, 'Teste', 'Crateús', 'Rua Teste', 'CE', 'Igor Claudino', '123', '88999999999', '88988888888');
INSERT INTO public.cliente (id, bairro, cidade, endereco, estado, nome, numero, telefone1, telefone2) VALUES (55, 'Centro', 'Crateús', 'Almirante Tamandaré', 'CE', 'Stefanne', '774', '88899999999', '99999999999');
INSERT INTO public.cliente (id, bairro, cidade, endereco, estado, nome, numero, telefone1, telefone2) VALUES (51, 'centro', 'crateus', 'almirante tamandare', 'CE', ' Luana Soares', '12', '88993551234', 'q2w35678');


--
-- TOC entry 2942 (class 0 OID 16385)
-- Dependencies: 196
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.funcionario (id, cargo, contato, email, nome, senha, sobrenome) VALUES (56, 'Tecnico', '88998052063', 'stefanne@mail.com', 'Stéfanne', '12345', 'Sousa');
INSERT INTO public.funcionario (id, cargo, contato, email, nome, senha, sobrenome) VALUES (1, 'Administrador', '88999999999', 'admin@mail.com', 'Administrador', '12345', 'do Sistema Massa');
INSERT INTO public.funcionario (id, cargo, contato, email, nome, senha, sobrenome) VALUES (57, 'Atendente', '88997555555', 'lucas@mail.com', 'João', '12345', 'Lucas');


--
-- TOC entry 2945 (class 0 OID 16424)
-- Dependencies: 199
-- Data for Name: os; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.os (id, aparelho, cor_aparelho, descricao_defeito, itens_inclusos, marca, modelo, servico, status, valor, cliente_id) VALUES (58, 'Celular', 'Prata', 'TEla quebrada', 'carregador', 'Samsung', 'gt234', 'troca de tela', 'Aberta', 230, 8);
INSERT INTO public.os (id, aparelho, cor_aparelho, descricao_defeito, itens_inclusos, marca, modelo, servico, status, valor, cliente_id) VALUES (60, 'Celular', 'Preto', 'falta botoes', 'carregador', 'LG', 'w79W7', 'adc botoes', 'Aguardando', 50, 51);
INSERT INTO public.os (id, aparelho, cor_aparelho, descricao_defeito, itens_inclusos, marca, modelo, servico, status, valor, cliente_id) VALUES (54, 'Computador', 'Prata', 'sgf', 'efe', 'Acer', 'vbn', 'fe', 'Aberta', 34, 7);
INSERT INTO public.os (id, aparelho, cor_aparelho, descricao_defeito, itens_inclusos, marca, modelo, servico, status, valor, cliente_id) VALUES (59, 'Tablet', 'Roxo', 'viciado', 'carregador', 'Microsoft', 'abc', 'troca de bateria', 'Concluida', 300, 55);


--
-- TOC entry 2952 (class 0 OID 0)
-- Dependencies: 197
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 62, true);


--
-- TOC entry 2817 (class 2606 OID 16402)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);


--
-- TOC entry 2815 (class 2606 OID 16392)
-- Name: funcionario funcionario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (id);


--
-- TOC entry 2819 (class 2606 OID 16431)
-- Name: os os_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.os
    ADD CONSTRAINT os_pkey PRIMARY KEY (id);


--
-- TOC entry 2820 (class 2606 OID 16432)
-- Name: os fkqit3h78vjw0mfglwkw7skc9mh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.os
    ADD CONSTRAINT fkqit3h78vjw0mfglwkw7skc9mh FOREIGN KEY (cliente_id) REFERENCES public.cliente(id);


-- Completed on 2019-06-24 00:21:20 -03

--
-- PostgreSQL database dump complete
--

