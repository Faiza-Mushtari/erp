package com.brainstation23.erp.mapper;

import com.brainstation23.erp.model.domain.Role;
import com.brainstation23.erp.model.dto.RoleResponse;
import com.brainstation23.erp.persistence.entity.RoleEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-17T17:27:07+0600",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role entityToDomain(RoleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( entity.getId() );
        role.setName( entity.getName() );

        return role;
    }

    @Override
    public RoleResponse domainToResponse(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResponse roleResponse = new RoleResponse();

        roleResponse.setId( role.getId() );
        roleResponse.setName( role.getName() );

        return roleResponse;
    }
}
