CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users
(
    id         UUID PRIMARY KEY      DEFAULT uuid_generate_v4(),
    username   VARCHAR(100) NOT NULL,
    prettyname VARCHAR(100),
    vacation   BOOLEAN               DEFAULT false,
    dayoff     BOOLEAN               DEFAULT false,
    starttime  INTEGER      NOT NULL DEFAULT 12,
    endtime    INTEGER      NOT NULL DEFAULT 21,
    role       VARCHAR(10)  NOT NULL DEFAULT 'user'
);

CREATE TABLE sessions
(
    id         UUID PRIMARY KEY      DEFAULT uuid_generate_v4(),
    username   VARCHAR(100) NOT NULL,
    date       DATE         NOT NULL DEFAULT CURRENT_DATE,
    workstart  TIMESTAMP,
    workend    TIMESTAMP,
    worktime   INTERVAL GENERATED ALWAYS AS ( workend - workstart ) STORED,
    overtime   INTERVAL GENERATED ALWAYS AS ( workend - workstart - INTERVAL '540 MINUTES') STORED,
    lunchstart TIMESTAMP,
    lunchend   TIMESTAMP,
    lunchtime  INTERVAL GENERATED ALWAYS AS ( lunchend - lunchstart ) STORED,
    awaystart  TIMESTAMP,
    awayend    TIMESTAMP,
    awaytime   INTERVAL GENERATED ALWAYS AS ( awayend - awaystart ) STORED,
    reason     VARCHAR(255),
    midnight   BOOLEAN               DEFAULT false,
    anomaly    BOOLEAN               DEFAULT false,
    closed     BOOLEAN               DEFAULT false,
    valid      BOOLEAN               DEFAULT false
);