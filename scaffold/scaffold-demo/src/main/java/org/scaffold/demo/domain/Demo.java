package org.scaffold.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;

/**
 * @Author scaffold
 * @Date 2023/8/9 14:16
 * @PackageName:org.scaffold.demo.domain
 * @ClassName: Demo
 * @Description: TODO
 */

@TableName(autoResultMap = true)
public class Demo {

    @TableId(type = IdType.AUTO)
    private Long id ;

    private String name;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private DemoJsonField attrs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DemoJsonField getAttr() {
        return attrs;
    }

    public void setAttr(DemoJsonField attr) {
        this.attrs = attr;
    }
}
