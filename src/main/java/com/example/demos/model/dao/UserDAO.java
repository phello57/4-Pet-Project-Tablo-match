package com.example.demos.model.dao;

import com.example.demos.model.dto.UserDTO;
import com.example.demos.model.dto.WinnersDTO;
import com.example.demos.model.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.AssociationOverride;
import java.util.List;

@Component
public class UserDAO {

    @Autowired
    Session session;

    public UserDTO getOnId(Long id) {

        User userSQL = session.get(User.class, id);

        UserDTO retUser = new UserDTO();
        retUser.id = userSQL.getId();
        retUser.name = userSQL.getName();

        return retUser;
    }

    public UserDTO getOnName(UserDTO userDTO) {

        UserDTO retUser = null;

        List<User> userSQL = null;

        try {
            userSQL = session.createQuery("SELECT a FROM User a where a.name='"+userDTO.name+"'", User.class).getResultList();

        } catch (jakarta.persistence.NoResultException o) {
            System.out.println("Error ");
        }
        if (!userSQL.isEmpty()) {
            retUser = new UserDTO();
            retUser.id = userSQL.getFirst().getId();
            retUser.name = userSQL.getFirst().getName();
        }

        return retUser;
    }

    public void insert(UserDTO userDtoCreatedByName) {
        UserDTO userDTO = getOnName(userDtoCreatedByName);

        boolean isUserNotExists = userDTO == null;

        if (isUserNotExists) {
            session.save(new User(userDtoCreatedByName.name));
        }

    }
}
