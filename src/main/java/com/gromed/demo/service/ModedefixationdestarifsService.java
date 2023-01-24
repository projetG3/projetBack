package com.gromed.demo.service;

import com.gromed.demo.model.Modedefixationdestarif;
import com.gromed.demo.repository.ModedefixationdestarifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModedefixationdestarifsService {

    @Autowired
    private ModedefixationdestarifRepository modedefixationdestarifRepository;

    public Optional<Modedefixationdestarif> getModeDeFixationDesTarifs(final Integer id) {
        return modedefixationdestarifRepository.findById(id);
    }

    public List<Modedefixationdestarif> getAllModeDeFixationDesTarifs() {
        return modedefixationdestarifRepository.findAll();
    }

    public void deleteModeDeFixationDesTarifs(final Integer id) {
        modedefixationdestarifRepository.deleteById(id);
    }

    public Modedefixationdestarif saveModeDeFixationDesTarifs(Modedefixationdestarif mft){
        return modedefixationdestarifRepository.save(mft);
    }
}
