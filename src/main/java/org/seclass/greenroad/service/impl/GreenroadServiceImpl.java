package org.seclass.greenroad.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.seclass.greenroad.dto.Result;
import org.seclass.greenroad.entity.Greenroad;
import org.seclass.greenroad.mapper.GreenroadMapper;
import org.seclass.greenroad.service.IGreenroadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreenroadServiceImpl extends ServiceImpl<GreenroadMapper, Greenroad> implements IGreenroadService {
    // 你的实现代码
    @Autowired
    private GreenroadMapper greenroadMapper;

    @Override
    public Result setGreenroad(Greenroad greenroad) {
        if (greenroadMapper.insert(greenroad)!=0) return Result.ok("插入成功！");
        else return Result.fail("插入失败");
    }
}

