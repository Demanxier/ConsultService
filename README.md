Este projeto foi idealizado para gerenciamento de atendimentos e tarefas, do meu dia a dia, onde controlo os tickets da empresa que trabalho e tarefas. 
O sistema permite:

- Cadastrar e gerenciar **atendimentos**, associando-os a consultores, tarefas e tickets externos.
- Organizar **tarefas** com status e anotações (cards), associadas a clientes e permitindo atualizações ao longo do tempo.
- **Clientes** são vinculados a **empresas** e podem gerar tickets externos que serão acompanhados por consultores.
- Consultores podem ser cadastrados e atribuídos a atendimentos.
- **Tickets externos** são registrados, podendo passar por um ciclo de abertura e fechamento, com atendimentos vinculados.

A aplicação facilita o acompanhamento e a gestão de interações entre clientes(Solicitantes) e consultores(Sendo eu sem custo ou externo, com custo), controlando tarefas e atendimentos de forma estruturada.

```mermaid
classDiagram
    class Atendimento {
        Long id
        String titulo
        LocalDate data
        LocalTime horaInicio
        LocalTime horaFim
        String descricao
        StatusAtendimento status
        Tarefa tarefa
        Consultor consultor
        TicketExterno ticketExterno
    }

    class CardTarefa {
        Long id
        String conteudo
        LocalDateTime criadoEm
        LocalDateTime atualzadoEm
        Tarefa tarefa
    }

    class Cliente {
        Long id
        String nome
        String email
        String senha
        Empresa empresa
        List~Tarefa~ tarefas
        List~TicketExterno~ ticketExternos
    }

    class Consultor {
        Long id
        String nome
        String email
        String senha
        boolean externo
        Double custoHora
        List~Atendimento~ atendimentos
    }

    class Empresa {
        Long id
        String nome
        String cnpj
        List~Cliente~ clientes
    }

    class Tarefa {
        Long id
        String titulo
        String descricao
        StatusTarefa status
        LocalDate vencimento
        LocalDateTime dataConcluido
        Cliente cliente
        List~CardTarefa~ cards
        List~Atendimento~ atendimento
    }

    class TicketExterno {
        Long id
        String titulo
        String descricao
        LocalDate dataAbertura
        LocalDate dataFechamento
        StatusTicket status
        Cliente cliente
        List~Atendimento~ atendimentos
    }

    Atendimento --> Tarefa : ManyToOne
    Atendimento --> Consultor : ManyToOne
    Atendimento --> TicketExterno : ManyToOne
    CardTarefa --> Tarefa : ManyToOne
    Cliente --> Empresa : ManyToOne
    Cliente --> Tarefa : OneToMany
    Cliente --> TicketExterno : OneToMany
    Consultor --> Atendimento : OneToMany
    Empresa --> Cliente : OneToMany
    Tarefa --> Cliente : ManyToOne
    Tarefa --> CardTarefa : OneToMany
    Tarefa --> Atendimento : OneToMany
    TicketExterno --> Cliente : ManyToOne
    TicketExterno --> Atendimento : OneToMany
```
