package mybatis;


import model.Ticket;

public interface TicketMapper {
    Ticket selectTicketById(int id);
    void insertTicket(Ticket ticket);
    void updateTicket(Ticket ticket);
    void deleteTicketById(int id);
}
