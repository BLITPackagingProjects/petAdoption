package com.blit.petAdoption.Service;

import com.blit.petAdoption.Entity.Application;

import java.util.List;

public interface ApplicationService {

    List<Application> reviewAllApplications ();

    Application reviewApplicationById(Long id);
}

