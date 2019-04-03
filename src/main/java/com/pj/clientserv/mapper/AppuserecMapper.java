package com.pj.clientserv.mapper;

import com.pj.clientserv.entity.Appuserec;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ccw
 * @since 2019-03-12
 */
public interface AppuserecMapper extends BaseMapper<Appuserec> {
    @Select("UPDATE appuserec set closetime = CURRENT_TIMESTAMP where id=#{id}")
    public void UpdateAppCloseTime(int id);
}
