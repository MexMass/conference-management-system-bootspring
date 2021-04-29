package com.lukas.ramonas.cms.Service;

import com.lukas.ramonas.cms.DAO.ConferenceDto;
import com.lukas.ramonas.cms.Model.Conference;
import com.lukas.ramonas.cms.Model.User;

import java.util.List;
import java.util.Optional;
public interface IConferenceService {
    Conference createNewConference(ConferenceDto conferenceDto);
    List<Conference> findAll();
    Optional<Conference> findById(Long id);
    Conference findByCreator(User user);
    List<Conference> findAllByCreator(User creator);
    public void delete(Long id);
}