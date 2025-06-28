package org.seclass.greenroad.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.seclass.greenroad.entity.Greenroad;

@Mapper
public interface GreenroadMapper extends BaseMapper<Greenroad>{
    // 自定义方法，插入绿色通道信息
    @Insert("INSERT INTO greenroad " +
            "(college_id, req_strat, req_end, upload_ddl, year, fund, state1, state2,state3, max, batch) " +
            "VALUES (#{collegeId}, #{reqStrat}, #{reqEnd}, #{uploadDdl}, #{year}, #{fund}, #{state1}, #{state2},#{state3}, #{max}, #{batch})")

    int insert(Greenroad greenroad);
}
