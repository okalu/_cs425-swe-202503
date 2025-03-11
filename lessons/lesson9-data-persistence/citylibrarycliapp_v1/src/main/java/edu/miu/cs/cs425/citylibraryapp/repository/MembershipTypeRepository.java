package edu.miu.cs.cs425.citylibraryapp.repository;

import edu.miu.cs.cs425.citylibraryapp.model.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipTypeRepository extends JpaRepository<MembershipType, Integer> {
}
