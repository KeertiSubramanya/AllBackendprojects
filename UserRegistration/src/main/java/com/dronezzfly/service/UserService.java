package com.dronezzfly.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.dronezzfly.model.UserRegistration;
import com.dronezzfly.repository.UserRepo;
import com.dronezzfly.requestdto.UserRequestDTO;
import com.dronezzfly.responsedto.UserResponseDTO;


@Service
public class UserService {
    @Autowired
    private UserRepo userRepository;

    @Autowired
    private ModelMapper modelmapper;
    
    @Value("${company.name}")
    private String companyName;

    // Create (Save User)
    public ResponseEntity<UserResponseDTO> saveUser(UserRequestDTO userRequestDTO) {

        // Map DTO to Entity
        UserRegistration user = new UserRegistration();
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setMailId(userRequestDTO.getMailId());
        user.setMobilenumber(userRequestDTO.getMobilenumber());
        user.setGender(userRequestDTO.getGender());
        user.setDob(userRequestDTO.getDob());
        user.setPassword(userRequestDTO.getPassword());
        user.setStatus("active");

        // Save to database
        UserRegistration savedUser = userRepository.save(user);

        // Map Entity to Response DTO
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(savedUser.getId());
        responseDTO.setFirstName(savedUser.getFirstName());
        responseDTO.setLastName(savedUser.getLastName());
        responseDTO.setMailId(savedUser.getMailId());
        responseDTO.setMobilenumber(savedUser.getMobilenumber());
        responseDTO.setGender(savedUser.getGender());
        responseDTO.setDob(savedUser.getDob());
        responseDTO.setPassword(savedUser.getPassword());
        responseDTO.setStatus(savedUser.getStatus());
        responseDTO.setCompanyname(companyName);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // Retrieve All Records
    public ResponseEntity<List<UserRegistration>> getAllRecords() {
        List<UserRegistration> retrieverecords = userRepository.findAll();
        return new ResponseEntity<>(retrieverecords, HttpStatus.OK);
    }

    // Update User
    public ResponseEntity<UserResponseDTO> updateUser(Long id, UserRequestDTO userRequestDTO) {
        Optional<UserRegistration> isAvailable = userRepository.findById(id);

        if (isAvailable.isPresent()) {
            UserRegistration user = isAvailable.get();

            // Update fields
            user.setFirstName(userRequestDTO.getFirstName());
            user.setLastName(userRequestDTO.getLastName());
            user.setMailId(userRequestDTO.getMailId());
            user.setMobilenumber(userRequestDTO.getMobilenumber());
            user.setGender(userRequestDTO.getGender());
            user.setDob(userRequestDTO.getDob());
            user.setPassword(userRequestDTO.getPassword());
            user.setStatus("active");

            // Save updated user
            UserRegistration updatedUser = userRepository.save(user);

            // Map Entity to Response DTO
            UserResponseDTO responseDTO = new UserResponseDTO();
            responseDTO.setId(updatedUser.getId());
            responseDTO.setFirstName(updatedUser.getFirstName());
            responseDTO.setLastName(updatedUser.getLastName());
            responseDTO.setMailId(updatedUser.getMailId());
            responseDTO.setMobilenumber(updatedUser.getMobilenumber());
            responseDTO.setGender(updatedUser.getGender());
            responseDTO.setDob(updatedUser.getDob());
            responseDTO.setPassword(updatedUser.getPassword());
            responseDTO.setStatus(updatedUser.getStatus());
            responseDTO.setCompanyname(companyName);

            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete User (Soft Delete)
    public ResponseEntity<Void> deleteUser(Long id) {
        Optional<UserRegistration> isAvailable = userRepository.findById(id);

        if (isAvailable.isPresent()) {
            UserRegistration user = isAvailable.get();
            user.setStatus("deactive"); // Soft delete by changing the status
            userRepository.save(user); // Save changes
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // HTTP 204 No Content
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}