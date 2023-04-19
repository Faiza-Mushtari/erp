package com.brainstation23.erp.mapper;

import com.brainstation23.erp.model.domain.Role;
import com.brainstation23.erp.model.dto.RoleResponse;
import com.brainstation23.erp.persistence.entity.RoleEntity;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role entityToDomain(RoleEntity entity);

    RoleResponse domainToResponse(Role domain);

    default Integer map(UUID uuid) {
        return uuid != null ? uuid.hashCode() : null;
    }
}




