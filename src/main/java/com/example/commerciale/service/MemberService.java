package com.example.commerciale.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.commerciale.models.Membre;
import com.example.commerciale.repository.MemberRepository;
import java.util.List;
@Service
public class MemberService {
    @Autowired
    private MemberRepository membrerepository ;
    public List<Membre> getAllMembers() {
        return membrerepository.findAll() ;
    }
    public Membre MembreExist(String email , String password){
        List<Membre> allmembre = getAllMembers() ;
        for (int i = 0; i < allmembre.size(); i++) {
            if((allmembre.get(i).getEmail().compareTo(email) == 0) && (allmembre.get(i).getMdp().compareTo(password) == 0)){
                return allmembre.get(i) ;
            }
        }
        return null ;
    }
    public int getDepartement(int id_membre){
        return membrerepository.getIddepartement(id_membre) ;
    }
}
