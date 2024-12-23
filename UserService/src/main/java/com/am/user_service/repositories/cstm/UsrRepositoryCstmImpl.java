package com.am.user_service.repositories.cstm;

import com.am.user_service.domain.dto.FilterDTO;
import com.am.user_service.domain.entities.UsrEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class UsrRepositoryCstmImpl implements UsrRepositoryCstm{

    public UsrRepositoryCstmImpl(){}

    @PersistenceContext
    EntityManager entityManager ;

    @Override
    public List<UsrEntity> findUsers(FilterDTO filterDTO) {
        StringBuilder query = new StringBuilder("SELECT usr FROM UsrEntity usr WHERE");
        boolean isFirst = true;

        if(filterDTO.email() == null && filterDTO.username() == null && filterDTO.city() == null && filterDTO.createdDateFrom() == null && filterDTO.createdDateTo() == null){
            throw new RuntimeException("At least one filter has to be populated");
        }



        if(filterDTO.username() != null){
            query.append(" UPPER(username) LIKE UPPER(CONCAT('%', :username, '%')) AND");
        }
        if(filterDTO.email() != null){
            query.append(" UPPER(email) LIKE UPPER(CONCAT('%', :email, '%')) AND");
        }
        if(filterDTO.city() != null){
            query.append(" city.name = :city AND");
        }
        if(filterDTO.createdDateFrom() != null){
            query.append(" createddate >= :createdDateFrom AND");
        }
        if(filterDTO.createdDateTo() != null){
            query.append(" createddate <= :createdDateTo AND");
        }

        query.delete(query.length() - 3, query.length() );
        var rs = entityManager.createQuery(query.toString(), UsrEntity.class);

        if(filterDTO.username() != null){
            rs.setParameter("username", filterDTO.username());
        }
        if(filterDTO.email() != null){
            rs.setParameter("email", filterDTO.email());
        }
        if(filterDTO.city() != null){
            rs.setParameter("city", filterDTO.city());
        }
        if(filterDTO.createdDateFrom() != null){
            rs.setParameter("createdDateFrom", filterDTO.createdDateFrom());
        }
        if(filterDTO.createdDateTo() != null){
            rs.setParameter("createdDateTo", filterDTO.createdDateTo());
        }


        return rs.getResultList();
    }
}
