package com.blit.petAdoption.Repository;

import com.blit.petAdoption.Entity.Pets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepo extends JpaRepository<Pets, Long> {

    @Query(value = "select * from tbl_pets where active = true",nativeQuery = true)
    public List<Pets> displayActivePets();


}
