package com.brainstation23.erp.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@ToString
@Getter
@Setter
public class UserResponse {
	@Schema(description = "User ID", example = "3F41A301-25ED-4F0F-876F-7657BEABB00U")
	private UUID id;

	@Schema(description = "User Name", example = "RK")
	private String username;

	@Schema(description = "User Email", example = "user@bs23.com")
	private String email;

	@NotNull
	@Schema(description = "User Role", example = "ROLE_ADMIN")
	private  String role;

	@NotNull
	@Schema(description = "User Password", example = "password123")
	private String password;
}
