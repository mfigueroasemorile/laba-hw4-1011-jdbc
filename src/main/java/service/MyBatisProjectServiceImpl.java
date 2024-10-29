package service;

import dao.IDao;
import model.Project;
import mybatis.ProjectMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisProjectServiceImpl implements IDao<Project> {

    private SqlSessionFactory sqlSessionFactory;

    public MyBatisProjectServiceImpl() {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project getElement (int idProject) {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            ProjectMapper mapper = session.getMapper(ProjectMapper.class);

            Project project = mapper.selectProjectById(idProject);
            System.out.println(project.toString());

            return project;
        }
    }

    @Override
    public List<Project> getAllElements() {
        List<Project> projectList = new ArrayList<>();

        return projectList;
    }

    @Override
    public void insertElement(Project project){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ProjectMapper mapper = session.getMapper(ProjectMapper.class);

            mapper.insertProject(project);
            session.commit();
        }
    }

    @Override
    public void updateElement(Project project){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ProjectMapper mapper = session.getMapper(ProjectMapper.class);

            mapper.updateProject(project);
            session.commit();
        }

    }
    @Override
    public void deleteElement(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ProjectMapper mapper = session.getMapper(ProjectMapper.class);

            mapper.deleteProjectById(id);
            session.commit();
        }
    }
}
