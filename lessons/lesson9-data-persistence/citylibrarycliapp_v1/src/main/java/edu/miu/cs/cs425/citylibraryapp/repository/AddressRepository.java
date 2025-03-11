package edu.miu.cs.cs425.citylibraryapp.repository;

import edu.miu.cs.cs425.citylibraryapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
