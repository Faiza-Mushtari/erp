package com.brainstation23.erp.controller.rest;


import com.brainstation23.erp.mapper.RoleMapper;
import com.brainstation23.erp.model.dto.CreateRoleRequest;
import com.brainstation23.erp.model.dto.RoleResponse;
import com.brainstation23.erp.model.dto.UpdateRoleRequest;
import com.brainstation23.erp.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.UUID;

@Tag(name = "Role")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/roles")
public class RoleRestController {
	private final RoleService roleService;
	private final RoleMapper roleMapper;

	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Get All Roles")
	@GetMapping
	public ResponseEntity<Page<RoleResponse>> getAll(@ParameterObject Pageable pageable) {
		log.info("Getting List of Roles");
		var domains = roleService.getAll(pageable);
		return ResponseEntity.ok(domains.map(roleMapper::domainToResponse));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Get Single Role")
	@GetMapping("{id}")
	public ResponseEntity<RoleResponse> getOne(@PathVariable UUID id) {
		log.info("Getting Details of Role({})", id);
		var domain = roleService.getOne(id);
		return ResponseEntity.ok(roleMapper.domainToResponse(domain));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Create Single Role")
	@PostMapping
	public ResponseEntity<Void> createOne(@RequestBody @Valid CreateRoleRequest createRequest) {
		log.info("Creating an Role: {} ", createRequest);
		var id = roleService.createOne(createRequest);
		var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Update Single Role")
	@PutMapping("{id}")
	public ResponseEntity<Void> updateOne(@PathVariable UUID id,
			@RequestBody @Valid UpdateRoleRequest updateRequest) {
		log.info("Updating an Role({}): {} ", id, updateRequest);
		roleService.updateOne(id, updateRequest);
		return ResponseEntity.noContent().build();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Delete Single Role")
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteOne(@PathVariable UUID id) {
		log.info("Deleting an Role({}) ", id);
		roleService.deleteOne(id);
		return ResponseEntity.noContent().build();
	}
}
