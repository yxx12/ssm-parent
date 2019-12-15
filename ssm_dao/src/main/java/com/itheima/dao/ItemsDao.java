package com.itheima.dao;

import com.itheima.domain.Items;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("itemsDao")
public interface ItemsDao {
  //  @Select("select * from items")
    List<Items> queryAll();

   // @Insert("insert into items (name,price,pic,createtime,detail) values (#{name},#{price},#{pic},#{createtime},#{detail})")
    int save(Items items);

    @Select("select * from items where name=#{name}")
    Items findByName(String name);

    @Update("update items set price=#{price} where name =#{name} and id=#{id}")
    void edit(Items items);
}
