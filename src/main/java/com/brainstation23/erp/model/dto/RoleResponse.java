package com.brainstation23.erp.model.dto;

import com.brainstation23.erp.persistence.entity.RoleType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
@Setter
public class RoleResponse {
	@Schema(description = "Role ID", example = "3F41A301-25ED-4F0F-876F-7657BEABB00R")
	private UUID id;

	@Schema(description = "Role Name", example = "Admin")
	private RoleType name;
}
