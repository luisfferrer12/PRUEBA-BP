CREATE TABLE T01_SOLICITUD
( ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  ESTADO INT NOT NULL,
  FECHA_INGRESO DATE,
  MONTO DECIMAL,
  ID_CLIENTE VARCHAR(45) 
);

INSERT INTO T01_SOLICITUD (ESTADO, FECHA_INGRESO, MONTO, ID_CLIENTE)
VALUES ('1', '2022-02-25', '5000', 'cliente 01');

DELETE FROM `t01_solicitud`.`t01_solicitud`
WHERE ID=6;


select * from t01_solicitud