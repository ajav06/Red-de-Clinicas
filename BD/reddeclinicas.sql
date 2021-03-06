PGDMP     9    ;                w            Red-de-Clinicas    9.6.11    11.1 (Debian 11.1-3.pgdg90+1) >    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    24714    Red-de-Clinicas    DATABASE     �   CREATE DATABASE "Red-de-Clinicas" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'es_VE.UTF-8' LC_CTYPE = 'es_VE.UTF-8';
 !   DROP DATABASE "Red-de-Clinicas";
             postgres    false            �            1259    25093    antecedentespersonales    TABLE     y  CREATE TABLE public.antecedentespersonales (
    nro_historial integer NOT NULL,
    alcohol text,
    tabaco text,
    drogas text,
    infusiones text,
    alimentacion text,
    diuresis text,
    catarsis text,
    suenno text,
    sexualidad text,
    otros_fis text,
    enf_infancia text,
    cardiacas text,
    respiratorias text,
    gastrointestinales text,
    neufrourologicos text,
    hematologicos text,
    ginecologos text,
    infectologicos text,
    endocrinologicos text,
    quirurgicos text,
    traumatologicos text,
    alergicos text,
    neurologicos text,
    epidemiologicos text,
    otras_enf text
);
 *   DROP TABLE public.antecedentespersonales;
       public         postgres    false            �            1259    25099    clinica    TABLE     �   CREATE TABLE public.clinica (
    codigo text NOT NULL,
    nombre text NOT NULL,
    estado text NOT NULL,
    direccion text NOT NULL,
    telefono text,
    email text,
    estatus "char" DEFAULT 'a'::"char" NOT NULL
);
    DROP TABLE public.clinica;
       public         postgres    false            �            1259    25138    ofertaservicio    TABLE     �   CREATE TABLE public.ofertaservicio (
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
            public       postgres    false    198            �            1259    25106    consulta    TABLE       CREATE TABLE public.consulta (
    ced_paciente text NOT NULL,
    cod_trabajo text NOT NULL,
    cod_oferta text NOT NULL,
    fecha date NOT NULL,
    turno text NOT NULL,
    motivo text NOT NULL,
    diagnostico text,
    tratamiento text,
    estatus character(1)
);
    DROP TABLE public.consulta;
       public         postgres    false            �            1259    25112    especialidad    TABLE     �   CREATE TABLE public.especialidad (
    codigo text NOT NULL,
    nombre text NOT NULL,
    descripcion text NOT NULL,
    estatus "char" DEFAULT 'a'::"char" NOT NULL
);
     DROP TABLE public.especialidad;
       public         postgres    false            �            1259    25119    historialmedico    TABLE       CREATE TABLE public.historialmedico (
    numero integer NOT NULL,
    ced_paciente text NOT NULL,
    peso double precision NOT NULL,
    altura double precision NOT NULL,
    enfermedad_actual text,
    ante_enfer_act text,
    ante_familiar text,
    sexo "char" NOT NULL
);
 #   DROP TABLE public.historialmedico;
       public         postgres    false            �            1259    25125    intervencion    TABLE     �   CREATE TABLE public.intervencion (
    ced_paciente text NOT NULL,
    cod_trabajo text NOT NULL,
    cod_oferta text NOT NULL,
    fecha date NOT NULL,
    estatus character(1)
);
     DROP TABLE public.intervencion;
       public         postgres    false            �            1259    25131    medico    TABLE     \  CREATE TABLE public.medico (
    cedula text NOT NULL,
    cod_especialidad text NOT NULL,
    nombres text NOT NULL,
    apellidos text NOT NULL,
    fecha_nacimiento date NOT NULL,
    edo_civil "char",
    estado text,
    direccion text,
    tlf_casa text,
    tlf_movil text,
    email text,
    estatus "char" DEFAULT 'a'::"char" NOT NULL
);
    DROP TABLE public.medico;
       public         postgres    false            �            1259    25144    paciente    TABLE     c  CREATE TABLE public.paciente (
    cedula text NOT NULL,
    nombres text NOT NULL,
    apellidos text NOT NULL,
    fecha_nacimiento date NOT NULL,
    edo_civil "char" NOT NULL,
    estado text NOT NULL,
    direccion text,
    tlf_casa text,
    tlf_movil text,
    email text,
    asegurado boolean,
    estatus "char" DEFAULT 'a'::"char" NOT NULL
);
    DROP TABLE public.paciente;
       public         postgres    false            �            1259    25151    seguro    TABLE     �   CREATE TABLE public.seguro (
    codigo integer NOT NULL,
    nombre text NOT NULL,
    descripcion text NOT NULL,
    estatus "char" DEFAULT 'a'::"char" NOT NULL
);
    DROP TABLE public.seguro;
       public         postgres    false            �            1259    25158    seguropaciente    TABLE     �   CREATE TABLE public.seguropaciente (
    numero integer NOT NULL,
    cod_seguro integer NOT NULL,
    ced_paciente text NOT NULL
);
 "   DROP TABLE public.seguropaciente;
       public         postgres    false            �            1259    25164    servicio    TABLE     �   CREATE TABLE public.servicio (
    codigo text NOT NULL,
    cod_especialidad text NOT NULL,
    nombre text,
    descripcion text,
    estatus "char" DEFAULT 'a'::"char" NOT NULL,
    tipo_servicio character(1) NOT NULL
);
    DROP TABLE public.servicio;
       public         postgres    false            �            1259    25171    trabajomedico    TABLE     �   CREATE TABLE public.trabajomedico (
    codigo text NOT NULL,
    cod_clinica text NOT NULL,
    ced_medico text NOT NULL,
    turno text,
    max_intervenciones integer,
    max_consultas integer
);
 !   DROP TABLE public.trabajomedico;
       public         postgres    false                       2604    25676    ofertaservicio codigo    DEFAULT     k   ALTER TABLE ONLY public.ofertaservicio ALTER COLUMN codigo SET DEFAULT nextval('public.codigo'::regclass);
 D   ALTER TABLE public.ofertaservicio ALTER COLUMN codigo DROP DEFAULT;
       public       postgres    false    198    192            �          0    25093    antecedentespersonales 
   TABLE DATA               �  COPY public.antecedentespersonales (nro_historial, alcohol, tabaco, drogas, infusiones, alimentacion, diuresis, catarsis, suenno, sexualidad, otros_fis, enf_infancia, cardiacas, respiratorias, gastrointestinales, neufrourologicos, hematologicos, ginecologos, infectologicos, endocrinologicos, quirurgicos, traumatologicos, alergicos, neurologicos, epidemiologicos, otras_enf) FROM stdin;
    public       postgres    false    185   �Q       �          0    25099    clinica 
   TABLE DATA               ^   COPY public.clinica (codigo, nombre, estado, direccion, telefono, email, estatus) FROM stdin;
    public       postgres    false    186   �Q       �          0    25106    consulta 
   TABLE DATA               �   COPY public.consulta (ced_paciente, cod_trabajo, cod_oferta, fecha, turno, motivo, diagnostico, tratamiento, estatus) FROM stdin;
    public       postgres    false    187   �R       �          0    25112    especialidad 
   TABLE DATA               L   COPY public.especialidad (codigo, nombre, descripcion, estatus) FROM stdin;
    public       postgres    false    188   �R       �          0    25119    historialmedico 
   TABLE DATA               �   COPY public.historialmedico (numero, ced_paciente, peso, altura, enfermedad_actual, ante_enfer_act, ante_familiar, sexo) FROM stdin;
    public       postgres    false    189   �S       �          0    25125    intervencion 
   TABLE DATA               ]   COPY public.intervencion (ced_paciente, cod_trabajo, cod_oferta, fecha, estatus) FROM stdin;
    public       postgres    false    190   T       �          0    25131    medico 
   TABLE DATA               �   COPY public.medico (cedula, cod_especialidad, nombres, apellidos, fecha_nacimiento, edo_civil, estado, direccion, tlf_casa, tlf_movil, email, estatus) FROM stdin;
    public       postgres    false    191   /T       �          0    25138    ofertaservicio 
   TABLE DATA               S   COPY public.ofertaservicio (codigo, cod_servicio, cod_clinica, precio) FROM stdin;
    public       postgres    false    192   �U       �          0    25144    paciente 
   TABLE DATA               �   COPY public.paciente (cedula, nombres, apellidos, fecha_nacimiento, edo_civil, estado, direccion, tlf_casa, tlf_movil, email, asegurado, estatus) FROM stdin;
    public       postgres    false    193   V       �          0    25151    seguro 
   TABLE DATA               F   COPY public.seguro (codigo, nombre, descripcion, estatus) FROM stdin;
    public       postgres    false    194   �V       �          0    25158    seguropaciente 
   TABLE DATA               J   COPY public.seguropaciente (numero, cod_seguro, ced_paciente) FROM stdin;
    public       postgres    false    195   kW       �          0    25164    servicio 
   TABLE DATA               i   COPY public.servicio (codigo, cod_especialidad, nombre, descripcion, estatus, tipo_servicio) FROM stdin;
    public       postgres    false    196   �W       �          0    25171    trabajomedico 
   TABLE DATA               r   COPY public.trabajomedico (codigo, cod_clinica, ced_medico, turno, max_intervenciones, max_consultas) FROM stdin;
    public       postgres    false    197   VX       �           0    0    codigo    SEQUENCE SET     4   SELECT pg_catalog.setval('public.codigo', 1, true);
            public       postgres    false    198                       2606    25178    clinica Clinica_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.clinica
    ADD CONSTRAINT "Clinica_pkey" PRIMARY KEY (codigo);
 @   ALTER TABLE ONLY public.clinica DROP CONSTRAINT "Clinica_pkey";
       public         postgres    false    186                       2606    25180    consulta Consulta_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT "Consulta_pkey" PRIMARY KEY (fecha, turno);
 B   ALTER TABLE ONLY public.consulta DROP CONSTRAINT "Consulta_pkey";
       public         postgres    false    187    187                       2606    25182    especialidad Especialidad_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.especialidad
    ADD CONSTRAINT "Especialidad_pkey" PRIMARY KEY (codigo);
 J   ALTER TABLE ONLY public.especialidad DROP CONSTRAINT "Especialidad_pkey";
       public         postgres    false    188                        2606    25184 $   historialmedico HistorialMedico_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.historialmedico
    ADD CONSTRAINT "HistorialMedico_pkey" PRIMARY KEY (numero);
 P   ALTER TABLE ONLY public.historialmedico DROP CONSTRAINT "HistorialMedico_pkey";
       public         postgres    false    189            "           2606    25186    intervencion Intervencion_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.intervencion
    ADD CONSTRAINT "Intervencion_pkey" PRIMARY KEY (fecha);
 J   ALTER TABLE ONLY public.intervencion DROP CONSTRAINT "Intervencion_pkey";
       public         postgres    false    190            $           2606    25188    medico Medico_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.medico
    ADD CONSTRAINT "Medico_pkey" PRIMARY KEY (cedula);
 >   ALTER TABLE ONLY public.medico DROP CONSTRAINT "Medico_pkey";
       public         postgres    false    191            &           2606    25190 "   ofertaservicio OfertaServicio_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.ofertaservicio
    ADD CONSTRAINT "OfertaServicio_pkey" PRIMARY KEY (codigo);
 N   ALTER TABLE ONLY public.ofertaservicio DROP CONSTRAINT "OfertaServicio_pkey";
       public         postgres    false    192            (           2606    25192    paciente Paciente_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT "Paciente_pkey" PRIMARY KEY (cedula);
 B   ALTER TABLE ONLY public.paciente DROP CONSTRAINT "Paciente_pkey";
       public         postgres    false    193            *           2606    25194    seguro SeguroMedico_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.seguro
    ADD CONSTRAINT "SeguroMedico_pkey" PRIMARY KEY (codigo);
 D   ALTER TABLE ONLY public.seguro DROP CONSTRAINT "SeguroMedico_pkey";
       public         postgres    false    194            ,           2606    25196 "   seguropaciente SeguroPaciente_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.seguropaciente
    ADD CONSTRAINT "SeguroPaciente_pkey" PRIMARY KEY (numero);
 N   ALTER TABLE ONLY public.seguropaciente DROP CONSTRAINT "SeguroPaciente_pkey";
       public         postgres    false    195            .           2606    25198    servicio Servicio_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.servicio
    ADD CONSTRAINT "Servicio_pkey" PRIMARY KEY (codigo);
 B   ALTER TABLE ONLY public.servicio DROP CONSTRAINT "Servicio_pkey";
       public         postgres    false    196            0           2606    25200     trabajomedico TrabajoMedico_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.trabajomedico
    ADD CONSTRAINT "TrabajoMedico_pkey" PRIMARY KEY (codigo);
 L   ALTER TABLE ONLY public.trabajomedico DROP CONSTRAINT "TrabajoMedico_pkey";
       public         postgres    false    197            ?           2606    25201    trabajomedico ced_med    FK CONSTRAINT     �   ALTER TABLE ONLY public.trabajomedico
    ADD CONSTRAINT ced_med FOREIGN KEY (ced_medico) REFERENCES public.medico(cedula) ON UPDATE CASCADE ON DELETE CASCADE;
 ?   ALTER TABLE ONLY public.trabajomedico DROP CONSTRAINT ced_med;
       public       postgres    false    191    2084    197            2           2606    25206    consulta ced_pac    FK CONSTRAINT     �   ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT ced_pac FOREIGN KEY (ced_paciente) REFERENCES public.paciente(cedula) ON UPDATE CASCADE ON DELETE CASCADE;
 :   ALTER TABLE ONLY public.consulta DROP CONSTRAINT ced_pac;
       public       postgres    false    187    193    2088            <           2606    25211    seguropaciente ced_paciente    FK CONSTRAINT     �   ALTER TABLE ONLY public.seguropaciente
    ADD CONSTRAINT ced_paciente FOREIGN KEY (ced_paciente) REFERENCES public.paciente(cedula) ON UPDATE CASCADE ON DELETE CASCADE;
 E   ALTER TABLE ONLY public.seguropaciente DROP CONSTRAINT ced_paciente;
       public       postgres    false    2088    195    193            5           2606    25282    historialmedico ced_paciente    FK CONSTRAINT     �   ALTER TABLE ONLY public.historialmedico
    ADD CONSTRAINT ced_paciente FOREIGN KEY (ced_paciente) REFERENCES public.paciente(cedula) ON UPDATE CASCADE ON DELETE CASCADE;
 F   ALTER TABLE ONLY public.historialmedico DROP CONSTRAINT ced_paciente;
       public       postgres    false    2088    193    189            @           2606    25221    trabajomedico cod_cli    FK CONSTRAINT     �   ALTER TABLE ONLY public.trabajomedico
    ADD CONSTRAINT cod_cli FOREIGN KEY (cod_clinica) REFERENCES public.clinica(codigo) ON UPDATE CASCADE ON DELETE CASCADE;
 ?   ALTER TABLE ONLY public.trabajomedico DROP CONSTRAINT cod_cli;
       public       postgres    false    2074    186    197            :           2606    25226    ofertaservicio cod_cli    FK CONSTRAINT     �   ALTER TABLE ONLY public.ofertaservicio
    ADD CONSTRAINT cod_cli FOREIGN KEY (cod_clinica) REFERENCES public.clinica(codigo) ON UPDATE CASCADE ON DELETE CASCADE;
 @   ALTER TABLE ONLY public.ofertaservicio DROP CONSTRAINT cod_cli;
       public       postgres    false    192    2074    186            9           2606    25231    medico cod_esp    FK CONSTRAINT     �   ALTER TABLE ONLY public.medico
    ADD CONSTRAINT cod_esp FOREIGN KEY (cod_especialidad) REFERENCES public.especialidad(codigo) ON UPDATE CASCADE ON DELETE CASCADE;
 8   ALTER TABLE ONLY public.medico DROP CONSTRAINT cod_esp;
       public       postgres    false    2078    188    191            >           2606    25236    servicio cod_esp    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicio
    ADD CONSTRAINT cod_esp FOREIGN KEY (cod_especialidad) REFERENCES public.especialidad(codigo) ON UPDATE CASCADE ON DELETE CASCADE;
 :   ALTER TABLE ONLY public.servicio DROP CONSTRAINT cod_esp;
       public       postgres    false    2078    196    188            3           2606    25241    consulta cod_ofe    FK CONSTRAINT        ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT cod_ofe FOREIGN KEY (cod_oferta) REFERENCES public.ofertaservicio(codigo);
 :   ALTER TABLE ONLY public.consulta DROP CONSTRAINT cod_ofe;
       public       postgres    false    187    192    2086            6           2606    25246    intervencion cod_ofe    FK CONSTRAINT     �   ALTER TABLE ONLY public.intervencion
    ADD CONSTRAINT cod_ofe FOREIGN KEY (cod_oferta) REFERENCES public.ofertaservicio(codigo);
 >   ALTER TABLE ONLY public.intervencion DROP CONSTRAINT cod_ofe;
       public       postgres    false    190    192    2086            7           2606    25251    intervencion cod_pac    FK CONSTRAINT     �   ALTER TABLE ONLY public.intervencion
    ADD CONSTRAINT cod_pac FOREIGN KEY (ced_paciente) REFERENCES public.paciente(cedula) ON UPDATE CASCADE ON DELETE CASCADE;
 >   ALTER TABLE ONLY public.intervencion DROP CONSTRAINT cod_pac;
       public       postgres    false    190    193    2088            =           2606    25256    seguropaciente cod_seguro    FK CONSTRAINT     �   ALTER TABLE ONLY public.seguropaciente
    ADD CONSTRAINT cod_seguro FOREIGN KEY (cod_seguro) REFERENCES public.seguro(codigo) ON UPDATE CASCADE ON DELETE CASCADE;
 C   ALTER TABLE ONLY public.seguropaciente DROP CONSTRAINT cod_seguro;
       public       postgres    false    2090    195    194            ;           2606    25261    ofertaservicio cod_ser    FK CONSTRAINT     �   ALTER TABLE ONLY public.ofertaservicio
    ADD CONSTRAINT cod_ser FOREIGN KEY (cod_servicio) REFERENCES public.servicio(codigo) ON UPDATE CASCADE ON DELETE CASCADE;
 @   ALTER TABLE ONLY public.ofertaservicio DROP CONSTRAINT cod_ser;
       public       postgres    false    196    2094    192            4           2606    25266    consulta cod_tra    FK CONSTRAINT        ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT cod_tra FOREIGN KEY (cod_trabajo) REFERENCES public.trabajomedico(codigo);
 :   ALTER TABLE ONLY public.consulta DROP CONSTRAINT cod_tra;
       public       postgres    false    2096    187    197            8           2606    25271    intervencion cod_tra    FK CONSTRAINT     �   ALTER TABLE ONLY public.intervencion
    ADD CONSTRAINT cod_tra FOREIGN KEY (cod_trabajo) REFERENCES public.trabajomedico(codigo);
 >   ALTER TABLE ONLY public.intervencion DROP CONSTRAINT cod_tra;
       public       postgres    false    190    197    2096            1           2606    25276 $   antecedentespersonales nro_historial    FK CONSTRAINT     �   ALTER TABLE ONLY public.antecedentespersonales
    ADD CONSTRAINT nro_historial FOREIGN KEY (nro_historial) REFERENCES public.historialmedico(numero) ON UPDATE CASCADE ON DELETE CASCADE;
 N   ALTER TABLE ONLY public.antecedentespersonales DROP CONSTRAINT nro_historial;
       public       postgres    false    189    185    2080            �   <   x��4�41���D ��ԼDN�ĢD(�1�$D$r�.#KS�5[X�Z��;F��� ��)�      �   �   x�M�1�0Eg�9Aդ)�Q��V1�7CPHP(܉Sp1\J���}�P�c���*�#�����B��[i��h��ݲo��2�����dJUJ�A���̗J�G�`�C�";3����Lf;�0��Q��Hy��-�z~ V�x�&�N��{�����$[��+Ud/�b�U�o��3X��V��4aC�C&�xGnc�      �      x������ � �      �   �   x�]�;�0D��S��?5B 
J�Q� K���N7���r1��Dq�oߌfAӈ���ӹ�h[x5����um�����+M3k���UJ�!h$kG�����:�ؤ+(m*Ux��k�z�
AA���Rk�	���)��j�E����;�	6��0�>c�Ρze      �   U   x��4�41��42��0L9��9���ؗ��(ldf` f�Zp�Yr�%�$r�0ˍ�������0�df�	n\1z\\\ u�l      �      x������ � �      �   h  x�M��j�0���P FR�$��8�?4mIۜzY;K�"[E�y����	vaf�ѥQ�(H��&Xr��ʘ�D�&��<a@��9��.�B�����*n�Z��0�3)��%h��#9[��@�.��5���o>yp��Z��������X�����c����k�b��_��O.�B�3����>��+Q-W��QW���%��+���<�<#�Ls%�b
%T���Dl�1��C�ҁv^l�!N��ZJ5��c0�i������eCɶ^��p{�/�O~�)(�!"��\;�#W��t�����T������^���G5u�'
֋9��it=۝/rW��}�Y������      �   W   x�M���0�R1�q�^��Gx-�V�� �����1�2�hq��N�7�r�m��*Ƴ�xau@�F����E��4��ʋ�A�*��      �   �   x�e�AN�0EדS��l�i�eÆJ�E���|'V1�x�I+u�i�\* �ff�ߛ1��ζ�n�s\��,)
m�5#Bڹ�Q�F;��}><Gf�8d�2�&e��=�d���j?!�b��fBe�J�ZZ�S�X? !&Юp�s �w�¯��)�����{�#��3/2m	ߨ�2�]}���8��K<J�(d�v��(]�(�{�C|�S��?��d9x�a?.���_�Z�      �   ^   x�3�t��+.�,)M����NM/-�/V@Tp-�,�O��WH)�L�2�+
��,K-*N�I-�&���Tn��_�Y��W�
WII�L����� q/\      �   )   x�322�4�42�4�41��2156���,L�b���� q��      �   �   x�u�A� E�p������q�h�f�$S�EH�TW=0�j�y���_�����=:(��wd�#�X�L�*��l��Q:Z���3K�u�zeA�0���������V֥������Ч[�q�Z�?^4����-��5H����{�K,��W��'8�e�      �     x�U���0DϦ����-������as�v�[���Mg�XMT��L�����1s0g6��	6�-��`��Kf���O�Kz�U�,�"��C3Ρ�9�P��P�&�P��PĂs(r��"]��ragQfpò��,�98����L��Y���+��s��'.��"U�w-�>�mۣ�ۙ���}#���L��{�R������y�I)�������~տ�G�?b_Tj����4'�������O���u]?����     