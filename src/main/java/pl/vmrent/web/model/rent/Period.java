package pl.vmrent.web.model.rent;

import pl.vmrent.web.validator.period.PeriodCheck;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@PeriodCheck
public class Period implements Serializable
{
    @FutureOrPresent
    @NotNull
    private LocalDateTime startDate;

    @Future
    @NotNull
    private LocalDateTime endDate;

    public LocalDateTime getStartDate()
    {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate)
    {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate()
    {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate)
    {
        this.endDate = endDate;
    }
}
