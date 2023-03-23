package com.example.shikusi_dipensary.services;


import com.example.shikusi_dipensary.repository.TriageRepository;
import com.example.shikusi_dipensary.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriageService {

    private final TriageRepository triageRepository;
    private final VisitRepository visitRepository;

    @Autowired
    public TriageService(TriageRepository triageRepository, VisitRepository visitRepository){
        this.triageRepository = triageRepository;
        this.visitRepository = visitRepository;
    }



}
