package com.festech.webapi.controller.web;

import com.festech.webapi.base.exception.AppWebException;
import com.festech.webapi.base.result.ResultDO;
import com.festech.webapi.service.IWebSerivce;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "网站控制器", tags = {"web-controller"})
@Validated
public class WebController {

    @Autowired
    private IWebSerivce webSerivce;

    @GetMapping(value = "/v1/infos/search")
    @ApiOperation(value = "查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "标题", required = true, paramType = "query", dataType = "String"),
    })
    public ResultDO searchInfos(
            @RequestParam String title
    ) throws AppWebException {

        return webSerivce.searchInfos(title);
    }

    @GetMapping(value = "/v1/infos_list/search")
    @ApiOperation(value = "查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类别", required = true, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, paramType = "query", dataType = "Integer"),
    })
    public ResultDO searchInfosList(
            @RequestParam int type,
            @RequestParam int pageNum,
            @RequestParam int pageSize
    ) throws AppWebException {

        return webSerivce.searchInfosList(type,pageNum,pageSize);
    }

    @GetMapping(value = "/v1/infos/latest_news")
    @ApiOperation(value = "查询接口")
    public ResultDO queryLatestNews() throws AppWebException {

        return webSerivce.queryLatestNews();
    }

}
