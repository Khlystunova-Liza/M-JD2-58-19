package by.pvt.service;

import by.pvt.dao.SystemUsersMapper;
import by.pvt.dto.SystemUsers;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

class SystemUsersService {

    private static Logger log = Logger.getLogger(SystemUsersService.class.getName());

    private SqlSessionFactory sqlSessionFactory;

    public SystemUsersService() {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("by/pvt/service/mybatis-config.xml")
            );
        } catch (IOException e) {
           log.log(Level.SEVERE,e.getMessage(),e);
        }
    }

    protected void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<SystemUsers> getSystemUsers(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<SystemUsers> systemUsers = sqlSession.getMapper(SystemUsersMapper.class)
                .selectByExample(null);
        sqlSession.commit();
        sqlSession.close();
        return systemUsers;
    }

    public void insert(SystemUsers systemUser){
       SqlSession sqlSession = sqlSessionFactory.openSession();
       int insert = sqlSession.getMapper(SystemUsersMapper.class).insert(systemUser);
       sqlSession.commit();
       sqlSession.close();
       log.info("Added  new systemUser. Result = " + insert);
   }

   public void insert(List<SystemUsers> systemUsers){
        if(systemUsers==null){
            log.info("The input systemUsers is null");
            return;
        }
       SqlSession sqlSession = sqlSessionFactory.openSession();
        if(sqlSession==null){
            log.info("Session is null");
            return;
        }
       SystemUsersMapper dao = sqlSession.getMapper(SystemUsersMapper.class);
       try {
           systemUsers.stream()
                   .filter(Objects::nonNull)
                   .forEach(dao::insert);
       } catch (Exception e) {
           log.log(Level.WARNING,e.getMessage(),e);
           sqlSession.rollback();
       }finally {
           sqlSession.close();
       }
       sqlSession.commit();
       sqlSession.close();
   }

   public void delete(int id){
       SqlSession sqlSession = sqlSessionFactory.openSession();
       int result = sqlSession.getMapper(SystemUsersMapper.class).deleteByPrimaryKey(id);
       log.info("Deleted systemUser with id " + id + " return:" + result);
       sqlSession.commit();
       sqlSession.close();
   }

   public void update(SystemUsers systemUsers){
       SqlSession sqlSession = sqlSessionFactory.openSession();
       int i = sqlSession.getMapper(SystemUsersMapper.class).updateByPrimaryKey(systemUsers);
       log.info("Update systemUser. Result: " + i);
       sqlSession.commit();
       sqlSession.close();
   }
}
