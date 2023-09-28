
CREATE TABLE tb_tarefa.tarefas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    sobre VARCHAR(300) NOT NULL,
    prioridade INT,
    data DATE,
    concluida BOOLEAN
);
