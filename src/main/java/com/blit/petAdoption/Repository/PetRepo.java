package com.blit.petAdoption.Repository;

import com.blit.petAdoption.Entity.Pets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepo extends JpaRepository<Pets, Long> {


}
