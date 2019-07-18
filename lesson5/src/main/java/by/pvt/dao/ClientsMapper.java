package by.pvt.dao;

import by.pvt.dto.Clients;
import by.pvt.dto.ClientsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClientsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clients
     *
     * @mbg.generated Thu Jul 18 15:07:45 MSK 2019
     */
    long countByExample(ClientsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clients
     *
     * @mbg.generated Thu Jul 18 15:07:45 MSK 2019
     */
    int deleteByExample(ClientsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clients
     *
     * @mbg.generated Thu Jul 18 15:07:45 MSK 2019
     */
    int insert(Clients record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clients
     *
     * @mbg.generated Thu Jul 18 15:07:45 MSK 2019
     */
    int insertSelective(Clients record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clients
     *
     * @mbg.generated Thu Jul 18 15:07:45 MSK 2019
     */
    List<Clients> selectByExample(ClientsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clients
     *
     * @mbg.generated Thu Jul 18 15:07:45 MSK 2019
     */
    int updateByExampleSelective(@Param("record") Clients record, @Param("example") ClientsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clients
     *
     * @mbg.generated Thu Jul 18 15:07:45 MSK 2019
     */
    int updateByExample(@Param("record") Clients record, @Param("example") ClientsExample example);
}