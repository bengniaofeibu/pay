package com.example.demo.controller.v1;

import com.example.demo.entity.Result;
import com.example.demo.entity.VersionInfo;
import com.example.demo.utils.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController(value = "versionControllerV1")
@RequestMapping("/v1/version")
@Api("版本API")
public class VersionController {

    @RequestMapping("/")
    public Result get() {
        VersionInfo versionInfo = new VersionInfo();
        versionInfo.setAuthor("林业");
        versionInfo.setVersion("v1.0");
        Calendar c1 = Calendar.getInstance();
        c1.set(2017, Calendar.SEPTEMBER, 16);
        versionInfo.setPublishDate(c1);
        versionInfo.setAuthor("林业");
        versionInfo.setChangelog("新增版本信息字段");
        return ResultUtil.success(versionInfo);
    }
}
