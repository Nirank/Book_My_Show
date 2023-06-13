package com.example.Book_My_Show.Services;



import com.example.Book_My_Show.Converters.UserConvertor;
import com.example.Book_My_Show.Entities.UserEntity;
import com.example.Book_My_Show.EntryDtos.UserEntryDto;
import com.example.Book_My_Show.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto)throws Exception,NullPointerException{
        // main aim to make entry in DB...we need to convert DTO to User
        // Old method : Create  object And set its Attribute with the help of DTO
        //like as    // User user = new user();
        // user.setAge(userEntryDto.getAge())
//               //user.setAddress(userEntryDto.getAddress()

        // we are using Builder methods for getting attributes from dto to entity
//        User user1 = User.builder().age(userEntryDto.getAge()).name(userEntryDto.getName())
//                .address(userEntryDto.getAddress()).email(userEntryDto.getEmail()).mobNo(userEntryDto.getMobNo())
//                .build();

        // here we are using converter

        UserEntity userEntity = UserConvertor.convertDtoToEntity(userEntryDto);

        userRepository.save(userEntity);

        return "User Added successfully";

    }



}
