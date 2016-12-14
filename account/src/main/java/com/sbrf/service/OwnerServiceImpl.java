package com.sbrf.service;

import com.sbrf.dao.api.OwnerDAO;
import com.sbrf.dao.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OwnerServiceImpl implements OwnerService {
    private final OwnerDAO ownerDAO;

    @Autowired
    public OwnerServiceImpl(OwnerDAO ownerDAO) {
        this.ownerDAO = ownerDAO;
    }

    @Override
    public long addOwner(Owner owner) {
        return ownerDAO.create(owner);
    }

    @Override
    public Owner findByName(String firstName, String middleName, String lastName) {
        return null;
    }

    @Override
    public Owner findByUserId(long userId) {
        return null;
    }

    @Override
    public Owner findById(long id) {
        return ownerDAO.read(id);
    }
}
