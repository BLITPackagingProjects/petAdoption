package com.blit.petAdoption.Repository;

import com.blit.petAdoption.Entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepo extends JpaRepository<Application, Long> {
}
