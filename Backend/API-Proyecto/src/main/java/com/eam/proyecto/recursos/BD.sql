DROP TABLE asistencia CASCADE CONSTRAINTS;

DROP TABLE blindaje CASCADE CONSTRAINTS;

DROP TABLE caracteristica_lugar CASCADE CONSTRAINTS;

DROP TABLE caracteristica_via CASCADE CONSTRAINTS;

DROP TABLE colores CASCADE CONSTRAINTS;

DROP TABLE comparendo CASCADE CONSTRAINTS;

DROP TABLE curso CASCADE CONSTRAINTS;

DROP TABLE detalle_comparendo CASCADE CONSTRAINTS;

DROP TABLE empresa CASCADE CONSTRAINTS;

DROP TABLE examen CASCADE CONSTRAINTS;

DROP TABLE grua CASCADE CONSTRAINTS;

DROP TABLE historial_duenio CASCADE CONSTRAINTS;

DROP TABLE informe_accidente_transito CASCADE CONSTRAINTS;

DROP TABLE licencia CASCADE CONSTRAINTS;

DROP TABLE lugar CASCADE CONSTRAINTS;

DROP TABLE modalidad_transporte CASCADE CONSTRAINTS;

DROP TABLE municipio CASCADE CONSTRAINTS;

DROP TABLE pago_comparendo CASCADE CONSTRAINTS;

DROP TABLE perjudicados CASCADE CONSTRAINTS;

DROP TABLE persona CASCADE CONSTRAINTS;

DROP TABLE poliza_seguro CASCADE CONSTRAINTS;

DROP TABLE requisitos CASCADE CONSTRAINTS;

DROP TABLE testigos CASCADE CONSTRAINTS;

DROP TABLE tipo_carroceria CASCADE CONSTRAINTS;

DROP TABLE tipo_documento CASCADE CONSTRAINTS;

DROP TABLE tipo_infraccion CASCADE CONSTRAINTS;

DROP TABLE tipo_tramite CASCADE CONSTRAINTS;

DROP TABLE tramite CASCADE CONSTRAINTS;

DROP TABLE usuario CASCADE CONSTRAINTS;

DROP TABLE validacion CASCADE CONSTRAINTS;

DROP TABLE valores CASCADE CONSTRAINTS;

DROP TABLE vehiculo CASCADE CONSTRAINTS;

DROP TABLE vehiculo_tramite CASCADE CONSTRAINTS;

DROP TABLE vehiculos_afectados CASCADE CONSTRAINTS;

DROP TABLE via CASCADE CONSTRAINTS;

DROP TABLE administrador CASCADE CONSTRAINTS;

CREATE TABLE asistencia (
    id         INTEGER NOT NULL,
    curso_id   INTEGER NOT NULL
);

ALTER TABLE asistencia ADD CONSTRAINT asistencia_pk PRIMARY KEY ( id );

CREATE TABLE blindaje (
    numero_resolucion   INTEGER NOT NULL,
    fecha               DATE
);

ALTER TABLE blindaje ADD CONSTRAINT blindaje_pk PRIMARY KEY ( numero_resolucion );

CREATE TABLE administrador (
    id INTEGER NOT NULL,
    usuario VARCHAR(20 CHAR) NOT NULL,
    contrasena VARCHAR(20 CHAR) NOT NULL
);

ALTER TABLE administrador ADD CONSTRAINT administrador_pk PRIMARY KEY ( id );

CREATE TABLE caracteristica_lugar (
    id           INTEGER NOT NULL,
    area_id      VARCHAR2(20 CHAR) NOT NULL,
    sector_id    VARCHAR2(20 CHAR) NOT NULL,
    zona_id      VARCHAR2(20 CHAR) NOT NULL,
    disenio_id   VARCHAR2(20 CHAR) NOT NULL,
    tiempo_id    VARCHAR2(20 CHAR) NOT NULL
);

ALTER TABLE caracteristica_lugar ADD CONSTRAINT caracteristica_lugar_pk PRIMARY KEY ( id );

CREATE TABLE caracteristica_via (
    id                       INTEGER NOT NULL,
    carac_geometrica_via_1   VARCHAR2(10 CHAR) NOT NULL,
    carac_geometrica_via_2   VARCHAR2(10 CHAR) NOT NULL,
    carac_geometrica_via_3   VARCHAR2(10 CHAR) NOT NULL,
    utilizacion              VARCHAR2(20 CHAR) NOT NULL,
    calzada                  VARCHAR2(20 CHAR) NOT NULL,
    carril                   VARCHAR2(20 CHAR) NOT NULL,
    material                 VARCHAR2(20 CHAR) NOT NULL,
    estado                   VARCHAR2(20 CHAR) NOT NULL,
    condicion                VARCHAR2(20 CHAR),
    iluminacion              VARCHAR2(20 CHAR) NOT NULL,
    disminucion_visual       VARCHAR2(20 CHAR) NOT NULL,
    control_semaforo         VARCHAR2(20 CHAR) NOT NULL,
    control_seniales          VARCHAR2(5 CHAR) NOT NULL,
    control_demarcacion      VARCHAR2(20 CHAR) NOT NULL
);

ALTER TABLE caracteristica_via ADD CONSTRAINT caracteristicas_via_pk PRIMARY KEY ( id );

CREATE TABLE colores (
    id               INTEGER NOT NULL,
    descripcion      VARCHAR2(20 CHAR) NOT NULL,
    vehiculo_placa   VARCHAR2(20 CHAR) NOT NULL
);

ALTER TABLE colores ADD CONSTRAINT colores_pk PRIMARY KEY ( id );

CREATE TABLE comparendo (
    id                        INTEGER NOT NULL,
    fecha                     DATE NOT NULL,
    localidad_comuna          VARCHAR2(20 CHAR),
    via_principal             INTEGER NOT NULL,
    municipio_id              INTEGER NOT NULL,
    via_secundaria            INTEGER NOT NULL,
    tipo_infraccion           INTEGER NOT NULL,
    modalidad_transporte_id   INTEGER NOT NULL,
    radio_accion_id           VARCHAR2(20 CHAR) NOT NULL,
    tipo_infractor            VARCHAR2(20 CHAR) NOT NULL,
    descripcion               VARCHAR2(100 CHAR) NOT NULL,
    grua_id                   INTEGER,
    agente                    VARCHAR2(20 CHAR) NOT NULL,
    cuidadano                 VARCHAR2(20 CHAR) NOT NULL,
    testigo                   VARCHAR2(20 CHAR),
    vehiculo_placa            VARCHAR2(20 CHAR) NOT NULL,
    estado                    VARCHAR2(10 CHAR) NOT NULL
);

ALTER TABLE comparendo ADD CONSTRAINT comparendo_pk PRIMARY KEY ( id );

CREATE TABLE curso (
    id                    INTEGER NOT NULL,
    docente               VARCHAR2(20 CHAR) NOT NULL,
    fecha                 DATE,
    HORA_INICIO         VARCHAR2(10 CHAR),
    HORA_FINALIZACION   VARCHAR2(10 CHAR)
);

ALTER TABLE curso ADD CONSTRAINT curso_pk PRIMARY KEY ( id );

CREATE TABLE detalle_comparendo (
    id                       INTEGER NOT NULL,
    aceptacion_compatrendo   INTEGER NOT NULL,
    fecha_asistencia         DATE
);

ALTER TABLE detalle_comparendo ADD CONSTRAINT detalle_comparendo_pk PRIMARY KEY ( id );

CREATE TABLE empresa (
    nit      INTEGER NOT NULL,
    nombre   VARCHAR2(20) NOT NULL
);

ALTER TABLE empresa ADD CONSTRAINT empresav1_pkv1 PRIMARY KEY ( nit );

CREATE TABLE examen (
    id                  INTEGER NOT NULL,
    examen_embriaguez   VARCHAR2(20 CHAR),
    examen_droga        VARCHAR2(20 CHAR),
    grado               VARCHAR2(10 CHAR)
);

ALTER TABLE examen ADD CONSTRAINT examen_pk PRIMARY KEY ( id );

CREATE TABLE grua (
    numero_grua                INTEGER NOT NULL,
    placa                      VARCHAR2(10) NOT NULL,
    consecutivo                VARCHAR2(20) NOT NULL,
    direccion_patio_asignado   VARCHAR2(20 CHAR)
);

ALTER TABLE grua ADD CONSTRAINT grua_pk PRIMARY KEY ( numero_grua );

ALTER TABLE grua ADD CONSTRAINT grua__un UNIQUE ( placa );

CREATE TABLE historial_duenio (
    id               INTEGER NOT NULL,
    persona_id       VARCHAR2(20 CHAR) NOT NULL,
    vehiculo_placa   VARCHAR2(20 CHAR) NOT NULL,
    fecha            DATE
);

ALTER TABLE historial_duenio ADD CONSTRAINT historial_duenio_pk PRIMARY KEY ( id );

CREATE TABLE informe_accidente_transito (
    id                INTEGER NOT NULL,
    tipo_gravedad     VARCHAR2(20 CHAR) NOT NULL,
    fecha_hora        DATE NOT NULL,
    agente            VARCHAR2(20 CHAR) NOT NULL,
    clase_accidente   VARCHAR2(20 CHAR),
    coques_con        VARCHAR2(20 CHAR),
    objeto_fijo       VARCHAR2(20 CHAR),
    croquis           BLOB,
    numero_muertos    INTEGER,
    numero_heridos    INTEGER
);

ALTER TABLE informe_accidente_transito ADD CONSTRAINT informe_accidente_transito_pk PRIMARY KEY ( id );

CREATE TABLE licencia (
    id                   INTEGER NOT NULL,
    numero_licencia      VARCHAR2(20) NOT NULL,
    fecha_expedicion     DATE,
    fecha_vencimiento    DATE,
    oficina_transito     VARCHAR2(20),
    categoria_licencia   VARCHAR2(10 CHAR)
);

ALTER TABLE licencia ADD CONSTRAINT licencia_pk PRIMARY KEY ( id );

CREATE TABLE lugar (
    id                 INTEGER NOT NULL,
    coordenanda_x      VARCHAR2(5 CHAR),
    coordenada_y       VARCHAR2(5 CHAR),
    direccion          VARCHAR2(20 CHAR) NOT NULL,
    localidad_comuna   VARCHAR2(20 CHAR) NOT NULL
);

ALTER TABLE lugar ADD CONSTRAINT lugar_pk PRIMARY KEY ( id );

CREATE TABLE modalidad_transporte (
    id                          INTEGER NOT NULL,
    descripcion                 VARCHAR2(20 CHAR) NOT NULL,
    tipo_transporte_pasajeros   VARCHAR2(20 CHAR)
);

ALTER TABLE modalidad_transporte ADD CONSTRAINT modalidadtransporte_pk PRIMARY KEY ( id );

CREATE TABLE municipio (
    id       INTEGER NOT NULL,
    nombre   VARCHAR2(20) NOT NULL
);

ALTER TABLE municipio ADD CONSTRAINT municipiov1_pk PRIMARY KEY ( id );

CREATE TABLE pago_comparendo (
    id              INTEGER NOT NULL,
    interese_mora   INTEGER,
    monto_total     INTEGER
);

ALTER TABLE pago_comparendo ADD CONSTRAINT pago_comparendo_pk PRIMARY KEY ( id );

CREATE TABLE perjudicados (
    id                       INTEGER NOT NULL,
    tipo_perjudicado         VARCHAR2(20 CHAR),
    persona_id               VARCHAR2(20 CHAR) NOT NULL,
    vehiculos_afectados_id   INTEGER NOT NULL,
    cinturon                 CHAR(1),
    casco                    CHAR(1),
    sexo                     VARCHAR2(10 CHAR),
    gravedad                 VARCHAR2(10 CHAR),
    condicion                VARCHAR2(10 CHAR),
    licencia_id              INTEGER
);

ALTER TABLE perjudicados ADD CONSTRAINT perjudicados_pk PRIMARY KEY ( id );

CREATE TABLE poliza_seguro (
    n_poliza               INTEGER NOT NULL,
    fecha_vencimiento      DATE NOT NULL,
    vehiculo_placa         VARCHAR2(20 CHAR) NOT NULL,
    compania_aseguradora   VARCHAR2(20 CHAR)
);

ALTER TABLE poliza_seguro ADD CONSTRAINT poliza_seguro_pkv1 PRIMARY KEY ( n_poliza );

CREATE TABLE requisitos (
    id                INTEGER NOT NULL,
    descripcion       VARCHAR2(20 CHAR),
    tipo_tramite_id   INTEGER NOT NULL
);

ALTER TABLE requisitos ADD CONSTRAINT requisitos_pk PRIMARY KEY ( id );

CREATE TABLE testigos (
    id                              INTEGER NOT NULL,
    persona_id                      VARCHAR2(20 CHAR) NOT NULL,
    informe_accidente_transito_id   INTEGER NOT NULL,
    testimonio                      VARCHAR2(100 CHAR)
);

ALTER TABLE testigos ADD CONSTRAINT testigos_pk PRIMARY KEY ( id );

CREATE TABLE tipo_carroceria (
    codigo   INTEGER NOT NULL,
    tipo     VARCHAR2(20 CHAR)
);

ALTER TABLE tipo_carroceria ADD CONSTRAINT tipo_carroceria_pk PRIMARY KEY ( codigo );

CREATE TABLE tipo_documento (
    id       INTEGER NOT NULL,
    nombre   VARCHAR2(30 CHAR) NOT NULL
);

ALTER TABLE tipo_documento ADD CONSTRAINT tipo_documento_pk PRIMARY KEY ( id );

CREATE TABLE tipo_infraccion (
    id                    INTEGER NOT NULL,
    codigo                VARCHAR2(10 CHAR) NOT NULL,
    inmovilizacion        INTEGER NOT NULL,
    suspencion_licencia   INTEGER NOT NULL,
    salarios_minimos      INTEGER NOT NULL
);

ALTER TABLE tipo_infraccion ADD CONSTRAINT infraccion_pk PRIMARY KEY ( id );

ALTER TABLE tipo_infraccion ADD CONSTRAINT infraccion__un UNIQUE ( codigo );

CREATE TABLE tipo_tramite (
    id            INTEGER NOT NULL,
    descripcion   VARCHAR2(20 CHAR) NOT NULL
);

ALTER TABLE tipo_tramite ADD CONSTRAINT tipo_tramite_pk PRIMARY KEY ( id );

CREATE TABLE tramite (
    id                    INTEGER NOT NULL,
    fecha                 DATE,
    descripcion           VARCHAR2(20 CHAR),
    valor                 INTEGER NOT NULL,
    persona_id            VARCHAR2(20 CHAR),
    vehiculo_tramite_id   VARCHAR2(20 CHAR) NOT NULL,
    tipo_tramite_id       INTEGER NOT NULL
);

ALTER TABLE tramite ADD CONSTRAINT tramite_pk PRIMARY KEY ( id );

CREATE TABLE persona (
    nip                 VARCHAR2(20 CHAR) NOT NULL,
    nombre_completo     VARCHAR2(50 CHAR) NOT NULL,
    fecha_nacimiento    DATE,
    direccion           VARCHAR2(100 CHAR) NOT NULL,
    eps                 VARCHAR2(20 CHAR),
    tipo_documento_id   INTEGER NOT NULL,
    placa               INTEGER,
    municipio_id        INTEGER NOT NULL,
    telefono            VARCHAR2(20 CHAR) NOT NULL
);

ALTER TABLE persona ADD CONSTRAINT persona_pk PRIMARY KEY ( nip );

ALTER TABLE persona ADD CONSTRAINT persona__un UNIQUE ( placa );

CREATE TABLE usuario (
    nombre_usuario        VARCHAR2(20 CHAR) NOT NULL,
    password              VARCHAR2(20) NOT NULL,
    email                 VARCHAR2(20),
    respuesta_seguridad   VARCHAR2(50),
    tipo_usuario          VARCHAR2(20 CHAR) NOT NULL,
    validacion_id         INTEGER NOT NULL,
    persona_id            VARCHAR2(20 CHAR) NOT NULL
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( nombre_usuario );

ALTER TABLE usuario ADD CONSTRAINT recuperar_contrasenia_un UNIQUE ( respuesta_seguridad,validacion_id );

CREATE TABLE validacion (
    id            INTEGER NOT NULL,
    descripcion   VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE validacion ADD CONSTRAINT validacion_pk PRIMARY KEY ( id );

CREATE TABLE valores (
    fecha                  DATE NOT NULL,
    valor_salario_minimo   INTEGER NOT NULL,
    valor_dia_mora         INTEGER,
    descuento_comparendo   INTEGER,
    dias_habiles           INTEGER
);

ALTER TABLE valores ADD CONSTRAINT valores_pk PRIMARY KEY ( fecha );

CREATE TABLE vehiculo (
    placa                  VARCHAR2(20 CHAR) NOT NULL,
    modelo                 VARCHAR2(10 CHAR),
    linea                  VARCHAR2(10 CHAR),
    capacidad_carga        INTEGER,
    licencia_transito      VARCHAR2(20 CHAR) NOT NULL,
    clase_vehiculo_id      VARCHAR2(20 CHAR) NOT NULL,
    lugar_matricula        VARCHAR2(20 CHAR) NOT NULL,
    tipo_vehiculo_id       VARCHAR2(20 CHAR) NOT NULL,
    nacionalidad           VARCHAR2(20 CHAR) NOT NULL,
    empresa_nit            INTEGER,
    marca                  VARCHAR2(20 CHAR),
    numero_pasajeros       INTEGER,
    no_targeta_operacion   INTEGER
);

ALTER TABLE vehiculo ADD CONSTRAINT vehiculov1_pk PRIMARY KEY ( placa );

ALTER TABLE vehiculo ADD CONSTRAINT vehiculo__un UNIQUE ( licencia_transito );

CREATE TABLE vehiculo_tramite (
    placa                        VARCHAR2(20 CHAR) NOT NULL,
    combustible                  VARCHAR2(20 CHAR),
    clindrada                    VARCHAR2(20 CHAR),
    no_motor                     INTEGER,
    no_chasis                    INTEGER,
    no_serie                     INTEGER,
    no_vin                       INTEGER,
    blindaje_numero_resolucion   INTEGER,
    tipo_carroceria_codigo       INTEGER NOT NULL
);

ALTER TABLE vehiculo_tramite ADD CONSTRAINT vehiculo_comparendo_pk PRIMARY KEY ( placa );

CREATE TABLE vehiculos_afectados (
    id                              INTEGER NOT NULL,
    vehiculo_placa                  VARCHAR2(20 CHAR) NOT NULL,
    inmovilizacion                  VARCHAR2(20 CHAR),
    disposicion                     VARCHAR2(20 CHAR),
    prpietario_mismo_conductor      CHAR(1),
    informe_accidente_transito_id   INTEGER NOT NULL,
    falla_en                        VARCHAR2(20 CHAR),
    lugar_impacto                   VARCHAR2(50 CHAR),
    version                         VARCHAR2(50 CHAR)
);

ALTER TABLE vehiculos_afectados ADD CONSTRAINT vehiculos_afectados_pk PRIMARY KEY ( id );

CREATE TABLE via (
    id         INTEGER NOT NULL,
    tipo_via   VARCHAR2(20 CHAR) NOT NULL,
    nombre     VARCHAR2(20 CHAR) NOT NULL
);

ALTER TABLE via ADD CONSTRAINT tipoavenida_pk PRIMARY KEY ( id );

ALTER TABLE asistencia
    ADD CONSTRAINT a_d_c_fk FOREIGN KEY ( id )
        REFERENCES detalle_comparendo ( id );

ALTER TABLE comparendo
    ADD CONSTRAINT agente FOREIGN KEY ( agente )
        REFERENCES persona ( nip );

ALTER TABLE asistencia
    ADD CONSTRAINT asistencia_curso_fk FOREIGN KEY ( curso_id )
        REFERENCES curso ( id );

ALTER TABLE caracteristica_lugar
    ADD CONSTRAINT c_l_i_a_t_fk FOREIGN KEY ( id )
        REFERENCES informe_accidente_transito ( id );

ALTER TABLE comparendo
    ADD CONSTRAINT c_m_t_fk FOREIGN KEY ( modalidad_transporte_id )
        REFERENCES modalidad_transporte ( id );

ALTER TABLE caracteristica_via
    ADD CONSTRAINT c_v_i_a_t_fk FOREIGN KEY ( id )
        REFERENCES informe_accidente_transito ( id );

ALTER TABLE comparendo
    ADD CONSTRAINT comparendo_grua_fk FOREIGN KEY ( grua_id )
        REFERENCES grua ( numero_grua );

ALTER TABLE comparendo
    ADD CONSTRAINT comparendo_infraccion_fk FOREIGN KEY ( tipo_infraccion )
        REFERENCES tipo_infraccion ( id );

ALTER TABLE comparendo
    ADD CONSTRAINT comparendo_vehiculo_fk FOREIGN KEY ( vehiculo_placa )
        REFERENCES vehiculo ( placa );

ALTER TABLE detalle_comparendo
    ADD CONSTRAINT d_c_c_fk FOREIGN KEY ( id )
        REFERENCES comparendo ( id );

ALTER TABLE examen
    ADD CONSTRAINT examen_perjudicados_fk FOREIGN KEY ( id )
        REFERENCES perjudicados ( id );

ALTER TABLE historial_duenio
    ADD CONSTRAINT historial_duenio_persona_fk FOREIGN KEY ( persona_id )
        REFERENCES persona ( nip );

ALTER TABLE historial_duenio
    ADD CONSTRAINT historial_duenio_vehiculo_fk FOREIGN KEY ( vehiculo_placa )
        REFERENCES vehiculo ( placa );

ALTER TABLE informe_accidente_transito
    ADD CONSTRAINT i_a_t_p_fk FOREIGN KEY ( agente )
        REFERENCES persona ( nip );

ALTER TABLE lugar
    ADD CONSTRAINT l_i_a_t_fk FOREIGN KEY ( id )
        REFERENCES informe_accidente_transito ( id );

ALTER TABLE comparendo
    ADD CONSTRAINT municipio FOREIGN KEY ( municipio_id )
        REFERENCES municipio ( id );

ALTER TABLE pago_comparendo
    ADD CONSTRAINT p_c_d_c_fk FOREIGN KEY ( id )
        REFERENCES detalle_comparendo ( id );

ALTER TABLE perjudicados
    ADD CONSTRAINT p_v_af_fk FOREIGN KEY ( vehiculos_afectados_id )
        REFERENCES vehiculos_afectados ( id );

ALTER TABLE perjudicados
    ADD CONSTRAINT perjudicados_licencia_fk FOREIGN KEY ( licencia_id )
        REFERENCES licencia ( id );

ALTER TABLE perjudicados
    ADD CONSTRAINT perjudicados_persona_fk FOREIGN KEY ( persona_id )
        REFERENCES persona ( nip );

ALTER TABLE comparendo
    ADD CONSTRAINT persona FOREIGN KEY ( cuidadano )
        REFERENCES persona ( nip );

ALTER TABLE persona
    ADD CONSTRAINT persona_municipio_fk FOREIGN KEY ( municipio_id )
        REFERENCES municipio ( id );

ALTER TABLE persona
    ADD CONSTRAINT persona_tipo_documento_fk FOREIGN KEY ( tipo_documento_id )
        REFERENCES tipo_documento ( id );

ALTER TABLE poliza_seguro
    ADD CONSTRAINT poliza_seguro_vehiculo_fk FOREIGN KEY ( vehiculo_placa )
        REFERENCES vehiculo ( placa );

ALTER TABLE requisitos
    ADD CONSTRAINT requisitos_tipo_tramite_fk FOREIGN KEY ( tipo_tramite_id )
        REFERENCES tipo_tramite ( id );

ALTER TABLE testigos
    ADD CONSTRAINT t_i_a_t_fk FOREIGN KEY ( informe_accidente_transito_id )
        REFERENCES informe_accidente_transito ( id );

ALTER TABLE comparendo
    ADD CONSTRAINT testigo FOREIGN KEY ( testigo )
        REFERENCES persona ( nip );

ALTER TABLE testigos
    ADD CONSTRAINT testigos_persona_fk FOREIGN KEY ( persona_id )
        REFERENCES persona ( nip );

ALTER TABLE tramite
    ADD CONSTRAINT tramite_tipo_tramite_fk FOREIGN KEY ( tipo_tramite_id )
        REFERENCES tipo_tramite ( id );

ALTER TABLE tramite
    ADD CONSTRAINT tramite_vehiculo_tramite_fk FOREIGN KEY ( vehiculo_tramite_id )
        REFERENCES vehiculo_tramite ( placa );

ALTER TABLE tramite
    ADD CONSTRAINT traspaso_persona FOREIGN KEY ( persona_id )
        REFERENCES persona ( nip );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_persona_fk FOREIGN KEY ( persona_id )
        REFERENCES persona ( nip );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_validacion_fk FOREIGN KEY ( validacion_id )
        REFERENCES validacion ( id );

ALTER TABLE vehiculos_afectados
    ADD CONSTRAINT v_a_i_a_t_fk FOREIGN KEY ( informe_accidente_transito_id )
        REFERENCES informe_accidente_transito ( id );

ALTER TABLE vehiculos_afectados
    ADD CONSTRAINT v_a_v_fk FOREIGN KEY ( vehiculo_placa )
        REFERENCES vehiculo ( placa );

ALTER TABLE vehiculo_tramite
    ADD CONSTRAINT v_t_b_fk FOREIGN KEY ( blindaje_numero_resolucion )
        REFERENCES blindaje ( numero_resolucion );

ALTER TABLE vehiculo_tramite
    ADD CONSTRAINT v_t_t_c_fk FOREIGN KEY ( tipo_carroceria_codigo )
        REFERENCES tipo_carroceria ( codigo );

ALTER TABLE vehiculo_tramite
    ADD CONSTRAINT v_t_v_fk FOREIGN KEY ( placa )
        REFERENCES vehiculo ( placa );

ALTER TABLE colores
    ADD CONSTRAINT vehiculo FOREIGN KEY ( vehiculo_placa )
        REFERENCES vehiculo ( placa );

ALTER TABLE vehiculo
    ADD CONSTRAINT vehiculo_empresa_fk FOREIGN KEY ( empresa_nit )
        REFERENCES empresa ( nit );

ALTER TABLE comparendo
    ADD CONSTRAINT viaprincipal FOREIGN KEY ( via_principal )
        REFERENCES via ( id );

ALTER TABLE comparendo
    ADD CONSTRAINT viasecundaria FOREIGN KEY ( via_secundaria )
        REFERENCES via ( id );

INSERT INTO "ADMINISTRADOR" (ID, USUARIO, CONTRASENA) VALUES ('1', 'admin', '123');

INSERT INTO "TIPO_DOCUMENTO" (ID, NOMBRE) VALUES ('1', 'Cedula de ciudadania');
INSERT INTO "TIPO_DOCUMENTO" (ID, NOMBRE) VALUES ('2', 'Tarjeta de identidad');
INSERT INTO "TIPO_DOCUMENTO" (ID, NOMBRE) VALUES ('3', 'Cedula de extranjeria');
INSERT INTO "TIPO_DOCUMENTO" (ID, NOMBRE) VALUES ('4', 'Pasaporte');
INSERT INTO "TIPO_DOCUMENTO" (ID, NOMBRE) VALUES ('5', 'Registro civil');

INSERT INTO "VALIDACION" (ID, DESCRIPCION) VALUES ('1', 'A que colegio de bachillerato asisti?');
INSERT INTO "VALIDACION" (ID, DESCRIPCION) VALUES ('2', 'Cual es el nombre de mi primera mascota?');
INSERT INTO "VALIDACION" (ID, DESCRIPCION) VALUES ('3', 'Cual es el nombre del hospital donde naci?');

INSERT INTO "MUNICIPIO" (ID, NOMBRE) VALUES ('1', 'Armenia');
INSERT INTO "MUNICIPIO" (ID, NOMBRE) VALUES ('2', 'Calarca');
INSERT INTO "MUNICIPIO" (ID, NOMBRE) VALUES ('3', 'Buenavista');
INSERT INTO "MUNICIPIO" (ID, NOMBRE) VALUES ('4', 'Circasia');

--SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME='USUARIO';
--SELECT * FROM USER_TABLES;
--SELECT * FROM USER_CONSTRAINTS;