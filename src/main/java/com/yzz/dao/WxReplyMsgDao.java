package com.yzz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yzz.dto.Page;
import com.yzz.entity.WxReplyMsg;

/** 
* 
* @description: 实体类WxReplyMsg的DAO接口 
* 
* @author 杨志钊 
* @date 2017-06-01 09:44:41 
*/ 
@Repository
public interface WxReplyMsgDao {

	/**单个实体全部字段添加*/
	int insert(WxReplyMsg entity);

	/**根据实体ID单个实体删除*/
	int deleteByPrimaryKey(String wxReplyMsgId);

	/**根据实体ID数组批量删除实体*/
	int deleteBatch(List<String> wxReplyMsgIds);

	/**单个实体全部字段更新*/
	int updateByPrimaryKey(WxReplyMsg entity);

	/**单个实体选择性字段更新*/
	int updateByPrimaryKeySelective(WxReplyMsg entity);

	/**根据实体ID查询单个实体*/
	WxReplyMsg selectByPrimaryKey(String wxReplyMsgId);

	/**根据选择性实体字段分页查询实体数组*/
	List<WxReplyMsg> selectByEntityAndPage(@Param("entity") WxReplyMsg entity, @Param("page") Page page);

	/**根据选择性实体字段查询实体数量*/
	int countByEntity(@Param("entity") WxReplyMsg entity);

}
