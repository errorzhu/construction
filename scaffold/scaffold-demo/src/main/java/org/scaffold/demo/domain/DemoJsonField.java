package org.scaffold.demo.domain;

/**
 * @Author scaffold
 * @Date 2023/8/9 14:19
 * @PackageName:org.scaffold.demo.domain
 * @ClassName: DemoJsonField
 * @Description: TODO
 */
public class DemoJsonField {


    private String name;
    private String value;


    public DemoJsonField() {
    }


    public DemoJsonField(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
