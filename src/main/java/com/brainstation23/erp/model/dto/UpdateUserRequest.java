package com.brainstation23.erp.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
public class UpdateUserRequest {
	@Schema(description = "User Name", example = "RK")
	private String username;

	@Schema(description = "User Email", example = "user@bs23.com")
	private String email;
	@NotNull
	@Schema(description = "User Role", example = "ROLE_ADMIN")
	private  String role;

	@NotNull
	@Schema(description = "User Password", example = "change123")
	private String password;

}
