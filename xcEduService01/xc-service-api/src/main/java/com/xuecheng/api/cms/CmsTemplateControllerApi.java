package com.xuecheng.api.cms;

import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value="cms模板管理接口",description = "cms模板管理接口，提供站点的增、删、改、查")
public interface CmsTemplateControllerApi {
    @ApiOperation("模板集合")
    public QueryResponseResult findList();
}
