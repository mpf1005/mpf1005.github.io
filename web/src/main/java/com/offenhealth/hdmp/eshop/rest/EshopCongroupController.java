package com.offenhealth.hdmp.eshop.rest;

import com.offenhealth.hdmp.eshop.bean.vo.EshopCongroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import org.apache.commons.lang3.ArrayUtils;
import com.offenhealth.hdmp.eshop.common.constants.ResultCode;
import com.offenhealth.hdmp.eshop.common.constants.ResultResponse;
import com.offenhealth.hdmp.eshop.common.util.BeanUtils;
import com.offenhealth.hdmp.eshop.common.util.ResultUtil;
import com.offenhealth.hdmp.eshop.bean.entity.EshopCongroup;
import com.offenhealth.hdmp.eshop.business.service.EshopCongroupService;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.Id;


/**
 * 
 * 耗材分组
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
@RestController
@RequestMapping("consumable-group")
@Api( description="耗材分组管理接口")
public class EshopCongroupController {
	@Autowired
	private EshopCongroupService eshopCongroupService;

    @RequestMapping(value="/list",method = RequestMethod.GET )
    @ApiOperation(value = "耗材分组列表",response = EshopCongroup.class)
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse pageList()  {

        return ResultUtil.getSuccess(eshopCongroupService.getlist());
    }


    @RequestMapping(value="/create",method = RequestMethod.POST )
    @ApiOperation(value = "新建耗材分组",response = ResultResponse.class)
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse save( @RequestBody EshopCongroup eshopCongroup){
       eshopCongroupService.insert(eshopCongroup);
        return  ResultUtil.getSuccess("id",eshopCongroup.getId());
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET )
    @ApiOperation(value = "获取特定耗材分组信息",response = EshopCongroup.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType="String", name = "id", value = "id" ),
    })
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse info(String id ){
        EshopCongroupVO eshopCongroupVO = eshopCongroupService.selectByPrimaryKey(id);
        if (eshopCongroupVO == null ){
            return ResultUtil.getError(ResultCode.DATA_NOT_EXIST.getCode());
        }
        return ResultUtil.getSuccess(eshopCongroupVO);
    }


    @RequestMapping(value="/edit",method = RequestMethod.POST)
    @ApiOperation(value = "编辑耗材分组",response = ResultResponse.class)
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse update(@RequestBody EshopCongroup vo){
        if ( vo == null) {
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode(),ResultCode.PARAM_ERROR.getMsg());
        }
        //更新
	    eshopCongroupService.updateByPrimaryKey(vo);
        return ResultUtil.getSuccess();
    }


    @ApiIgnore
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
		eshopCongroupService.deleteBatch(ids);
        return ResultUtil.getSuccess();
    }
    @RequestMapping(value="/{id}/delete",method = RequestMethod.POST)
    @ApiOperation(value = "删除单个分组",response = ResultResponse.class)
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse deleteBatch( @PathVariable String id){
        if (id==null){
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode(),ResultCode.PARAM_ERROR.getMsg());
        }
        eshopCongroupService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccess();
    }
	
}
