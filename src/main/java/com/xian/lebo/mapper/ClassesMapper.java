package com.xian.lebo.mapper;


import com.xian.lebo.pojo.Classes;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassesMapper {
    @Select("select c.id,c.cname,t.tname from classes c inner join teacher t on c.tid=t.id ")
    List<Classes> getClasses();

    @Select("select c.id,c.cname,t.tname from classes c inner join teacher t on c.tid=t.id where c.cname like '%${cname}%'")
    List<Classes> getClassesCnameLike(String cname);

    @Select("select c.id,c.cname,t.tname from classes c inner join teacher t on c.tid=t.id where t.tname like '%${tname}%'")
    List<Classes> getClassesTnameLike(String tname);

    @Insert("insert into classes (`cname`,`tid`)values(#{cname},#{tid}) ")
    int addClasses(Classes classes);

    @Delete("delete from classes where id= #{id}")
    int deleteClasses(int id);

    @Select("SELECT c.id,c.cname,t.tname,c.tid FROM classes c INNER JOIN teacher t ON c.tid=t.id WHERE c.`id`=#{id}")
    Classes getClassesById(int id);

    @Update("update classes set cname=#{cname},tid=#{tid} where id =#{id}")
    int updateClassesById(Classes classes);

    @Select("select c.id,c.cname from classes c inner join teacher t on c.tid=t.id ")
    List<Classes> getAllClasses();
}
