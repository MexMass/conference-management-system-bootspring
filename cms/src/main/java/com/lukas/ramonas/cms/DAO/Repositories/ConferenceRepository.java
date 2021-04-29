package com.lukas.ramonas.cms.DAO.Repositories;

// This will be AUTO IMPLEMENTED by Spring into a Bean called conferenceRepository
// CRUD refers Create, Read, Update, Delete

import com.lukas.ramonas.cms.Model.Conference;
import com.lukas.ramonas.cms.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    Conference findByName(String name);
    Conference findByCreator(User user);
    List<Conference> findAllByCreator(User user);
}