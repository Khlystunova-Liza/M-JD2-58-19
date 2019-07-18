package by.pvt.service;

import by.pvt.dao.SystemUsersMapper;
import by.pvt.dto.SystemUsers;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class SystemUsersService {

    private static Logger log = Logger.getLogger(SystemUsersService.class.getName());

    private SqlSessionFactory sqlSessionFactory;

    SystemUsersService() {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("by/pvt/service/mybatis-config.xml")
            );
        } catch (IOException e) {
           log.log(Level.SEVERE,e.getMessage(),e);
        }
    }

    List<SystemUsers> getSystemUsers(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<SystemUsers> systemUsers = sqlSession.getMapper(SystemUsersMapper.class)
                .selectByExample(null);
        sqlSession.commit();
        sqlSession.close();
        return systemUsers;
    }

    void insert(SystemUsers systemUser){
       SqlSession sqlSession = sqlSessionFactory.openSession();
       int insert = sqlSession.getMapper(SystemUsersMapper.class).insert(systemUser);
       sqlSession.commit();
       sqlSession.close();
       log.info("Added  new systemUser. Result = " + insert);
   }

   void delete(int id){
       SqlSession sqlSession = sqlSessionFactory.openSession();
       int result = sqlSession.getMapper(SystemUsersMapper.class).deleteByPrimaryKey(id);
       log.info("Deleted systemUser with id " + id + " return:" + result);
       sqlSession.commit();
       sqlSession.close();
   }

   void update(SystemUsers systemUsers){
       SqlSession sqlSession = sqlSessionFactory.openSession();
       int i = sqlSession.getMapper(SystemUsersMapper.class).updateByPrimaryKey(systemUsers);
       log.info("Update systemUser. Result: " + i);
       sqlSession.commit();
       sqlSession.close();
   }
}
