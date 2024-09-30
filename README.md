classDiagram
    class EMPRESA {
        int id
        string nome
        string CNPJ
    }
    class CLIENTE {
        int id
        string nome
        string email
        string senha
        int idEmpresa
    }
    class TICKET {
        int id
        string titulo
        string descricao
        string status
        int idCliente
        int idConsultor
        int idAgendamento
        int idTicketExterno
    }
    class TICKET_EXTERNO {
        int id
        string titulo
        string descricao
        string status
    }
    class CONSULTOR {
        int id
        string nome
        string email
        string senha
        boolean externo
        float custoHora
    }
    class ATENDIMENTO {
        int id
        date data
        time horaInicio
        time horaFim
        string descricao
        string status
        int idTicket
    }
    EMPRESA ||--o{ CLIENTE : "1,N"
    CLIENTE ||--o{ TICKET : "1,N"
    CONSULTOR ||--o{ TICKET : "N,N"
    TICKET ||--|{ TICKET_EXTERNO : "0,1"
    TICKET ||--o{ ATENDIMENTO : "1,N"
