# 🛒 Sistema de Cadastro e Pedido de Produtos

Aplicação de console desenvolvida em **Java**, com foco em práticas sólidas de **programação orientada a objetos (POO)**.

---

## 📌 Funcionalidades

- Cadastro de **clientes** com nome, email e data de nascimento
- Criação de **pedidos** com status (enum: `PENDING_PAYMENT`, `PROCESSING`, `SHIPPED`, `DELIVERED`)
- Inclusão de **itens ao pedido**, podendo ser:
  - Produto comum
  - Produto usado (com data de fabricação)
  - Produto importado (com taxa de alfândega)
- Geração de **resumo do pedido**, incluindo data/hora, cliente, itens e valor total
- **Tratamento de exceções personalizadas** (`DomainException`, `ParseException`, etc.)

---

## 💻 Tecnologias utilizadas

- Java (JDK 17+ recomendado)
- Paradigma: Programação Orientada a Objetos
- Manipulação de datas com `SimpleDateFormat`
- Pacotes organizados por responsabilidade: `Application`, `Entities`, `Enums`, `Exceptions`

---

## 🧠 Conceitos aplicados

- Classes e objetos
- Herança e polimorfismo
- Enumerações
- Encapsulamento
- Manipulação de listas (`ArrayList`)
- Tratamento de erros e exceções customizadas
- Responsabilidade única (SRP) e boa estrutura de código

---

## 🚀 Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
Importe o projeto no Eclipse como Java Project

Execute a classe Main no pacote Application

Siga as instruções no console

## 📷 Exemplo de execução
```
Enter cliente data: 
Name: João Silva
Email: joao@email.com
Birth date (dd/MM/yyyy): 22/05/1990

Enter order data: 
Status: PROCESSING
How many items to this order? 2

Enter #1 item data: 
Type of product (C/U/I): C
Product name: Monitor
Product price: 900.00
Quantity: 1

Enter #2 item data: 
Type of product (C/U/I): I
Product name: Teclado
Product price: 200.00
Customs Fee: 50.00
Quantity: 1

ORDER SUMMARY:
...
```

## 🧑‍💻 Autor
Desenvolvido por Wallace Maia🧠
💬 https://www.linkedin.com/in/wallace-maia-9634a8312/
