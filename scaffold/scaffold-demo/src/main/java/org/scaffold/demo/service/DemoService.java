package org.scaffold.demo.service;

import org.scaffold.demo.domain.Demo;
import org.scaffold.demo.mapper.DemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author scaffold
 * @Date 2023/8/9 14:20
 * @PackageName:org.scaffold.demo.service
 * @ClassName: DemoService
 * @Description: TODO
 */

@Service
public class DemoService {

    @Resource
    private DemoMapper demoMapper;


    public List<Demo> getDemos() {

        return demoMapper.selectList(null);
    }

    public Long insert(Demo demo) {
        demoMapper.insert(demo);
        return demo.getId();
    }


}
