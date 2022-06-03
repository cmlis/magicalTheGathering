
INSERT INTO JOGADOR (nome) VALUES ('Camila');
INSERT INTO JOGADOR (nome) VALUES ('Maria');


INSERT INTO BARALHO (nome, jogador_id) VALUES ('Os ++',1);
INSERT INTO BARALHO (nome, jogador_id) VALUES ('Os queridinhos',2);




INSERT INTO CARTA(nome,edicao, idioma,is_foil,preco,qtd_carta_msm_caract) VALUES ('Abrade','F2020','PORTUGUES',1 ,50.55,1);
INSERT INTO CARTA(nome,edicao, idioma,is_foil,preco,qtd_carta_msm_caract) VALUES ('Acorn Catapult','F2020','PORTUGUES',1,20.00,2);
INSERT INTO CARTA(nome,edicao, idioma,is_foil,preco,qtd_carta_msm_caract) VALUES ('Calming Licid','F2021','ENGLISH',0,30,3);
INSERT INTO CARTA(nome,edicao, idioma,is_foil,preco,qtd_carta_msm_caract) VALUES ('Chromanticore','F2022','JAPANESE',0 ,14.20,0);
INSERT INTO CARTA(nome,edicao, idioma,is_foil,preco,qtd_carta_msm_caract) VALUES ('Chromanticore','F2020','ENGLISH',0,20.20,1);

INSERT INTO baralho_cartas (cartas_id,baralho_id) VALUES (1,1);
INSERT INTO baralho_cartas (cartas_id,baralho_id) VALUES (2,1);
INSERT INTO baralho_cartas (cartas_id,baralho_id) VALUES (4,1);
INSERT INTO baralho_cartas (cartas_id,baralho_id) VALUES (3,2);
INSERT INTO baralho_cartas (cartas_id,baralho_id) VALUES (5,2);
