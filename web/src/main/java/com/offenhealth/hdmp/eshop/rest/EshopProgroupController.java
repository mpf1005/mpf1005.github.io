package com.offenhealth.hdmp.eshop.rest;

import com.offenhealth.hdmp.eshop.bean.entity.EshopProgroup;
import com.offenhealth.hdmp.eshop.bean.vo.EshopProgroupVO;
import com.offenhealth.hdmp.eshop.bean.vo.EshopProgroupCountVO;
import com.offenhealth.hdmp.eshop.business.service.EshopProgroupService;
import com.offenhealth.hdmp.eshop.common.constants.ResultCode;
import com.offenhealth.hdmp.eshop.common.constants.ResultResponse;
import com.offenhealth.hdmp.eshop.common.util.ResultUtil;
import io.swagger.annotations.*;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * 
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
@RestController
@RequestMapping("project-group")
@Api( description="项目分组管理")
public class EshopProgroupController {
    /*
     *注入eshopProgroupService接口
     */
	@Autowired
	private EshopProgroupService eshopProgroupService;
    /**
     *
     *
     * @author 王杰
     * @date 2017-08-21 13:14:44
     */
    @RequestMapping(value="/list",method = RequestMethod.GET)
    @ApiOperation(value = "读取项目分组的列表",response = EshopProgroup.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType="int", name = "pageNum", value = "页码，为空时默认1" ),
            @ApiImplicitParam(paramType = "query", dataType="int", name = "pageSize", value = "页数,为空时默认20" ),
            @ApiImplicitParam(paramType = "query", dataType="string", name = "search", value = "搜索字符" )
    })
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse pageList(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "20")Integer pageSize, String search)  {
        EshopProgroupCountVO eshopProjectVO = eshopProgroupService.pageList(pageNum, pageSize, search);
        return ResultUtil.getSuccess(eshopProjectVO);
    }

    /**
     *
     * 读取特定项目分组
     * @author 王杰
     * @date 2017-08-21 15:56:23
     */
    @RequestMapping(value="/{id}",method = RequestMethod.GET )
    @ApiOperation(value = "读取特定项目分组",response = EshopProgroup.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType="String", name = "id", value = "id" ),
    })
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse info(String id){
        EshopProgroupVO eshopProgroupVO = eshopProgroupService.selectGroupByPrimaryKey(id);
        if (eshopProgroupVO == null ){
            return ResultUtil.getError(ResultCode.DATA_NOT_EXIST.getCode());
        }
        return ResultUtil.getSuccess(eshopProgroupVO);
    }

    /**
     *
     * 新建项目分组
     * @author 王杰
     * @date 2017-08-21 14:41:16
     */
    @RequestMapping(value="/create",method = RequestMethod.POST )
    @ApiOperation(value = "新建项目分组",response = ResultResponse.class)
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse save(@RequestBody EshopProgroup eshopProgroup){
        eshopProgroupService.insert(eshopProgroup);
        return ResultUtil.getSuccess("id",eshopProgroup.getId());
    }

    /**
     *
     * 编辑项目分组
     * @author 王杰
     * @date 2017-08-21 14:41:16
     */
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ApiOperation(value = "编辑项目分组",response = ResultResponse.class)
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse update(@RequestBody EshopProgroup eshopProgroup){
        if ( eshopProgroup == null) {
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode());
        }
        //编辑项目分组
	    eshopProgroupService.updateByPrimaryKey(eshopProgroup);
        return ResultUtil.getSuccess();
    }
    /**
     *
     * 删除项目的分组
     * @author 王杰
     * @date 2017-08-21 18:41:16
     */
    @RequestMapping(value="/{id}/delete",method = RequestMethod.POST)
    @ApiOperation(value = "删除项目的分组",response = ResultResponse.class)
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse deleteBatch(@PathVariable String id){
        if (id==null) {
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode());
        }
        eshopProgroupService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccess();
    }

    @RequestMapping(value="/deleteBatch",method = RequestMethod.POST)
    @ApiOperation(value = "批量删除",response = ResultResponse.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType="array", name = "ids", value = "id数组" ),
    })
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse deleteBatch(String [] ids){
        if (ArrayUtils.isEmpty(ids)) {
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode());
        }
		eshopProgroupService.deleteBatch(ids);
        return ResultUtil.getSuccess();
    }

	
}
