package com.jiangfucheng.im.httpserver.controller;

import com.jiangfucheng.im.common.resp.Response;
import com.jiangfucheng.im.common.util.ParamValidator;
import com.jiangfucheng.im.httpserver.bo.UserBo;
import com.jiangfucheng.im.httpserver.bo.UserTokenPayloadBo;
import com.jiangfucheng.im.httpserver.service.UserService;
import com.jiangfucheng.im.httpserver.vo.PasswordVo;
import com.jiangfucheng.im.httpserver.vo.UserVo;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * Date: 2020/5/13
 * Time: 22:31
 *
 * @author jiangfucheng
 */
@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/user/{id}")
	public Response queryUserDetail(@PathVariable("id") Long id) {
		ParamValidator.notNull(id, "id不能为空");
		UserBo userbo = userService.getUserById(id);
		return Response.ok(userbo.convertToUserVo());
	}

	@PostMapping("/user")
	public Response register(@RequestBody UserVo userVo) {
		Long userId = userService.createUser(userVo.convertToUserBo());
		return Response.ok(userId);
	}

	@PutMapping("/user")
	public Response updateUserDetail(UserTokenPayloadBo userTokenPayload,
									 @RequestBody UserVo userVo) {
		userVo.setId(userTokenPayload.getUserId());
		userVo.setAccount(userTokenPayload.getAccount());
		UserBo userBo = userService.updateUser(userVo.convertToUserBo());
		userBo.setPassword("");
		return Response.ok(userBo.convertToUserVo());
	}

	@PutMapping("/user/password")
	public Response changePassword(UserTokenPayloadBo userTokenPayloadBo,
								   @RequestBody PasswordVo passwordVo) {
		userService.updatePassword(passwordVo.convertToUserPasswordBo(userTokenPayloadBo.getUserId()));
		return Response.ok();
	}

}
