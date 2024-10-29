package mybatis;

import model.Project;


public interface ProjectMapper {
    Project selectProjectById(int id);
    void insertProject(Project project);
    void updateProject(Project project);
    void deleteProjectById(int id);
}
