package com.jiangfucheng.im.client.utils;

import com.jiangfucheng.im.client.context.ChatClientContext;
import com.jiangfucheng.im.protobuf.Base;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.
 * Date: 2020/7/30
 * Time: 21:12
 *
 * @author jiangfucheng
 */
public class MessageUtils {
	/**
	 * 是否已经收到该消息的ACK
	 */
	public static boolean isReceivedAckMessage(ChatClientContext context, long messageId) {
		ConcurrentHashMap<Long, Base.Message> unReceiveAckMessages = context.getUnReceiveAckMessages();
		return !unReceiveAckMessages.containsKey(messageId);
	}

	/**
	 * 是否已经收到该消息的RESP
	 */
	public static boolean isCompleteMessage(ChatClientContext context, long messageId) {
		ConcurrentHashMap<Long, Base.Message> unCompletedMessages = context.getUnCompletedMessages();
		return !unCompletedMessages.containsKey(messageId);
	}

}