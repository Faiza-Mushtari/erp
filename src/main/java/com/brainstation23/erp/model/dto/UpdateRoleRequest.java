package com.brainstation23.erp.model.dto;

import com.brainstation23.erp.persistence.entity.RoleType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UpdateRoleRequest {
	@Schema(description = "Role Name", example = "Admin")
	private RoleType name;
}
