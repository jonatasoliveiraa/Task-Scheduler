package com.taskscheduler.User.business.converter;

import com.taskscheduler.User.business.dto.AddressDTO;
import com.taskscheduler.User.business.dto.PhoneDTO;
import com.taskscheduler.User.business.dto.UserDTO;
import com.taskscheduler.User.infrastructure.entity.Address;
import com.taskscheduler.User.infrastructure.entity.Phone;
import com.taskscheduler.User.infrastructure.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {

    public User toUser(UserDTO userDTO){
        return User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .addresses(toListAddress(userDTO.getAddresses()))
                .phones(toListPhone(userDTO.getPhones()))
                .build();
    }

    public List<Address> toListAddress(List<AddressDTO> addressDTOS){
        List<Address> addresses = new ArrayList<>();
        for (AddressDTO addressDTO : addressDTOS) {
            addresses.add(toAddress(addressDTO));
        }
        return addresses;
    }

    public Address toAddress(AddressDTO addressDTO){
        return Address.builder()
                .street(addressDTO.getStreet())
                .neighborhood(addressDTO.getNeighborhood())
                .number(addressDTO.getNumber())
                .complement(addressDTO.getComplement())
                .city(addressDTO.getCity())
                .state(addressDTO.getState())
                .zipCode(addressDTO.getZipCode())
                .build();
    }

    public List<Phone> toListPhone(List<PhoneDTO> phoneDTOS){
        List<Phone> phones = new ArrayList<>();
        for (PhoneDTO phoneDTO : phoneDTOS) {
            phones.add(toPhone(phoneDTO));
        }
        return phones;
    }

    public Phone toPhone(PhoneDTO phoneDTO){
        return Phone.builder()
                .phoneNumber(phoneDTO.getPhoneNumber())
                .ddd(phoneDTO.getDdd())
                .build();
    }



    public UserDTO toUserDTO(User user){
        return UserDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .addresses(toListAddressDTO(user.getAddresses()))
                .phones(toListPhoneDTO(user.getPhones()))
                .build();
    }

    public List<AddressDTO> toListAddressDTO(List<Address> addresses){
        List<AddressDTO> addressesDTO = new ArrayList<>();
        for (Address address : addresses) {
            addressesDTO.add(toAddressDTO(address));
        }
        return addressesDTO;
    }

    public AddressDTO toAddressDTO(Address address){
        return AddressDTO.builder()
                .street(address.getStreet())
                .neighborhood(address.getNeighborhood())
                .number(address.getNumber())
                .complement(address.getComplement())
                .city(address.getCity())
                .state(address.getState())
                .zipCode(address.getZipCode())
                .build();
    }

    public List<PhoneDTO> toListPhoneDTO(List<Phone> phones){
        List<PhoneDTO> phonesDTO = new ArrayList<>();
        for (Phone phone : phones) {
            phonesDTO.add(toPhoneDTO(phone));
        }
        return phonesDTO;
    }

    public PhoneDTO toPhoneDTO(Phone phone){
        return PhoneDTO.builder()
                .phoneNumber(phone.getPhoneNumber())
                .ddd(phone.getDdd())
                .build();
    }
}
