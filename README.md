# UtilsSikuli
Projeto que possui métodos utilitários para realizar processos com o Sikuli. Estão encapsulados os métodos mais utilizados no sikuli pela intuitive para serem utilizados como uma lib acessória em qualquer projeto.

A idéia principal é que este projeto sirva como dependência em um servidor que irá expor via REST os métodos do Sikuli para serem usados de dentro da VM do cliente, deixando toda a regra de negócio da operação do lado dos servidores da intuitive e o servidor apenas executará a interação com a tela.

## Sikuli
O sikuli é uma ferramenta de scripts que possibilita a automação da GUI através de comandos simples. Ele possui uma API para o java que utilizamos para fazer a automação de tarefas para alguns clientes.

Atualmente realizamos o processo de Upload de XML, Baixa automática e Entrega nos ERPs MV SOUL e MV 2000.

A versão do sikuli que estamos utilizando nesse projeto é a 1.1.4

## Links úteis:

Documentação do Sikuli: http://doc.sikuli.org/

Fórum de discussão do Sikuli (o criador costuma responder todas as dúvidas que são colocadas lá): https://answers.launchpad.net/sikuli 

Javadoc do projeto: https://intuitivecare.github.io/UtilsSikuli/
