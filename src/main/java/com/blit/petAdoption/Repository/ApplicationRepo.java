package com.blit.petAdoption.Repository;

import com.blit.petAdoption.Entity.Application;
import com.blit.petAdoption.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepo extends JpaRepository <Application, Long>{


}
