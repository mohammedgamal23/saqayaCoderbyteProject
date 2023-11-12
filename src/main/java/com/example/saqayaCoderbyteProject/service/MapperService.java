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
        User user = userData.get();
        vto.setId(user.getId());
        vto.setEmail(user.getEmail());
        vto.setFirstName(user.getFirstName());
        vto.setLastName(user.getLastName());
        vto.setMarketingConsent(user.getMarketingConsent());
        return vto;
    }
}
