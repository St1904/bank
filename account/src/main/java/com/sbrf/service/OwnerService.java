package com.sbrf.service;

import com.sbrf.dao.model.Owner;

public interface OwnerService {
    long addOwner(Owner owner);
    Owner findByName(String firstName, String middleName, String lastName);
    Owner findByUserId(long userId);
    Owner findById(long id);
}
