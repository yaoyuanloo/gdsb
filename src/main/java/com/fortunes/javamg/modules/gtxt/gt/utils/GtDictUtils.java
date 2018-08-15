/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.fortunes.javamg.common.utils.CacheUtils;
import com.fortunes.javamg.common.utils.SpringContextHolder;
import com.fortunes.javamg.modules.gtxt.gt.dao.GtDictDao;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtDict;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 字典工具类
 * 
 * @version 2013-5-29
 */
public class GtDictUtils {
	
	private static GtDictDao gtDictDao = SpringContextHolder.getBean(GtDictDao.class);

	public static final String CACHE_GTDICT_MAP = "gtDictMap";
	
	public static String getGtDictLabel(String value, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)){
			for (GtDict dict : getGtDictList(type)){
				if (type.equals(dict.getType()) && value.equals(dict.getValue())){
					return dict.getLabel();
				}
			}
		}
		return defaultValue;
	}
	
	public static String getGtDictLabels(String values, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)){
			List<String> valueList = Lists.newArrayList();
			for (String value : StringUtils.split(values, ",")){
				valueList.add(getGtDictLabel(value, type, defaultValue));
			}
			return StringUtils.join(valueList, ",");
		}
		return defaultValue;
	}

	public static String getGtDictValue(String label, String type, String defaultLabel){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)){
			for (GtDict dict : getGtDictList(type)){
				if (type.equals(dict.getType()) && label.equals(dict.getLabel())){
					return dict.getValue();
				}
			}
		}
		return defaultLabel;
	}
	
	public static List<GtDict> getGtDictList(String type){
		@SuppressWarnings("unchecked")
		Map<String, List<GtDict>> gtDictMap = (Map<String, List<GtDict>>)CacheUtils.get(CACHE_GTDICT_MAP);
		if (gtDictMap==null){
			gtDictMap = Maps.newHashMap();
			for (GtDict gtDict : gtDictDao.findAllList(new GtDict())){
				List<GtDict> dictList = gtDictMap.get(gtDict.getType());
				if (dictList != null){
					dictList.add(gtDict);
				}else{
					gtDictMap.put(gtDict.getType(), Lists.newArrayList(gtDict));
				}
			}
			CacheUtils.put(CACHE_GTDICT_MAP, gtDictMap);
		}
		List<GtDict> dictList = gtDictMap.get(type);
		if (dictList == null){
			dictList = Lists.newArrayList();
		}
		return dictList;
	}
	
}
