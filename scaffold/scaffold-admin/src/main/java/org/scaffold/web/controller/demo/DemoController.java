package org.scaffold.web.controller.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.scaffold.common.annotation.Anonymous;
import org.scaffold.common.core.controller.BaseController;
import org.scaffold.common.core.domain.AjaxResult;
import org.scaffold.demo.domain.Demo;
import org.scaffold.demo.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author scaffold
 * @Date 2023/8/9 10:04
 * @PackageName:org.scaffold.web.controller.demo
 * @ClassName: TestController
 * @Description: TODO
 */

@Anonymous
@Api("demo测试")
@RestController
public class DemoController extends BaseController {

    @Resource
    private DemoService demoService;


    @ApiOperation("hello")
    @GetMapping("hello")
    public AjaxResult hello() {
        return AjaxResult.success("hello");
    }

    @ApiOperation("获取demo")
    @GetMapping("demo")
    public AjaxResult getDemos() {
        return AjaxResult.success(demoService.getDemos());
    }

    @ApiOperation("插入demo")
    @PostMapping("demo")
    public AjaxResult addDemo(@RequestBody Demo demo) {
        return AjaxResult.success(demoService.insert(demo));
    }


}
