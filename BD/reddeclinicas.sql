PGDMP     &                    w            Red-de-Clinicas    9.6.11    11.1 (Debian 11.1-3.pgdg90+1)     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    24714    Red-de-Clinicas    DATABASE     �   CREATE DATABASE "Red-de-Clinicas" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'es_VE.UTF-8' LC_CTYPE = 'es_VE.UTF-8';
 !   DROP DATABASE "Red-de-Clinicas";
             postgres    false            �            1259    25138    ofertaservicio    TABLE     �   CREATE TABLE public.ofertaservicio (
    codigo text NOT NULL,
    cod_servicio text NOT NULL,
    cod_clinica text NOT NULL,
    precio double precision NOT NULL
);
 "   DROP TABLE public.ofertaservicio;
       public         postgres    false            �            1259    25674    codigo    SEQUENCE     o   CREATE SEQUENCE public.codigo
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.codigo;
       public       postgres    false    192            �           0    0    codigo    SEQUENCE OWNED BY     D   ALTER SEQUENCE public.codigo OWNED BY public.ofertaservicio.codigo;
            public       postgres    false    198                       2604    25676    ofertaservicio codigo    DEFAULT     k   ALTER TABLE ONLY public.ofertaservicio ALTER COLUMN codigo SET DEFAULT nextval('public.codigo'::regclass);
 D   ALTER TABLE public.ofertaservicio ALTER COLUMN codigo DROP DEFAULT;
       public       postgres    false    198    192                      0    25138    ofertaservicio 
   TABLE DATA               S   COPY public.ofertaservicio (codigo, cod_servicio, cod_clinica, precio) FROM stdin;
    public       postgres    false    192   �       �           0    0    codigo    SEQUENCE SET     4   SELECT pg_catalog.setval('public.codigo', 1, true);
            public       postgres    false    198                       2606    25190 "   ofertaservicio OfertaServicio_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.ofertaservicio
    ADD CONSTRAINT "OfertaServicio_pkey" PRIMARY KEY (codigo);
 N   ALTER TABLE ONLY public.ofertaservicio DROP CONSTRAINT "OfertaServicio_pkey";
       public         postgres    false    192                       2606    25226    ofertaservicio cod_cli    FK CONSTRAINT     �   ALTER TABLE ONLY public.ofertaservicio
    ADD CONSTRAINT cod_cli FOREIGN KEY (cod_clinica) REFERENCES public.clinica(codigo) ON UPDATE CASCADE ON DELETE CASCADE;
 @   ALTER TABLE ONLY public.ofertaservicio DROP CONSTRAINT cod_cli;
       public       postgres    false    192            	           2606    25261    ofertaservicio cod_ser    FK CONSTRAINT     �   ALTER TABLE ONLY public.ofertaservicio
    ADD CONSTRAINT cod_ser FOREIGN KEY (cod_servicio) REFERENCES public.servicio(codigo) ON UPDATE CASCADE ON DELETE CASCADE;
 @   ALTER TABLE ONLY public.ofertaservicio DROP CONSTRAINT cod_ser;
       public       postgres    false    192                  x������ � �     