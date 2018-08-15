package com.fortunes.gtxt.dubbo;


/**
 * 业务系统码表接口
 * Created by cxd on 2016/10/18.
 */
public interface BusiDictService {

    /**
     * 获取业务系统所有码表
     * @return
     */
    public GtxtListResult<BusiDict> getAllDicts();

    /**
     * 根据码表类型获取某一类码表
     * @param type 码表类型
     * @return
     */
    public GtxtListResult<BusiDict> getDictsByType(String type);

    /**
     * 根据码表类型与码表值获取码表名称
     * @param type 码表类型
     * @param value 码表值
     * @return
     */
    public GtxtListResult<BusiDict> getDictLabel(String type, String value);

}
