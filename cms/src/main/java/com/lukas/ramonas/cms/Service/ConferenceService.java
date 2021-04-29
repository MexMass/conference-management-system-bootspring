package com.lukas.ramonas.cms.Service;

import com.lukas.ramonas.cms.DAO.ConferenceDto;
import com.lukas.ramonas.cms.DAO.Repositories.ConferenceRepository;
import com.lukas.ramonas.cms.Exceptions.ConferenceAlreadyExistException;
import com.lukas.ramonas.cms.Model.Conference;
import com.lukas.ramonas.cms.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ConferenceService implements IConferenceService {
    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private UserService userService;

    @Transactional
    @Override
    public Conference createNewConference(ConferenceDto conferenceDto)
            throws ConferenceAlreadyExistException {
        Authentication user1 = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(user1.getName());

        if (nameExist(conferenceDto.getName())) {
            throw new ConferenceAlreadyExistException(
                    "There is a conference with that name: "
                            +  conferenceDto.getName());
        }
        Conference conference = new Conference();
        conference.setCreator(user);
        conference.setName(conferenceDto.getName());
        conference.setDescription(conferenceDto.getDescription());
        conference.setStartConference(conferenceDto.getStartConference());
        conference.setEndConference(conferenceDto.getEndConference());
        return conferenceRepository.save(conference);
    }

    @Override
    public List<Conference> findAll() {
        return conferenceRepository.findAll();
    }

    @Override
    public Optional<Conference> findById(Long id){
        return conferenceRepository.findById(id);
    }

    @Override
    public Conference findByCreator(User creator){
        return conferenceRepository.findByCreator(creator);
    };

    @Override
    public List<Conference> findAllByCreator(User creator){
        return conferenceRepository.findAllByCreator(creator);
    };

    @Override
    public void delete(Long id) {
        conferenceRepository.deleteById(id);
    }

    private boolean nameExist(String name) {
        return conferenceRepository.findByName(name) != null;
    }
}