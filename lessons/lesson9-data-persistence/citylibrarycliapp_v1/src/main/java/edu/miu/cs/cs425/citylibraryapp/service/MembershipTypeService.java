package edu.miu.cs.cs425.citylibraryapp.service;

import edu.miu.cs.cs425.citylibraryapp.model.MembershipType;

import java.util.List;

public interface MembershipTypeService {
    MembershipType addNewMembershipType(MembershipType membershipType);
    MembershipType getMembershipTypeById(Integer id);
    List<MembershipType> getAllMembershipTypes();
}
