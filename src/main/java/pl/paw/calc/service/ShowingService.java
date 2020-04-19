package pl.paw.calc.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.paw.calc.entity.Showing;
import pl.paw.calc.model.ShowingDateModel;
import pl.paw.calc.repository.ShowingRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class ShowingService {

    private final ShowingRepository showingRepository;

    public List<Showing> getAllShowings() {
        return showingRepository.findAll();
    }

    public List<Showing> getShowingsAfterCurrentDate(){
        return showingRepository.findAllByShowingDateAfter(new Date());
    }

    public List<Showing> getShowingsForSpecificPeriod(ShowingDateModel showingDateModel){
        return showingRepository.findAllByShowingDateBetween(showingDateModel.getDateFrom(), showingDateModel.getDateTo());
    }
}