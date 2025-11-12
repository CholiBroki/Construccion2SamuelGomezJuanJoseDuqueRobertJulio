package app.domain.service;

import app.adapter.out.HumanResourcesAdapter;
import app.domain.valueobject.Email;
import app.domain.valueobject.Phone;
import app.domain.model.HumanResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffInformationService {
    
    @Autowired
    private HumanResourcesAdapter hrAdapter;

    public void updateEmail(Long hrId, Email newEmail) {
        Optional<HumanResources> memberOpt = hrAdapter.findById(hrId);
        if (memberOpt.isPresent()) {
            HumanResources member = memberOpt.get();
            member.changeEmail(newEmail);
            hrAdapter.save(member);
        } else {
            throw new IllegalArgumentException("HR Member not found with id: " + hrId);
        }
    }

    public void updatePhone(Long hrId, Phone newPhone) {
        Optional<HumanResources> memberOpt = hrAdapter.findById(hrId);
        if (memberOpt.isPresent()) {
            HumanResources member = memberOpt.get();
            member.changePhone(newPhone);
            hrAdapter.save(member);
        } else {
            throw new IllegalArgumentException("HR Member not found with id: " + hrId);
        }
    }
}