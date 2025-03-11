package edu.miu.cs.cs425.citylibraryapp.service.impl;

import edu.miu.cs.cs425.citylibraryapp.model.Address;
import edu.miu.cs.cs425.citylibraryapp.repository.AddressRepository;
import edu.miu.cs.cs425.citylibraryapp.service.AddressService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address addNewAddress(Address address) {
        return addressRepository.save(address);
    }
}
