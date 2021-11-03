package com.mahsa.mongolib.rentBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService {
    @Autowired
    RentRepository rentRepository;

    public void saveRent(RentBook rentBook){
        rentRepository.save(rentBook);
    }
}
