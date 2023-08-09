package org.scaffold.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.scaffold.demo.domain.Demo;

/**
 * @Author scaffold
 * @Date 2023/8/9 14:19
 * @PackageName:org.scaffold.demo.mapper
 * @ClassName: DemoMapper
 * @Description: TODO
 */
@Mapper
public interface DemoMapper extends BaseMapper<Demo> {

}
