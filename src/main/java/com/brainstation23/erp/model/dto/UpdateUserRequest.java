package com.brainstation23.erp.model.dto;

import com.brainstation23.erp.persistence.entity.RoleType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UpdateUserRequest {
	@Schema(description = "User Name", example = "RK")
	private String username;

	@Schema(description = "User Email", example = "user@bs23.com")
	private String email;

	@Schema(description = "User Role", example = "Admin")
	private RoleType name;
}
