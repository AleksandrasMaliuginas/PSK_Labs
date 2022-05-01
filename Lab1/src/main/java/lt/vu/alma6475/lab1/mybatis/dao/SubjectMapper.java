package lt.vu.alma6475.lab1.mybatis.dao;

import java.util.List;
import lt.vu.alma6475.lab1.mybatis.model.Subject;
import org.mybatis.cdi.Mapper;

@Mapper
public interface SubjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SUBJECT
     *
     * @mbg.generated Fri Apr 29 11:35:03 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SUBJECT
     *
     * @mbg.generated Fri Apr 29 11:35:03 EEST 2022
     */
    int insert(Subject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SUBJECT
     *
     * @mbg.generated Fri Apr 29 11:35:03 EEST 2022
     */
    Subject selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SUBJECT
     *
     * @mbg.generated Fri Apr 29 11:35:03 EEST 2022
     */
    List<Subject> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SUBJECT
     *
     * @mbg.generated Fri Apr 29 11:35:03 EEST 2022
     */
    int updateByPrimaryKey(Subject record);
}