CREATE TABLE lancamento (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(200) NOT NULL,
	tipo_pagamento VARCHAR(50) NOT NULL,
	valor DECIMAL(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lancamento (descricao, tipo_pagamento, valor) VALUES ('Gasolina', 'CARTAO DE CREDITO', 30.00);
INSERT INTO lancamento (descricao, tipo_pagamento, valor) VALUES ('Pão de queijo', 'CARTAO DE CREDITO', 5.00);
INSERT INTO lancamento (descricao, tipo_pagamento, valor) VALUES ('Celular', 'DINHEIRO', 150.00);
