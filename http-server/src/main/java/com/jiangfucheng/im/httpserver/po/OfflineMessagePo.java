package com.jiangfucheng.im.httpserver.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Date: 2020/5/13
 * Time: 22:01
 *
 * @author jiangfucheng
 */
@Data
@TableName("im_offline_msg")
public class OfflineMessagePo {
	private Long id;
	private Long fromId;
	private Long toId;
	private Integer msgType;
	private String content;
	private Date createTime;
}