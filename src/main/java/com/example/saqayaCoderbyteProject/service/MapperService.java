package com.example.saqayaCoderbyteProject.service;


import com.example.saqayaCoderbyteProject.model.User;
import com.example.saqayaCoderbyteProject.model.UserVTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MapperService {
    public static UserVTO mapToCustomVTO(Optional<User> userData){
        UserVTO vto = new UserVTO();
        vto.setId(userData.get().getId());
        vto.setEmail(userData.get().getEmail());
        vto.setFirstName(userData.get().getFirstName());
        vto.setLastName(userData.get().getLastName());
        vto.setMarketingConsent(userData.get().getMarketingConsent());
        return vto;
    }
}
