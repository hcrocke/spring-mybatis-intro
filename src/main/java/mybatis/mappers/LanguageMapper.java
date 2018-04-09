package mybatis.mappers;

import mybatis.model.User;
import mybatis.model.languages.MultiLanguage;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LanguageMapper {

    String INSERT_INFO = "INSERT INTO `mybatis-test`.`language_info` (`searchTermOne`, `searchTermTwo`, `languageOne`, `languageTwo`, `sameLanguage`) " +
            "VALUES (#{searchTermOne}, #{searchTermTwo}, #{searchLanguageOne}, #{searchLanguageTwo}, #{sameLanguage})";

    String SELECT_INFO = "SELECT * from `mybatis-test`.`language_info` where " +
            "searchTermOne = #{arg0} and searchTermTwo = #{arg1}";

    String UPDATE_INFO = "UPDATE `mybatis-test`.`language_info` SET searchTermOne = #{searchTermOne}, searchTermTwo = #{searchTermTwo}, "
            + "languageOne = #{searchLanguageOne}, languageTwo = #{searchLanguageTwo} WHERE searchTermOne = #{searchTermOne}";

    String GET_BY_ID = "SELECT * FROM `mybatis-test`.`language_info` where id = #{id}";

    String DELETE_ENTRY = "DELETE FROM `mybatis-test`.`language_info` WHERE id = #{id}";




    @Insert(INSERT_INFO)
    public int insertLangInfo(MultiLanguage result);

    @Select(SELECT_INFO)
    public MultiLanguage selectRecord(String searchTermOne, String searchTermTwo);

    @Update(UPDATE_INFO)
    public int updateInfo(MultiLanguage update);

    @Select(GET_BY_ID)
    public User getById(int id);

    @Delete(DELETE_ENTRY)
    public int deleteEntry(int id);

}

