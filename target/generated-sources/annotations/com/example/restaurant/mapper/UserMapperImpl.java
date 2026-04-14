package com.example.restaurant.mapper;

import com.example.restaurant.entity.User;
import com.example.restaurant.pojo.user.UserResPojo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-14T15:16:09+0545",
    comments = "version: 1.6.3, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResPojo toPojo(User user) {
        if ( user == null ) {
            return null;
        }

        UserResPojo userResPojo = new UserResPojo();

        userResPojo.setPhone( user.getPhoneNumber() );
        userResPojo.setRole( user.getUserRole() );
        userResPojo.setId( user.getId() );
        userResPojo.setFirstName( user.getFirstName() );
        userResPojo.setMiddleName( user.getMiddleName() );
        userResPojo.setLastName( user.getLastName() );

        return userResPojo;
    }

    @Override
    public List<UserResPojo> toPojoList(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResPojo> list = new ArrayList<UserResPojo>( users.size() );
        for ( User user : users ) {
            list.add( toPojo( user ) );
        }

        return list;
    }
}
