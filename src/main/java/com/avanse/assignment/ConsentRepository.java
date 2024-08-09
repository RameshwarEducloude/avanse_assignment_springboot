package com.avanse.assignment;

import com.avanse.assignment.entities.UserConsent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsentRepository extends CrudRepository<UserConsent, Integer> {
}
