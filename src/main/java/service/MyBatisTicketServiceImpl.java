package service;

import dao.IDao;
import model.Supplier;
import model.Ticket;
import mybatis.SupplierMapper;
import mybatis.TicketMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisTicketServiceImpl implements IDao<Ticket> {

    private SqlSessionFactory sqlSessionFactory;

    public MyBatisTicketServiceImpl() {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ticket getElement (int idTicket) {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            TicketMapper mapper = session.getMapper(TicketMapper.class);

            Ticket ticket = mapper.selectTicketById(idTicket);
            System.out.println(ticket.toString());

            return ticket;
        }
    }

    @Override
    public List<Ticket> getAllElements() {
        List<Ticket> ticketList = new ArrayList<>();

        return ticketList;
    }

    @Override
    public void insertElement(Ticket ticket){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            TicketMapper mapper = session.getMapper(TicketMapper.class);

            mapper.insertTicket(ticket);
            session.commit();
        }
    }

    @Override
    public void updateElement(Ticket ticket){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            TicketMapper mapper = session.getMapper(TicketMapper.class);

            mapper.updateTicket(ticket);
            session.commit();
        }

    }
    @Override
    public void deleteElement(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            TicketMapper mapper = session.getMapper(TicketMapper.class);

            mapper.deleteTicketById(id);
            session.commit();
        }
    }
}
