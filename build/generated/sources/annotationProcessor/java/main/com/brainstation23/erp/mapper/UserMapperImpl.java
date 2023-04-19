package com.brainstation23.erp.mapper;

import com.brainstation23.erp.model.domain.User;
import com.brainstation23.erp.model.dto.UserResponse;
import com.brainstation23.erp.persistence.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T10:49:10+0600",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User entityToDomain(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        User user = new User();

        user.setId( entity.getId() );
        user.setUsername( entity.getUsername() );
        user.setEmail( entity.getEmail() );
        user.setPassword( entity.getPassword() );
        user.setRole( entity.getRole() );

        return user;
    }

    @Override
    public UserResponse domainToResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( user.getId() );
        userResponse.setUsername( user.getUsername() );
        userResponse.setEmail( user.getEmail() );
        userResponse.setRole( user.getRole() );
        userResponse.setPassword( user.getPassword() );

        return userResponse;
    }
}
