package lt.vu.alma6475.lab1.mybatis.dao;

import java.util.List;
import lt.vu.alma6475.lab1.mybatis.model.Tutor;
import org.mybatis.cdi.Mapper;

@Mapper
public interface TutorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TUTOR
     *
     * @mbg.generated Fri Apr 29 11:35:03 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TUTOR
     *
     * @mbg.generated Fri Apr 29 11:35:03 EEST 2022
     */
    int insert(Tutor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TUTOR
     *
     * @mbg.generated Fri Apr 29 11:35:03 EEST 2022
     */
    Tutor selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TUTOR
     *
     * @mbg.generated Fri Apr 29 11:35:03 EEST 2022
     */
    List<Tutor> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TUTOR
     *
     * @mbg.generated Fri Apr 29 11:35:03 EEST 2022
     */
    int updateByPrimaryKey(Tutor record);
}