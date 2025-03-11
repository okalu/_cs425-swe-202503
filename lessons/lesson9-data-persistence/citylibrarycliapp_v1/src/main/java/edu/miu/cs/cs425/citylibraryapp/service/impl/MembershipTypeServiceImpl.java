package edu.miu.cs.cs425.citylibraryapp.service.impl;

import edu.miu.cs.cs425.citylibraryapp.model.MembershipType;
import edu.miu.cs.cs425.citylibraryapp.repository.MembershipTypeRepository;
import edu.miu.cs.cs425.citylibraryapp.service.MembershipTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipTypeServiceImpl implements MembershipTypeService {

    private final MembershipTypeRepository membershipTypeRepository;

    public MembershipTypeServiceImpl(MembershipTypeRepository membershipTypeRepository) {
        this.membershipTypeRepository = membershipTypeRepository;
    }


    @Override
    public MembershipType addNewMembershipType(MembershipType membershipType) {
        return membershipTypeRepository.save(membershipType);
    }

    @Override
    public MembershipType getMembershipTypeById(Integer id) {
        return membershipTypeRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<MembershipType> getAllMembershipTypes() {
        return membershipTypeRepository.findAll();
    }
}
