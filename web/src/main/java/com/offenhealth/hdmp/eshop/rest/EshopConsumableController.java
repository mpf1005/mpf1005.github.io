package com.offenhealth.hdmp.eshop.rest;

import com.offenhealth.hdmp.eshop.bean.vo.EshopConsumableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import org.apache.commons.lang3.ArrayUtils;
import com.offenhealth.hdmp.eshop.common.constants.ResultCode;
import com.offenhealth.hdmp.eshop.common.constants.ResultResponse;
import com.offenhealth.hdmp.eshop.common.util.BeanUtils;
import com.offenhealth.hdmp.eshop.common.util.ResultUtil;
import com.offenhealth.hdmp.eshop.bean.entity.EshopConsumable;
import com.offenhealth.hdmp.eshop.business.service.EshopConsumableService;
import springfox.documentation.annotations.ApiIgnore;


/**
 * 
 *耗材
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
@RestController
@RequestMapping("consumables")
@Api( description="耗材管理接口")
public class EshopConsumableController {
	@Autowired
	private EshopConsumableService eshopConsumableService;

    @RequestMapping(value="/list",method = RequestMethod.POST )
    @ApiOperation(value = "分页耗材列表",response = EshopConsumable.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType="int", name = "pageNum", value = "页码，为空时默认1" ),
            @ApiImplicitParam(paramType = "query", dataType="int", name = "pageSize", value = "页数,为空时默认20" ),
            @ApiImplicitParam(paramType = "query", dataType="string", name = "search", value = "搜索字符" )
    })
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse pageList(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "20")Integer pageSize, String search)  {
        return ResultUtil.getSuccess(eshopConsumableService.pageList(pageNum,pageSize,search));
    }


    @RequestMapping(value="/create",method = RequestMethod.POST )
    @ApiOperation(value = "新增耗材",response = ResultResponse.class)
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse save( @RequestBody EshopConsumableVO eshopConsumableVO){
        eshopConsumableService.insertConsumable(eshopConsumableVO);
        return ResultUtil.getSuccess("id",eshopConsumableVO.getId());
    }


    @RequestMapping(value="/edit",method = RequestMethod.POST)
    @ApiOperation(value = "耗材更新",response = ResultResponse.class)
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse update(EshopConsumable vo){
        if ( vo == null) {
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode());
        }
        EshopConsumable po = eshopConsumableService.selectByPrimaryKey(vo.getId());
        if ( po == null) {
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode());
        }
        BeanUtils.copyProperties(vo,po, BeanUtils.getNullPropertyNames(vo));
        //更新
        eshopConsumableService.updateByPrimaryKey(po);
        return ResultUtil.getSuccess();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET )
    @ApiOperation(value = "读取特定耗材",response = EshopConsumable.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType="String", name = "id", value = "id" ),
    })
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse queryConsumablesInfo(String id){
        EshopConsumableVO eshopConsumable = eshopConsumableService.queryConsumablesInfo(id);
        if (eshopConsumable == null ){
            return ResultUtil.getError(ResultCode.DATA_NOT_EXIST.getCode());
        }
        return ResultUtil.getSuccess(eshopConsumable);
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
		eshopConsumableService.deleteBatch(ids);
        return ResultUtil.getSuccess();
    }
    @RequestMapping(value="/{id}/delete",method = RequestMethod.POST)
    @ApiOperation(value = "删除单个耗材",response = ResultResponse.class)

    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse deleteConsumable( @PathVariable String  id){
        if (id==null) {
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode());
        }
        eshopConsumableService.deleteConsumable(id);
        return ResultUtil.getSuccess();
    }

	
}
