package com.blit.petAdoption.Service;

import com.blit.petAdoption.Entity.Application;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplicationServices {

    List<Application> EmployeeCanSeeAllApplication();
}
