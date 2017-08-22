package com.offenhealth.hdmp.eshop.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;
import org.apache.commons.lang3.ArrayUtils;
import com.offenhealth.hdmp.eshop.common.constants.ResultCode;
import com.offenhealth.hdmp.eshop.common.constants.ResultResponse;
import com.offenhealth.hdmp.eshop.common.util.BeanUtils;
import com.offenhealth.hdmp.eshop.common.util.ResultUtil;
import com.offenhealth.hdmp.eshop.bean.entity.EshopGoodsShelf;
import com.offenhealth.hdmp.eshop.business.service.EshopGoodsShelfService;
import springfox.documentation.annotations.ApiIgnore;


/**
 * 
 * 货架
 * @author hhy
 * @date 2017-08-21 15:36:33
 */

@RestController
@RequestMapping("eshopgoodsshelf")
@Api( description="接口")
public class EshopGoodsShelfController {
	@Autowired
	private EshopGoodsShelfService eshopGoodsShelfService;

    @RequestMapping(value="/list",method = RequestMethod.POST )
    @ApiOperation(value = "分页列表",response = EshopGoodsShelf.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType="int", name = "pageNum", value = "页码，为空时默认1" ),
            @ApiImplicitParam(paramType = "query", dataType="int", name = "pageSize", value = "页数,为空时默认20" ),
            @ApiImplicitParam(paramType = "query", dataType="string", name = "search", value = "搜索字符" )
    })
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse pageList(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "20")Integer pageSize, String search)  {
        return ResultUtil.getSuccess(eshopGoodsShelfService.pageList(pageNum,pageSize,search));
    }


    @RequestMapping(value="/save",method = RequestMethod.POST )
    @ApiOperation(value = "保存",response = ResultResponse.class)
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse save(EshopGoodsShelf eshopGoodsShelf){
		eshopGoodsShelfService.insert(eshopGoodsShelf);
        return ResultUtil.getSuccess();
    }

    @RequestMapping(value="/info",method = RequestMethod.GET )
    @ApiOperation(value = "获取信息",response = EshopGoodsShelf.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType="String", name = "id", value = "id" ),
    })
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse info(String id ){
		EshopGoodsShelf eshopGoodsShelf = eshopGoodsShelfService.selectByPrimaryKey(id);
        if (eshopGoodsShelf == null ){
            return ResultUtil.getError(ResultCode.DATA_NOT_EXIST.getCode());
        }
        return ResultUtil.getSuccess(eshopGoodsShelf);
    }


    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ApiOperation(value = "更新",response = ResultResponse.class)
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse update(EshopGoodsShelf vo){
        if ( vo == null) {
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode());
        }
		EshopGoodsShelf po = eshopGoodsShelfService.selectByPrimaryKey(vo.getId());
        if ( po == null) {
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode());
        }
        BeanUtils.copyProperties(vo,po, BeanUtils.getNullPropertyNames(vo));
        //更新
	    eshopGoodsShelfService.updateByPrimaryKey(po);
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
		eshopGoodsShelfService.deleteBatch(ids);
        return ResultUtil.getSuccess();
    }

	
}
